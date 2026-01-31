package com.data_merchants.finito.config;

import com.data_merchants.finito.model.ShopProduct;
import com.data_merchants.finito.repository.ShopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopDataSeeder {

    @Bean
    CommandLineRunner initShopData(ShopRepository shopRepo) {
        return args -> {
            // Only seed if empty to prevent duplicates on restart
            if (shopRepo.count() == 0) {
                shopRepo.save(new ShopProduct(null, "Organic Chicken Breast", 12.99, "Protein", true,
                        "https://placehold.co/400x300/orange/white?text=Chicken+Breast"));

                shopRepo.save(new ShopProduct(null, "Firm Tofu Block", 3.50, "Protein", true,
                        "https://placehold.co/400x300/green/white?text=Tofu"));

                shopRepo.save(new ShopProduct(null, "Whey Protein Isolate", 29.99, "Supplement", true,
                        "https://placehold.co/400x300/black/white?text=Whey+Protein"));

                shopRepo.save(new ShopProduct(null, "Fresh Broccoli", 2.20, "Vegetable", true,
                        "https://placehold.co/400x300/green/white?text=Broccoli"));

                shopRepo.save(new ShopProduct(null, "Jasmine Rice", 5.00, "Grain", true,
                        "https://placehold.co/400x300/yellow/black?text=Rice"));

                shopRepo.save(new ShopProduct(null, "Greek Yogurt", 4.50, "Dairy", true,
                        "https://placehold.co/400x300/blue/white?text=Greek+Yogurt"));

                shopRepo.save(new ShopProduct(null, "Almond Milk", 3.99, "Dairy", true,
                        "https://placehold.co/400x300/brown/white?text=Almond+Milk"));

                System.out.println("✅ SHOP OPEN: Inventory stocked with visual assets.");
            }
        };
    }
}