package week3.lessons.solid.interfacesegregation;

/**
 * DeliveryDepartment - Focused interface for logistics functionality
 * 
 * This interface is part of the interface segregation solution,
 * containing only methods related to delivery and distribution.
 * Only factories that handle their own logistics (like MaquilaFactory)
 * will implement this interface.
 */
interface DeliveryDepartment {
    /**
     * Manages the logistics operations
     */
    public void logistics();

    /**
     * Handles distribution of finished products
     */
    public void distribution();
}
