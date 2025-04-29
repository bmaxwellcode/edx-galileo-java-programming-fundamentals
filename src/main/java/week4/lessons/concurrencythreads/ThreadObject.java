package week4.lessons.concurrencythreads;

/**
 * This class demonstrates creating a thread by extending the Thread class.
 * Advantages: Direct access to Thread methods
 * Disadvantages: Cannot extend any other class (Java doesn't support multiple
 * inheritance)
 */
public class ThreadObject extends Thread {
    @Override
    public void run() {
        // This method contains the thread's execution logic
        // It will run in a separate thread when start() is called
        System.out.println("Hello from thread 1");

        for (int i = 0; i < 20; i++) {
            try {
                // Thread.sleep causes the current thread to pause execution
                // Parameter is in milliseconds (1000ms = 1 second)
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // This exception is thrown when another thread interrupts this thread
                // while it's sleeping or waiting
                System.out.println("Thread 1 has been interrupted");

                // Preserve the interrupted status for higher level interrupt handlers
                // This is important best practice for interrupt handling
                Thread.currentThread().interrupt();
            }
            System.out.println("Count from thread 1 - " + i);
        }
        // When this method completes, the thread terminates
    }
}
