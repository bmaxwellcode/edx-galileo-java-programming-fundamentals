package main2.week2.exercises.librarymanager;

/**
 * ScienceFictioneAudioBook class represents audio books from the science
 * fiction genre.
 * This class extends ScienceFictionBook and implements the eAudioBook
 * interface,
 * combining inheritance and interface implementation.
 * 
 * This demonstrates multiple inheritance concepts in Java through
 * class extension and interface implementation.
 */
public class ScienceFictioneAudioBook extends ScienceFictionBook implements eAudioBook {
    /** The number of audio tracks in this audio book */
    private int numberOfTracks;

    /**
     * Creates a new sci-fi audio book with the specified title, author, and
     * publication year.
     *
     * @param title             The title of the sci-fi audio book
     * @param author            The author of the sci-fi audio book
     * @param yearOfPublication The year when the sci-fi audio book was published
     */
    public ScienceFictioneAudioBook(String title, String author, int yearOfPublication) {
        super(title, author, yearOfPublication);
    }

    /**
     * Sets the number of audio tracks in this audio book.
     *
     * @param numberOfTracks The number of audio tracks
     */
    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    /**
     * Gets the number of audio tracks in this audio book.
     * Implementation of the eAudioBook interface method.
     *
     * @return The number of audio tracks
     */
    @Override
    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    /**
     * Prints the sci-fi audio book information to the console.
     * Overrides the parent class method to add audio book-specific details.
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Number of Tracks: " + numberOfTracks);
    }
}
