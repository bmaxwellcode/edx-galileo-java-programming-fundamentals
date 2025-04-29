package week3.lessons.solid.interfacesegregation;

/**
 * CarFactory - Implements only the interfaces it needs
 * 
 * This factory demonstrates the Interface Segregation Principle by:
 * 1. Implementing only ProductionDepartment and InvestigationDepartment
 * 2. Not being forced to implement administration or delivery methods
 * 
 * A car factory in this example focuses on production and R&D
 * but outsources administration and delivery to other companies.
 */
class CarFactory implements ProductionDepartment, InvestigationDepartment {
    public CarFactory() {
        System.out.println("Created a new Car Factory");
    }

    @Override
    public void manufacture() {
        System.out.println("CarFactory: Manufacturing automobiles on assembly line");
    }

    @Override
    public void transformRawMaterial() {
        System.out.println("CarFactory: Processing metal, plastic, and other raw materials");
    }

    @Override
    public void createNewProduct() {
        System.out.println("CarFactory: Designing new car models");
    }

    @Override
    public void costReduction() {
        System.out.println("CarFactory: Researching more efficient manufacturing processes");
    }
}
