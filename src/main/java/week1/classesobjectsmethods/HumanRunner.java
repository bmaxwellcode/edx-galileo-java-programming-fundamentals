package week1.classesobjectsmethods;

/**
 * HumanRunner class demonstrates the usage and functionality of the Human
 * class.
 * This class shows how to create Human objects, set attributes like birth
 * dates,
 * calculate ages, and establish relationships between humans.
 */
public class HumanRunner {

    /**
     * Main method to demonstrate Human class functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===== HUMAN DEMONSTRATION =====");

        // Demonstrate creating humans with basic attributes
        demonstrateHumanCreation();

        // Demonstrate relationships between humans
        demonstrateHumanRelationships();

        // Additional functionalities could be demonstrated here
        demonstrateAdditionalFeatures();
    }

    /**
     * Demonstrates creating Human objects and setting basic attributes.
     */
    private static void demonstrateHumanCreation() {
        System.out.println("\n--- Creating Humans and Setting Attributes ---");

        // Create a female human with name and gender
        Human connie = new Human("Connie", "Smith", 'F');

        // Set birth date (year, month, day) - Note: month is 1-based (January = 1)
        connie.setBirthDate(1987, 1, 22); // January 22, 1987

        // Display name and calculated age
        System.out.println(connie.getFullName() + " is " + connie.getAge() + " years old");

        // Create another human with different attributes
        Human john = new Human("John", "Brown", 'M');
        john.setBirthDate(1986, 12, 8); // December 8, 1986
        System.out.println(john.getFullName() + " is " + john.getAge() + " years old");
    }

    /**
     * Demonstrates establishing and querying relationships between Human objects.
     */
    private static void demonstrateHumanRelationships() {
        System.out.println("\n--- Demonstrating Human Relationships ---");

        // Create two humans
        Human alice = new Human("Alice", "Johnson", 'F');
        Human bob = new Human("Bob", "Williams", 'M');

        // Display initial state (no relationships)
        System.out.println("Initial state:");
        System.out.println(alice.getFullName() + " has no partner initially");

        // Establish a partnership between the humans
        System.out.println("\nEstablishing partnership:");
        alice.addPartner(bob);

        // Verify the bidirectional relationship was established correctly
        System.out.println(alice.getFullName() + "'s partner is " + alice.getPartnerName());
        System.out.println(bob.getFullName() + "'s partner is " + bob.getPartnerName());
    }

    /**
     * Demonstrates additional features of the Human class.
     */
    private static void demonstrateAdditionalFeatures() {
        System.out.println("\n--- Demonstrating Additional Features ---");

        // Create a human
        Human david = new Human("David", "Clark", 'M');

        // Demonstrate the speak method
        System.out.println("Human speaking:");
        david.speak("Hello, world! I am " + david.getFullName() + ".");

        // Set and retrieve ID
        int id = 12345;
        System.out.println("\nSetting ID to: " + id);
        david.setId(id);
        System.out.println("Retrieved ID: " + david.getId());
    }
}