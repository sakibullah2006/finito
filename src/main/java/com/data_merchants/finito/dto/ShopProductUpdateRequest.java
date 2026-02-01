package com.data_merchants.finito.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to update an existing shop product")
public record ShopProductUpdateRequest(
        @Schema(description = "Updated product name (optional)", example = "Organic Bananas") String name,

        @Schema(description = "Updated product price (optional)", example = "3.49") Double price,

        @Schema(description = "Updated product category (optional)", example = "Fruit") String category,

        @Schema(description = "Updated stock status (optional)", example = "true") Boolean inStock,

        @Schema(description = "Updated product image URL (optional)", example = "https://placehold.co/400x300/yellow/black?text=Bananas") String imageUrl) {
}
