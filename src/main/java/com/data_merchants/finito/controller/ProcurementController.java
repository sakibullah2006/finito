package com.data_merchants.finito.controller;

import com.data_merchants.finito.dto.OrderResponse;
import com.data_merchants.finito.service.ProcurementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/procurement")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 🛡️ Safety for Hackathon Demos
@Tag(name = "Procurement Tool", description = "Endpoints for executing purchases and managing orders.")
public class ProcurementController {

    private final ProcurementService procurementService;

    @PostMapping("/order")
    @Operation(summary = "Execute Smart Order", description = "Analyzes inventory gaps, validates items against the Shop Catalog, calculates total cost, and executes the purchase.")
    public ResponseEntity<OrderResponse> placeOrder(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId,
            @RequestBody List<String> ingredients) {

        // The service now handles Shop Validation, Costing, and Inventory Restocking
        var response = procurementService.executeSmartOrder(userId, ingredients);

        return ResponseEntity.ok(response);
    }
}