package week1.controlflow;

/**
 * Demonstrates the use of branching statements (break and continue) in Java.
 * This class shows how these statements affect the flow of code execution in
 * loops.
 */
public class BranchingStatements {

    /**
     * Main method that demonstrates a countdown with branching statements.
     * Contains commented-out examples of how break and continue would change
     * behavior.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Starting the countdown!");

        // Count down from 7 to 0
        for (int i = 7; i >= 0; i--) {
            // Print the current number in the countdown
            System.out.println(i);

            /*
             * EXAMPLE 1: Using 'continue' would skip to the next iteration,
             * preventing "beep" from printing after each number
             */
            // continue;

            /*
             * EXAMPLE 2: Using 'break' would exit the loop after the first number,
             * stopping the countdown early
             */
            // break;

            /*
             * EXAMPLE 3: Conditional branching
             * This would either skip the "beep" or exit the loop
             * when the countdown reaches 3
             */
            /*
             * if (i < 4) {
             * //continue; // Skip "beep" when i < 4
             * //break; // Stop the countdown when i < 4
             * }
             */

            // Print beep after each number in the countdown
            System.out.println("beep");
        }

        System.out.println("Countdown complete!");
    }
}
