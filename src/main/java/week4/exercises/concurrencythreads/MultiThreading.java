package week4.exercises.concurrencythreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Restaurant Simulation using Multi-Threading
 * 
 * This program simulates a restaurant operation with multiple concurrent
 * processes:
 * - A chef who cooks different food items at random intervals
 * - Two customer queues where customers wait to place orders
 * - Two attendants who serve customers from their respective queues
 * - A system that generates new customers entering the restaurant
 * 
 * The simulation demonstrates concurrent programming concepts including:
 * - Thread creation and management
 * - Synchronized methods for thread safety
 * - Producer-consumer relationships
 * - Resource sharing and coordination
 */
public final class MultiThreading {
    /** The number of attenders in the restaurant. */
    private static final int NUMBER_OF_ATTENDERS = 2;

    /**
     * Private constructor to prevent instantiation.
     * This class contains only static methods.
     */
    private MultiThreading() {
        // Private constructor for utility class
    }

    /**
     * The main method that runs the restaurant simulation.
     * Initializes the food inventory, creates and starts the chef, entry,
     * and attender threads, and manages the simulation until user input.
     *
     * @param args command line arguments (not used)
     * @throws Exception if any thread is interrupted
     */
    public static void main(String[] args) throws Exception {
        Scanner inputReader = new Scanner(System.in);
        String userInput;

        System.out.println("=== Restaurant Simulation Started ===");
        System.out.println("(Press enter key to stop the simulation)");

        // Initialize food inventory
        FoodStock.initialize(0, 0, 0);

        // Initialize all threads needed for the simulation
        Chef chef = new Chef();
        Entry customerEntry = new Entry();
        Attender[] attenders = new Attender[NUMBER_OF_ATTENDERS];
        for (int i = 0; i < NUMBER_OF_ATTENDERS; i++) {
            attenders[i] = new Attender(i);
        }

        // Start all threads
        chef.start();
        customerEntry.start();
        for (Attender attender : attenders) {
            attender.start();
        }

        // Wait for user input to stop the simulation
        // Any input (except just pressing Enter) will terminate all threads
        while (true) {
            userInput = inputReader.next();

            // Terminate all threads cleanly
            System.out.println("\n=== Shutting down simulation ===");
            chef.end();
            customerEntry.end();
            for (Attender attender : attenders) {
                attender.end();
            }

            System.out.println("All threads terminated. Simulation ended.");
            inputReader.close();
            System.exit(0);
        }
    }
}

/**
 * Manages the inventory of food items in the restaurant.
 * This class implements a singleton pattern to ensure there is only one
 * instance managing the food inventory across the application.
 */
final class FoodStock {
    /** The number of burgers in stock. */
    private static int burger;

    /** The number of sandwiches in stock. */
    private static int sandwich;

    /** The number of salads in stock. */
    private static int salad;

    /**
     * Private constructor to prevent instantiation.
     * This class follows the singleton pattern.
     */
    private FoodStock() {
        // Private constructor for singleton pattern
    }

    /**
     * Initializes the food inventory with the specified quantities.
     *
     * @param initialBurger   the initial number of burgers
     * @param initialSandwich the initial number of sandwiches
     * @param initialSalad    the initial number of salads
     */
    public static void initialize(int initialBurger, int initialSandwich, int initialSalad) {
        burger = initialBurger;
        sandwich = initialSandwich;
        salad = initialSalad;
    }

    /**
     * Cooks or sells a burger based on the specified action.
     * This method is synchronized to ensure thread safety.
     *
     * @param action the action to perform ("cook" or "sell")
     * @return true if the action was successful, false otherwise
     */
    public static synchronized boolean cookSellBurger(String action) {
        if ("cook".equals(action)) {
            burger++;
            return true;
        } else if ("sell".equals(action) && burger > 0) {
            burger--;
            return true;
        }
        return false;
    }

    /**
     * Cooks or sells a sandwich based on the specified action.
     * This method is synchronized to ensure thread safety.
     *
     * @param action the action to perform ("cook" or "sell")
     * @return true if the action was successful, false otherwise
     */
    public static synchronized boolean cookSellSandwich(String action) {
        if ("cook".equals(action)) {
            sandwich++;
            return true;
        } else if ("sell".equals(action) && sandwich > 0) {
            sandwich--;
            return true;
        }
        return false;
    }

