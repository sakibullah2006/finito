package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, String> {

    // Fetch the most recent plan for the Dashboard
    Optional<MealPlan> findTopByUserIdOrderByPlanDateDesc(String userId);
}