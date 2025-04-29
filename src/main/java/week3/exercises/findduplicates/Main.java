package week3.exercises.findduplicates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Main - Demonstrates different approaches to finding and removing duplicates.
 *
 * This class shows two methods for removing duplicates from a list:
 * 1. Using nested loops to manually find and remove duplicates
 * 2. Using a HashSet to automatically remove duplicates
 */
public class Main {

    /**
     * Main method demonstrating duplicate removal techniques.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> computerBrands = new ArrayList<>();

        // Add computer brands with some duplicates
        computerBrands.add("Apple");
        computerBrands.add("Acer");
        computerBrands.add("Samsung");
        computerBrands.add("Asus");
        computerBrands.add("Sony");
        computerBrands.add("Dell");
        computerBrands.add("Hewlett-Packard");
        computerBrands.add("Asus");
        computerBrands.add("Apple");
        computerBrands.add("Acer");
        computerBrands.add("Toshiba");
        computerBrands.add("Sony");
        computerBrands.add("Samsung");

        // Method 1: Remove duplicates using nested loops
        for (int i = 0; i < computerBrands.size(); i++) {
            for (int j = i + 1; j < computerBrands.size(); j++) {
                if (computerBrands.get(i).equals(computerBrands.get(j))) {
                    computerBrands.remove(j);
                }
            }
        }

        System.out.println("List after manual duplicate removal: " + computerBrands);

        // Method 2: Use a HashSet to remove duplicates
        Set<String> computerBrandsSet = new HashSet<>(computerBrands);
        System.out.println("List after HashSet duplicate removal: " + computerBrandsSet);
    }
}
