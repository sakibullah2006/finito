package com.data_merchants.finito.controller;

import com.data_merchants.finito.model.ShopProduct;
import com.data_merchants.finito.repository.ShopRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

import com.data_merchants.finito.dto.ShopProductCreateRequest;
import com.data_merchants.finito.dto.ShopProductUpdateRequest;

@RestController
@RequestMapping("/api/v1/shop")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Critical for Next.js Dashboard access
@Tag(name = "Shop Catalog Tool", description = "Allows the Agent and Dashboard to view available inventory.")
public class ShopController {

    private final ShopRepository shopRepo;

    @GetMapping("/catalog")
    @Operation(summary = "Get Full Catalog", description = "Retrieves a paginated list of all products currently in stock. Supports category filtering (e.g., 'Protein', 'Vegetable', 'Grain'). Only returns items where inStock=true.")
    public ResponseEntity<Page<ShopProduct>> getCatalog(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (category != null && !category.isBlank()) {
            return ResponseEntity.ok(shopRepo.findByCategoryIgnoreCase(category, pageable));
        }
        return ResponseEntity.ok(shopRepo.findByInStockTrue(pageable));
    }

    @GetMapping("/search")
    @Operation(summary = "Search Products", description = "Search for products by name. Supports both exact matches (e.g., 'Sweet Potato') and partial matches (e.g., 'Chicken' finds 'Organic Chicken Breast'). Returns all matching products with availability and pricing.")
    public ResponseEntity<List<ShopProduct>> searchProduct(@RequestParam String query) {
        return ResponseEntity.ok(shopRepo.findByNameContainingIgnoreCase(query));
    }

    @PostMapping("/products")
    @Operation(summary = "Create Shop Product", description = "Creates a new product in the shop catalog. Product name must be unique. AI agents can use this to add new items to the shop.")
    public ResponseEntity<?> createProduct(@RequestBody ShopProductCreateRequest request) {
        // Check if product with same name already exists
        var existing = shopRepo.findByNameIgnoreCase(request.name());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "ERROR",
                    "message", "Product with name '" + request.name() + "' already exists."));
        }

        ShopProduct product = ShopProduct.builder()
                .name(request.name())
                .price(request.price() != null ? request.price() : 0.0)
                .category(request.category() != null ? request.category() : "Other")
                .inStock(request.inStock() != null ? request.inStock() : true)
                .imageUrl(request.imageUrl() != null ? request.imageUrl()
                        : "https://placehold.co/400x300/grey/white?text=" + request.name().replace(" ", "+"))
                .build();

        shopRepo.save(product);

        return ResponseEntity.ok(Map.of(
                "status", "CREATED",
                "message", "Product '" + product.getName() + "' created successfully.",
                "product", product));
    }

    @PutMapping("/products/{id}")
    @Operation(summary = "Update Shop Product", description = "Updates an existing shop product. Only provided fields will be updated. AI agents can use this to modify product details.")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long id,
            @RequestBody ShopProductUpdateRequest request) {

        var productOpt = shopRepo.findById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "NOT_FOUND",
                    "message", "Product with ID " + id + " not found."));
        }

        ShopProduct product = productOpt.get();

        // Update only provided fields
        if (request.name() != null && !request.name().isBlank()) {
            // Check if new name conflicts with another product
            var existing = shopRepo.findByNameIgnoreCase(request.name());
            if (existing.isPresent() && !existing.get().getId().equals(id)) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "ERROR",
                        "message", "Product with name '" + request.name() + "' already exists."));
            }
            product.setName(request.name());
        }
        if (request.price() != null) {
            product.setPrice(request.price());
        }
        if (request.category() != null && !request.category().isBlank()) {
            product.setCategory(request.category());
        }
        if (request.inStock() != null) {
            product.setInStock(request.inStock());
        }
        if (request.imageUrl() != null && !request.imageUrl().isBlank()) {
            product.setImageUrl(request.imageUrl());
        }

        shopRepo.save(product);

        return ResponseEntity.ok(Map.of(
                "status", "UPDATED",
                "message", "Product '" + product.getName() + "' updated successfully.",
                "product", product));
    }

    @DeleteMapping("/products/{id}")
    @Operation(summary = "Delete Shop Product", description = "Permanently deletes a product from the shop catalog. Use with caution. AI agents can use this to remove discontinued items.")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        var productOpt = shopRepo.findById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "NOT_FOUND",
                    "message", "Product with ID " + id + " not found."));
        }

        ShopProduct product = productOpt.get();
        String productName = product.getName();
        shopRepo.delete(product);

        return ResponseEntity.ok(Map.of(
                "status", "DELETED",
                "message", "Product '" + productName + "' deleted successfully."));
    }

    @PatchMapping("/products/{id}/stock")
    @Operation(summary = "Toggle Product Stock Status", description = "Toggles the in-stock status of a product (true ↔ false). AI agents can use this to mark items as available or unavailable.")
    public ResponseEntity<?> toggleStock(@PathVariable Long id) {
        var productOpt = shopRepo.findById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "NOT_FOUND",
                    "message", "Product with ID " + id + " not found."));
        }

        ShopProduct product = productOpt.get();
        product.setInStock(!product.isInStock());
        shopRepo.save(product);

        return ResponseEntity.ok(Map.of(
                "status", "UPDATED",
                "message",
                "Product '" + product.getName() + "' is now " + (product.isInStock() ? "in stock" : "out of stock")
                        + ".",
                "product", product));
    }
}