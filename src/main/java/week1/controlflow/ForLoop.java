package week1.controlflow;

/**
 * Demonstrates the use of for loops in Java.
 * This class shows how to execute a block of code repeatedly for a specified
 * number of times.
 */
public class ForLoop {

    /**
     * Main method that demonstrates a basic for loop that counts from 0 to 9.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // A for loop consists of initialization, condition, and update expressions
        // 1. Initialize count to 0
        // 2. Continue loop as long as count < 10
        // 3. Increment count by 1 after each iteration
        System.out.println("Counting from 0 to 9:");

        for (int count = 0; count < 10; count++) {
            System.out.println("Current count: " + count);
        }

        // At this point, count is 10 and no longer in scope
        System.out.println("Loop complete!");

        // You can also use for loops to iterate through arrays and collections
        // Example:
        /*
         * String[] names = {"Alice", "Bob", "Charlie"};
         * for (int i = 0; i < names.length; i++) {
         * System.out.println("Name: " + names[i]);
         * }
         */
    }
}
