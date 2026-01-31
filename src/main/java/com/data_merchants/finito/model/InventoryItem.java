package com.data_merchants.finito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    private Double quantity;

    private String unit;

    // 🆕 Visual Consistency with ShopProduct
    private String category; // e.g., "Protein"

    @Column(length = 1000)
    private String imageUrl; // e.g., "https://placehold.co/..."

    public boolean isLowStock() {
        return quantity != null && quantity < 1.0;
    }
}