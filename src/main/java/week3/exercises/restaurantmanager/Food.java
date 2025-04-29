package week3.exercises.restaurantmanager;

/**
 * Food - Abstract base class for all food items in the restaurant.
 *
 * This class provides common properties and behaviors for all food items
 * following the SOLID principles, particularly the Single Responsibility
 * Principle. It defines the basic structure that all food types must implement.
 */
abstract class Food {
    /** Common properties for all food items */
    private String name;
    private double price;

    /**
     * Constructs a new Food item with name and price.
     *
     * @param name  The name of the food item
     * @param price The price of the food item
     */
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the food item.
     *
     * @return The food item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the food item.
     *
     * @return The food item price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the food item.
     * Each subclass must implement this method to provide its specific format.
     *
     * @return Formatted string representation of the food item
     */
    public abstract String toString();
}