package com.data_merchants.finito.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to add an item to the user's inventory")
public record InventoryAddRequest(
        @Schema(description = "Name of the item to add (e.g., 'Sweet Potato', 'Organic Chicken Breast')", example = "Sweet Potato") String itemName,

        @Schema(description = "Quantity to add", example = "5.0", defaultValue = "1.0") Double quantity,

        @Schema(description = "Unit of measurement", example = "unit", defaultValue = "unit") String unit) {
}
