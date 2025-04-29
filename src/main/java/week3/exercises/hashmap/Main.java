package week3.exercises.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Main - Demonstrates basic HashMap operations.
 *
 * This class provides examples of creating and using HashMaps with different
 * key-value pairs. It shows how to store, retrieve, and iterate through
 * HashMap entries.
 */
public class Main {

    /**
     * Main method demonstrating HashMap operations with different data types.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Example 1: HashMap with Integer keys and String values for months
        Map<Integer, String> months = new HashMap<>();

        // Populate the months HashMap with month numbers and names
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        // Retrieving values using get() with the key
        System.out.println("First month: " + months.get(1)); // January
        System.out.println("Last month: " + months.get(12)); // December
        System.out.println("Invalid key: " + months.get(13)); // This will return null (no key 13)

        System.out.println("\n--- Country Codes Example ---");

        // Example 2: HashMap with String keys and String values for countries
        Map<String, String> countries = new HashMap<>();

        // Populate the countries HashMap with country codes and names
        countries.put("GTM", "Guatemala");
        countries.put("USA", "United States of America");
        countries.put("CHN", "China");
        countries.put("ESP", "Spain");

        // Iterate through HashMap entries using forEach() with lambda expression
        countries.forEach((code, name) -> System.out.println("Code: " + code + "   Name: " + name));

        // Demonstrate additional HashMap methods
        System.out.println("\nTotal countries: " + countries.size());
        System.out.println("Contains USA: " + countries.containsKey("USA"));
        System.out.println("Contains Canada: " + countries.containsKey("CAN"));
    }
}
