package week3.exercises.restaurantmanager;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * MainDish - Represents a main dish on the restaurant menu.
 *
 * This class extends the Food class and includes specific information
 * about main dishes, such as the main meal ingredients and accompaniments.
 */
class MainDish extends Food {
    /** MainDish specific properties. */
    private String mainmeal;
    private String accompaniments;

    /**
     * Constructs a new MainDish with complete information.
     *
     * @param name           The name of the main dish
     * @param price          The price of the main dish
     * @param mainmeal       The main ingredients of the dish
     * @param accompaniments Side items that come with the dish
     */
    public MainDish(String name, double price, String mainmeal, String accompaniments) {
        super(name, price);
        this.mainmeal = mainmeal;
        this.accompaniments = accompaniments;
    }

    /**
     * Reads main dish data from a file and creates MainDish objects.
     *
     * @param filename The path to the file containing main dish data
     * @return List of MainDish objects created from the file
     */
    public static List<MainDish> getMainDishFromFile(String filename) {
        List<MainDish> mainDishes = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String mainDishName = null;
            String mainMealIngredients = null;
            String accompaniments = null;
            String priceString = null;
            double price = 0.0;

            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                line = line.trim();
                if (mainDishName == null) {
                    // First line is the dish name
                    mainDishName = line;
                } else if (mainMealIngredients == null) {
                    // Second line contains main meal ingredients
                    mainMealIngredients = line;
                } else if (accompaniments == null) {
                    // Third line contains accompaniments
                    accompaniments = line;
                } else if (priceString == null) {
                    // Fourth line is the price
                    priceString = line;
                    priceString = priceString.replace("$", "");
                    price = Double.parseDouble(priceString);
                } else {
                    // Empty line indicates end of current dish entry
                    if (line.isEmpty()) {
                        mainDishes.add(new MainDish(mainDishName, price, mainMealIngredients, accompaniments));
                        // Reset variables for next dish
                        mainDishName = null;
                        priceString = null;
                        price = 0.0;
                        mainMealIngredients = null;
                        accompaniments = null;
                    }
                }
            }

            // Add the last dish (which doesn't end with an empty line)
            mainDishes.add(new MainDish(mainDishName, price, mainMealIngredients, accompaniments));
        } catch (IOException e) {
            System.err.println("Error reading main dish file: " + e.getMessage());
        }

        return mainDishes;
    }

    /**
     * Returns a formatted string representation of the main dish.
     *
     * @return String with the name, main ingredients, accompaniments, and price
     */
    @Override
    public String toString() {
        return "\t" + super.getName() + "\n" +
                "\t    " + mainmeal + "\n" +
                "\t    " + accompaniments + "\n" +
                "\t    " + "$" + String.format("%.2f", super.getPrice()) + "\n";
    }
}