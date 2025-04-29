package week3.lessons.solid.interfacesegregation;

/**
 * ProductionDepartment - Focused interface for production functionality
 * 
 * This interface is part of the interface segregation solution,
 * containing only methods related to production operations.
 * All factories in this example implement this interface since
 * they all handle manufacturing in some form.
 */
interface ProductionDepartment {
    /**
     * Handles the manufacturing process
     */
    public void manufacture();

    /**
     * Processes raw materials into components
     */
    public void transformRawMaterial();
}
