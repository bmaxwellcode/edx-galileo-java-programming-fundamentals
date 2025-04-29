package week3.exercises.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Arraylist - Demonstrates basic ArrayList operations.
 *
 * This class shows how to use an ArrayList to:
 * 1. Store user input until a sentinel value is entered
 * 2. Avoid adding duplicate values
 * 3. Perform common ArrayList operations (add, remove, set, etc.)
 */
public class Arraylist {

    /**
     * Main method demonstrating ArrayList operations and user input handling.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // PART 1: User input collection in an ArrayList
        List<String> list = new ArrayList<>();

        // Initialize with one item
        list.add("bananas");

        // Collect user input until "EXIT" is entered
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter items to add to the list.");
        System.out.println("Type EXIT when you have finished");

        while (true) {
            String item = scanner.next();
            if (item.equalsIgnoreCase("EXIT")) {
                break;
            }
            // Only add unique items that aren't the exit command
            if (!list.contains(item.toLowerCase())) {
                list.add(item);
            }
        }

        System.out.println("Your list: " + list);

        // PART 2: Demonstration of ArrayList methods
        System.out.println("\n--- ArrayList Methods Demonstration ---");
        List<Integer> numberList = new ArrayList<>();

        // add() method - adds elements to the list
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        System.out.println("After add(): " + numberList);

        // remove() method - removes the element at the specified index
        numberList.remove(1); // removes the element at index 1 (value 2)
        System.out.println("After remove(1): " + numberList);

        // set() method - replaces element at the specified index
        numberList.set(1, 10); // sets the element at index 1 to 10
        System.out.println("After set(1, 10): " + numberList);

        // isEmpty() method - checks if the list is empty
        System.out.println("Is list empty? " + numberList.isEmpty());

        // size() method - returns the number of elements in the list
        System.out.println("Size of list: " + numberList.size());

        // contains() method - checks if list contains specified element
        System.out.println("Does list contain 10? " + numberList.contains(10));
        System.out.println("Does list contain 5? " + numberList.contains(5));

        // clear() method - removes all elements from the list
        numberList.clear();
        System.out.println("After clear(): " + numberList);

        // Add an element after clearing to demonstrate contains() again
        numberList.add(5);
        System.out.println("Added element 5: " + numberList);
        System.out.println("Does list contain 5? " + numberList.contains(5));

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
