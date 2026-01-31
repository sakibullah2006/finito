package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<ShopProduct, Long> {

    // Used by the Agent to search for specific items (e.g., "Do you have Tofu?")
    List<ShopProduct> findByNameContainingIgnoreCase(String name);

    // Used by the Dashboard and Agent to see the full catalog
    List<ShopProduct> findByInStockTrue();
}