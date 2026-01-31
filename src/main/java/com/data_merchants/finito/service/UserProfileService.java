package com.data_merchants.finito.service;

import com.data_merchants.finito.dto.ProfileUpdateRequest;
import com.data_merchants.finito.model.UserProfile;
import com.data_merchants.finito.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileService {

    private final UserProfileRepository profileRepo;

    public UserProfile getProfile(String userId) {
        return profileRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Digital Twin not found for: " + userId));
    }

    @Transactional
    public UserProfile updateProfile(String userId, ProfileUpdateRequest request) {
        UserProfile profile = getProfile(userId);

        // Smart Update: Only update fields that the Agent sends
        if (request.weight() != null)
            profile.setWeight(request.weight());
        if (request.height() != null)
            profile.setHeight(request.height());
        if (request.currentGoal() != null)
            profile.setCurrentGoal(request.currentGoal());
        if (request.dailyCalorieTarget() != null)
            profile.setDailyCalorieTarget(request.dailyCalorieTarget());
        if (request.dietaryRestrictions() != null)
            profile.setDietaryRestrictions(request.dietaryRestrictions());

        UserProfile saved = profileRepo.save(profile);

        // 📢 DEMO LOGGING: Show that the update triggered a calculation
        log.info("📝 TWIN UPDATED for User: {}", userId);
        log.info("⚖️ New Stats: {}kg / {}cm", saved.getWeight(), saved.getHeight());
        log.info("🧮 Recalculated BMI: {}", String.format("%.2f", saved.getBMI()));

        return saved;
    }
}