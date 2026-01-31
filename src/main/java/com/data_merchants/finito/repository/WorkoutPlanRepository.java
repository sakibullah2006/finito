package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, String> {
    Optional<WorkoutPlan> findTopByUserIdOrderByCreatedDateDesc(String userId);
}