package week3.lessons.arrays.arraylist.simplearray;

/**
 * Main - Demonstrates various ways to create and use arrays in Java
 * 
 * This class shows different methods for:
 * 1. Creating and initializing arrays
 * 2. Accessing array elements
 * 3. Iterating through arrays using different loop techniques
 */
public class Main {

    public static void main(String[] args) {
        // ===== Array Creation: Method 1 =====
        // Create array with specified size, then assign values individually
        System.out.println("---- Array Creation Method 1 ----");
        String[] maleStudents = new String[5];
        maleStudents[0] = "James";
        maleStudents[1] = "John";
        maleStudents[2] = "David";
        maleStudents[3] = "Joseph";
        maleStudents[4] = "Charles";

        // ===== Iteration: Traditional for loop with index =====
        System.out.println("Male students (using traditional for loop):");
        for (int i = 0; i < maleStudents.length; i++) {
            System.out.println((i + 1) + ". " + maleStudents[i]);
        }

        System.out.println();

        // ===== Array Creation: Method 2 =====
        // Create and initialize array in one statement using array literal
        System.out.println("---- Array Creation Method 2 ----");
        String[] femaleStudents = { "Mary", "Susan", "Michelle", "Sarah", "Ashley" };

        // ===== Iteration: Traditional for loop (same as above) =====
        System.out.println("Female students (using traditional for loop):");
        for (int i = 0; i < femaleStudents.length; i++) {
            System.out.println((i + 1) + ". " + femaleStudents[i]);
        }

        System.out.println();

        // ===== Array Creation: Method 3 =====
        // Alternative syntax: create array instance with initializer
        System.out.println("---- Array Creation Method 3 ----");
        String[] studentList = new String[] { "Jason", "Gloria", "Paul", "Lisa" };

        // ===== Iteration: Enhanced for loop (for-each) =====
        System.out.println("Student List (using enhanced for-each loop):");
        int count = 1;
        for (String student : studentList) {
            System.out.println(count + ". " + student);
            count++;
        }

        // Note: The enhanced for loop doesn't provide the index directly,
        // so we maintain a separate counter if needed
    }
}
