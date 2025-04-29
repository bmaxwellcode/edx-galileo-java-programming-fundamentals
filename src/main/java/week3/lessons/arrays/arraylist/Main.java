package week3.lessons.arrays.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main - Demonstrates ArrayList creation and common operations.
 *
 * This class shows the basic usage of ArrayList, a dynamic collection
 * that can grow and shrink at runtime, unlike fixed-size arrays.
 */
public class Main {

    /**
     * Main method demonstrating ArrayList operations.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create an ArrayList with generic type String
        List<String> studentList = new ArrayList<>();

        // Add elements to the ArrayList
        studentList.add("John");
        studentList.add("Maria");
        studentList.add("Carlos");
        studentList.add("Zoe");

        // Display the ArrayList
        System.out.println("---- ArrayList Operations ----");
        System.out.println("Original ArrayList:");
        System.out.println(studentList);
        System.out.println("Size: " + studentList.size());

        // Access elements by index
        System.out.println("\nAccessing elements by index:");
        System.out.println("First student: " + studentList.get(0));
        System.out.println("Last student: " + studentList.get(studentList.size() - 1));

        // Modify an element
        System.out.println("\nModifying an element:");
        studentList.set(1, "Mary");
        System.out.println("After changing Maria to Mary: " + studentList);

        // Remove an element
        System.out.println("\nRemoving an element:");
        studentList.remove(2); // Remove Carlos
        System.out.println("After removing Carlos: " + studentList);
        System.out.println("New size: " + studentList.size());

        // Sort the ArrayList
        System.out.println("\nSorting the ArrayList:");
        Collections.sort(studentList);
        System.out.println("Sorted list: " + studentList);

        // Check if an element exists
        System.out.println("\nChecking if elements exist:");
        System.out.println("Contains 'John': " + studentList.contains("John"));
        System.out.println("Contains 'Carlos': " + studentList.contains("Carlos"));

        // Clear the ArrayList
        System.out.println("\nClearing the ArrayList:");
        studentList.clear();
        System.out.println("After clear, size: " + studentList.size());
        System.out.println("Is empty: " + studentList.isEmpty());
    }
}
