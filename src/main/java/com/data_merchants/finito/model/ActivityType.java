package com.data_merchants.finito.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Type of activity being logged")
public enum ActivityType {
    @Schema(description = "Physical exercise or workout session")
    WORKOUT,

    @Schema(description = "Sleep or rest period")
    SLEEP,

    @Schema(description = "Meal or food consumption")
    MEAL
}
