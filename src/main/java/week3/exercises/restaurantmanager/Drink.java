package week3.exercises.restaurantmanager;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Drink - Represents a beverage on the restaurant menu.
 *
 * This class extends the Food class and provides specific implementation
 * for drink items, including file loading capabilities.
 */
class Drink extends Food {
    /**
     * Constructs a new Drink with name and price.
     *
     * @param name  The name of the drink
     * @param price The price of the drink
     */
    public Drink(String name, double price) {
        super(name, price);
    }

    /**
     * Reads drink data from a file and creates Drink objects.
     *
     * @param filename The path to the file containing drink data
     * @return List of Drink objects created from the file
     */
    public static List<Drink> getDrinkFromFile(String filename) {
        List<Drink> drinkList = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            String drinkName = null;
            String priceString = null;
            double price = 0.0;

            while ((line = input.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    // Empty line indicates end of current drink entry
                    if (drinkName != null && priceString != null) {
                        drinkList.add(new Drink(drinkName, price));
                        // Reset variables for next drink
                        drinkName = null;
                        priceString = null;
                        price = 0.0;
                    }
                    continue;
                }

                if (drinkName == null) {
                    drinkName = line;
                } else if (priceString == null) {
                    priceString = line;
                    priceString = priceString.replace("$", "");
                    price = Double.parseDouble(priceString);
                }
            }

            // Add the last drink if it exists
            if (drinkName != null && priceString != null) {
                drinkList.add(new Drink(drinkName, price));
            }
        } catch (IOException e) {
            System.err.println("Error reading drink file: " + e.getMessage());
        }
        return drinkList;
    }

    /**
     * Returns a formatted string representation of the drink.
     *
     * @return String with the name and price of the drink
     */
    @Override
    public String toString() {
        return "\t" + super.getName() + "\n" +
                "\t    " + "$" + String.format("%.2f", super.getPrice()) + "\n";
    }
}