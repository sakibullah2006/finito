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

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Critical for Next.js
@Tag(name = "User Inventory Tool", description = "Manage the digital twin's current stock of ingredients.")
public class InventoryController {

    private final InventoryRepository inventoryRepo;

    @GetMapping
    @Operation(summary = "Get My Inventory", description = "Returns the user's current fridge status.")
    public ResponseEntity<List<InventoryItem>> getUserInventory(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId) {
        // In a real app, use the header. For hackathon demo simplicity, we can default
        // to 'Alice'
        // if the header is missing to ensure the UI always shows data.
        return ResponseEntity.ok(inventoryRepo.findByUserId(userId));
    }

    @PostMapping("/consume")
    @Operation(summary = "Consume Ingredient", description = "Reduces the quantity of an item. Simulates cooking or eating.")
    public ResponseEntity<?> consumeItem(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId,
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
}