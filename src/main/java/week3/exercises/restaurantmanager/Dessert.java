package week3.exercises.restaurantmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dessert - Represents a dessert item on the restaurant menu.
 *
 * This class extends the Food class and includes specific information
 * about desserts, such as a description of the item.
 */
class Dessert extends Food {
    /** Dessert specific property. */
    private String description;

    /**
     * Constructs a new Dessert with complete information.
     *
     * @param name        The name of the dessert
     * @param price       The price of the dessert
     * @param description A short description of the dessert
     */
    public Dessert(String name, double price, String description) {
        super(name, price);
        this.description = description;
    }

    /**
     * Reads dessert data from a file and creates Dessert objects.
     *
     * @param filename The path to the file containing dessert data
     * @return List of Dessert objects created from the file
     */
    public static List<Dessert> getDessertFromFile(String filename) {
        List<Dessert> desserts = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            String dessertName = null;
            String description = null;
            String priceString = null;
            double price = 0.0;

            while ((line = input.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    // Empty line indicates end of current dessert entry
                    if (dessertName != null && description != null && priceString != null) {
                        desserts.add(new Dessert(dessertName, price, description));
                        // Reset variables for next dessert
                        dessertName = null;
                        description = null;
                        priceString = null;
                        price = 0.0;
                    }
                    continue;
                }

                if (dessertName == null) {
                    dessertName = line;
                } else if (description == null) {
                    description = line;
                } else if (priceString == null) {
                    priceString = line;
                    priceString = priceString.replace("$", "");
                    price = Double.parseDouble(priceString);
                }
            }

            // Add the last dessert if it exists
            if (dessertName != null && description != null && priceString != null) {
                desserts.add(new Dessert(dessertName, price, description));
            }
        } catch (IOException e) {
            System.err.println("Error reading dessert file: " + e.getMessage());
        }

        return desserts;
    }

    /**
     * Returns a formatted string representation of the dessert.
     *
     * @return String with the name, description, and price of the dessert
     */
    @Override
    public String toString() {
        return "\t" + super.getName() + "\n" +
                "\t    " + description + "\n" +
                "\t    " + "$" + String.format("%.2f", super.getPrice()) + "\n";
    }
}