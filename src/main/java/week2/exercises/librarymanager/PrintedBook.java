package main2.week2.exercises.librarymanager;

/**
 * PrintedBook interface defines the basic functionality required for physical
 * books.
 * 
 * This interface demonstrates the use of interface contracts in Java.
 * Classes that implement this interface must provide methods for getting the
 * physical dimensions and weight of the printed book.
 */
public interface PrintedBook {
    /**
     * Gets the dimensions of the printed book.
     *
     * @return A String representing the book's dimensions
     */
    String getDimensions();

    /**
     * Gets the weight of the printed book.
     *
     * @return A String representing the book's weight
     */
    String getWeight();
}
