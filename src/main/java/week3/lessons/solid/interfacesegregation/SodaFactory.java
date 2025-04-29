package week3.lessons.solid.interfacesegregation;

/**
 * SodaFactory - Implements multiple focused interfaces
 * 
 * This factory demonstrates the Interface Segregation Principle by:
 * 1. Implementing several smaller interfaces instead of one large interface
 * 2. Each interface provides a specific set of related behaviors
 * 
 * A soda factory needs production, administration, and R&D capabilities
 * but does not handle its own delivery (perhaps using third-party logistics).
 */
class SodaFactory implements ProductionDepartment, AdministrativeDepartment, InvestigationDepartment {
    public SodaFactory() {
        System.out.println("Created a new Soda Factory");
    }

    @Override
    public void manufacture() {
        System.out.println("SodaFactory: Manufacturing soda beverages");
    }

    @Override
    public void transformRawMaterial() {
        System.out.println("SodaFactory: Processing ingredients and flavoring compounds");
    }

    @Override
    public void administration() {
        System.out.println("SodaFactory: Managing administrative operations");
    }

    @Override
    public void accountancy() {
        System.out.println("SodaFactory: Handling financial accounting");
    }

    @Override
    public void createNewProduct() {
        System.out.println("SodaFactory: Developing new beverage flavors");
    }

    @Override
    public void costReduction() {
        System.out.println("SodaFactory: Optimizing production processes to reduce costs");
    }
}
