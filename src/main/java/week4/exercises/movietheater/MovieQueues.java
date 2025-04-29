package week4.exercises.movietheater;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the customer queues for the movie theater.
 * This class handles the synchronization of customer queues and provides
 * thread-safe methods for adding and removing customers from queues.
 */
public final class MovieQueues {
    /** The number of queues in the movie theater. */
    private static final int NUMBER_OF_QUEUES = 5;

    /**
     * List of customer queues, where each queue is represented by a List of
     * Customers.
     */
    private static final List<List<Customer>> queues = new ArrayList<>();

    /** Static initializer to create the queues. */
    static {
        for (int i = 0; i < NUMBER_OF_QUEUES; i++) {
            queues.add(new ArrayList<>());
        }
    }

    /**
     * Private constructor to prevent instantiation.
     * This class follows the singleton pattern.
     */
    private MovieQueues() {
        // Private constructor for singleton pattern
    }

    /**
     * Adds a customer to the specified queue.
     * This method is synchronized to ensure thread safety.
     *
     * @param queueNumber the queue number to add the customer to (1-based)
     * @param customer    the customer to add to the queue
     * @throws IllegalArgumentException if the queue number is invalid
     */
    public static synchronized void enterCustomer(int queueNumber, Customer customer) {
        if (queueNumber < 1 || queueNumber > NUMBER_OF_QUEUES) {
            throw new IllegalArgumentException("Invalid queue number: " + queueNumber);
        }
        queues.get(queueNumber - 1).add(customer);
    }

    /**
     * Removes and returns the next customer from the specified queue.
     * This method is synchronized to ensure thread safety.
     *
     * @param queueNumber the queue number to get the customer from (1-based)
     * @return the next customer in the queue, or null if the queue is empty
     * @throws IllegalArgumentException if the queue number is invalid
     */
    public static synchronized Customer attendCustomer(int queueNumber) {
        if (queueNumber < 1 || queueNumber > NUMBER_OF_QUEUES) {
            throw new IllegalArgumentException("Invalid queue number: " + queueNumber);
        }
        List<Customer> queue = queues.get(queueNumber - 1);
        return queue.isEmpty() ? null : queue.remove(0);
    }

    /**
     * Gets the current status of all queues.
     * This method is synchronized to ensure thread safety.
     *
     * @return a string containing the current status of all queues
     */
    public static synchronized String getQueuesStatus() {
        StringBuilder status = new StringBuilder("Queues Status:\n");
        for (int i = 0; i < NUMBER_OF_QUEUES; i++) {
            status.append("\tQueue ").append(i + 1).append(": ")
                    .append(queues.get(i).size()).append(" customers\n");
        }
        return status.toString();
    }

    /**
     * Checks if all queues are empty.
     * This method is synchronized to ensure thread safety.
     *
     * @return true if all queues are empty, false otherwise
     */
    public static synchronized boolean allQueuesEmpty() {
        for (List<Customer> queue : queues) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
