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

                                shopRepo.save(ShopProduct.builder()
                                                .name("Free Range Eggs (Dozen)")
                                                .price(4.50)
                                                .category("Protein")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/yellow/white?text=Eggs")
                                                .build());

                                // 2. Salmon
                                shopRepo.save(ShopProduct.builder()
                                                .name("Atlantic Salmon Fillet")
                                                .price(15.99)
                                                .category("Protein")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/orange/black?text=Salmon")
                                                .build());

                                // 3. Avocado
                                shopRepo.save(ShopProduct.builder()
                                                .name("Ripe Avocado")
                                                .price(1.50)
                                                .category("Vegetable")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/green/black?text=Avocado")
                                                .build());

                                // 4. Sweet Potato
                                shopRepo.save(ShopProduct.builder()
                                                .name("Sweet Potato")
                                                .price(0.80)
                                                .category("Vegetable")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/orange/white?text=Sweet+Potato")
                                                .build());

                                // 5. Spinach
                                shopRepo.save(ShopProduct.builder()
                                                .name("Organic Spinach")
                                                .price(3.00)
                                                .category("Vegetable")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/green/white?text=Spinach")
                                                .build());

                                // 6. Banana
                                shopRepo.save(ShopProduct.builder()
                                                .name("Banana Bunch")
                                                .price(1.20)
                                                .category("Fruit")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/yellow/black?text=Banana")
                                                .build());

                                // 7. Oats
                                shopRepo.save(ShopProduct.builder()
                                                .name("Rolled Oats")
                                                .price(2.50)
                                                .category("Grain")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/brown/white?text=Oats")
                                                .build());

                                // 8. Blueberries
                                shopRepo.save(ShopProduct.builder()
                                                .name("Fresh Blueberries")
                                                .price(4.99)
                                                .category("Fruit")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/blue/white?text=Blueberries")
                                                .build());

                                // 9. Peanut Butter
                                shopRepo.save(ShopProduct.builder()
                                                .name("Natural Peanut Butter")
                                                .price(5.50)
                                                .category("Pantry")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/brown/yellow?text=Peanut+Butter")
                                                .build());

                                // 10. Whole Wheat Bread
                                shopRepo.save(ShopProduct.builder()
                                                .name("Whole Wheat Bread")
                                                .price(3.20)
                                                .category("Grain")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/brown/black?text=Bread")
                                                .build());

                                // 11. Tuna
                                shopRepo.save(ShopProduct.builder()
                                                .name("Canned Tuna")
                                                .price(1.80)
                                                .category("Protein")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/grey/blue?text=Tuna")
                                                .build());

                                // 12. Asparagus
                                shopRepo.save(ShopProduct.builder()
                                                .name("Asparagus Bundle")
                                                .price(3.99)
                                                .category("Vegetable")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/green/white?text=Asparagus")
                                                .build());

                                // 13. Cottage Cheese
                                shopRepo.save(ShopProduct.builder()
                                                .name("Low Fat Cottage Cheese")
                                                .price(3.50)
                                                .category("Dairy")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/white/blue?text=Cottage+Cheese")
                                                .build());

                                // 14. Dark Chocolate
                                shopRepo.save(ShopProduct.builder()
                                                .name("Dark Chocolate 85%")
                                                .price(2.99)
                                                .category("Pantry")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/black/white?text=Chocolate")
                                                .build());

                                // 15. Quinoa
                                shopRepo.save(ShopProduct.builder()
                                                .name("Quinoa Pack")
                                                .price(6.00)
                                                .category("Grain")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/yellow/red?text=Quinoa")
                                                .build());

                                // 16. Apple
                                shopRepo.save(ShopProduct.builder()
                                                .name("Gala Apple")
                                                .price(0.50)
                                                .category("Fruit")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/red/white?text=Apple")
                                                .build());

                                // 17. Green Tea
                                shopRepo.save(ShopProduct.builder()
                                                .name("Green Tea Box")
                                                .price(4.00)
                                                .category("Pantry")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/green/white?text=Green+Tea")
                                                .build());

                                // 18. Multivitamin
                                shopRepo.save(ShopProduct.builder()
                                                .name("Daily Multivitamin")
                                                .price(12.00)
                                                .category("Supplement")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/white/blue?text=Multivitamin")
                                                .build());

                                // 19. Ground Beef
                                shopRepo.save(ShopProduct.builder()
                                                .name("Lean Ground Beef")
                                                .price(8.99)
                                                .category("Protein")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/red/white?text=Beef")
                                                .build());

                                // 20. Olive Oil
                                shopRepo.save(ShopProduct.builder()
                                                .name("Extra Virgin Olive Oil")
                                                .price(9.99)
                                                .category("Pantry")
                                                .inStock(true)
                                                .imageUrl("https://placehold.co/400x300/black/yellow?text=EVOO")
                                                .build());

                                System.out.println("✅ SHOP OPEN: Inventory stocked with 20 visual assets.");

                        }
                };
        }
}