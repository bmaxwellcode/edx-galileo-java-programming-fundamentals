package main2.week2.exercises.librarymanager;

/**
 * DramaBook class represents books from the drama genre.
 * This class extends the Book class and adds drama-specific attributes
 * like time period and setting place.
 * 
 * This demonstrates inheritance in object-oriented programming.
 */
public class DramaBook extends Book {
    /** The time period in which the drama takes place */
    private int time;

    /** The location where the drama takes place */
    private String place;

    /**
     * Creates a new drama book with the specified title, author, and publication
     * year.
     *
     * @param title         The title of the drama book
     * @param author        The author of the drama book
     * @param yearPublished The year when the drama book was published
     */
    public DramaBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    /**
     * Sets the time period of the drama.
     *
     * @param time The time period in which the drama takes place
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Sets the location of the drama.
     *
     * @param place The location where the drama takes place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Gets the time period of the drama.
     *
     * @return The time period in which the drama takes place
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets the location of the drama.
     *
     * @return The location where the drama takes place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Prints the drama book information to the console.
     * Overrides the parent class method to add drama-specific details.
     */
    @Override
    public void print() {
        super.print();
        System.out.print("Time: " + time + " Place: " + place);
    }
}
