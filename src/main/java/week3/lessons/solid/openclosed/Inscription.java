package week3.lessons.solid.openclosed;

/**
 * Inscription - Defines the common interface for all student inscription types
 * 
 * This interface is crucial for the Open/Closed Principle:
 * - It defines a stable contract that client code can depend on
 * - New student types can be added by implementing this interface
 * - Existing code doesn't need to change to support new student types
 * 
 * Each implementing class provides its own specific inscription procedure.
 */
interface Inscription {
    /**
     * Creates the paperwork for a specific inscription procedure
     * 
     * @param ID The procedure ID to assign to the paperwork
     * @return A PaperWork object representing the completed procedure
     */
    public PaperWork procedure(int ID);
}
