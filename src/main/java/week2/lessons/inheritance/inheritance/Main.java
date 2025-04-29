package main2.week2.lessons.inheritance.inheritance;

/**
 * Main class demonstrates inheritance and polymorphism concepts.
 * 
 * This example illustrates key inheritance concepts:
 * - Parent-child class relationships (Car as parent, F1Car and CityCar as
 * children)
 * - Method overriding (printDescription is overridden in child classes)
 * - Polymorphism (child class instances can be referenced through parent class
 * type)
 * 
 * Key inheritance principles:
 * - Child classes can inherit state and behavior from parent class
 * - The 'extends' keyword establishes inheritance relationship
 * - When defining a child class constructor, super() calls the parent
 * constructor
 * - A child class may not redefine a public method as private
 * - A child class may not override static methods of the parent class
 * - A child class may not extend more than one class
 * - A child class may inherit functionality of parent class
 * - A child class may inherit the properties of the parent class
 * - A child class may add new properties
 * - A child class may add new actions
 */
public class Main {
    /**
     * Main method demonstrates polymorphism by creating different car types.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create an F1Car but reference it as a Car (polymorphism)
        Car ferrari = new F1Car(320);

        // Create a regular Car
        Car coupe = new Car(220);

        // Call the printDescription method - each will use its own implementation
        ferrari.printDescription(); // Will print "F1 Car"
        coupe.printDescription(); // Will print "Car"

        // Create a CityCar but reference it as a Car (polymorphism)
        Car toyota = new CityCar(140);
        toyota.printDescription(); // Will print "City Car"
    }
}
