package week4.exercises.movietheater;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class that initializes and runs the movie theater simulation.
 * This class sets up the ticket inventory, creates customer entry and
 * attender threads, and manages the overall simulation flow.
 */
public final class MultiThreading {
    /** The number of attenders in the movie theater. */
    private static final int NUMBER_OF_ATTENDERS = 5;

    /** The initial number of tickets for each movie. */
    private static final int INITIAL_TICKETS_PER_MOVIE = 10;

    /** The monitoring interval in milliseconds. */
    private static final int MONITOR_INTERVAL = 1000;

    /**
     * Private constructor to prevent instantiation.
     * This class contains only static methods.
     */
    private MultiThreading() {
        // Private constructor for utility class
    }

    /**
     * Initializes the movie ticket inventory with the specified number of tickets
     * for each movie.
     *
     * @return a map containing movie names and their initial ticket counts
     */
    private static Map<String, Integer> initializeMovieInventory() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Star Trek Beyond", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Moana", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Arrival", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Star Wars: Rogue One", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Split", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Fantastic Beasts & Where to Find Them", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Logan", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Justice League", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Alien: Covenant", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Thor: Ragnarok", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("The Mummy", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Kingsman: The Golden Circle", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Wonder Woman", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Star Wars: Episode VIII -The Last Jedi", INITIAL_TICKETS_PER_MOVIE);
        inventory.put("Guardians of the Galaxy: Vol 2", INITIAL_TICKETS_PER_MOVIE);
        return inventory;
    }

    /**
     * The main method that runs the movie theater simulation.
     * Initializes the ticket inventory, creates and starts the entry and
     * attender threads, and monitors the simulation until completion.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize movie ticket inventory
        MovieTicketsStock.initialize(initializeMovieInventory());
        System.out.println("Initial Movie Tickets Status:");
        System.out.println(MovieTicketsStock.getInventoryStatus());

        // Create and start the entry thread
        Entry entry = new Entry();
        entry.start();

        // Create and start attender threads
        Attender[] attenders = new Attender[NUMBER_OF_ATTENDERS];
        for (int i = 0; i < NUMBER_OF_ATTENDERS; i++) {
            attenders[i] = new Attender(i + 1);
            attenders[i].start();
        }

        // Create a monitor thread to check for end condition
        Thread monitor = new Thread(() -> {
            while (!MovieTicketsStock.allTicketsSold() && !MovieQueues.allQueuesEmpty()) {
                try {
                    Thread.sleep(MONITOR_INTERVAL);
                } catch (InterruptedException e) {
                    System.out.println("Monitor thread was interrupted");
                }
            }
        });
        monitor.start();

        // Wait for user input to end the simulation
        System.out.println("Enter any key to end the simulation...");
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
        }

        // Stop all threads
        entry.end();
        for (Attender attender : attenders) {
            attender.end();
        }

        // Print final status
        System.out.println("\nFinal Movie Tickets Status:");
        System.out.println(MovieTicketsStock.getInventoryStatus());
        System.out.println("\nFinal Queues Status:");
        System.out.println(MovieQueues.getQueuesStatus());
    }
}