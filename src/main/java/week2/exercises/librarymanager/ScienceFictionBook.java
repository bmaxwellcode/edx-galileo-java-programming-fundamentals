package main2.week2.exercises.librarymanager;

/**
 * ScienceFictionBook class represents books from the science fiction genre.
 * This class extends the Book class and adds sci-fi specific attributes
 * like the subject/theme.
 * 
 * This demonstrates inheritance in object-oriented programming.
 */
public class ScienceFictionBook extends Book {
    /** The subject or theme of the science fiction book */
    private String subject;

    /**
     * Creates a new science fiction book with the specified title, author, and
     * publication year.
     *
     * @param title             The title of the sci-fi book
     * @param author            The author of the sci-fi book
     * @param yearOfPublication The year when the sci-fi book was published
     */
    public ScienceFictionBook(String title, String author, int yearOfPublication) {
        super(title, author, yearOfPublication);
    }

    /**
     * Sets the subject/theme of the science fiction book.
     *
     * @param subject The subject or theme of the sci-fi book
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Prints the science fiction book information to the console.
     * Overrides the parent class method to add sci-fi specific details.
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Subject: " + subject);
    }
}
