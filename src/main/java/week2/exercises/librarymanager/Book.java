package main2.week2.exercises.librarymanager;

/**
 * Book class represents the base class for all types of books in the library
 * system.
 * This class demonstrates basic OOP principles and serves as a foundation
 * for the inheritance hierarchy.
 */
public class Book {
    /** The title of the book */
    private String title;

    /** The author of the book */
    private String author;

    /** The year when the book was published */
    private int yearOfPublication;

    /**
     * Creates a new book with the specified title, author, and publication year.
     *
     * @param title             The title of the book
     * @param author            The author of the book
     * @param yearOfPublication The year when the book was published
     */
    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    /**
     * Gets the title of the book.
     *
     * @return The book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return The year when the book was published
     */
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    /**
     * Prints the book information to the console.
     * Can be overridden by subclasses to provide additional information.
     */
    public void print() {
        System.out.println("Title: " + title + " Author: " + author +
                " Year of publication: " + yearOfPublication);
    }
}
