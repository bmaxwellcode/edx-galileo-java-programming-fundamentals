package week3.lessons.solid.interfacesegregation;

/**
 * AdministrativeDepartment - Focused interface for administrative functionality
 * 
 * This interface is part of the interface segregation solution,
 * containing only methods related to administrative functions.
 * Factories that need administrative capabilities can implement
 * just this interface without being forced to implement unrelated methods.
 */
interface AdministrativeDepartment {
    /**
     * Handles general administrative tasks
     */
    public void administration();

    /**
     * Manages financial accounting processes
     */
    public void accountancy();
}
