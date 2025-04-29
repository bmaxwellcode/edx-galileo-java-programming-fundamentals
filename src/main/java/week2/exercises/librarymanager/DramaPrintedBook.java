package main2.week2.exercises.librarymanager;

/**
 * DramaPrintedBook class represents physical books from the drama genre.
 * This class extends DramaBook and implements the PrintedBook interface,
 * combining inheritance and interface implementation.
 * 
 * This demonstrates multiple inheritance concepts in Java through
 * class extension and interface implementation.
 */
public class DramaPrintedBook extends DramaBook implements PrintedBook {
    /** The length of the printed book in appropriate units */
    private double length;

    /** The width of the printed book in appropriate units */
    private double width;

    /** The height of the printed book in appropriate units */
    private double height;

    /** The weight of the printed book in pounds */
    private double weight;

    /**
     * Creates a new printed drama book with the specified title, author, and
     * publication year.
     *
     * @param title         The title of the drama book
     * @param author        The author of the drama book
     * @param yearPublished The year when the drama book was published
     */
    public DramaPrintedBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    // public DramaPrintedBook(
    // double length,
    // double width,
    // double height,
    // double weight
    // ) {
    // this.length = length;
    // this.width = width;
    // this.height = height;
    // this.weight = weight;
    // }
    /**
     * Sets the physical dimensions of the printed book.
     *
     * @param length The length of the book
     * @param width  The width of the book
     * @param height The height of the book
     */
    public void setDimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the weight of the printed book.
     *
     * @param weight The weight of the book in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the dimensions of the printed book.
     * Implementation of the PrintedBook interface method.
     *
     * @return A formatted string with the book's dimensions
     */
    @Override
    public String getDimensions() {
        return "Dimensions are " + length + " x " + width + " x " + height;
    }

    /**
     * Gets the weight of the printed book.
     * Implementation of the PrintedBook interface method.
     *
     * @return A formatted string with the book's weight
     */
    @Override
    public String getWeight() {
        return weight + "lbs";
    }
}
