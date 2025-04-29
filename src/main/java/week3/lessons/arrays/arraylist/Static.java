package week3.lessons.arrays.arraylist;

import java.util.Arrays;

/**
 * Static - Demonstrates the use of fixed-size arrays in Java.
 *
 * This class shows different types of arrays in Java:
 * 1. Primitive type arrays (initialized with default values)
 * 2. Reference type arrays (initialized with null values)
 * 3. Custom object arrays
 *
 * It also demonstrates different ways to create and initialize arrays.
 */
public class Static {

    /**
     * Main method demonstrating different types of arrays and their operations.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // ===== Primitive Array Example =====
        System.out.println("---- Primitive Integer Array ----");
        // Creates array of int with default values (0)
        int[] intArray = new int[3];
        System.out.println("Array of primitive ints (default values are 0):");
        System.out.println(Arrays.toString(intArray));

        // ===== Wrapper Class Array Example =====
        System.out.println("\n---- Integer Object Array ----");
        // Creates array of Integer objects with default values (null)
        Integer[] integerArray = new Integer[3];
        System.out.println("Array of Integer objects (default values are null):");
        System.out.println(Arrays.toString(integerArray));

        // Assign a value to first element
        integerArray[0] = Integer.valueOf(5);
        System.out.println("\nAfter setting first element to 5:");
        System.out.println(Arrays.toString(integerArray));

        // ===== Custom Object Array Example =====
        System.out.println("\n---- Custom Object Array ----");
        // Initialize array with objects using array initializer syntax
        Foo[] fooArray = { new Foo(1), new Foo(2), new Foo(3) };
        System.out.println("Array of Foo objects created with initializer:");
        System.out.println(Arrays.toString(fooArray));

        // Set one element to null
        fooArray[1] = null;
        System.out.println("\nAfter setting second element to null:");
        System.out.println(Arrays.toString(fooArray));

        // ===== Array Size Limitations =====
        System.out.println("\n---- Array Size Limitations ----");
        System.out.println("Arrays have fixed size. We cannot add or remove elements.");
        System.out.println("We can only change values at existing indices.");
    }
}

/**
 * Foo - Simple demonstration class for custom objects in arrays.
 *
 * This class represents a simple object with an ID that can be stored in
 * arrays.
 */
class Foo {

    /** The unique identifier for this Foo object */
    private int id;

    /**
     * Constructs a Foo object with the specified ID.
     *
     * @param id The unique identifier for this Foo object
     */
    public Foo(int id) {
        this.id = id;
    }

    /**
     * Returns a string representation of this Foo object.
     *
     * @return String describing this Foo object with its ID
     */
    @Override
    public String toString() {
        return "I'm Foo Object #" + this.id;
    }
}
