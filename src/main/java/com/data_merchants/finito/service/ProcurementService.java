package com.data_merchants.finito.service;

import com.data_merchants.finito.dto.OrderResponse;
import com.data_merchants.finito.model.InventoryItem;
import com.data_merchants.finito.model.ProcurementOrder;
import com.data_merchants.finito.model.ShopProduct;
import com.data_merchants.finito.model.UserProfile;
import com.data_merchants.finito.repository.InventoryRepository;
import com.data_merchants.finito.repository.ProcurementOrderRepository;
import com.data_merchants.finito.repository.ShopRepository;
import com.data_merchants.finito.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcurementService {

    private final InventoryRepository inventoryRepo;
    private final ProcurementOrderRepository orderRepo;
    private final UserProfileRepository userRepo;
    private final ShopRepository shopRepo; // <--- NEW INJECTION

    @Transactional
    public OrderResponse executeSmartOrder(String userId, List<String> requiredIngredients) {
        // 1. Context Check
        UserProfile profile = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));

        log.info("🤖 AGENT ACTIVATED for User: {}", profile.getDisplayName());

        // 2. Inventory Gap Analysis
        List<InventoryItem> userInventory = inventoryRepo.findByUserId(userId);
        List<String> inventoryNames = userInventory.stream()
                .map(item -> item.getName().toLowerCase())
                .toList();

        List<String> missingIngredients = requiredIngredients.stream()
                .filter(req -> !inventoryNames.contains(req.toLowerCase()))
                .collect(Collectors.toList());

        if (missingIngredients.isEmpty()) {
            return new OrderResponse("SKIPPED", "NO_ORDER", "Inventory sufficient.");
        }

        // 3. 🆕 Shop Validation & Cost Calculation
        List<String> validatedItems = new ArrayList<>();
        double estimatedCost = 0.0;

        for (String item : missingIngredients) {
            // Try exact match first (case-insensitive)
            var exactMatch = shopRepo.findByNameIgnoreCase(item);

            if (exactMatch.isPresent() && exactMatch.get().isInStock()) {
                ShopProduct shopItem = exactMatch.get();
                validatedItems.add(shopItem.getName());
                estimatedCost += shopItem.getPrice();
                log.info("✅ EXACT MATCH: '{}' found in store (${})", shopItem.getName(), shopItem.getPrice());
                continue;
            }

            // Fallback to fuzzy search (e.g., "Chicken" matches "Organic Chicken Breast")
            List<ShopProduct> matches = shopRepo.findByNameContainingIgnoreCase(item);

            // Filter to only in-stock items
            var inStockMatches = matches.stream()
                    .filter(ShopProduct::isInStock)
                    .toList();

            if (!inStockMatches.isEmpty()) {
                ShopProduct bestMatch = inStockMatches.get(0); // Pick the first/best match
                validatedItems.add(bestMatch.getName());
                estimatedCost += bestMatch.getPrice();
                log.info("✅ FUZZY MATCH: '{}' matched to '{}' (${})", item, bestMatch.getName(), bestMatch.getPrice());
            } else {
                log.warn("❌ UNAVAILABLE: Store does not carry '{}' or it's out of stock. Skipping.", item);
            }
        }

        if (validatedItems.isEmpty()) {
            return new OrderResponse("FAILED", "OUT_OF_STOCK", "None of the required items were found in the shop.");
        }

        // 4. Execute Order & INSTANT RESTOCK (Magic Demo Moment)
        for (String itemName : validatedItems) {
            // Find the shop details to copy image/category
            ShopProduct shopItem = shopRepo.findByNameContainingIgnoreCase(itemName).get(0);

            // Check if user already has it (to just add quantity)
            InventoryItem existingItem = inventoryRepo.findByUserIdAndNameIgnoreCase(userId, shopItem.getName())
                    .orElse(null);

            if (existingItem != null) {
                // Restock existing
                existingItem.setQuantity(existingItem.getQuantity() + 1.0);
                inventoryRepo.save(existingItem);
            } else {
                // Create new Inventory Item from Shop Data
                InventoryItem newItem = InventoryItem.builder()
                        .userId(userId)
                        .name(shopItem.getName()) // Use standardized name
                        .category(shopItem.getCategory()) // Copy category
                        .imageUrl(shopItem.getImageUrl()) // Copy image
                        .quantity(1.0)
                        .unit("unit")
                        .build();
                inventoryRepo.save(newItem);
            }
        }

        String orderId = UUID.randomUUID().toString();
        ProcurementOrder order = ProcurementOrder.builder()
                .orderId(orderId)
                .userId(userId)
                .createdAt(LocalDateTime.now())
                .status("COMPLETED")
                .totalCost(estimatedCost) // <--- Saving the cost
                .items(validatedItems)
                .build();

        orderRepo.save(order);

        String message = String.format("Ordered %d items. Total: $%.2f", validatedItems.size(), estimatedCost);
        log.info("💰 TRANSACTION: {}", message);

        return new OrderResponse(orderId, "SUCCESS", message);
    }
}