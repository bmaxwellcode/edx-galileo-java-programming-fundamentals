package week4.lessons.concurrencythreads;

/**
 * This class demonstrates creating a thread by implementing the Runnable
 * interface.
 * Advantages:
 * - Can implement other interfaces or extend other classes
 * - Follows composition over inheritance principle
 * - More flexible design approach
 */
public class ThreadAllObject implements Runnable {
    private static final int PRINT_INTERVAL = 10_000_000;
    private static final int MAX_COUNT = Integer.MAX_VALUE;

    @Override
    public void run() {
        // Thread logic that will execute when thread.start() is called
        System.out.println("Hello from thread 2");

        // Original sleep-based approach (commented out)
        // for (int i = 0; i < 20; i++) {
        // try {
        // Thread.sleep(1500);
        // } catch (InterruptedException ex) {
        // System.out.println("Thread 2 has been interrupted");
        // Thread.currentThread().interrupt();
        // }
        // System.out.println("Count from thread 2 - " + i);
        // }

        // Alternative approach that demonstrates manual interrupt checking
        // Counting to Integer.MAX_VALUE (2,147,483,647)
        for (int i = 0; i < MAX_COUNT; i++) {
            // Only print every 10 million iterations to reduce console output
            if (i % PRINT_INTERVAL == 0) {
                System.out.println("Count from thread 2 - " + i);
            }

            // Thread.interrupted() checks if this thread has been interrupted
            // This is a polling approach to interrupt handling (vs exception-based
            // approach)
            if (Thread.interrupted()) {
                System.out.println("Thread 2 has been interrupted");
                break; // Exit the loop when interrupted
            }
        }
        // Thread terminates when run() completes
    }
}
