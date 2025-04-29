package main2.week2.exercises.librarymanager;

/**
 * eBook interface defines the basic functionality required for electronic
 * books.
 * 
 * This interface demonstrates the use of interface contracts in Java.
 * Classes that implement this interface must provide a method for getting the
 * digital size of the eBook.
 */
public interface eBook {
    /**
     * Gets the digital size of the eBook.
     *
     * @return The size of the eBook in appropriate units (likely MB)
     */
    int getSize();
}
