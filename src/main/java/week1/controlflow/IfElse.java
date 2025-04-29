package week1.controlflow;

/**
 * Demonstrates the use of if-else conditional statements in Java.
 * This class shows how to make decisions based on given conditions.
 */
public class IfElse {

    /**
     * Main method that demonstrates a basic if-else statement with a grade example.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define a student grade to test
        int grade = 85;

        // Use if-else to determine if the grade is passing or not
        // Grades above 70 are considered passing
        if (grade > 70) {
            System.out.println("Congratulations! You passed.");
        } else {
            System.out.println("You should work harder next time.");
        }

        // You can also try changing the grade value to see different outcomes
    }
}
