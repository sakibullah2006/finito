package com.data_merchants.finito.controller;

import com.data_merchants.finito.dto.ProfileUpdateRequest;
import com.data_merchants.finito.model.UserProfile;
import com.data_merchants.finito.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Digital Twin Profile Tool", description = "Read and Update the user's biological stats and goals.")
public class UserProfileController {

    private final UserProfileService profileService;

    @GetMapping
    @Operation(summary = "Get Biological Profile", description = "Reads the user's weight, height, BMI, and goals.")
    public ResponseEntity<UserProfile> getProfile(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId) {
        return ResponseEntity.ok(profileService.getProfile(userId));
    }

    @PutMapping
    @Operation(summary = "Update Profile Stats", description = "Updates weight, height, or goals. Call this when the user says 'I lost weight' or 'I want to build muscle'.")
    public ResponseEntity<UserProfile> updateProfile(
            @RequestHeader(value = "X-User-Id", defaultValue = "Alice") String userId,
            @RequestBody ProfileUpdateRequest request) {
        return ResponseEntity.ok(profileService.updateProfile(userId, request));
    }
}