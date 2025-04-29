package week4.exercises.movietheater;

import java.util.Random;

/**
 * Represents a thread that attends to customers in the movie theater queues.
 * This thread processes customers from the queues, handles ticket sales,
 * and manages customer service times.
 */
public class Attender extends Thread {
    /** Random number generator for service time calculation. */
    private final Random random = new Random();

    /** Flag to control the thread's execution. */
    private volatile boolean threadAlive = true;

    /** The queue number this attender is responsible for. */
    private final int queueNumber;

    /** Minimum service time in milliseconds. */
    private static final int MIN_SERVICE_TIME = 1000;

    /** Maximum service time in milliseconds. */
    private static final int MAX_SERVICE_TIME = 3000;

    /**
     * Constructs a new Attender for the specified queue.
     *
     * @param queueNumber the queue number this attender will service
     */
    public Attender(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    /**
     * Generates a random service time for attending a customer.
     *
     * @return a random service time in milliseconds
     */
    private int generateServiceTime() {
        return MIN_SERVICE_TIME + random.nextInt(MAX_SERVICE_TIME - MIN_SERVICE_TIME);
    }

    /**
     * Processes a customer from the queue, including ticket sales and service time.
     *
     * @param customer the customer to attend
     */
    private void attendCustomer(Customer customer) {
        int serviceTime = generateServiceTime();
        System.out.println("Attender " + queueNumber + " is attending customer #" +
                customer.getId() + " for " + (serviceTime / 1000) + " seconds");

        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            System.out.println("Attender " + queueNumber + " was interrupted");
        }

        if (MovieTicketsStock.sellTicket(customer.getMovieDecision())) {
            System.out.println("Customer #" + customer.getId() + " bought a ticket for " +
                    customer.getMovieDecision());
        } else {
            System.out.println("Customer #" + customer.getId() + " couldn't buy a ticket for " +
                    customer.getMovieDecision() + " (sold out)");
        }
    }

    /**
     * The main execution method of the thread.
     * Continuously processes customers from the assigned queue until stopped.
     */
    @Override
    public void run() {
        while (threadAlive) {
            Customer customer = MovieQueues.attendCustomer(queueNumber);
            if (customer != null) {
                attendCustomer(customer);
            }
        }
    }

    /**
     * Signals the attender thread to terminate.
     */
    public void end() {
        threadAlive = false;
    }
}
