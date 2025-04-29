package week1.classesobjectsmethods;

/**
 * Utility class for converting and displaying time.
 * Demonstrates operators, integer division, modulo operations and method
 * implementation.
 */
public class TimeHelper {

    /** The total time in seconds. */
    private int seconds;

    /**
     * Creates a new TimeHelper with the specified number of seconds.
     *
     * @param seconds The number of seconds to convert
     */
    public TimeHelper(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Converts the time to minutes.
     * Demonstrates integer division.
     *
     * @return The number of complete minutes
     */
    public int inMinutes() {
        return seconds / 60;
    }

    /**
     * Converts the time to hours.
     * Demonstrates integer division.
     *
     * @return The number of complete hours
     */
    public int inHours() {
        return seconds / 3600;
    }

    /**
     * Returns a string representation of the time.
     * Demonstrates modulo operations and conditional operators.
     *
     * @return Formatted string showing hours, minutes, and seconds
     */
    @Override
    public String toString() {
        int hours = inHours();
        int minutes = (seconds % 3600) / 60; // find remaining seconds after taking out hours, then divide by 60 for
                                             // remaining minutes
        int remSeconds = seconds % 60;

        return hours + (hours == 1 ? " hour " : " hours ")
                + minutes + (minutes == 1 ? " minute " : " minutes ")
                + remSeconds + (remSeconds == 1 ? " second " : " seconds ");
    }
}