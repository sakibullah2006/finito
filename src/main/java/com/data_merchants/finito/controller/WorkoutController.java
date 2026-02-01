package com.data_merchants.finito.controller;

import com.data_merchants.finito.dto.ReadinessResponse;
import com.data_merchants.finito.dto.WorkoutPlanSaveRequest;
import com.data_merchants.finito.model.WorkoutPlan;
import com.data_merchants.finito.service.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workouts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Workout Agent Tool", description = "Manages exercise plans and calculates user readiness.")
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping("/save")
    @Operation(summary = "Save Workout Plan", operationId = "saveWorkoutPlan", description = "Saves the AI-generated workout routine to the user's dashboard. The plan content should include exercises, sets, reps, and rest periods in markdown format.")
    public ResponseEntity<WorkoutPlan> savePlan(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId,
            @RequestBody WorkoutPlanSaveRequest request) {
        return ResponseEntity.ok(workoutService.saveAIPlan(userId, request));
    }

    @GetMapping("/current")
    @Operation(summary = "Get Active Workout Plan", operationId = "getCurrentWorkoutPlan", description = "Retrieves the user's current active workout routine. Returns the most recently saved workout plan, or null if none exists.")
    public ResponseEntity<WorkoutPlan> getCurrentPlan(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId) {
        return ResponseEntity.ok(workoutService.getCurrentPlan(userId));
    }

    @GetMapping("/readiness")
    @Operation(summary = "Check Recovery Status", operationId = "getReadiness", description = "Calculates the user's readiness score based on Fatigue vs Fitness metrics from recent workout and sleep data. Returns a readiness percentage and recommendation.")
    public ResponseEntity<ReadinessResponse> getReadiness(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId) {
        return ResponseEntity.ok(workoutService.calculateReadiness(userId));
    }
}