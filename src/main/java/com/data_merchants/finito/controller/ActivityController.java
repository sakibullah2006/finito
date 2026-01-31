package com.data_merchants.finito.controller;

import com.data_merchants.finito.model.ActivityLog;
import com.data_merchants.finito.repository.ActivityLogRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import com.data_merchants.finito.dto.ActivityRequest;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Allow Dashboard to show these logs too
@Tag(name = "Lifestyle Activity Tool", description = "Allows the Agent to read and write the user's daily activities (workouts, meals, sleep).")
public class ActivityController {

    private final ActivityLogRepository activityRepo;

    @PostMapping("/log")
    @Operation(summary = "Log New Activity", description = "Records a user event. Call this when the user says they did something (e.g., 'I ate lunch', 'I went for a run').")
    public ResponseEntity<ActivityLog> logActivity(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId,
            @RequestBody ActivityRequest request) {

        // Extract Agent's parameters
        String type = (request.type() != null ? request.type() : "GENERAL").toUpperCase();
        String description = request.description();

        ActivityLog log = ActivityLog.builder()
                .userId(userId)
                .timestamp(LocalDateTime.now())
                .activityType(type)
                .description(description)
                .impactScore(10) // Mock score for Hackathon simplicity
                .build();

        return ResponseEntity.ok(activityRepo.save(log));
    }

    @GetMapping("/history")
    @Operation(summary = "Get Activity History", description = "Retrieves recent activities. Use this to summarize what the user has done or check for consistency.")
    public ResponseEntity<List<ActivityLog>> getActivityHistory(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId,
            @RequestParam(required = false) String type) {

        if (type != null && !type.isBlank()) {
            return ResponseEntity
                    .ok(activityRepo.findByUserIdAndActivityTypeOrderByTimestampDesc(userId, type.toUpperCase()));
        }
        return ResponseEntity.ok(activityRepo.findByUserIdOrderByTimestampDesc(userId));
    }
}