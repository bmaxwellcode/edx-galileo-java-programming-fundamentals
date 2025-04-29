package week3.lessons.solid.openclosed;

import java.util.ArrayList;

/**
 * OpenClosed - Demonstrates the Open/Closed Principle (OCP)
 * 
 * The Open/Closed Principle states:
 * "Software entities (classes, modules, functions, etc.) should be open for
 * extension,
 * but closed for modification."
 * 
 * Benefits:
 * - Reduces risk: Existing code doesn't need to change when adding new
 * functionality
 * - Promotes modularity: New behaviors can be added through new classes
 * - Increases stability: Core code remains unchanged when extending
 * - Improves maintainability: Changes are isolated to new components
 * 
 * This example shows how a university registration system can handle different
 * types
 * of student inscriptions without modifying existing code.
 */
public class OpenClosed {
    private static ArrayList<PaperWork> universityProcedures = new ArrayList<PaperWork>();
    private static int idCounter = 17000;

    public static void main(String[] args) throws Exception {
        System.out.println("=== Open/Closed Principle Demonstration ===\n");

        // Register different types of students
        System.out.println("Registering different types of students:");
        newInscription(new FirstYearStudent("Personal Identity Document Data"));
        newInscription(new ReEntryStudent("14101010"));
        newInscription(new TransferedStudent("Previous Study on X University"));

        // Display all created procedures
        System.out.println("\nProcedures:");
        for (PaperWork procedure : universityProcedures) {
            System.out.println(procedure);
        }

        System.out.println("\n=== Open/Closed Principle Explanation ===");
        System.out.println("1. The system is CLOSED FOR MODIFICATION:");
        System.out.println("   - The newInscription() method doesn't need to change");
        System.out.println("   - The PaperWork class stays the same");
        System.out.println("\n2. The system is OPEN FOR EXTENSION:");
        System.out.println("   - New student types can be added (e.g., GraduateStudent)");
        System.out.println("   - Each new type just needs to implement the Inscription interface");
        System.out.println("   - Existing code works with all current and future student types");
    }

    /**
     * Processes a new student inscription and adds it to university procedures
     * 
     * This method demonstrates the Open/Closed Principle by working with the
     * abstract Inscription interface rather than concrete implementations.
     * Because of this design, new student types can be added without changing this
     * method.
     * 
     * @param inscription The inscription to process (any class implementing
     *                    Inscription)
     */
    public static void newInscription(Inscription inscription) {
        universityProcedures.add(inscription.procedure(idCounter));
        idCounter++;
    }
}
