package week4.exercises.movietheater;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the inventory of movie tickets in the theater.
 * This class implements a singleton pattern to ensure there is only one
 * instance managing the ticket inventory across the application.
 */
public final class MovieTicketsStock {
    /** The inventory of available tickets for each movie. */
    private static final Map<String, Integer> MOVIE_INVENTORY = new HashMap<>();

    /**
     * Private constructor to prevent instantiation.
     * This class follows the singleton pattern.
     */
    private MovieTicketsStock() {
        // Private constructor for singleton pattern
    }

    /**
     * Initializes the movie inventory with the given map of movies and ticket
     * counts.
     *
     * @param movieInventoryMap the map containing movie names and their ticket
     *                          counts
     */
    public static void initialize(Map<String, Integer> movieInventoryMap) {
        MOVIE_INVENTORY.putAll(movieInventoryMap);
    }

    /**
     * Attempts to sell a ticket for the specified movie.
     * This method is synchronized to ensure thread safety.
     *
     * @param movie the name of the movie
     * @return true if a ticket was successfully sold, false otherwise
     */
    public static synchronized boolean sellTicket(String movie) {
        Integer availableTickets = MOVIE_INVENTORY.get(movie);
        if (availableTickets != null && availableTickets > 0) {
            MOVIE_INVENTORY.put(movie, availableTickets - 1);
            return true;
        }
        return false;
    }

    /**
     * Gets the number of remaining tickets for a specific movie.
     *
     * @param movie the name of the movie
     * @return the number of remaining tickets, or 0 if the movie is not found
     */
    public static int getRemainingTickets(String movie) {
        Integer tickets = MOVIE_INVENTORY.get(movie);
        return tickets != null ? tickets : 0;
    }

    /**
     * Checks if all tickets have been sold.
     *
     * @return true if all tickets are sold, false otherwise
     */
    public static boolean allTicketsSold() {
        return MOVIE_INVENTORY.values().stream().mapToInt(Integer::intValue).sum() == 0;
    }

    /**
     * Gets a formatted string showing the current inventory status.
     *
     * @return a string containing the current ticket status for each movie
     */
    public static String getInventoryStatus() {
        StringBuilder status = new StringBuilder("Movie Tickets Status:\n");
        for (Map.Entry<String, Integer> entry : MOVIE_INVENTORY.entrySet()) {
            status.append("\t").append(entry.getKey()).append(": ")
                    .append(entry.getValue()).append(" tickets\n");
        }
        return status.toString();
    }
}
