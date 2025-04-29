package main2.week2.lessons.memory;

/**
 * GarbageCollector class demonstrates how Java's automatic memory management
 * works.
 * 
 * The garbage collector is responsible for:
 * - Identifying objects that are no longer referenced by the program
 * - Reclaiming the memory used by these unreferenced objects
 * - Preventing memory leaks by freeing unused memory
 * 
 * Key characteristics of Java's garbage collection:
 * - Automatic process that runs in the background
 * - Uses various algorithms to detect unused objects (mark-and-sweep,
 * generational collection, etc.)
 * - Can be triggered explicitly using System.gc() (though this is only a
 * suggestion to the JVM)
 * - Objects become eligible for garbage collection when they have no references
 * pointing to them
 * 
 * Garbage collection phases:
 * 1. Marking - identifying which objects are in use and which are not
 * 2. Deletion - removing unused objects to free memory
 * 3. Compaction (optional) - moving remaining objects together to reduce
 * fragmentation
 * 
 * The finalize() method can be overridden to perform cleanup actions before an
 * object is garbage collected,
 * but its use is discouraged in modern Java applications in favor of
 * try-with-resources or explicit resource management.
 */
public class GarbageCollector {
    /**
     * Demonstrates when objects become eligible for garbage collection.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create objects
        Object obj1 = new Object();
        Object obj2 = new Object();

        // obj1 becomes unreferenced and eligible for garbage collection
        obj1 = null;

        // obj2 becomes unreferenced when it's reassigned
        obj2 = new Object();

        // Suggest to run garbage collection (JVM may ignore this hint)
        System.gc();

        System.out.println("Garbage collection requested, but may not have run yet.");
    }
}
