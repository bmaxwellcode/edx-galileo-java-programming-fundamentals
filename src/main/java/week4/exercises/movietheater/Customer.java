package week4.exercises.movietheater;

/**
 * Represents a customer in the movie theater system.
 * Each customer has an ID, decision time duration, and a movie choice.
 */
public class Customer {
    /** The unique identifier of the customer. */
    private final int id;

    /** The time taken by the customer to make a decision (in milliseconds). */
    private final int decisionTimeDuration;

    /** The movie chosen by the customer. */
    private final String movieDecision;

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param id                   the unique identifier of the customer
     * @param decisionTimeDuration the time taken to make a decision (in
     *                             milliseconds)
     * @param movieDecision        the movie chosen by the customer
     */
    public Customer(int id, int decisionTimeDuration, String movieDecision) {
        this.id = id;
        this.decisionTimeDuration = decisionTimeDuration;
        this.movieDecision = movieDecision;
    }

    /**
     * Gets the customer's ID.
     *
     * @return the customer's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the customer's decision time duration.
     *
     * @return the decision time duration in milliseconds
     */
    public int getDecisionTimeDuration() {
        return decisionTimeDuration;
    }

    /**
     * Gets the customer's movie choice.
     *
     * @return the chosen movie
     */
    public String getMovieDecision() {
        return movieDecision;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return a string in the format "Customer #X" where X is the customer's ID
     */
    @Override
    public String toString() {
        return "Customer #" + this.id;
    }
}
