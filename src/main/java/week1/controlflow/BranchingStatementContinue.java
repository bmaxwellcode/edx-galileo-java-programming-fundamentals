package week1.controlflow;

/**
 * Demonstrates the use of the 'continue' statement to skip iterations in a
 * loop.
 * This class shows how to bypass the remainder of a loop iteration when a
 * certain condition is met.
 */
public class BranchingStatementContinue {

    /**
     * Main method that creates a number, processes it with loopNumber method,
     * and displays the result.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        int number = 1;
        System.out.println("Starting with number: " + number);

        String result = loopNumber(number);
        System.out.println("Result: " + result);
    }

    /**
     * Processes a number in a while loop using continue and return statements.
     * This method:
     * 1. Continues as long as the number is non-negative
     * 2. Increments the number if it's less than 10 (using continue to skip the
     * rest)
     * 3. Returns a success message when the number reaches 10 or higher
     * 4. Returns a failure message if the loop exits without reaching the threshold
     * 
     * @param newNumber The starting number to process
     * @return A message indicating the result of the processing
     */
    public static String loopNumber(int newNumber) {
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
            System.out.println("Number reached threshold: " + newNumber);
            return "Done"; // Exit method with success message
        }

        // This code is only reached if the while loop condition becomes false
        // (newNumber < 0)
        return newNumber + " is negative"; // Exit method with failure message
    }
}
