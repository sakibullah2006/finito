package com.data_merchants.finito.config;

import com.data_merchants.finito.model.ActivityLog;
import com.data_merchants.finito.repository.ActivityLogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class ActivityLogDataSeeder {

    @Bean
    CommandLineRunner initActivityLogs(ActivityLogRepository activityRepo) {
        return args -> {
            // Seed only if no logs exist
            if (activityRepo.count() == 0) {
                // Generate 20 logs over the last 10 days
                // Day 10 (Oldest) - Day 1 (Yesterday)

                // Day 10: Heavy Lifting
                activityRepo.save(createLog("Alice", 240, "WORKOUT", "Deadlifts 3x5", 8));
                activityRepo.save(createLog("Alice", 230, "SLEEP", "Good sleep", 8));

                // Day 9: Recovery
                activityRepo.save(createLog("Alice", 216, "WORKOUT", "Yoga Flow", 2));
                activityRepo.save(createLog("Alice", 206, "SLEEP", "Deep sleep", 9));

                // Day 8: HIIT
                activityRepo.save(createLog("Alice", 192, "WORKOUT", "Sprints 10x100m", 9));
                activityRepo.save(createLog("Alice", 182, "SLEEP", "Restless night", 4));

                // Day 7: Fatigue Setting In
                activityRepo.save(createLog("Alice", 168, "WORKOUT", "Bench Press 5x5", 7));
                activityRepo.save(createLog("Alice", 158, "SLEEP", "Okay sleep", 6));

                // Day 6: Rest Day
                activityRepo.save(createLog("Alice", 144, "SLEEP", "Catching up on sleep", 9));

                // Day 5: Cardio
                activityRepo.save(createLog("Alice", 120, "WORKOUT", "5k Run", 6));
                activityRepo.save(createLog("Alice", 110, "SLEEP", "Good sleep", 8));

                // Day 4: Heavy Legs
                activityRepo.save(createLog("Alice", 96, "WORKOUT", "Squats 5x5", 9));
                activityRepo.save(createLog("Alice", 86, "SLEEP", "Slept well", 8));

                // Day 3: Active Recovery
                activityRepo.save(createLog("Alice", 72, "WORKOUT", "Walk in park", 1));
                activityRepo.save(createLog("Alice", 62, "SLEEP", "Great sleep", 9));

                // Day 2: Upper Body Hypertrophy
                activityRepo.save(createLog("Alice", 48, "WORKOUT", "Shoulder Press & Accessories", 7));
                activityRepo.save(createLog("Alice", 38, "SLEEP", "Average sleep", 6));

                // Day 1: Conditioning
                activityRepo.save(createLog("Alice", 24, "WORKOUT", "CrossFit WOD", 8));
                activityRepo.save(createLog("Alice", 14, "SLEEP", "Exhausted, deep sleep", 9));

                // Today: Morning Routine
                activityRepo.save(createLog("Alice", 2, "WORKOUT", "Morning Mobility", 2));

                System.out.println("✅ ACTIVITY HISTORY: Seeded 21 logs (10-day history).");
            }
        };
    }

    private ActivityLog createLog(String userId, int hoursAgo, String type, String desc, int score) {
        return ActivityLog.builder()
                .userId(userId)
                .timestamp(LocalDateTime.now().minusHours(hoursAgo))
                .activityType(type)
                .description(desc)
                .impactScore(score)
                .build();
    }
}
