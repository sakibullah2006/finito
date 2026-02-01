package com.data_merchants.finito.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to create a new shop product")
public record ShopProductCreateRequest(
        @Schema(description = "Product name (must be unique)", example = "Organic Bananas") String name,

        @Schema(description = "Product price", example = "2.99") Double price,

        @Schema(description = "Product category (e.g., 'Protein', 'Vegetable', 'Fruit', 'Grain', 'Dairy', 'Pantry', 'Supplement')", example = "Fruit") String category,

        @Schema(description = "Whether product is in stock", example = "true", defaultValue = "true") Boolean inStock,

        @Schema(description = "Product image URL", example = "https://placehold.co/400x300/yellow/black?text=Bananas") String imageUrl) {
}
