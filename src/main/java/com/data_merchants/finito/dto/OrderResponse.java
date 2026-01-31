package com.data_merchants.finito.dto;

/**
 * The "Receipt" returned to the AI Agent.
 * The Agent uses the 'message' field to confirm success to the user.
 */
public record OrderResponse(
        String orderId,
        String status, // e.g., "SUCCESS", "SKIPPED", "FAILED"
        String message // Human-readable explanation for the Agent to speak
) {
}