package com.data_merchants.finito.controller;

import com.data_merchants.finito.dto.ActivityRequest;
import com.data_merchants.finito.model.ActivityLog;
import com.data_merchants.finito.repository.ActivityLogRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Lifestyle Activity Tool", description = "Allows the Agent to read and write user activities.")
public class ActivityController {

    private final ActivityLogRepository activityRepo;

    @PostMapping("/log")
    @Operation(summary = "Log New Activity", description = "Records an event. Expects an 'impactScore' (1-10) based on Agent's reasoning.")
    public ResponseEntity<ActivityLog> logActivity(
            @RequestHeader(value = "X-User-Id", defaultValue = "416c69636544656661756c7455736572") String userId,
            @RequestBody ActivityRequest request) {

        // Agent decides the score. We verify it exists.
        int score = (request.impactScore() != null) ? request.impactScore() : 5;

        ActivityLog log = ActivityLog.builder()
                .userId(userId)
                .timestamp(LocalDateTime.now())
                .activityType(request.type().name())
                .description(request.description())
                .impactScore(score)
                .build();

        return ResponseEntity.ok(activityRepo.save(log));
    }

    @GetMapping("/history")
    @Operation(summary = "Get Activity History", description = "Retrieves recent logs.")
    public ResponseEntity<List<ActivityLog>> getActivityHistory(
            @RequestHeader(value = "X-User-Id", defaultValue = "416c69636544656661756c7455736572") String userId,
            @RequestParam(required = false) String type) {

        if (type != null && !type.isBlank()) {
            return ResponseEntity
                    .ok(activityRepo.findByUserIdAndActivityTypeOrderByTimestampDesc(userId, type.toUpperCase()));
        }
        return ResponseEntity.ok(activityRepo.findByUserIdOrderByTimestampDesc(userId));
    }
}