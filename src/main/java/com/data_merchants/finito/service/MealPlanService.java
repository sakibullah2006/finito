package com.data_merchants.finito.service;

import com.data_merchants.finito.dto.MealPlanSaveRequest;
import com.data_merchants.finito.model.MealPlan;
import com.data_merchants.finito.repository.MealPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealPlanService {

    private final MealPlanRepository planRepo;

    @Transactional
    public MealPlan saveAIPlan(String userId, MealPlanSaveRequest request) {
        log.info("📝 SAVING AI PLAN for User: {}", userId);

        MealPlan plan = MealPlan.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .planDate(LocalDate.now())
                .goalType(request.goalType())
                .description(request.planContent()) // <--- Storing the AI's brain output
                .build();

        return planRepo.save(plan);
    }

    public MealPlan getCurrentPlan(String userId) {
        return planRepo.findTopByUserIdOrderByPlanDateDesc(userId)
                .orElse(null);
    }
}