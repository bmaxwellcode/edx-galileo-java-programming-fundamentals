package week1.classesobjectsmethods;

/**
 * Represents a classroom with a unique room number and student capacity.
 * Demonstrates static variables, instance variables, and static methods.
 */
public class Classroom {

    /** Class variable to assign sequential room numbers starting at 101. */
    private static int nextClassroomNumber = 101;

    /** Class variable tracking the classroom with highest capacity. */
    private static Classroom highestCapacityClassroom;

    /** The unique room number for this classroom. */
    private int classroomNumber;

    /** The number of students this classroom can accommodate. */
    private int capacity;

    /**
     * Creates a new classroom with the given capacity and assigns a unique room
     * number. Updates the highest capacity classroom if applicable.
     *
     * @param capacity The maximum number of students the room can hold
     */
    public Classroom(int capacity) {
        this.capacity = capacity;
        classroomNumber = nextClassroomNumber;
        nextClassroomNumber++;

        if (highestCapacityClassroom == null
                || highestCapacityClassroom.capacity < this.capacity) {
            highestCapacityClassroom = this;
        }
    }

    /**
     * Returns the number of classrooms that have been created.
     *
     * @return The count of classrooms created
     */
    public static int getNumberOfClassrooms() {
        return nextClassroomNumber - 101; // Subtract starting number to get actual count
    }

    /**
     * Returns the capacity of this classroom.
     *
     * @return The capacity of the classroom
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the room number of this classroom.
     *
     * @return The classroom number
     */
    public int getClassroomNumber() {
        return classroomNumber;
    }

    /**
     * Returns the classroom with the highest capacity.
     *
     * @return The Classroom object with the highest capacity
     */
    public static Classroom getMaxCapacityClassroom() {
        return highestCapacityClassroom;
    }

    /**
     * Returns a string representation of the classroom.
     *
     * @return A string with classroom number and capacity
     */
    public String toString() {
        return "Classroom " + classroomNumber + " has a capacity of: " + capacity;
    }
}
