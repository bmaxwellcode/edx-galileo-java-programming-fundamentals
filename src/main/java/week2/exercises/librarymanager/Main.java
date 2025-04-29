package main2.week2.exercises.librarymanager;

/**
 * Main class demonstrates the library management system.
 * 
 * This class showcases how to create and use different types of books,
 * demonstrating inheritance, polymorphism, and interface implementation
 * in a library management context.
 */
public class Main {
    public static void main(String[] args) {
        // Create and demonstrate various book types
        System.out.println("===== Library Management System Demo =====");

        // Create a basic book
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        System.out.println("Basic Book:");
        book.print();
        System.out.println();

        // Create a drama book
        DramaBook dramaBook = new DramaBook("Romeo and Juliet", "William Shakespeare", 1597);
        dramaBook.setTime(1300);
        dramaBook.setPlace("Verona, Italy");
        System.out.println("Drama Book:");
        dramaBook.print();
        System.out.println("\n");

        // Create a science fiction book
        ScienceFictionBook scifiBook = new ScienceFictionBook("Dune", "Frank Herbert", 1965);
        scifiBook.setSubject("Space Politics");
        System.out.println("Science Fiction Book:");
        scifiBook.print();
        System.out.println();

        // Create a printed drama book
        DramaPrintedBook printedDrama = new DramaPrintedBook("Hamlet", "William Shakespeare", 1600);
        printedDrama.setPlace("Denmark");
        printedDrama.setTime(1400);
        printedDrama.setDimensions(6.0, 9.0, 1.5);
        printedDrama.setWeight(1.2);
        System.out.println("Printed Drama Book:");
        printedDrama.print();
        System.out.println("Physical properties: " + printedDrama.getDimensions() + ", " + printedDrama.getWeight());
        System.out.println();

        // Create a sci-fi audio book
        ScienceFictioneAudioBook audioScifi = new ScienceFictioneAudioBook("Foundation", "Isaac Asimov", 1951);
        audioScifi.setSubject("Future Society");
        audioScifi.setNumberOfTracks(42);
        System.out.println("Science Fiction Audio Book:");
        audioScifi.print();
    }
}
