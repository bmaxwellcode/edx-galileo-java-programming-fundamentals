package main2.week2.lessons.polymorphism;

/**
 * Main class demonstrates polymorphism concepts in Java.
 * 
 * Polymorphism: ability to carry out different actions on an object with the
 * same name but with different purposes or contexts.
 *
 * Types of polymorphism demonstrated:
 * - Compile-time Polymorphism: multiple methods with same name but different
 * parameters (method overloading)
 * - Runtime polymorphism: subclass applies a different implementation of method
 * in superclass (method overriding)
 *
 * A method that has been overridden in at least one subclass (child class) is
 * said to be polymorphic.
 * It is important to note that attributes are not overridden, they are hidden.
 * In order to have separate values for an attribute in each instance of a
 * subclass, it is necessary to define it only in the parent class and
 * initialize or assign a value in the child class constructor.
 */
public class Main {
    /**
     * Main method demonstrates polymorphism through various Human and BandMember
     * instances.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a Human instance
        Human john = new Human("john");

        // Create a BandMember but reference it as a Human (runtime polymorphism)
        Human louis = new BandMember("louis");

        // Create a BandMember with its actual type
        BandMember jack = new BandMember("jack");

        // Each printName() call demonstrates runtime polymorphism
        // Different implementations will be called based on the actual object type
        john.printName(); // Calls Human's printName()
        louis.printName(); // Calls BandMember's printName() despite being referenced as Human
        jack.printName(); // Calls BandMember's printName()

        // BandMember-specific methods demonstrating interface implementation
        jack.sing(); // From Vocalist interface
        jack.playFavoriteSong(); // From Guitarist interface (which extends PlaySong)
    }
}
