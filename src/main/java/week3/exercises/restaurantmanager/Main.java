package week3.exercises.restaurantmanager;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Exercise 2 - Restaurant Manager with SOLID Principles.
 *
 * In this exercise you will practice SOLID principles.
 * You are developing an application that manages a restaurant system.
 * In this exercise we will focus on the menu of the restaurant.
 * The food information is given in the text files: main_dish.txt, drinks.txt and dessert.txt.
 *
 * Instructions: Create the class Food with its attributes and methods. Then add its child classes:
 * MainDish, Drink and Dessert. Users can create combos with: 1 Main Dish, 1 Drink and 1 Dessert.
 * Create the class Combo and a method called CalculateComboPrice to get the price of the combo.
 * Your task is to complete or implement the classes and methods, and create 20 combinations of Food
 * to show to the user. Each combo can have a random discount range (from $0.00 to $5.00), and a price
 * (the sum of the price of each Food Object minus the discount).
 */

/**
 * Restaurant Manager Application.
 *
 * This application demonstrates the use of SOLID principles in a restaurant
 * system.
 * It loads food items from files, displays the menu, and creates random combo
 * meals
 * with special discounts.
 *
 * Key SOLID principles demonstrated:
 * - Single Responsibility: Each class has a specific purpose
 * - Open/Closed: Food class is extended without modification
 * - Liskov Substitution: Food subclasses can be used interchangeably
 * - Interface Segregation: Classes have specific interfaces
 * - Dependency Inversion: High-level modules depend on abstractions
 */
public class Main {

    /**
     * Main method that runs the restaurant manager application.
     *
     * @param args Command line arguments (not used)
     * @throws Exception If an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        // Display the restaurant menu
        displayMenu();

        // Display combo specials
        displayCombos();
    }

    /**
     * Loads and displays all menu items by category.
     */
    private static void displayMenu() {
        // Display main dishes
        System.out.println("Menu");
        System.out.printf("%13s\n", "Main Dishes");
        List<MainDish> mainDish = MainDish.getMainDishFromFile("src/main/resources/week3/main_dish.txt");
        for (MainDish dish : mainDish) {
            System.out.print(dish);
        }

        // Display drinks
        System.out.printf("%8s\n", "Drinks");
        List<Drink> drinks = Drink.getDrinkFromFile("src/main/resources/week3/drinks.txt");
        for (Drink drink : drinks) {
            System.out.print(drink);
        }

        // Display desserts
        System.out.printf("%10s\n", "Desserts");
        List<Dessert> desserts = Dessert.getDessertFromFile("src/main/resources/week3/dessert.txt");
        for (Dessert dessert : desserts) {
            System.out.print(dessert);
        }

        System.out.println();
    }

    /**
     * Creates and displays 20 unique random combo specials.
     * Each combo consists of one main dish, one drink, and one dessert.
     * No combination will be repeated.
     */
    private static void displayCombos() {
        System.out.println("Combos with Special Discount");

        // Load menu items first
        List<MainDish> mainDishes = MainDish.getMainDishFromFile("src/main/resources/week3/main_dish.txt");
        List<Drink> drinks = Drink.getDrinkFromFile("src/main/resources/week3/drinks.txt");
        List<Dessert> desserts = Dessert.getDessertFromFile("src/main/resources/week3/dessert.txt");

        // Calculate maximum possible unique combinations
        int maxCombinations = mainDishes.size() * drinks.size() * desserts.size();
        int numCombosToShow = Math.min(20, maxCombinations);

        // Set to track unique combinations
        Set<String> usedCombinations = new HashSet<>();
        Random random = new Random();
        int attempts = 0;
        final int MAX_ATTEMPTS = 100; // Prevent infinite loop

        while (usedCombinations.size() < numCombosToShow) {
            // Generate random indices
            int mainDishIndex = random.nextInt(mainDishes.size());
            int drinkIndex = random.nextInt(drinks.size());
            int dessertIndex = random.nextInt(desserts.size());

            // Create combo key to check for uniqueness
            String comboKey = mainDishIndex + ":" + drinkIndex + ":" + dessertIndex;
            attempts++;

            // If we've tried too many times, break to avoid infinite loop
            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Warning: Could not generate enough unique combinations.");
                break;
            }

            // Create the combo if it's unique
            if (!usedCombinations.contains(comboKey)) {
                Combo combo = new Combo(
                        mainDishes.get(mainDishIndex),
                        drinks.get(drinkIndex),
                        desserts.get(dessertIndex));
                System.out.print(combo);
                usedCombinations.add(comboKey);
            }
        }
    }
}