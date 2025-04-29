package week1.controlflow;

/**
 * Demonstrates the use of the 'break' statement to exit a loop prematurely.
 * This class shows how to escape from a loop when a certain condition is met.
 */
public class BranchingStatementBreak {

    /**
     * Main method that creates a number and passes it to the loopNumber method.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        int number = 1;
        System.out.println("Starting with number: " + number);
        loopNumber(number);
    }

    /**
     * Processes a number in a while loop with conditional branching.
     * This method:
     * 1. Continues as long as the number is non-negative
     * 2. Increments the number if it's less than 10 (using continue to skip the
     * rest)
     * 3. Prints the number and exits the loop with break when the number reaches 10
     * or higher
     * 
     * @param newNumber The starting number to process
     */
    public static void loopNumber(int newNumber) {
        System.out.println("Processing number in loop...");

        // Loop continues while number is non-negative
        while (newNumber >= 0) {
            // If number is less than 10, increment it and skip to next iteration
            if (newNumber < 10) {
                System.out.println("Number " + newNumber + " is less than 10, incrementing...");
                newNumber++;
                continue; // Skip the rest of the loop body and start next iteration
            }

            // This code is only reached when number >= 10
            System.out.println("Number reached " + newNumber + " - threshold met!");
            System.out.println("Done - exiting loop");
            break; // Exit the loop immediately
        }

        System.out.println("Final number value: " + newNumber);
    }
}
