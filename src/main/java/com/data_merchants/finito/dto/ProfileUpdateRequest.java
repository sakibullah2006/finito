package com.data_merchants.finito.dto;

public record ProfileUpdateRequest(
        Double weight,
        Double height,
        String currentGoal, // e.g., "Muscle Gain"
        String dietaryRestrictions,
        Integer dailyCalorieTarget) {
}