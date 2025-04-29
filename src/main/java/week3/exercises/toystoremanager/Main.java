package week3.exercises.toystoremanager;

import java.util.*;

/**
 * ToyStoreManager - Demonstrates HashMap usage for toy categorization
 * 
 * This class shows how to use a HashMap to categorize toys into different
 * groups,
 * then sort the categories alphabetically and display them.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize array of toy names
        String[] toys = new String[9];
        toys[0] = "Buzz Lightyear";
        toys[1] = "Sheriff Woody";
        toys[2] = "Mr. Potato Head";
        toys[3] = "Barbie";
        toys[4] = "Troll doll";
        toys[5] = "Tonka Truck";
        toys[6] = "Elmo";
        toys[7] = "Big bird";
        toys[8] = "Cookie Monster";

        // Create a HashMap to classify toys into categories
        Map<String, List<String>> toyCategory = new HashMap<>();

        // Create and populate the Sesame Street category
        List<String> sesameList = new ArrayList<>();
        sesameList.add(toys[6]); // Elmo
        sesameList.add(toys[7]); // Big bird
        sesameList.add(toys[8]); // Cookie Monster
        toyCategory.put("Sesame Street", sesameList);

        // Create and populate the Toy Story category
        List<String> toystoryList = new ArrayList<>();
        toystoryList.add(toys[0]); // Buzz Lightyear
        toystoryList.add(toys[1]); // Sheriff Woody
        toystoryList.add(toys[2]); // Mr. Potato Head
        toystoryList.add(toys[4]); // Troll doll
        toyCategory.put("Toy Story", toystoryList);

        // Create and populate the Other category
        List<String> otherList = new ArrayList<>();
        otherList.add(toys[3]); // Barbie
        otherList.add(toys[5]); // Tonka Truck
        toyCategory.put("Other", otherList);

        // Sort each category's toys in alphabetical order
        System.out.println("Toy categories after sorting:");
        for (HashMap.Entry<String, List<String>> entry : toyCategory.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // Print each category with its sorted toys
        for (Map.Entry<String, List<String>> entry : toyCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
