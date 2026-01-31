package com.data_merchants.finito.controller;

import com.data_merchants.finito.model.ShopProduct;
import com.data_merchants.finito.repository.ShopRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shop")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Critical for Next.js Dashboard access
@Tag(name = "Shop Catalog Tool", description = "Allows the Agent and Dashboard to view available inventory.")
public class ShopController {

    private final ShopRepository shopRepo;

    @GetMapping("/catalog")
    @Operation(summary = "Get Full Catalog", description = "Retrieves a list of all products currently in stock. Use this to discover what items can be ordered.")
    public ResponseEntity<List<ShopProduct>> getCatalog() {
        return ResponseEntity.ok(shopRepo.findByInStockTrue());
    }

    @GetMapping("/search")
    @Operation(summary = "Search Product", description = "Search for a specific product by name (e.g., 'Chicken'). Returns availability and price.")
    public ResponseEntity<List<ShopProduct>> searchProduct(@RequestParam String query) {
        return ResponseEntity.ok(shopRepo.findByNameContainingIgnoreCase(query));
    }
}