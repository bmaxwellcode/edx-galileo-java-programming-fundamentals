package week2.lessons.memory;

/**
 * The Heap represents one of the primary memory areas in the Java Virtual
 * Machine.
 * 
 * The heap is responsible for storing:
 * - All objects (e.g., instances of classes)
 * - Arrays (regardless of whether they contain primitive types or object
 * references)
 * - Class metadata and static variables
 * 
 * Key characteristics of the heap:
 * - Shared among all threads in the application
 * - Dynamically allocated during runtime
 * - Managed by the garbage collector
 * - Can be configured using JVM parameters (-Xms for initial size, -Xmx for
 * maximum size)
 * 
 * Memory in the heap persists beyond the scope of the method that created it,
 * unlike stack memory.
 */
public class Heap {
}
