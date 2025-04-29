package week4.lessons.concurrencythreads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.lang.InterruptedException;
import java.util.Scanner;

/**
 * Main class that simulates a restaurant with multi-threading.
 * The simulation includes:
 * - A chef who cooks food items
 * - Two queues where customers wait
 * - Two attenders who serve customers from each queue
 * - A system to handle new customer arrivals
 */
public class MultiThreading {
    private static final int INITIAL_FOOD_STOCK = 10;
    private static final int CUSTOMER_QUEUE_CAPACITY = 5;
    private static final int SIMULATION_DURATION_MS = 10000;

    /**
     * Main method to start the restaurant simulation.
     *
     * @param args Command line arguments (not used)
     * @throws InterruptedException if thread operations are interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        FoodStock foodStock = new FoodStock(INITIAL_FOOD_STOCK);
        CustomerQueues customerQueues = new CustomerQueues(CUSTOMER_QUEUE_CAPACITY);

        Thread chefThread = new Thread(new Chef(foodStock));
        Thread entryThread = new Thread(new Entry(customerQueues));
        Thread attender1Thread = new Thread(new Attender(1, customerQueues, foodStock));
        Thread attender2Thread = new Thread(new Attender(2, customerQueues, foodStock));

        chefThread.start();
        entryThread.start();
        attender1Thread.start();
        attender2Thread.start();

        Thread.sleep(SIMULATION_DURATION_MS);

        chefThread.interrupt();
        entryThread.interrupt();
        attender1Thread.interrupt();
        attender2Thread.interrupt();
    }
}

/**
 * Manages the food inventory with thread-safe operations.
 */
class FoodStock {
    private int foodCount;
    private static final int MAX_FOOD_STOCK = 15;

    public FoodStock(int initialStock) {
        this.foodCount = initialStock;
    }

    public synchronized void addFood() {
        if (foodCount < MAX_FOOD_STOCK) {
            foodCount++;
            System.out.println("Chef added food. Current stock: " + foodCount);
            notifyAll();
        }
    }

    public synchronized boolean getFood() {
        while (foodCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        foodCount--;
        System.out.println("Food taken. Current stock: " + foodCount);
        return true;
    }
}

/**
 * Manages two customer queues with thread-safe operations.
 */
class CustomerQueues {
    private final Queue<Customer> queue1;
    private final Queue<Customer> queue2;
    private final int capacity;

    public CustomerQueues(int capacity) {
        this.capacity = capacity;
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public synchronized void addCustomer(Customer customer) {
        while (queue1.size() >= capacity && queue2.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        if (queue1.size() <= queue2.size()) {
            queue1.add(customer);
            System.out.println("Customer " + customer.getId() + " joined queue 1");
        } else {
            queue2.add(customer);
            System.out.println("Customer " + customer.getId() + " joined queue 2");
        }
        notifyAll();
    }

    public synchronized Customer getCustomerFromQueue(int queueNumber) {
        Queue<Customer> selectedQueue = (queueNumber == 1) ? queue1 : queue2;

        while (selectedQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        Customer customer = selectedQueue.poll();
        notifyAll();
        return customer;
    }
}

/**
 * Represents a customer with an ID and food order.
 */
class Customer {
    private final int id;
    private final boolean wantsFood;

    public Customer(int id) {
        this.id = id;
        this.wantsFood = new Random().nextBoolean();
    }

    public int getId() {
        return id;
    }

    public boolean wantsFood() {
        return wantsFood;
    }
}

/**
 * Simulates a chef preparing food at random intervals.
 */
class Chef implements Runnable {
    private final FoodStock foodStock;
    private static final int MIN_COOKING_TIME_MS = 1000;
    private static final int MAX_COOKING_TIME_MS = 3000;
    private final Random random = new Random();

    public Chef(FoodStock foodStock) {
        this.foodStock = foodStock;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(random.nextInt(MAX_COOKING_TIME_MS - MIN_COOKING_TIME_MS) + MIN_COOKING_TIME_MS);
                foodStock.addFood();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Simulates customer entry into the restaurant.
 */
class Entry implements Runnable {
    private final CustomerQueues customerQueues;
    private static final int MIN_ENTRY_TIME_MS = 500;
    private static final int MAX_ENTRY_TIME_MS = 2000;
    private final Random random = new Random();
    private int customerCount = 0;

    public Entry(CustomerQueues customerQueues) {
        this.customerQueues = customerQueues;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(random.nextInt(MAX_ENTRY_TIME_MS - MIN_ENTRY_TIME_MS) + MIN_ENTRY_TIME_MS);
                customerQueues.addCustomer(new Customer(++customerCount));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Simulates an attender serving customers from a specific queue.
 */
class Attender implements Runnable {
    private final int queueNumber;
    private final CustomerQueues customerQueues;
    private final FoodStock foodStock;
    private static final int SERVICE_TIME_MS = 1000;

    public Attender(int queueNumber, CustomerQueues customerQueues, FoodStock foodStock) {
        this.queueNumber = queueNumber;
        this.customerQueues = customerQueues;
        this.foodStock = foodStock;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customerQueues.getCustomerFromQueue(queueNumber);
                if (customer != null) {
                    if (customer.wantsFood()) {
                        if (foodStock.getFood()) {
                            System.out.println(
                                    "Attender " + queueNumber + " served food to customer " + customer.getId());
                        }
                    } else {
                        System.out.println(
                                "Attender " + queueNumber + " helped customer " + customer.getId() + " (no food)");
                    }
                    Thread.sleep(SERVICE_TIME_MS);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
