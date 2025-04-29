package week1.controlflow;

/**
 * Demonstrates the use of switch statements in Java.
 * This class shows how to perform different actions based on different
 * conditions
 * using a more concise alternative to multiple if-else statements.
 */
public class SwitchStatement {

    /**
     * Main method that demonstrates a switch statement with a CRUD example.
     * CRUD: Create, Read, Update, Delete - common operations in data management.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define a value to determine which case to execute
        // 1 = Create, 2 = Read, 3 = Update, 4 = Delete
        int choice = 3; // This will trigger the "Update" case

        System.out.println("Executing CRUD operation based on choice: " + choice);

        // Switch statement evaluates the expression once and compares it with multiple
        // cases
        switch (choice) {
            case 1:
                // Execute if choice equals 1
                System.out.println("Creating a new record...");
                break; // Exit the switch statement

            case 2:
                // Execute if choice equals 2
                System.out.println("Reading existing records...");
                break; // Exit the switch statement

            case 3:
                // Execute if choice equals 3
                System.out.println("Updating an existing record...");
                break; // Exit the switch statement

            case 4:
                // Execute if choice equals 4
                System.out.println("Deleting a record...");
                break; // Exit the switch statement

            default:
                // Execute if choice doesn't match any case
                System.out.println("Invalid input: " + choice + ". Please choose 1-4.");
                break; // Not necessary for the default case, but good practice
        }

        // Note: Without 'break' statements, execution would "fall through" to the next
        // case
    }
}
