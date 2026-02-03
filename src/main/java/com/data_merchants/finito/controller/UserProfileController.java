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
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId) {
        return ResponseEntity.ok(profileService.getProfile(userId));
    }

    @GetMapping("/search")
    @Operation(summary = "Find User by Email", description = "Looks up a user profile by email address.")
    public ResponseEntity<UserProfile> searchUser(
            @RequestParam("email") String email) {
        return ResponseEntity.ok(profileService.getUserByEmail(email));
    }

    @PostMapping
    @Operation(summary = "Create New Profile", description = "Creates a new user profile with initial stats and goals.")
    public ResponseEntity<UserProfile> createUser(
            @RequestBody com.data_merchants.finito.dto.CreateUserRequest request) {
        return ResponseEntity.ok(profileService.createUser(request));
    }

    @PutMapping
    @Operation(summary = "Update Profile Stats", description = "Updates weight, height, or goals. Call this when the user says 'I lost weight' or 'I want to build muscle'.")
    public ResponseEntity<UserProfile> updateProfile(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId,
            @RequestBody ProfileUpdateRequest request) {
        return ResponseEntity.ok(profileService.updateProfile(userId, request));
    }

    @DeleteMapping
    @Operation(summary = "Delete User Profile", description = "Permanently deletes a user profile and all associated data (inventory, meal plans, workout plans, activity logs, orders). Use with caution. AI agents can use this for account deletion requests.")
    public ResponseEntity<?> deleteUser(
            @RequestHeader(value = "X-User-Id", defaultValue = "477565737444656661756c7455736572") String userId) {
        profileService.deleteUser(userId);
        return ResponseEntity.ok(java.util.Map.of(
                "status", "DELETED",
                "message", "User profile and all associated data for '" + userId + "' has been permanently deleted."));
    }
}