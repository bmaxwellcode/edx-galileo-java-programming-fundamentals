package week4.lessons.functionalinterfaces;

import java.text.DecimalFormat; // For formatting price values
import java.util.Arrays; // For creating initial list of products
import java.util.LinkedList; // For mutable list implementation
import java.util.List; // For working with collections
import java.util.function.Predicate; // Functional interface for filter conditions
import java.util.stream.Collectors; // For stream collection operations

/**
 * This class demonstrates the use of functional interfaces and lambdas
 * with practical examples of filtering and manipulating a product list
 */
public class FunctionalInterfaces {
        /**
         * Main method that demonstrates various functional interface operations on a
         * product list.
         *
         * @param args Command line arguments (not used)
         * @throws Exception If an error occurs during execution
         */
        public static void main(String[] args) throws Exception {
                // Create a list of grocery products
                // Using LinkedList instead of Arrays.asList directly because:
                // 1. Arrays.asList returns a fixed-size list that doesn't allow
                // additions/removals
                // 2. LinkedList allows the collection to be modified dynamically
                List<Product> groceryStore = new LinkedList<>(
                                Arrays.asList(
                                                new Product(0, "Tomato", "Fruit", 1.75f),
                                                new Product(1, "Avocado", "Fruit", 5.00f),
                                                new Product(2, "Lemon", "Fruit", 0.50f),
                                                new Product(3, "Onion", "Vegetable", 1.50f),
                                                new Product(4, "Carrot", "Vegetable", 1.25f),
                                                new Product(5, "Broccoli", "Vegetable", 2.00f),
                                                new Product(6, "Shrimp", "Seafood", 10.99f),
                                                new Product(7, "Chicken", "Meat", 7.35f),
                                                new Product(8, "Roast Beef", "Meat", 8.35f)));

                // Display the original product list
                System.out.println("Original List:");
                groceryStore.forEach(System.out::println);

                // DEMONSTRATION 1: Removing items with Predicate
                // Create a Predicate that identifies meat products
                Predicate<Product> meatRemover = product -> "Meat".equals(product.getCategory());

                // Remove all products that satisfy the meatRemover predicate
                groceryStore.removeIf(meatRemover);

                // Display the list after removing meat products
                System.out.println("\nWithout Meat List:");
                groceryStore.forEach(System.out::println);

                // DEMONSTRATION 2: Removing expensive products
                // Create a Predicate that identifies expensive products (price > $5)
                Predicate<Product> expensiveRemover = product -> product.getPrice() > 5.0f;

                // Remove all expensive products from the list
                groceryStore.removeIf(expensiveRemover);

                // Display the list after removing both meat and expensive products
                System.out.println("\nWithout Expensive & Meat List:");
                groceryStore.forEach(System.out::println);

                // DEMONSTRATION 3: Filtering without modifying the original list
                // Use streams to find just the first fruit in the list
                System.out.println("\nFilter First Fruit:");
                groceryStore.stream()
                                .filter(product -> product.getCategory().equals("Fruit"))
                                .findFirst()
                                .ifPresent(System.out::println);

                // Use streams to create a new list containing only fruit products
                System.out.println("\nFilter All Fruit:");
                List<Product> fruitProducts = groceryStore.stream()
                                .filter(product -> product.getCategory().equals("Fruit"))
                                .collect(Collectors.toList());
                System.out.println(fruitProducts);

                // Show that the original list hasn't been modified by the filtering operations
                System.out.println("\nOriginal list after filtering:");
                groceryStore.forEach(System.out::println);
        }
}

/**
 * This class represents a product in a grocery store
 * with basic properties like id, name, category and price
 */
class Product {
        private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("$0.00");
        private final int id;
        private final String name;
        private final String category;
        private final float price;

        /**
         * Constructor to initialize all product properties
         */
        public Product(int id, String name, String category, float price) {
                this.id = id;
                this.name = name;
                this.category = category;
                this.price = price;
        }

        /**
         * Gets the product's unique identifier.
         *
         * @return The product ID
         */
        public int getId() {
                return id;
        }

        /**
         * Gets the product's name.
         *
         * @return The product name
         */
        public String getName() {
                return name;
        }

        /**
         * Gets the product's category.
         *
         * @return The product category
         */
        public String getCategory() {
                return category;
        }

        /**
         * Gets the product's price.
         *
         * @return The product price
         */
        public float getPrice() {
                return price;
        }

        /**
         * Provides a string representation of the product
         * including its name and formatted price
         */
        @Override
        public String toString() {
                return name + " " + PRICE_FORMAT.format(price);
        }
}