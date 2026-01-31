package com.data_merchants.finito.config;

import com.data_merchants.finito.model.InventoryItem;
import com.data_merchants.finito.model.UserProfile;
import com.data_merchants.finito.repository.InventoryRepository;
import com.data_merchants.finito.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryDataSeeder {

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

            if (inventoryRepo.count() == 0) {
                // 1. Salt (Essential, usually in stock)
                inventoryRepo.save(InventoryItem.builder()
                        .userId("Alice")
                        .name("Salt")
                        .quantity(1.0)
                        .unit("kg")
                        .category("Pantry")
                        .imageUrl("https://placehold.co/400x300/grey/white?text=Salt")
                        .build());

                // 2. Olive Oil (Essential)
                inventoryRepo.save(InventoryItem.builder()
                        .userId("Alice")
                        .name("Olive Oil")
                        .quantity(0.5)
                        .unit("liters")
                        .category("Pantry")
                        .imageUrl("https://placehold.co/400x300/yellow/black?text=Olive+Oil")
                        .build());

                // 3. Rice (Partially stocked)
                inventoryRepo.save(InventoryItem.builder()
                        .userId("Alice")
                        .name("Jasmine Rice")
                        .quantity(2.0)
                        .unit("kg")
                        .category("Grain")
                        .imageUrl("https://placehold.co/400x300/yellow/black?text=Rice")
                        .build());

                System.out.println("✅ Inventory seeded with visual assets.");
            }
        };
    }
}