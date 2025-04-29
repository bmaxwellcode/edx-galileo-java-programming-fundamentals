package week4.exercises.functionalinterfaces;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

/**
 * Demonstrates the use of functional interfaces and lambda expressions in Java.
 * This class shows various operations on a list of products using streams,
 * predicates, and method references.
 */
public class Main {
        /**
         * Main method demonstrating functional programming features.
         * Creates a list of products and performs various filtering operations.
         *
         * @param args command line arguments (not used)
         * @throws Exception if any unexpected error occurs
         */
        public static void main(String[] args) throws Exception {
                // NOTE: An ArrayList might be more efficient here than LinkedList because:
                // 1. This code primarily does iteration and filtering, where ArrayList excels
                // 2. ArrayList has O(1) random access vs LinkedList's O(n)
                // 3. ArrayList is more memory-efficient (no node overhead)
                // 4. We're not doing frequent insertions/deletions in the middle of the list
                // 5. The initialization creates an intermediate collection anyway
                List<Product> store = new LinkedList<Product>(
                                Arrays.asList(
                                                // ID Name Department Price
                                                new Product(0, "Laptop", "Electronics", 1099.99f),
                                                new Product(1, "Hat", "Clothes", 5f),
                                                new Product(2, "Stove", "Kitchen", 800.70f),
                                                new Product(3, "Camara", "Electronics", 50.50f),
                                                new Product(4, "Fridge", "Kitchen", 960.25f),
                                                new Product(5, "Sweater", "Clothes", 25f),
                                                new Product(6, "Scanner", "Electronics", 346.60f),
                                                new Product(7, "Microwave", "Kitchen", 490.10f),
                                                new Product(8, "Pants", "Clothes", 10.30f)));

                // Print each of the products
                System.out.println("Original List:");

                // The '::' syntax is a method reference operator introduced in Java 8
                // store.forEach(System.out::println) is equivalent to:
                // store.forEach(item -> System.out.println(item))
                // It passes each product to println(), which implicitly calls the product's
                // toString() method
                // System.out is the object on which the method will be called
                // println is the method being referenced
                // :: connects the object and the method
                store.forEach(System.out::println);

                System.out.println();

                // Filter and print the Products which belongs to the Electronics department
                System.out.println("Only Electronics:");
                System.out.println(
                                store.stream() // Convert list to a stream for processing
                                                .filter(
                                                                // Filter condition
                                                                (Product product) -> product.getDepartment()
                                                                                .equals("Electronics"))
                                                .collect(Collectors.toList()));

                // Remove Products which belongs to the Kitchen department
                Predicate<Product> kitchenProduct = (Product product) -> "Kitchen".equals(product.getDepartment());

                store.removeIf(kitchenProduct);

                // Print each of the products
                System.out.println("\n\nWithout Kitchen department, list:");
                store.forEach(System.out::println);

                // Print products that are chepear than $800.00
                System.out.println("\n\nCheap products:");
                System.out.println(
                                store.stream() // Convert list to a stream for processing
                                                .filter(
                                                                // Filter condition
                                                                (Product product) -> product.getPrice() < 800.00f)
                                                .collect(Collectors.toList()));

                // Remove Products that more expensive than $700.00
                Predicate<Product> abovePrice = (Product product) -> product.getPrice() > 700.00f;
                store.removeIf(abovePrice);

                // Print each of the products
                System.out.println("\n\nWithout Expensive products, list:");
                store.forEach(System.out::println);
        }
}

/**
 * Represents a product in a store with its properties.
 */
class Product {
        /** The unique identifier of the product. */
        private final int id;

        /** The name of the product. */
        private final String name;

        /** The department the product belongs to. */
        private final String department;

        /** The price of the product. */
        private final float price;

        /**
         * Constructs a new Product with the specified details.
         *
         * @param id         the unique identifier
         * @param name       the product name
         * @param department the department name
         * @param price      the product price
         */
        public Product(int id, String name, String department, float price) {
                this.id = id;
                this.name = name;
                this.department = department;
                this.price = price;
        }

        /**
         * Gets the product ID.
         *
         * @return the product ID
         */
        public int getId() {
                return id;
        }

        /**
         * Gets the product name.
         *
         * @return the product name
         */
        public String getName() {
                return name;
        }

        /**
         * Gets the product department.
         *
         * @return the department name
         */
        public String getDepartment() {
                return department;
        }

        /**
         * Gets the product price.
         *
         * @return the product price
         */
        public float getPrice() {
                return price;
        }

        /**
         * Returns a string representation of the product.
         *
         * @return a string containing the product name and formatted price
         */
        @Override
        public String toString() {
                return (this.name + (new DecimalFormat(" $0.00")).format(this.price));
        }
}