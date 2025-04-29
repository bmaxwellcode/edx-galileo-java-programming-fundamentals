package week4.exercises.movietheater;

import java.util.Random;

/**
 * Represents a thread that generates new customers for the movie theater.
 * This thread randomly creates customers with different movie choices and
 * adds them to the appropriate queue.
 */
public class Entry extends Thread {
    /** Random number generator for customer generation. */
    private final Random random = new Random();

    /** The unique identifier for the next customer. */
    private static int id;

    /** Flag to control the thread's execution. */
    private volatile boolean threadAlive = true;

    /** Minimum time between customer arrivals in milliseconds. */
    private static final int MIN_ARRIVAL_TIME = 1000;

    /** Maximum time between customer arrivals in milliseconds. */
    private static final int MAX_ARRIVAL_TIME = 3000;

    /** Minimum decision time in milliseconds. */
    private static final int MIN_DECISION_TIME = 1000;

    /** Maximum decision time in milliseconds. */
    private static final int MAX_DECISION_TIME = 3000;

    /** Number of movies available. */
    private static final int NUMBER_OF_MOVIES = 15;

    /** Number of queues available. */
    private static final int NUMBER_OF_QUEUES = 5;

    /**
     * Creates a new customer and adds them to the appropriate queue.
     *
     * @param customerArrivalTimeInterval the time interval for customer arrival
     */
    public void entry(int customerArrivalTimeInterval) {
        int movieDecision = 1 + random.nextInt(NUMBER_OF_MOVIES);
        int decisionTimeDuration = MIN_DECISION_TIME + random.nextInt(MAX_DECISION_TIME - MIN_DECISION_TIME);
        String movieName = getMovieName(movieDecision);
        int queue = ((movieDecision - 1) / 3) + 1;

        Customer customer = new Customer(id++, decisionTimeDuration, movieName);
        MovieQueues.enterCustomer(queue, customer);

        System.out.println("Customer #" + id + " enters the queue " + queue +
                " in " + (customerArrivalTimeInterval / 1000) + " seconds");
    }

    /**
     * Gets the movie name based on the movie decision number.
     *
     * @param movieDecision the movie decision number (1-15)
     * @return the corresponding movie name
     */
    private String getMovieName(int movieDecision) {
        String movieName;
        switch (movieDecision) {
            case 1:
                movieName = "Star Trek Beyond";
                break;
            case 2:
                movieName = "Moana";
                break;
            case 3:
                movieName = "Arrival";
                break;
            case 4:
                movieName = "Star Wars: Rogue One";
                break;
            case 5:
                movieName = "Split";
                break;
            case 6:
                movieName = "Fantastic Beasts & Where to Find Them";
                break;
            case 7:
                movieName = "Logan";
                break;
            case 8:
                movieName = "Justice League";
                break;
            case 9:
                movieName = "Alien: Covenant";
                break;
            case 10:
                movieName = "Thor: Ragnarok";
                break;
            case 11:
                movieName = "The Mummy";
                break;
            case 12:
                movieName = "Kingsman: The Golden Circle";
                break;
            case 13:
                movieName = "Wonder Woman";
                break;
            case 14:
                movieName = "Star Wars: Episode VIII -The Last Jedi";
                break;
            case 15:
                movieName = "Guardians of the Galaxy: Vol 2";
                break;
            default:
                movieName = "";
                break;
        }
        return movieName;
    }

    /**
     * The main execution method for the entry thread.
     * Continuously generates new customers until the thread is terminated.
     */
    @Override
    public void run() {
        while (threadAlive) {
            try {
                int arrivalTime = MIN_ARRIVAL_TIME + random.nextInt(MAX_ARRIVAL_TIME - MIN_ARRIVAL_TIME);
                Thread.sleep(arrivalTime);
                entry(arrivalTime);
            } catch (InterruptedException e) {
                System.out.println("Entry thread was interrupted");
            }
        }
    }

    /**
     * Signals the entry thread to terminate.
     */
    public void end() {
        threadAlive = false;
    }
}
