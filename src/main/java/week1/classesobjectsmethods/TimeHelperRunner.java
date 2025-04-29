package week1.classesobjectsmethods;

/**
 * TimeHelperRunner class demonstrates the usage and functionality of the
 * TimeHelper class.
 * This class shows how to convert time in seconds to minutes and hours,
 * and how to format time for display.
 */
public class TimeHelperRunner {

    /**
     * Main method to demonstrate TimeHelper class functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===== TIME HELPER DEMONSTRATION =====");

        // Test case 1: 3700 seconds (1 hour, 1 minute, 40 seconds)
        demonstrateTimeHelper(3700);

        // Test case 2: 7320 seconds (2 hours, 2 minutes, 0 seconds)
        demonstrateTimeHelper(7320);

        // Additional test cases can be added here
        // For example, testing with 0 seconds or very large values
        demonstrateTimeHelper(0);
        demonstrateTimeHelper(86400); // 24 hours
    }

    /**
     * Demonstrates the functionality of TimeHelper for a given number of seconds.
     * Shows conversion to minutes, hours, and formatted string representation.
     * 
     * @param seconds The number of seconds to convert
     */
    private static void demonstrateTimeHelper(int seconds) {
        System.out.println("\n--- Testing with " + seconds + " seconds ---");

        // Create a TimeHelper object with the specified seconds
        TimeHelper timeHelper = new TimeHelper(seconds);

        // Display various time conversions
        System.out.println(seconds + " seconds in minutes: " + timeHelper.inMinutes());
        System.out.println(seconds + " seconds in hours: " + timeHelper.inHours());
        System.out.println(seconds + " seconds formatted: " + timeHelper.toString());
    }
}