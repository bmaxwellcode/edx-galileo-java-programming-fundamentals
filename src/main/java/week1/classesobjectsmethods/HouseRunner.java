package week1.classesobjectsmethods;

/**
 * HouseRunner class demonstrates the usage and functionality of the House
 * class. This class shows how to create a House object, build structures,
 * and modify its properties.
 */
public class HouseRunner {

    /**
     * Main method to demonstrate House class functionality.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===== HOUSE DEMONSTRATION =====");

        // Create a new House with initial color "white"
        House myHouse = new House("white");

        // Display initial house description
        myHouse.describeHouse();

        // Build various structures and show how the house changes
        myHouse.build("bedroom");
        myHouse.paintHouse("tan"); // Change the house color
        myHouse.build("garage");
        myHouse.build("half bathroom");

        // Display updated house description after modifications
        myHouse.describeHouse();

        // Demonstrate the handling of an invalid structure type
        System.out.println("\nAttempting to build an invalid structure:");
        myHouse.build("garden"); // This should show error/validation message
    }
}