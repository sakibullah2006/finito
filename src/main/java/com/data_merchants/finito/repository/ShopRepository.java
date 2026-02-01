package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<ShopProduct, Long> {

        // Used by the Agent to search for specific items (e.g., "Do you have Tofu?")
        List<ShopProduct> findByNameContainingIgnoreCase(String name);

        // Exact match for precise lookups (e.g., "Sweet Potato")
        Optional<ShopProduct> findByNameIgnoreCase(String name);

        // Used by the Dashboard and Agent to see the full catalog
        org.springframework.data.domain.Page<ShopProduct> findByInStockTrue(
                        org.springframework.data.domain.Pageable pageable);

        // Used for category-based filtering
        org.springframework.data.domain.Page<ShopProduct> findByCategoryIgnoreCase(String category,
                        org.springframework.data.domain.Pageable pageable);
}