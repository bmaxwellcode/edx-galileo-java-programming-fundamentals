package week2.lessons.memory;

/**
 * The Stack represents one of the primary memory areas in the Java Virtual
 * Machine.
 * 
 * The stack is responsible for storing:
 * - Primitive data types (e.g., int, char, float, etc.)
 * - References to objects (but not the objects themselves, which are stored in
 * the heap)
 * - Method call frames, including local variables and partial results
 * 
 * Key characteristics of the stack:
 * - Each thread has its own stack (memory space allocated for thread execution)
 * - Memory is allocated and deallocated in a Last-In-First-Out (LIFO) manner
 * - Automatically managed by the JVM (no garbage collection needed)
 * - Limited in size (can be configured using the -Xss JVM parameter)
 * - Stack memory is faster to allocate than heap memory
 * - Variables only exist within the scope of the method they are declared in
 */
public class Stack {
}
