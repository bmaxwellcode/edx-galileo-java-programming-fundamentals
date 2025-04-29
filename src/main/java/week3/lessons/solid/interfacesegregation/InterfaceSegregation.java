package week3.lessons.solid.interfacesegregation;

/**
 * InterfaceSegregation - Demonstrates the Interface Segregation Principle (ISP)
 * 
 * The Interface Segregation Principle states that:
 * "Clients should not be forced to depend upon interfaces that they do not
 * use."
 * 
 * Benefits:
 * - Reduces coupling: Classes only depend on methods they actually use
 * - Enhances readability: Each interface has a specific responsibility
 * - Improves maintainability: Changes to one functionality affect fewer classes
 * - Increases flexibility: Interfaces can be composed to build complex
 * behaviors
 * 
 * This example shows how to segregate a "fat" interface (Factory) into
 * multiple smaller, more focused interfaces for different departments.
 */
public class InterfaceSegregation {
    public static void main(String[] args) {
        System.out.println("=== Interface Segregation Principle Demonstration ===\n");

        // === Example 1: MaquilaFactory ===
        System.out.println("MaquilaFactory implements:");
        System.out.println("- ProductionDepartment (manufacture, transformRawMaterial)");
        System.out.println("- DeliveryDepartment (logistics, distribution)");
        MaquilaFactory maquilaX = new MaquilaFactory();
        maquilaX.manufacture();
        maquilaX.transformRawMaterial();
        maquilaX.logistics();
        maquilaX.distribution();

        System.out.println("\n=== Benefits of segregated interfaces for MaquilaFactory ===");
        System.out.println("- Only implements methods relevant to its business model");
        System.out.println("- Does not need to implement unrelated methods like accountancy or research");

        // === Example 2: SodaFactory ===
        System.out.println("\nSodaFactory implements:");
        System.out.println("- ProductionDepartment (manufacture, transformRawMaterial)");
        System.out.println("- AdministrativeDepartment (administration, accountancy)");
        System.out.println("- InvestigationDepartment (createNewProduct, costReduction)");
        SodaFactory sodaX = new SodaFactory();
        sodaX.manufacture();
        sodaX.administration();
        sodaX.createNewProduct();

        // === Example 3: CarFactory ===
        System.out.println("\nCarFactory implements:");
        System.out.println("- ProductionDepartment (manufacture, transformRawMaterial)");
        System.out.println("- InvestigationDepartment (createNewProduct, costReduction)");
        CarFactory carX = new CarFactory();
        carX.manufacture();
        carX.createNewProduct();

        // Contrast with the "bad" implementation approach
        System.out.println("\n=== Problems with the 'Fat' Factory Interface ===");
        System.out.println("Without interface segregation, all factories would need to implement:");
        System.out.println("- Methods they don't need (violating ISP)");
        System.out.println("- Empty/stub implementations (code pollution)");
        System.out.println("- Increased complexity and maintenance burden");
    }
}
