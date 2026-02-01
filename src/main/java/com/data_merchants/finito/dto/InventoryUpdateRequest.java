package com.data_merchants.finito.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to update an item's quantity in the user's inventory")
public record InventoryUpdateRequest(
        @Schema(description = "Name of the item to update", example = "Sweet Potato") String itemName,

        @Schema(description = "New quantity value", example = "10.0") Double quantity) {
}
