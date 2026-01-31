
package com.data_merchants.finito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "meal_plans")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String userId;

    private LocalDate planDate;

    // Storing the entire plan description as text (easier for Hackathon than
    // complex relationships)
    @Column(length = 5000)
    private String description;

    // e.g., "High Protein", "Vegetarian"
    private String goalType;
}