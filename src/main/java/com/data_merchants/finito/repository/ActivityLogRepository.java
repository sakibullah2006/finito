package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    // Agent: "What did Alice do recently?"
    List<ActivityLog> findByUserIdOrderByTimestampDesc(String userId);

    // Agent: "Show me Alice's workouts"
    List<ActivityLog> findByUserIdAndActivityTypeOrderByTimestampDesc(String userId, String activityType);
}