package com.data_merchants.finito.config;

import com.data_merchants.finito.model.ShopProduct;
import com.data_merchants.finito.repository.ShopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.ArrayList;

@Configuration
public class ShopDataSeeder {

        @Bean
        CommandLineRunner initShopData(ShopRepository shopRepo) {
                return args -> {
                        if (shopRepo.count() == 0) {
                                List<ShopProduct> products = new ArrayList<>();

                                // Proteins
                                products.add(new ShopProduct(null, "Organic Chicken Breast", 12.99, "Protein", true,
                                                "https://placehold.co/400x300/orange/white?text=Chicken+Breast"));
                                products.add(new ShopProduct(null, "Firm Tofu Block", 3.50, "Protein", true,
                                                "https://placehold.co/400x300/green/white?text=Tofu"));
                                products.add(new ShopProduct(null, "Atlantic Salmon Fillet", 15.99, "Protein", true,
                                                "https://placehold.co/400x300/orange/black?text=Salmon"));
                                products.add(new ShopProduct(null, "Free Range Eggs (Dozen)", 4.50, "Protein", true,
                                                "https://placehold.co/400x300/yellow/white?text=Eggs"));
                                products.add(new ShopProduct(null, "Canned Tuna", 1.80, "Protein", true,
                                                "https://placehold.co/400x300/grey/blue?text=Tuna"));
                                products.add(new ShopProduct(null, "Lean Ground Beef", 8.99, "Protein", true,
                                                "https://placehold.co/400x300/red/white?text=Beef"));
                                products.add(new ShopProduct(null, "Turkey Breast", 9.99, "Protein", true,
                                                "https://placehold.co/400x300/orange/white?text=Turkey"));
                                products.add(new ShopProduct(null, "Tilapia Fillet", 7.50, "Protein", true,
                                                "https://placehold.co/400x300/white/blue?text=Tilapia"));
                                products.add(new ShopProduct(null, "Shrimp (Frozen)", 13.99, "Protein", true,
                                                "https://placehold.co/400x300/pink/white?text=Shrimp"));
                                products.add(new ShopProduct(null, "Pork Tenderloin", 8.50, "Protein", true,
                                                "https://placehold.co/400x300/pink/black?text=Pork"));
                                products.add(new ShopProduct(null, "Lamb Chops", 18.99, "Protein", true,
                                                "https://placehold.co/400x300/red/white?text=Lamb"));
                                products.add(new ShopProduct(null, "Cod Fillet", 10.99, "Protein", true,
                                                "https://placehold.co/400x300/white/blue?text=Cod"));
                                products.add(new ShopProduct(null, "Black Beans (Canned)", 1.29, "Protein", true,
                                                "https://placehold.co/400x300/black/white?text=Black+Beans"));
                                products.add(new ShopProduct(null, "Chickpeas (Canned)", 1.29, "Protein", true,
                                                "https://placehold.co/400x300/yellow/black?text=Chickpeas"));
                                products.add(new ShopProduct(null, "Lentils (Dry)", 2.49, "Protein", true,
                                                "https://placehold.co/400x300/brown/white?text=Lentils"));
                                products.add(new ShopProduct(null, "Edamame", 3.99, "Protein", true,
                                                "https://placehold.co/400x300/green/white?text=Edamame"));
                                products.add(new ShopProduct(null, "Seitan", 5.99, "Protein", true,
                                                "https://placehold.co/400x300/brown/white?text=Seitan"));
                                products.add(new ShopProduct(null, "Tempeh", 4.50, "Protein", true,
                                                "https://placehold.co/400x300/brown/white?text=Tempeh"));
                                products.add(new ShopProduct(null, "Venison Steak", 22.99, "Protein", true,
                                                "https://placehold.co/400x300/red/black?text=Venison"));
                                products.add(new ShopProduct(null, "Duck Breast", 16.99, "Protein", true,
                                                "https://placehold.co/400x300/brown/white?text=Duck"));

                                // Vegetables
                                products.add(new ShopProduct(null, "Fresh Broccoli", 2.20, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Broccoli"));
                                products.add(new ShopProduct(null, "Ripe Avocado", 1.50, "Vegetable", true,
                                                "https://placehold.co/400x300/green/black?text=Avocado"));
                                products.add(new ShopProduct(null, "Sweet Potato", 0.80, "Vegetable", true,
                                                "https://placehold.co/400x300/orange/white?text=Sweet+Potato"));
                                products.add(new ShopProduct(null, "Organic Spinach", 3.00, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Spinach"));
                                products.add(new ShopProduct(null, "Asparagus Bundle", 3.99, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Asparagus"));
                                products.add(new ShopProduct(null, "Kale Bunch", 2.50, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Kale"));
                                products.add(new ShopProduct(null, "Bell Pepper (Red)", 1.20, "Vegetable", true,
                                                "https://placehold.co/400x300/red/white?text=Red+Pepper"));
                                products.add(new ShopProduct(null, "Carrots (Bag)", 1.99, "Vegetable", true,
                                                "https://placehold.co/400x300/orange/white?text=Carrots"));
                                products.add(new ShopProduct(null, "Cucumber", 0.99, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Cucumber"));
                                products.add(new ShopProduct(null, "Zucchini", 1.25, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Zucchini"));
                                products.add(new ShopProduct(null, "Cauliflower Head", 3.50, "Vegetable", true,
                                                "https://placehold.co/400x300/white/black?text=Cauliflower"));
                                products.add(new ShopProduct(null, "Brussels Sprouts", 3.99, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Brussels+Sprouts"));
                                products.add(new ShopProduct(null, "Green Beans", 2.99, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Green+Beans"));
                                products.add(new ShopProduct(null, "Mushrooms (Button)", 2.49, "Vegetable", true,
                                                "https://placehold.co/400x300/brown/white?text=Mushrooms"));
                                products.add(new ShopProduct(null, "Red Onion", 0.85, "Vegetable", true,
                                                "https://placehold.co/400x300/purple/white?text=Red+Onion"));
                                products.add(new ShopProduct(null, "Garlic Bulb", 0.50, "Vegetable", true,
                                                "https://placehold.co/400x300/white/black?text=Garlic"));
                                products.add(new ShopProduct(null, "Cherry Tomatoes", 3.25, "Vegetable", true,
                                                "https://placehold.co/400x300/red/white?text=Cherry+Tomatoes"));
                                products.add(new ShopProduct(null, "Romaine Lettuce", 2.00, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Lettuce"));
                                products.add(new ShopProduct(null, "Eggplant", 1.75, "Vegetable", true,
                                                "https://placehold.co/400x300/purple/white?text=Eggplant"));
                                products.add(new ShopProduct(null, "Celery Stalks", 1.99, "Vegetable", true,
                                                "https://placehold.co/400x300/green/white?text=Celery"));

                                // Fruits
                                products.add(new ShopProduct(null, "Banana Bunch", 1.20, "Fruit", true,
                                                "https://placehold.co/400x300/yellow/black?text=Banana"));
                                products.add(new ShopProduct(null, "Fresh Blueberries", 4.99, "Fruit", true,
                                                "https://placehold.co/400x300/blue/white?text=Blueberries"));
                                products.add(new ShopProduct(null, "Gala Apple", 0.50, "Fruit", true,
                                                "https://placehold.co/400x300/red/white?text=Apple"));
                                products.add(new ShopProduct(null, "Orange", 0.75, "Fruit", true,
                                                "https://placehold.co/400x300/orange/white?text=Orange"));
                                products.add(new ShopProduct(null, "Strawberries", 3.99, "Fruit", true,
                                                "https://placehold.co/400x300/red/white?text=Strawberries"));
                                products.add(new ShopProduct(null, "Raspberries", 4.50, "Fruit", true,
                                                "https://placehold.co/400x300/red/white?text=Raspberries"));
                                products.add(new ShopProduct(null, "Pineapple", 3.50, "Fruit", true,
                                                "https://placehold.co/400x300/yellow/black?text=Pineapple"));
                                products.add(new ShopProduct(null, "Mango", 1.50, "Fruit", true,
                                                "https://placehold.co/400x300/orange/red?text=Mango"));
                                products.add(new ShopProduct(null, "Grapes (Green)", 3.99, "Fruit", true,
                                                "https://placehold.co/400x300/green/white?text=Grapes"));
                                products.add(new ShopProduct(null, "Kiwi", 0.60, "Fruit", true,
                                                "https://placehold.co/400x300/green/black?text=Kiwi"));
                                products.add(new ShopProduct(null, "Watermelon", 5.99, "Fruit", true,
                                                "https://placehold.co/400x300/green/red?text=Watermelon"));
                                products.add(new ShopProduct(null, "Pear", 0.80, "Fruit", true,
                                                "https://placehold.co/400x300/green/white?text=Pear"));
                                products.add(new ShopProduct(null, "Peach", 1.00, "Fruit", true,
                                                "https://placehold.co/400x300/orange/red?text=Peach"));
                                products.add(new ShopProduct(null, "Lemon", 0.65, "Fruit", true,
                                                "https://placehold.co/400x300/yellow/white?text=Lemon"));
                                products.add(new ShopProduct(null, "Lime", 0.50, "Fruit", true,
                                                "https://placehold.co/400x300/green/white?text=Lime"));
                                products.add(new ShopProduct(null, "Grapefruit", 1.10, "Fruit", true,
                                                "https://placehold.co/400x300/orange/red?text=Grapefruit"));
                                products.add(new ShopProduct(null, "Cherries", 5.50, "Fruit", true,
                                                "https://placehold.co/400x300/red/black?text=Cherries"));
                                products.add(new ShopProduct(null, "Plum", 0.70, "Fruit", true,
                                                "https://placehold.co/400x300/purple/white?text=Plum"));
                                products.add(new ShopProduct(null, "Blackberries", 4.25, "Fruit", true,
                                                "https://placehold.co/400x300/black/white?text=Blackberries"));
                                products.add(new ShopProduct(null, "Cantaloupe", 3.00, "Fruit", true,
                                                "https://placehold.co/400x300/orange/green?text=Cantaloupe"));

                                // Grains
                                products.add(new ShopProduct(null, "Jasmine Rice", 5.00, "Grain", true,
                                                "https://placehold.co/400x300/yellow/black?text=Rice"));
                                products.add(new ShopProduct(null, "Rolled Oats", 2.50, "Grain", true,
                                                "https://placehold.co/400x300/brown/white?text=Oats"));
                                products.add(new ShopProduct(null, "Whole Wheat Bread", 3.20, "Grain", true,
                                                "https://placehold.co/400x300/brown/black?text=Bread"));
                                products.add(new ShopProduct(null, "Quinoa Pack", 6.00, "Grain", true,
                                                "https://placehold.co/400x300/yellow/red?text=Quinoa"));
                                products.add(new ShopProduct(null, "Brown Rice", 4.50, "Grain", true,
                                                "https://placehold.co/400x300/brown/white?text=Brown+Rice"));
                                products.add(new ShopProduct(null, "Basmati Rice", 5.50, "Grain", true,
                                                "https://placehold.co/400x300/white/black?text=Basmati"));
                                products.add(new ShopProduct(null, "Whole Wheat Pasta", 2.00, "Grain", true,
                                                "https://placehold.co/400x300/brown/white?text=Pasta"));
                                products.add(new ShopProduct(null, "Couscous", 3.00, "Grain", true,
                                                "https://placehold.co/400x300/yellow/white?text=Couscous"));
                                products.add(new ShopProduct(null, "Barley", 2.80, "Grain", true,
                                                "https://placehold.co/400x300/brown/black?text=Barley"));
                                products.add(new ShopProduct(null, "Sourdough Bread", 4.50, "Grain", true,
                                                "https://placehold.co/400x300/white/brown?text=Sourdough"));
                                products.add(new ShopProduct(null, "Tortillas (Whole Wheat)", 2.50, "Grain", true,
                                                "https://placehold.co/400x300/brown/white?text=Tortillas"));
                                products.add(new ShopProduct(null, "Bagels (Everything)", 3.99, "Grain", true,
                                                "https://placehold.co/400x300/brown/black?text=Bagels"));
                                products.add(new ShopProduct(null, "Granola", 5.99, "Grain", true,
                                                "https://placehold.co/400x300/brown/yellow?text=Granola"));
                                products.add(new ShopProduct(null, "Wild Rice", 6.50, "Grain", true,
                                                "https://placehold.co/400x300/black/white?text=Wild+Rice"));
                                products.add(new ShopProduct(null, "Cornmeal", 2.20, "Grain", true,
                                                "https://placehold.co/400x300/yellow/white?text=Cornmeal"));
                                products.add(new ShopProduct(null, "Bulgur", 3.50, "Grain", true,
                                                "https://placehold.co/400x300/brown/white?text=Bulgur"));
                                products.add(new ShopProduct(null, "Popcorn Kernels", 2.00, "Grain", true,
                                                "https://placehold.co/400x300/yellow/white?text=Popcorn"));
                                products.add(new ShopProduct(null, "Pita Bread", 2.50, "Grain", true,
                                                "https://placehold.co/400x300/white/brown?text=Pita"));
                                products.add(new ShopProduct(null, "Rice Cakes", 2.99, "Grain", true,
                                                "https://placehold.co/400x300/white/black?text=Rice+Cakes"));
                                products.add(new ShopProduct(null, "Soba Noodles", 4.20, "Grain", true,
                                                "https://placehold.co/400x300/brown/grey?text=Soba"));

                                // Dairy & Alternatives
                                products.add(new ShopProduct(null, "Greek Yogurt", 4.50, "Dairy", true,
                                                "https://placehold.co/400x300/blue/white?text=Greek+Yogurt"));
                                products.add(new ShopProduct(null, "Almond Milk", 3.99, "Dairy", true,
                                                "https://placehold.co/400x300/brown/white?text=Almond+Milk"));
                                products.add(new ShopProduct(null, "Low Fat Cottage Cheese", 3.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/blue?text=Cottage+Cheese"));
                                products.add(new ShopProduct(null, "Cheddar Cheese", 5.00, "Dairy", true,
                                                "https://placehold.co/400x300/orange/black?text=Cheddar"));
                                products.add(new ShopProduct(null, "Mozzarella Ball", 4.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/black?text=Mozzarella"));
                                products.add(new ShopProduct(null, "Parmesan Cheese", 6.99, "Dairy", true,
                                                "https://placehold.co/400x300/yellow/white?text=Parmesan"));
                                products.add(new ShopProduct(null, "Oat Milk", 4.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/brown?text=Oat+Milk"));
                                products.add(new ShopProduct(null, "Soy Milk", 3.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/black?text=Soy+Milk"));
                                products.add(new ShopProduct(null, "Butter (Salted)", 4.00, "Dairy", true,
                                                "https://placehold.co/400x300/yellow/black?text=Butter"));
                                products.add(new ShopProduct(null, "Cream Cheese", 3.00, "Dairy", true,
                                                "https://placehold.co/400x300/white/blue?text=Cream+Cheese"));
                                products.add(new ShopProduct(null, "Sour Cream", 2.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/blue?text=Sour+Cream"));
                                products.add(new ShopProduct(null, "Feta Cheese", 5.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/black?text=Feta"));
                                products.add(new ShopProduct(null, "Heavy Cream", 3.99, "Dairy", true,
                                                "https://placehold.co/400x300/white/black?text=Heavy+Cream"));
                                products.add(new ShopProduct(null, "Coconut Yogurt", 5.99, "Dairy", true,
                                                "https://placehold.co/400x300/white/green?text=Coconut+Yogurt"));
                                products.add(new ShopProduct(null, "Goat Cheese", 6.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/grey?text=Goat+Cheese"));
                                products.add(new ShopProduct(null, "Ricotta Cheese", 4.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/black?text=Ricotta"));
                                products.add(new ShopProduct(null, "Kefir", 4.99, "Dairy", true,
                                                "https://placehold.co/400x300/white/blue?text=Kefir"));
                                products.add(new ShopProduct(null, "Ghee", 8.99, "Dairy", true,
                                                "https://placehold.co/400x300/yellow/gold?text=Ghee"));
                                products.add(new ShopProduct(null, "Swiss Cheese Slices", 5.00, "Dairy", true,
                                                "https://placehold.co/400x300/yellow/white?text=Swiss"));
                                products.add(new ShopProduct(null, "Coconut Milk (Canned)", 2.50, "Dairy", true,
                                                "https://placehold.co/400x300/white/green?text=Coconut+Milk"));

                                // Pantry & Seasoning
                                products.add(new ShopProduct(null, "Natural Peanut Butter", 5.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/yellow?text=Peanut+Butter"));
                                products.add(new ShopProduct(null, "Dark Chocolate 85%", 2.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/white?text=Chocolate"));
                                products.add(new ShopProduct(null, "Green Tea Box", 4.00, "Pantry", true,
                                                "https://placehold.co/400x300/green/white?text=Green+Tea"));
                                products.add(new ShopProduct(null, "Extra Virgin Olive Oil", 9.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/yellow?text=EVOO"));
                                products.add(new ShopProduct(null, "Sea Salt", 2.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/grey?text=Sea+Salt"));
                                products.add(new ShopProduct(null, "Black Pepper Corns", 3.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/grey?text=Pepper"));
                                products.add(new ShopProduct(null, "Raw Honey", 7.50, "Pantry", true,
                                                "https://placehold.co/400x300/yellow/orange?text=Honey"));
                                products.add(new ShopProduct(null, "Maple Syrup", 8.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/orange?text=Maple+Syrup"));
                                products.add(new ShopProduct(null, "Almond Butter", 9.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/white?text=Almond+Butter"));
                                products.add(new ShopProduct(null, "Chia Seeds", 6.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/white?text=Chia"));
                                products.add(new ShopProduct(null, "Flax Seeds", 4.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/black?text=Flax"));
                                products.add(new ShopProduct(null, "Pumpkin Seeds", 5.50, "Pantry", true,
                                                "https://placehold.co/400x300/green/black?text=Pumpkin+Seeds"));
                                products.add(new ShopProduct(null, "Walnuts", 7.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/white?text=Walnuts"));
                                products.add(new ShopProduct(null, "Cashews", 8.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/brown?text=Cashews"));
                                products.add(new ShopProduct(null, "Almonds", 7.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/white?text=Almonds"));
                                products.add(new ShopProduct(null, "Coconut Oil", 6.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/black?text=Coconut+Oil"));
                                products.add(new ShopProduct(null, "Balsamic Vinegar", 5.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/red?text=Balsamic"));
                                products.add(new ShopProduct(null, "Soy Sauce", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/black/red?text=Soy+Sauce"));
                                products.add(new ShopProduct(null, "Sriracha Hot Sauce", 4.50, "Pantry", true,
                                                "https://placehold.co/400x300/red/green?text=Sriracha"));
                                products.add(new ShopProduct(null, "Tomato Sauce (Jar)", 3.00, "Pantry", true,
                                                "https://placehold.co/400x300/red/white?text=Tomato+Sauce"));
                                // Continued Pantry & Seasoning
                                products.add(new ShopProduct(null, "Vegetable Broth", 2.50, "Pantry", true,
                                                "https://placehold.co/400x300/yellow/green?text=Broth"));
                                products.add(new ShopProduct(null, "Coffee Beans", 12.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/black?text=Coffee"));
                                products.add(new ShopProduct(null, "Chicken Broth", 2.99, "Pantry", true,
                                                "https://placehold.co/400x300/yellow/white?text=Chicken+Broth"));
                                products.add(new ShopProduct(null, "Beef Broth", 2.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/white?text=Beef+Broth"));
                                products.add(new ShopProduct(null, "Cinnamon Powder", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/red?text=Cinnamon"));
                                products.add(new ShopProduct(null, "Turmeric Powder", 4.00, "Pantry", true,
                                                "https://placehold.co/400x300/orange/yellow?text=Turmeric"));
                                products.add(new ShopProduct(null, "Paprika", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/red/white?text=Paprika"));
                                products.add(new ShopProduct(null, "Cumin", 3.25, "Pantry", true,
                                                "https://placehold.co/400x300/brown/yellow?text=Cumin"));
                                products.add(new ShopProduct(null, "Oregano", 3.00, "Pantry", true,
                                                "https://placehold.co/400x300/green/brown?text=Oregano"));
                                products.add(new ShopProduct(null, "Basil (Dried)", 3.00, "Pantry", true,
                                                "https://placehold.co/400x300/green/black?text=Basil"));
                                products.add(new ShopProduct(null, "Thyme", 3.00, "Pantry", true,
                                                "https://placehold.co/400x300/green/grey?text=Thyme"));
                                products.add(new ShopProduct(null, "Rosemary", 3.00, "Pantry", true,
                                                "https://placehold.co/400x300/green/white?text=Rosemary"));
                                products.add(new ShopProduct(null, "Garlic Powder", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/white/yellow?text=Garlic+Powder"));
                                products.add(new ShopProduct(null, "Onion Powder", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/white/brown?text=Onion+Powder"));
                                products.add(new ShopProduct(null, "Chili Flakes", 3.00, "Pantry", true,
                                                "https://placehold.co/400x300/red/white?text=Chili+Flakes"));
                                products.add(new ShopProduct(null, "Sesame Oil", 5.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/yellow?text=Sesame+Oil"));
                                products.add(new ShopProduct(null, "Rice Vinegar", 4.00, "Pantry", true,
                                                "https://placehold.co/400x300/white/yellow?text=Rice+Vinegar"));
                                products.add(new ShopProduct(null, "Apple Cider Vinegar", 5.00, "Pantry", true,
                                                "https://placehold.co/400x300/orange/brown?text=ACV"));
                                products.add(new ShopProduct(null, "Dijon Mustard", 3.99, "Pantry", true,
                                                "https://placehold.co/400x300/yellow/brown?text=Mustard"));
                                products.add(new ShopProduct(null, "Mayonnaise (Olive Oil)", 4.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/yellow?text=Mayo"));
                                products.add(new ShopProduct(null, "Ketchup (Low Sugar)", 3.99, "Pantry", true,
                                                "https://placehold.co/400x300/red/white?text=Ketchup"));
                                products.add(new ShopProduct(null, "BBQ Sauce", 4.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/red?text=BBQ+Sauce"));
                                products.add(new ShopProduct(null, "Salsa (Medium)", 3.99, "Pantry", true,
                                                "https://placehold.co/400x300/red/green?text=Salsa"));
                                products.add(new ShopProduct(null, "Hummus", 4.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/yellow?text=Hummus"));
                                products.add(new ShopProduct(null, "Tahini", 7.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/brown?text=Tahini"));
                                products.add(new ShopProduct(null, "Pesto Sauce", 5.99, "Pantry", true,
                                                "https://placehold.co/400x300/green/white?text=Pesto"));
                                products.add(new ShopProduct(null, "Cocoa Powder", 4.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/black?text=Cocoa"));
                                products.add(new ShopProduct(null, "Vanilla Extract", 12.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/brown?text=Vanilla"));
                                products.add(new ShopProduct(null, "Baking Powder", 2.50, "Pantry", true,
                                                "https://placehold.co/400x300/white/white?text=Baking+Powder"));
                                products.add(new ShopProduct(null, "Baking Soda", 1.50, "Pantry", true,
                                                "https://placehold.co/400x300/white/blue?text=Baking+Soda"));
                                products.add(new ShopProduct(null, "Almond Flour", 8.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/brown?text=Almond+Flour"));
                                products.add(new ShopProduct(null, "Coconut Flour", 6.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/white?text=Coconut+Flour"));
                                products.add(new ShopProduct(null, "Stevia Sweetener", 7.50, "Pantry", true,
                                                "https://placehold.co/400x300/white/green?text=Stevia"));
                                products.add(new ShopProduct(null, "Monk Fruit Sweetener", 9.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/orange?text=Monk+Fruit"));
                                products.add(new ShopProduct(null, "Agave Nectar", 6.50, "Pantry", true,
                                                "https://placehold.co/400x300/yellow/brown?text=Agave"));
                                products.add(new ShopProduct(null, "Dates (Pitted)", 5.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/black?text=Dates"));
                                products.add(new ShopProduct(null, "Dried Cranberries", 4.50, "Pantry", true,
                                                "https://placehold.co/400x300/red/black?text=Dried+Cranberries"));
                                products.add(new ShopProduct(null, "Raisins", 3.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/brown?text=Raisins"));
                                products.add(new ShopProduct(null, "Apricots (Dried)", 5.50, "Pantry", true,
                                                "https://placehold.co/400x300/orange/yellow?text=Dried+Apricots"));
                                products.add(new ShopProduct(null, "Figs (Dried)", 6.00, "Pantry", true,
                                                "https://placehold.co/400x300/brown/purple?text=Dried+Figs"));
                                products.add(new ShopProduct(null, "Prunes", 4.99, "Pantry", true,
                                                "https://placehold.co/400x300/black/white?text=Prunes"));
                                products.add(new ShopProduct(null, "Sunflower Seeds", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/grey/white?text=Sunflower+Seeds"));
                                products.add(new ShopProduct(null, "Hemp Seeds", 8.99, "Pantry", true,
                                                "https://placehold.co/400x300/green/brown?text=Hemp+Seeds"));
                                products.add(new ShopProduct(null, "Pistachios", 9.99, "Pantry", true,
                                                "https://placehold.co/400x300/green/brown?text=Pistachios"));
                                products.add(new ShopProduct(null, "Hazelnuts", 8.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/white?text=Hazelnuts"));
                                products.add(new ShopProduct(null, "Macadamia Nuts", 12.50, "Pantry", true,
                                                "https://placehold.co/400x300/white/yellow?text=Macadamia"));
                                products.add(new ShopProduct(null, "Brazil Nuts", 10.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/white?text=Brazil+Nuts"));
                                products.add(new ShopProduct(null, "Pine Nuts", 14.99, "Pantry", true,
                                                "https://placehold.co/400x300/white/yellow?text=Pine+Nuts"));
                                products.add(new ShopProduct(null, "Popcorn (Microwave)", 3.50, "Pantry", true,
                                                "https://placehold.co/400x300/yellow/white?text=Popcorn"));
                                products.add(new ShopProduct(null, "Beef Jerky", 6.99, "Pantry", true,
                                                "https://placehold.co/400x300/brown/red?text=Jerky"));
                                products.add(new ShopProduct(null, "Protein Bar", 2.50, "Pantry", true,
                                                "https://placehold.co/400x300/brown/blue?text=Protein+Bar"));
                                products.add(new ShopProduct(null, "Energy Drink (Sugar Free)", 2.50, "Pantry", true,
                                                "https://placehold.co/400x300/blue/silver?text=Energy+Drink"));

                                // Supplements
                                products.add(new ShopProduct(null, "Whey Protein Isolate", 29.99, "Supplement", true,
                                                "https://placehold.co/400x300/black/white?text=Whey+Protein"));
                                products.add(new ShopProduct(null, "Daily Multivitamin", 12.00, "Supplement", true,
                                                "https://placehold.co/400x300/white/blue?text=Multivitamin"));
                                products.add(new ShopProduct(null, "Creatine Monohydrate", 19.99, "Supplement", true,
                                                "https://placehold.co/400x300/white/blue?text=Creatine"));
                                products.add(new ShopProduct(null, "Fish Oil Omega-3", 15.50, "Supplement", true,
                                                "https://placehold.co/400x300/yellow/blue?text=Fish+Oil"));
                                products.add(new ShopProduct(null, "Vitamin D3", 9.99, "Supplement", true,
                                                "https://placehold.co/400x300/yellow/white?text=Vitamin+D3"));
                                products.add(new ShopProduct(null, "Magnesium Citrate", 11.50, "Supplement", true,
                                                "https://placehold.co/400x300/white/purple?text=Magnesium"));
                                products.add(new ShopProduct(null, "Plant Protein Powder", 32.99, "Supplement", true,
                                                "https://placehold.co/400x300/green/white?text=Plant+Protein"));
                                products.add(new ShopProduct(null, "BCAA Powder", 24.99, "Supplement", true,
                                                "https://placehold.co/400x300/blue/black?text=BCAA"));

                                shopRepo.saveAll(products);
                                System.out.println("✅ SHOP OPEN: Inventory stocked with " + products.size()
                                                + " diverse items.");
                        }
                };
        }
}