    /**
     * Cooks or sells a salad based on the specified action.
     * This method is synchronized to ensure thread safety.
     *
     * @param action the action to perform ("cook" or "sell")
     * @return true if the action was successful, false otherwise
     */
    public static synchronized boolean cookSellSalad(String action) {
        if ("cook".equals(action)) {
            salad++;
            return true;
        } else if ("sell".equals(action) && salad > 0) {
            salad--;
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the current food inventory.
     *
     * @return a string containing the current inventory status
     */
    @Override
    public String toString() {
        return "Food Inventory:\n" +
                "\tBurgers: " + burger + "\n" +
                "\tSandwiches: " + sandwich + "\n" +
                "\tSalads: " + salad;
    }
}

/**
 * Manages the customer queues for the restaurant.
 * This class handles the synchronization of customer queues and provides
 * thread-safe methods for adding and removing customers from queues.
 */
final class CustomerQueues {
    /** The number of queues in the restaurant. */
    private static final int NUMBER_OF_QUEUES = 2;

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
    private CustomerQueues() {
        // Private constructor for singleton pattern
    }

    /**
     * Adds a customer to the specified queue.
     * This method is synchronized to ensure thread safety.
     *
     * @param queueNumber the queue number to add the customer to (0 or 1)
     * @param customer    the customer to add to the queue
     * @throws IllegalArgumentException if the queue number is invalid
     */
    public static synchronized void enterCustomer(int queueNumber, Customer customer) {
        if (queueNumber < 0 || queueNumber >= NUMBER_OF_QUEUES) {
            throw new IllegalArgumentException("Invalid queue number: " + queueNumber);
        }
        queues.get(queueNumber).add(customer);
    }

    /**
     * Removes and returns the next customer from the specified queue.
     * This method is synchronized to ensure thread safety.
     *
     * @param queueNumber the queue number to get the customer from (0 or 1)
     * @return the next customer in the queue, or null if the queue is empty
     * @throws IllegalArgumentException if the queue number is invalid
     */
    public static synchronized Customer attendCustomer(int queueNumber) {
        if (queueNumber < 0 || queueNumber >= NUMBER_OF_QUEUES) {
            throw new IllegalArgumentException("Invalid queue number: " + queueNumber);
        }
        List<Customer> queue = queues.get(queueNumber);
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

/**
 * Represents a customer in the restaurant system.
 * Each customer has an ID, decision time duration, and a food choice.
 */
final class Customer {
    /** The unique identifier of the customer. */
    private final int id;

    /** The time taken by the customer to make a decision (in milliseconds). */
    private final int timeToDecide;

    /** The food item chosen by the customer. */
    private final String desiredFood;

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param id           the unique identifier of the customer
     * @param timeToDecide the time taken to make a decision (in milliseconds)
     * @param desiredFood  the food item chosen by the customer
     */
    public Customer(int id, int timeToDecide, String desiredFood) {
        this.id = id;
        this.timeToDecide = timeToDecide;
        this.desiredFood = desiredFood;
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
    public int getTimeToDecide() {
        return timeToDecide;
    }

    /**
     * Gets the customer's food choice.
     *
     * @return the chosen food item
     */
    public String getDesiredFood() {
        return desiredFood;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return a string in the format "Customer #X" where X is the customer's ID
     */
    @Override
    public String toString() {
        return "Customer #" + id;
    }
}

/**
 * Represents a chef in the restaurant who cooks food items.
 * This thread continuously cooks different types of food at random intervals.
 */
final class Chef extends Thread {
    /** Random number generator for cooking time calculation. */
    private final Random randomGenerator;

    /** Flag to control the thread's execution. */
    private volatile boolean threadAlive;

    /** Minimum cooking time in milliseconds. */
    private static final int MIN_COOKING_TIME = 2000;

    /** Random cooking time range in milliseconds. */
    private static final int RANDOM_COOKING_TIME = 1000;

    /** Number of different food types that can be cooked. */
    private static final int NUMBER_OF_FOOD_TYPES = 3;

    /**
     * Constructs a new Chef thread.
     */
    public Chef() {
        randomGenerator = new Random();
        threadAlive = true;
    }

    /**
     * The main execution method of the thread.
     * Continuously cooks food items until stopped.
     */
    @Override
    public void run() {
        while (threadAlive) {
            try {
                int cookingTime = MIN_COOKING_TIME + randomGenerator.nextInt(RANDOM_COOKING_TIME);
                Thread.sleep(cookingTime);
                int foodType = randomGenerator.nextInt(NUMBER_OF_FOOD_TYPES);
                cookFood(foodType);
            } catch (InterruptedException e) {
                System.out.println("Chef thread was interrupted");
            }
        }
    }

    /**
     * Cooks a specific type of food based on the food type number.
     *
     * @param foodType the type of food to cook (0: burger, 1: sandwich, 2: salad)
     */
    private void cookFood(int foodType) {
        switch (foodType) {
            case 0:
                if (FoodStock.cookSellBurger("cook")) {
                    System.out.println("Chef cooked a burger");
                }
                break;
            case 1:
                if (FoodStock.cookSellSandwich("cook")) {
                    System.out.println("Chef cooked a sandwich");
                }
                break;
            case 2:
                if (FoodStock.cookSellSalad("cook")) {
                    System.out.println("Chef cooked a salad");
                }
                break;
        }
    }

    /**
     * Signals the chef thread to terminate.
     */
    public void end() {
        threadAlive = false;
    }
}

/**
 * Represents a thread that generates new customers for the restaurant.
 * This thread randomly creates customers with different food choices and
 * adds them to the appropriate queue.
 */
final class Entry extends Thread {
    /** Random number generator for customer generation. */
    private final Random randomGenerator;

    /** The unique identifier for the next customer. */
    private static int customerIdCounter;

    /** Flag to control the thread's execution. */
    private volatile boolean threadAlive;

    /** Minimum time between customer arrivals in milliseconds. */
    private static final int MIN_ENTRY_TIME = 1000;

    /** Random entry time range in milliseconds. */
    private static final int RANDOM_ENTRY_TIME = 1000;

    /** Number of queues in the restaurant. */
    private static final int NUMBER_OF_QUEUES = 2;

    /** Number of different food types available. */
    private static final int NUMBER_OF_FOOD_TYPES = 3;

    /** Minimum decision time in milliseconds. */
    private static final int MIN_DECISION_TIME = 1000;

    /** Random decision time range in milliseconds. */
    private static final int RANDOM_DECISION_TIME = 1000;

    /**
     * Constructs a new Entry thread.
     */
    public Entry() {
        randomGenerator = new Random();
        threadAlive = true;
    }

    /**
     * The main execution method of the thread.
     * Continuously generates new customers until stopped.
     */
    @Override
    public void run() {
        while (threadAlive) {
            try {
                int entryTime = MIN_ENTRY_TIME + randomGenerator.nextInt(RANDOM_ENTRY_TIME);
                Thread.sleep(entryTime);
                createCustomer(entryTime);
            } catch (InterruptedException e) {
                System.out.println("Entry thread was interrupted");
            }
        }
    }

    /**
     * Creates a new customer with random food choice and adds them to a queue.
     *
     * @param entryTime the time taken for the customer to enter
     */
    private void createCustomer(int entryTime) {
        int foodType = randomGenerator.nextInt(NUMBER_OF_FOOD_TYPES);
        int decisionTime = MIN_DECISION_TIME + randomGenerator.nextInt(RANDOM_DECISION_TIME);
        String foodName = getFoodName(foodType);
        int queue = randomGenerator.nextInt(NUMBER_OF_QUEUES);

        Customer customer = new Customer(customerIdCounter++, decisionTime, foodName);
        CustomerQueues.enterCustomer(queue, customer);

        System.out.println("Customer #" + customerIdCounter + " enters queue " + (queue + 1) +
                " in " + (entryTime / 1000) + " seconds");
    }

    /**
     * Gets the food name based on the food type number.
     *
     * @param foodType the type of food (0: burger, 1: sandwich, 2: salad)
     * @return the corresponding food name
     */
    private String getFoodName(int foodType) {
        switch (foodType) {
            case 0:
                return "burger";
            case 1:
                return "sandwich";
            case 2:
                return "salad";
            default:
                return "";
        }
    }

    /**
     * Signals the entry thread to terminate.
     */
    public void end() {
        threadAlive = false;
    }
}

/**
 * Represents an attender who serves customers in the restaurant.
 * This thread processes customers from its assigned queue, handling
 * food orders and service times.
 */
final class Attender extends Thread {
    /** The queue number this attender is responsible for. */
    private final int queueNumber;

    /** Flag to control the thread's execution. */
    private volatile boolean threadAlive;

    /** Minimum service time in milliseconds. */
    private static final int MIN_SERVICE_TIME = 1000;

    /** Random service time range in milliseconds. */
    private static final int RANDOM_SERVICE_TIME = 1000;

    /**
     * Constructs a new Attender for the specified queue.
     *
     * @param queueNumber the queue number this attender will service
     */
    public Attender(int queueNumber) {
        this.queueNumber = queueNumber;
        this.threadAlive = true;
    }

    /**
     * The main execution method of the thread.
     * Continuously processes customers from the assigned queue until stopped.
     */
    @Override
    public void run() {
        while (threadAlive) {
            Customer customer = CustomerQueues.attendCustomer(queueNumber);
            if (customer != null) {
                serveCustomer(customer);
            }
        }
    }

    /**
     * Processes a customer from the queue, including food order and service time.
     *
     * @param customer the customer to serve
     */
    private void serveCustomer(Customer customer) {
        int serviceTime = MIN_SERVICE_TIME + (int) (Math.random() * RANDOM_SERVICE_TIME);
        System.out.println("Attender " + (queueNumber + 1) + " is attending customer #" +
                customer.getId() + " for " + (serviceTime / 1000) + " seconds");

        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            System.out.println("Attender " + (queueNumber + 1) + " was interrupted");
        }

        String food = customer.getDesiredFood();
        boolean success = false;
        switch (food) {
            case "burger":
                success = FoodStock.cookSellBurger("sell");
                break;
            case "sandwich":
                success = FoodStock.cookSellSandwich("sell");
                break;
            case "salad":
                success = FoodStock.cookSellSalad("sell");
                break;
        }

        if (success) {
            System.out.println("Customer #" + customer.getId() + " got a " + food);
        } else {
            System.out.println("Customer #" + customer.getId() + " couldn't get a " + food +
                    " (out of stock)");
        }
    }

    /**
     * Signals the attender thread to terminate.
     */
    public void end() {
        threadAlive = false;
    }
}