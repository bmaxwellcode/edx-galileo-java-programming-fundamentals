package main2.week2.lessons.polymorphism;

/**
 * BandMember class represents a Human who is also a musician in a band.
 * 
 * This class demonstrates multiple aspects of polymorphism:
 * - Inheritance: extends Human to inherit its properties and methods
 * - Interface implementation: implements Vocalist and Guitarist interfaces
 * - Method overriding: overrides the printName method from Human
 * - Multiple interface inheritance: inherits from interfaces that have a
 * hierarchy
 */
public class BandMember extends Human implements Vocalist, Guitarist {
    /**
     * Creates a new BandMember with the specified name.
     * Uses the parent class constructor to initialize the name.
     * 
     * @param name The band member's name
     */
    public BandMember(String name) {
        super(name);
    }

    /**
     * Prints the band member's name with a prefix.
     * This method overrides the parent class method to provide more specific
     * output.
     */
    @Override
    public void printName() {
        System.out.println("Band member " + name);
    }

    /**
     * Implements the sing method from the Vocalist interface.
     * This demonstrates implementation of an interface method.
     */
    @Override
    public void sing() {
        System.out.println("La La La");
    }
}
