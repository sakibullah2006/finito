package com.data_merchants.finito.config;

import com.data_merchants.finito.model.InventoryItem;
import com.data_merchants.finito.model.UserProfile;
import com.data_merchants.finito.repository.InventoryRepository;
import com.data_merchants.finito.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(InventoryRepository inventoryRepo, UserProfileRepository profileRepo) {
        return args -> {
            // 1. Seed Profile (The "Digital Twin")
            if (profileRepo.count() == 0) {
                profileRepo.save(UserProfile.builder()
                        .userId("Alice")
                        .email("alice@example.com")
                        .displayName("Alice the Architect")
                        .currentGoal("Sustainable Energy")
                        .dietaryRestrictions("Peanut-Free")
                        .dailyCalorieTarget(2200)
                        .weight(65.5) // kg
                        .height(170.0) // cm
                        .build());
                System.out.println("✅ Digital Twin 'Alice' created with Weight/Height stats.");
            }

            // 2. Seed Inventory (The "Reasoning" Data)
            if (inventoryRepo.count() == 0) {
                inventoryRepo
                        .save(InventoryItem.builder().userId("Alice").name("Salt").quantity(1.0).unit("kg").build());
                inventoryRepo.save(
                        InventoryItem.builder().userId("Alice").name("Olive Oil").quantity(0.5).unit("liters").build());
                inventoryRepo
                        .save(InventoryItem.builder().userId("Alice").name("Rice").quantity(2.0).unit("kg").build());
                System.out.println("✅ Inventory initialized.");
            }
        };
    }
}