package main2.week2.lessons.memory;

/**
 * MemoryLeaks demonstrates techniques to prevent memory leaks in Java
 * applications.
 * A memory leak occurs when objects that are no longer needed still maintain
 * references, preventing the garbage collector from reclaiming their memory.
 *
 * To prevent memory leaks, it is necessary to remove object references when
 * they
 * are no longer needed. This class demonstrates three common techniques:
 *
 * 1. Setting the object's reference to null
 * 2. Assigning a reference to another object
 * 3. Using anonymous objects
 *
 * Additional best practices to prevent memory leaks:
 * - Close resources properly (streams, connections, etc.)
 * - Be careful with static fields (they remain in memory for the application's
 * lifetime)
 * - Implement proper cleanup in listeners and callbacks
 * - Be mindful of inner class references to outer class instances
 */
public class MemoryLeaks {

    /**
     * Demonstrates various techniques to prevent memory leaks.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // 1) By setting the object's reference to null
        String str1 = "Hello, World!";
        str1 = null; // str1 is now unreferenced

        // 2) By assigning a reference to another object
        String str2 = "Goodbye, World!";
        str2 = "New String"; // str2 now references a new object, the old one is unreferenced

        // 3) By anonymous object
        printString(new String("Anonymous String")); // The "Anonymous String" object
        // is unreferenced after the method call
    }

    /**
     * Prints the provided string to the console.
     * When using anonymous objects as arguments, they become eligible for
     * garbage collection after the method returns.
     *
     * @param str The string to print
     */
    public static void printString(String str) {
        System.out.println(str);
    }
}
