package com.data_merchants.finito.repository;

import com.data_merchants.finito.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
    // Basic CRUD is sufficient
}
