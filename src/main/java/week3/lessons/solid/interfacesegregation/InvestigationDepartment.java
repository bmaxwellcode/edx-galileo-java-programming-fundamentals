package week3.lessons.solid.interfacesegregation;

/**
 * InvestigationDepartment - Focused interface for R&D functionality
 * 
 * This interface is part of the interface segregation solution,
 * containing only methods related to research and development.
 * Only factories that need R&D capabilities (like SodaFactory and CarFactory)
 * will implement this interface.
 */
interface InvestigationDepartment {
    /**
     * Develops new products through research and innovation
     */
    public void createNewProduct();

    /**
     * Identifies and implements cost-saving measures
     */
    public void costReduction();
}
