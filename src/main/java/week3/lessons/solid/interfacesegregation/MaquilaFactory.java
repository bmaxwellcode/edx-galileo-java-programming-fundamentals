package week3.lessons.solid.interfacesegregation;

/**
 * MaquilaFactory - Implements only the interfaces it needs
 * 
 * This factory demonstrates the Interface Segregation Principle by:
 * 1. Implementing only the interfaces relevant to its business model
 * 2. Not being forced to implement unneeded methods from a fat interface
 * 
 * A maquila factory focuses on production and delivery
 * but does not handle administration or research internally.
 */
class MaquilaFactory implements ProductionDepartment, DeliveryDepartment {
    public MaquilaFactory() {
        System.out.println("Created a new Maquila Factory");
    }

    @Override
    public void manufacture() {
        System.out.println("MaquilaFactory: Manufacturing products based on client specifications");
    }

    @Override
    public void transformRawMaterial() {
        System.out.println("MaquilaFactory: Transforming raw materials into components");
    }

    @Override
    public void logistics() {
        System.out.println("MaquilaFactory: Managing logistics for incoming materials and outgoing products");
    }

    @Override
    public void distribution() {
        System.out.println("MaquilaFactory: Distributing finished products to clients");
    }
}
