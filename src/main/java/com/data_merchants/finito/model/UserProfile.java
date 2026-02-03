package com.data_merchants.finito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_profiles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @Column(nullable = false, unique = true)
    private String userId; // Links to the "Context Injected" ID (e.g., "Alice")

    @Column(nullable = false, unique = true)
    private String email;

    private String displayName;

    // "Weight Loss", "Muscle Gain", "Maintenance"
    private String currentGoal;

    // Comma-separated list: "Vegetarian,Gluten-Free"
    private String dietaryRestrictions;

    private Integer dailyCalorieTarget;

    // 🆕 New Biological Data
    private Double weight; // stored in kg
    private Double height; // stored in cm

    // Helper: You can call this in your Service to "reason" about BMI
    public Double getBMI() {
        if (weight != null && height != null && height > 0) {
            double heightInMeters = height / 100.0;
            return weight / (heightInMeters * heightInMeters);
        }
        return 0.0;
    }
}