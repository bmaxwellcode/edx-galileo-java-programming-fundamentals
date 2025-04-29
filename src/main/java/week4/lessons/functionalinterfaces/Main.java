package week4.lessons.functionalinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Main class that demonstrates traditional vs. lambda approaches
 * for common operations like sorting and filtering.
 */
public class Main {
    private static final int LIST_SIZE = 20;
    private static final int MAX_RANDOM_VALUE = 255;
    private static final int FILTER_THRESHOLD = 50;

    /**
     * Generates a list of random integers between 0 and 254.
     * 
     * @return A list containing random integers
     */
    private List<Integer> generateRandomList() {
        final List<Integer> numbersList = new ArrayList<>();
        final Random randomGenerator = new Random();

        for (int i = 0; i < LIST_SIZE; i++) {
            numbersList.add(randomGenerator.nextInt(MAX_RANDOM_VALUE));
        }
        return numbersList;
    }

    /**
     * Demonstrates the traditional way of sorting a list using
     * an anonymous Comparator class.
     */
    private void demonstrateTraditionalSort() {
        final List<Integer> numbers = generateRandomList();
        System.out.println("Traditional sort approach:");
        System.out.println("Before sorting: " + numbers);

        // Sorting using traditional approach with anonymous Comparator class
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return first.compareTo(second);
            }
        });

        System.out.println("After sorting: " + numbers);
    }

    /**
     * Demonstrates sorting a list using lambda expression,
     * which is more concise than the traditional approach.
     */
    private void demonstrateLambdaSort() {
        final List<Integer> numbers = generateRandomList();
        System.out.println("\nLambda sort approach:");
        System.out.println("Before sorting: " + numbers);

        // Sort using lambda expression - much shorter than anonymous class
        numbers.sort(Integer::compareTo);

        System.out.println("After sorting: " + numbers);
    }

    /**
     * Demonstrates traditional filtering using a for-each loop
     * and conditional statements.
     */
    private void demonstrateTraditionalFilter() {
        final List<Integer> unfilteredList = generateRandomList();
        final List<Integer> filteredList = new ArrayList<>();

        // Manual filtering with for-each loop
        for (Integer number : unfilteredList) {
            if (number > FILTER_THRESHOLD) {
                filteredList.add(number);
            }
        }

        System.out.println("\nTraditional filter approach:");
        System.out.println("Original list: " + unfilteredList);
        System.out.println("Filtered list (numbers > " + FILTER_THRESHOLD + "): " + filteredList);
    }

    /**
     * Demonstrates filtering using streams and lambda expressions,
     * which is more concise than the traditional approach.
     */
    private void demonstrateLambdaFilter() {
        final List<Integer> unfilteredList = generateRandomList();

        // Use stream API with lambda to filter in one line
        final List<Integer> filteredList = unfilteredList.stream()
                .filter(number -> number > FILTER_THRESHOLD)
                .collect(Collectors.toList());

        System.out.println("\nLambda filter approach:");
        System.out.println("Original list: " + unfilteredList);
        System.out.println("Filtered list (numbers > " + FILTER_THRESHOLD + "): " + filteredList);
    }

    /**
     * Main method that runs all the demonstration methods.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        final Main demo = new Main();

        // Demonstrate different sorting approaches
        demo.demonstrateTraditionalSort();
        demo.demonstrateLambdaSort();

        // Demonstrate different filtering approaches
        demo.demonstrateTraditionalFilter();
        demo.demonstrateLambdaFilter();
    }
}
