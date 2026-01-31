package com.data_merchants.finito.service;

import com.data_merchants.finito.dto.ReadinessResponse;
import com.data_merchants.finito.dto.WorkoutPlanSaveRequest;
import com.data_merchants.finito.model.ActivityLog;
import com.data_merchants.finito.model.WorkoutPlan;
import com.data_merchants.finito.repository.ActivityLogRepository;
import com.data_merchants.finito.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkoutService {

    private final WorkoutPlanRepository planRepo;
    private final ActivityLogRepository activityRepo;

    @Transactional
    public WorkoutPlan saveAIPlan(String userId, WorkoutPlanSaveRequest request) {
        log.info("🏋️ SAVING AI WORKOUT for User: {}", userId);
        WorkoutPlan plan = WorkoutPlan.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .createdDate(LocalDate.now())
                .goal(request.goal())
                .content(request.planContent())
                .build();
        return planRepo.save(plan);
    }

    public WorkoutPlan getCurrentPlan(String userId) {
        return planRepo.findTopByUserIdOrderByCreatedDateDesc(userId).orElse(null);
    }

    /**
     * 🧪 BANISTER MODEL IMPLEMENTATION
     * Calculates Readiness (0-100) based on decay of Fatigue vs Recovery.
     */
    public ReadinessResponse calculateReadiness(String userId) {
        List<ActivityLog> history = activityRepo.findByUserIdOrderByTimestampDesc(userId);
        LocalDateTime now = LocalDateTime.now();

        double fatigueAccumulation = 0.0;
        double recoveryAccumulation = 0.0;

        for (ActivityLog log : history) {
            long hoursAgo = Duration.between(log.getTimestamp(), now).toHours();
            if (hoursAgo > 168)
                break; // Ignore history older than 7 days

            // Get Agent's Impact Score (Default to 5 if missing)
            double impact = (log.getImpactScore() != null) ? log.getImpactScore() : 5.0;

            if ("WORKOUT".equalsIgnoreCase(log.getActivityType())) {
                // 📉 Fatigue Decay (24h constant)
                double decay = Math.exp(-hoursAgo / 24.0);
                fatigueAccumulation += (impact * 10.0) * decay;

            } else if ("SLEEP".equalsIgnoreCase(log.getActivityType())) {
                // 🔋 Recovery Decay (12h constant - sleep effects fade faster)
                double decay = Math.exp(-hoursAgo / 12.0);
                recoveryAccumulation += (impact * 8.0) * decay;
            }
        }

        // Base Readiness (80 is neutral baseline)
        double rawScore = 80.0 + recoveryAccumulation - fatigueAccumulation;
        int finalScore = (int) Math.min(100, Math.max(0, rawScore));

        // Clinical Status Logic
        String status;
        String recommendation;

        if (finalScore < 40) {
            status = "OVERREACHED";
            recommendation = "High CNS Stress. Risk of injury. Recommendation: REST or Meditation.";
        } else if (finalScore < 70) {
            status = "FATIGUED";
            recommendation = "Residual fatigue detected. Recommendation: Low Intensity (Yoga, Walk).";
        } else if (finalScore < 90) {
            status = "READY";
            recommendation = "System operational. Proceed with standard training plan.";
        } else {
            status = "PEAKING";
            recommendation = "High readiness! You are primed for a PR or HIIT session.";
        }

        return new ReadinessResponse(status, finalScore, recommendation);
    }
}