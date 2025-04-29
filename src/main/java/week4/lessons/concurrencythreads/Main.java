package week4.lessons.concurrencythreads;

/**
 * Demonstrates different approaches to creating and managing threads in Java.
 */
public class Main {

    /**
     * Main method that demonstrates thread creation and control.
     *
     * @param args Command line arguments (not used)
     * @throws InterruptedException if thread operations are interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        // Thread creation using two different approaches:
        // 1. Using a class that extends Thread
        Thread thread1 = new ThreadObject();

        // 2. Using a class that implements Runnable
        // Note: We need to wrap the Runnable object in a Thread instance
        Thread thread2 = new Thread(new ThreadAllObject());

        // Start the thread execution (commented out thread1 for this demo)
        // thread1.start();
        thread2.start();

        // Thread control mechanisms (commented out here):

        // Sleep causes the main thread to pause execution for 2 seconds
        // Thread.sleep(2000);

        // Interrupt signals the thread to stop execution
        // thread1.interrupt();
        // thread2.interrupt();

        // Join makes the main thread wait until thread2 completes
        // This ensures thread2 finishes before the main thread continues
        thread2.join();

        // This will only execute after thread2 has completed
        System.out.println("Main thread will continue");
    }
}
