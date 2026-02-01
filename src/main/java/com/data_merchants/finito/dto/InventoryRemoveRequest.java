package com.data_merchants.finito.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to remove an item from the user's inventory")
public record InventoryRemoveRequest(
        @Schema(description = "Name of the item to remove", example = "Sweet Potato") String itemName) {
}
