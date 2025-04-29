package week1.classesobjectsmethods;

/**
 * ClassroomRunner class demonstrates the usage and functionality of the
 * Classroom class.
 * This class shows how to create multiple Classroom objects and use static
 * methods
 * to track all created classrooms and their properties.
 */
public class ClassroomRunner {

    /**
     * Main method to demonstrate Classroom class functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===== CLASSROOM DEMONSTRATION =====");

        // Create classrooms with different capacities and observe static tracking
        createAndReportClassroom(20);
        createAndReportClassroom(50);
        createAndReportClassroom(30);

        // Additional demonstration - try to find all classrooms
        System.out.println("\nTotal classrooms created: " + Classroom.getNumberOfClassrooms());
    }

    /**
     * Creates a new classroom with the specified capacity and reports its details
     * along with updated static information about all classrooms.
     * 
     * @param capacity The capacity of the classroom to create
     * @return The created Classroom object
     */
    private static Classroom createAndReportClassroom(int capacity) {
        // Create a new classroom with specified capacity
        Classroom classroom = new Classroom(capacity);

        // Print separator for readability
        System.out.println("+++++++++++++++++++++++++++++++++++");

        // Report details about the newly created classroom
        System.out.println("Classroom created: " + classroom.toString());

        // Report overall classroom statistics (using static methods)
        System.out.println("Number of classrooms: " + Classroom.getNumberOfClassrooms());
        System.out.println("Max capacity classroom number: " +
                Classroom.getMaxCapacityClassroom().getClassroomNumber());
        System.out.println("Max classroom capacity: " +
                Classroom.getMaxCapacityClassroom().getCapacity());

        // Print separator for readability
        System.out.println("+++++++++++++++++++++++++++++++++++");

        return classroom;
    }
}