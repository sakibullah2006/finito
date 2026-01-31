package com.data_merchants.finito.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ActivityRequest(
                @Schema(description = "Type of activity: WORKOUT, SLEEP, or MEAL", example = "WORKOUT") com.data_merchants.finito.model.ActivityType type,

                @Schema(description = "Natural language description", example = "Ran 5km in 25 mins") String description,

                // 🚨 THIS IS THE CRITICAL FIX FOR THE AGENT 🚨
                @Schema(description = "Rate the intensity 1-10. 10=HIIT/Marathon/Deep Sleep. 1=Walking/Light Nap. REQUIRED.", example = "8", requiredMode = Schema.RequiredMode.REQUIRED) Integer impactScore) {
}