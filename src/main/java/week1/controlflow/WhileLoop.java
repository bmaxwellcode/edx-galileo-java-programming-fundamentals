package week1.controlflow;

/**
 * Demonstrates the use of while loops in Java.
 * This class shows how to repeat a block of code as long as a specified
 * condition is true.
 */
public class WhileLoop {

    /**
     * Main method that demonstrates a basic while loop counting from 1 to 5.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize counter variable
        int number = 1;

        System.out.println("Counting from 1 to 5 using a while loop:");

        // Continue loop as long as number is less than or equal to 5
        while (number <= 5) {
            // Print the current number
            System.out.println("Current number: " + number);

            // Increment the number (important to avoid an infinite loop)
            number = number + 1; // Could also use number++ or number += 1
        }

        // At this point, number is 6
        System.out.println("Loop complete. Final value of number: " + number);

        // Note: Unlike for loops, while loops are typically used when:
        // 1. The number of iterations is not known in advance
        // 2. The loop might not execute at all (if the condition is false initially)
    }
}
