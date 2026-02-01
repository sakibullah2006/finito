package com.data_merchants.finito.controller;

import com.data_merchants.finito.model.InventoryItem;
import com.data_merchants.finito.repository.InventoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.data_merchants.finito.dto.ConsumeRequest;
import com.data_merchants.finito.dto.InventoryAddRequest;
import com.data_merchants.finito.dto.InventoryUpdateRequest;
import com.data_merchants.finito.dto.InventoryRemoveRequest;
import com.data_merchants.finito.model.ShopProduct;
import com.data_merchants.finito.repository.ShopRepository;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Critical for Next.js
@Tag(name = "User Inventory Tool", description = "Manage the digital twin's current stock of ingredients.")
public class InventoryController {

    private final InventoryRepository inventoryRepo;
    private final ShopRepository shopRepo;

    @GetMapping
    @Operation(summary = "Get My Inventory", description = "Returns the user's current fridge status.")
    public ResponseEntity<List<InventoryItem>> getUserInventory(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId) {
        // In a real app, use the header. For hackathon demo simplicity, we can default
        // to 'Alice'
        // if the header is missing to ensure the UI always shows data.
        return ResponseEntity.ok(inventoryRepo.findByUserId(userId));
    }

    @PostMapping("/consume")
    @Operation(summary = "Consume Ingredient", description = "Reduces the quantity of an item. Simulates cooking or eating.")
    public ResponseEntity<?> consumeItem(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId,
            @RequestBody ConsumeRequest request) {

        String itemName = request.itemName();

        var itemOpt = inventoryRepo.findByUserIdAndNameIgnoreCase(userId, itemName);

        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            // Reduce quantity by 1.0 (or set to 0 if low)
            double newQuantity = Math.max(0.0, item.getQuantity() - 1.0);
            item.setQuantity(newQuantity);
            inventoryRepo.save(item);

            return ResponseEntity.ok(Map.of(
                    "status", "UPDATED",
                    "message", "Consumed 1 unit of " + itemName + ". New Quantity: " + newQuantity));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    @Operation(summary = "Add Item to Inventory", description = "Adds a new item to the user's inventory or increases quantity if it already exists. Automatically pulls category and image from shop catalog.")
    public ResponseEntity<?> addItem(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId,
            @RequestBody InventoryAddRequest request) {

        String itemName = request.itemName();
        Double quantity = request.quantity() != null ? request.quantity() : 1.0;
        String unit = request.unit() != null ? request.unit() : "unit";

        // Check if item already exists
        var itemOpt = inventoryRepo.findByUserIdAndNameIgnoreCase(userId, itemName);

        if (itemOpt.isPresent()) {
            // Update existing item
            InventoryItem item = itemOpt.get();
            item.setQuantity(item.getQuantity() + quantity);
            inventoryRepo.save(item);

            return ResponseEntity.ok(Map.of(
                    "status", "UPDATED",
                    "message", "Added " + quantity + " units to " + itemName + ". New Quantity: " + item.getQuantity(),
                    "item", item));
        }

        // Create new item - try to get details from shop catalog
        String category = "Other";
        String imageUrl = "https://placehold.co/400x300/grey/white?text=" + itemName.replace(" ", "+");

        // Try exact match first, then fuzzy match
        var shopItems = shopRepo.findByNameContainingIgnoreCase(itemName);
        if (!shopItems.isEmpty()) {
            ShopProduct shopItem = shopItems.get(0);
            category = shopItem.getCategory();
            imageUrl = shopItem.getImageUrl();
            itemName = shopItem.getName(); // Use standardized name from shop
        }

        InventoryItem newItem = InventoryItem.builder()
                .userId(userId)
                .name(itemName)
                .category(category)
                .imageUrl(imageUrl)
                .quantity(quantity)
                .unit(unit)
                .build();

        inventoryRepo.save(newItem);

        return ResponseEntity.ok(Map.of(
                "status", "CREATED",
                "message", "Added " + quantity + " units of " + itemName + " to inventory.",
                "item", newItem));
    }

    @PutMapping("/update")
    @Operation(summary = "Update Item Quantity", description = "Updates the quantity of an existing inventory item.")
    public ResponseEntity<?> updateItem(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId,
            @RequestBody InventoryUpdateRequest request) {

        String itemName = request.itemName();
        Double newQuantity = request.quantity();

        if (newQuantity == null || newQuantity < 0) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "ERROR",
                    "message", "Quantity must be a positive number."));
        }

        var itemOpt = inventoryRepo.findByUserIdAndNameIgnoreCase(userId, itemName);

        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            item.setQuantity(newQuantity);
            inventoryRepo.save(item);

            return ResponseEntity.ok(Map.of(
                    "status", "UPDATED",
                    "message", "Updated " + itemName + " quantity to " + newQuantity,
                    "item", item));
        }

        return ResponseEntity.status(404).body(Map.of(
                "status", "NOT_FOUND",
                "message", "Item '" + itemName + "' not found in inventory."));
    }

    @DeleteMapping("/remove")
    @Operation(summary = "Remove Item from Inventory", description = "Completely removes an item from the user's inventory.")
    public ResponseEntity<?> removeItem(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId,
            @RequestBody InventoryRemoveRequest request) {

        String itemName = request.itemName();

        var itemOpt = inventoryRepo.findByUserIdAndNameIgnoreCase(userId, itemName);

        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            inventoryRepo.delete(item);

            return ResponseEntity.ok(Map.of(
                    "status", "DELETED",
                    "message", "Removed " + itemName + " from inventory."));
        }

        return ResponseEntity.status(404).body(Map.of(
                "status", "NOT_FOUND",
                "message", "Item '" + itemName + "' not found in inventory."));
    }
}