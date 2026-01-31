package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findByUserId(String userId);

    // 🆕 Find by name (case-insensitive)
    Optional<InventoryItem> findByUserIdAndNameIgnoreCase(String userId, String name);
}
