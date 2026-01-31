package com.data_merchants.finito.dto;

public record CreateUserRequest(
        String email,
        String displayName,
        Double weight,
        Double height,
        String currentGoal,
        String dietaryRestrictions,
        Integer dailyCalorieTarget) {
}
