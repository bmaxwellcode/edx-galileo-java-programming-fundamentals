package main2.week2.lessons.polymorphism;

/**
 * Human class represents a basic person with a name.
 * 
 * This class serves as the parent/base class in the polymorphism demonstration,
 * providing common attributes and behaviors that child classes can inherit
 * and override.
 */
public class Human {
    /** The person's name (protected to allow access by subclasses) */
    protected String name;

    /**
     * Creates a new Human with the specified name.
     * 
     * @param name The person's name
     */
    public Human(String name) {
        this.name = name;
    }

    /**
     * Prints the person's name to the console.
     * This method can be overridden by subclasses to provide more specific output.
     */
    public void printName() {
        System.out.println(name);
    }
}
