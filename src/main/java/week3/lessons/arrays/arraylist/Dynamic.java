package week3.lessons.arrays.arraylist;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Dynamic - Demonstrates dynamic data structures (ArrayList and HashMap).
 *
 * This class showcases dynamic data structures that can grow and shrink at
 * runtime, unlike arrays which have a fixed size. It also demonstrates String
 * object references and the Java String pool concept.
 */
public class Dynamic {

    /**
     * Main method demonstrating dynamic data structures and string comparisons.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("----Dynamic Structures----\n");

        // ===== ArrayList Demonstration =====
        System.out.println("---- ArrayList Example ----");
        System.out.println("Empty ArrayList:");
        ArrayList<String> dynamicList = new ArrayList<>();
        System.out.println(dynamicList);

        System.out.println("\nAdd an element to the ArrayList:");
        dynamicList.add("I'm Dynamic");
        System.out.println(dynamicList);
        System.out.println("My size: " + dynamicList.size());

        System.out.println("\nAdd a second element to the ArrayList:");
        dynamicList.add("I'm Growing");
        System.out.println(dynamicList);
        System.out.println("My size: " + dynamicList.size());

        // ===== String Pool Demonstration =====
        System.out.println("\n---- String Pool Example ----");
        System.out.println("Creating String literals and comparing references");
        String dynamic = "I'm Dynamic";
        String grow = "I'm Growing";
        String other = "other";

        // Compare references using == operator (checks if references point to same
        // object)
        System.out.println("== compares object references (memory addresses):");
        System.out.println("dynamic == dynamicList.get(0): " + (dynamic == dynamicList.get(0)));
        System.out.println("grow == dynamicList.get(1): " + (grow == dynamicList.get(1)));
        System.out.println("other == dynamicList.get(1): " + (other == dynamicList.get(1)));

        // Compare string values
        System.out.println("\nComparing string values using equals():");
        System.out.println("dynamic.equals(dynamicList.get(0)): " + dynamic.equals(dynamicList.get(0)));
        System.out.println("grow.equals(dynamicList.get(1)): " + grow.equals(dynamicList.get(1)));

        // ===== HashMap Demonstration =====
        System.out.println("\n---- HashMap Example ----");
        System.out.println("Empty HashMap:");
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map);

        System.out.println("\nAdd key-value pairs to HashMap:");
        map.put(10, "I'm Dynamic");
        System.out.println("After adding {10: \"I'm Dynamic\"}: " + map);

        map.put(25, "I'm Growing");
        System.out.println("After adding {25: \"I'm Growing\"}: " + map);

        // String reference comparison with HashMap values
        System.out.println("\n---- String References Across Data Structures ----");
        System.out.println("Comparing string references between ArrayList and HashMap:");
        System.out.println("dynamicList.get(0) == map.get(10): " + (dynamicList.get(0) == map.get(10)));
        System.out.println("dynamicList.get(1) == map.get(25): " + (dynamicList.get(1) == map.get(25)));

        // Better practice: compare values using equals()
        System.out.println("\nComparing string values using equals() (recommended):");
        System.out.println("dynamicList.get(0).equals(map.get(10)): " + dynamicList.get(0).equals(map.get(10)));
        System.out.println("dynamicList.get(1).equals(map.get(25)): " + dynamicList.get(1).equals(map.get(25)));
    }
}
