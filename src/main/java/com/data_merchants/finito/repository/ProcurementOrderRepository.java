package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.ProcurementOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProcurementOrderRepository extends JpaRepository<ProcurementOrder, String> {
    List<ProcurementOrder> findByUserId(String userId);
}
