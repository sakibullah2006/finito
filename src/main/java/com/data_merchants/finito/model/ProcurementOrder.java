package com.data_merchants.finito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "procurement_orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementOrder {

    @Id
    private String orderId;

    @Column(nullable = false)
    private String userId;

    private LocalDateTime createdAt;

    private String status;

    // 🆕 Track the money!
    private Double totalCost;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "item_name")
    private List<String> items;
}