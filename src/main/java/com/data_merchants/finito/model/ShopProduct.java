package com.data_merchants.finito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g., "Organic Chicken Breast"

    private Double price;

    private String category; // "Protein", "Vegetable", "Dairy"

    private boolean inStock;

    // The visual hook for your dashboard
    @Column(length = 1000)
    private String imageUrl;
}