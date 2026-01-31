package com.data_merchants.finito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // "MEAL", "WORKOUT", "SLEEP"
    private String activityType;

    // "Ate a chicken salad", "Ran 5km"
    @Column(length = 1000)
    private String description;

    // Optional: Impact score logic for advanced scoring
    private Integer impactScore;
}