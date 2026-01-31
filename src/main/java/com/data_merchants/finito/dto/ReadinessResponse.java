package com.data_merchants.finito.dto;

public record ReadinessResponse(
                String status, // "FRESH", "FATIGUED", "OVERREACHED"
                Integer score, // 0-100 (100 = Fully Recovered)
                String recommendation // Clinical advice for the user
) {
}