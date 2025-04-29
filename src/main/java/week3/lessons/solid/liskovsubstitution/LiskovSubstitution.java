package week3.lessons.solid.liskovsubstitution;

/**
 * LiskovSubstitution - Demonstrates the Liskov Substitution Principle (LSP)
 * 
 * The Liskov Substitution Principle states:
 * "Objects of a superclass should be replaceable with objects of a subclass
 * without affecting the correctness of the program."
 * 
 * Benefits of LSP:
 * - Ensures inheritance is used properly
 * - Enables polymorphism to work correctly
 * - Creates more reliable and predictable code
 * - Makes code more maintainable and extensible
 * 
 * This example shows how different Animal subclasses can be used
 * interchangeably
 * with the PetShopInfoCenter, which works with the base Animal type.
 */
public class LiskovSubstitution {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Liskov Substitution Principle Demonstration ===\n");
        System.out.println("Creating pet shop catalog with different animal types...\n");

        // Add different types of animals to the catalog
        PetShopInfoCenter.addProduct(
                new Dog(180, 100, 15, "If you Adopt, Supplies are Free!"));

        PetShopInfoCenter.addProduct(
                new Fish(15, 15));

        // PetShopInfoCenter treats all animals polymorphically
        // It doesn't need to know the specific type of each animal
        System.out.println(PetShopInfoCenter.generateCatalogue());

        System.out.println("=== LSP Explanation ===");
        System.out.println("The PetShopInfoCenter works with the base Animal type");
        System.out.println("All subtypes (Dog, Fish) can be used wherever Animal is expected");
        System.out.println("This demonstrates the Liskov Substitution Principle in action");
    }
}
