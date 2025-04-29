package week3.lessons.arrays.arraylist.multidimensionalarray;

/**
 * Main - Demonstrates multidimensional arrays in Java.
 *
 * This class shows different ways to:
 * 1. Create and initialize 2D arrays
 * 2. Access elements in multidimensional arrays
 * 3. Iterate through 2D arrays using nested loops
 * 4. Find dimensions (rows and columns) of multidimensional arrays
 */
public class Main {

    /**
     * Main method demonstrating multidimensional array operations.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // ===== EXAMPLE 1: Pets 2D Array =====
        System.out.println("===== EXAMPLE 1: Categorized Pets 2D Array =====");
        // Create 2D array with 2 rows (animal types) and 3 columns (breeds)
        // First dimension [2] = animal types (dogs, cats)
        // Second dimension [3] = breeds for each animal type
        String[][] pets = new String[2][3];

        // Fill first row with dog breeds
        pets[0][0] = "French poodle"; // Row 0, Column 0
        pets[0][1] = "Boxer"; // Row 0, Column 1
        pets[0][2] = "Chihuahua"; // Row 0, Column 2

        // Fill second row with cat breeds
        pets[1][0] = "British shorthair"; // Row 1, Column 0
        pets[1][1] = "Himalayan"; // Row 1, Column 1
        pets[1][2] = "Siberian"; // Row 1, Column 2

        // Print all pets, organized by animal type
        // Outer loop iterates through rows (animal types)
        // Inner loop iterates through columns (breeds)
        System.out.println("Dogs");
        System.out.println("----");
        for (int type = 0; type < pets.length; type++) {
            if (type == 1) {
                System.out.println();
                System.out.println("Cats");
                System.out.println("----");
            }

            for (int breed = 0; breed < pets[type].length; breed++) {
                System.out.println(pets[type][breed]);
            }
        }

        System.out.println();

        // ===== EXAMPLE 2: Default Values in 2D Integer Array =====
        System.out.println("===== EXAMPLE 2: Default Values in 2D Integer Array =====");
        // Create 2D array with 3 rows and 2 columns
        // Default value for int is 0
        System.out.println("Uninitialized int 2D array (default values = 0):");
        int[][] intNumbers = new int[3][2];

        // Print the array in matrix form
        for (int i = 0; i < intNumbers.length; i++) {
            for (int j = 0; j < intNumbers[i].length; j++) {
                System.out.print(intNumbers[i][j] + " ");
            }
            System.out.println(); // Move to next row
        }
        System.out.println();

        // ===== EXAMPLE 3: Initializing 2D Arrays with Values =====
        System.out.println("===== EXAMPLE 3: Matrix Operations with 2D Array =====");
        // Initialize 2D array with values using array literal
        // This creates a 3×4 matrix (3 rows, 4 columns)
        System.out.println("Matrix initialized with values:");
        int[][] matrix = {
                { 1, 2, 3, 4 }, // First row
                { 5, 6, 7, 8 }, // Second row
                { 9, 10, 11, 12 } // Third row
        };

        // Get dimensions of the matrix
        int rows = matrix.length; // Number of rows
        int columns = matrix[0].length; // Number of columns in first row
        System.out.println("Matrix dimensions: " + rows + "×" + columns);

        // Access specific element (second row, third column)
        // Remember: indices start from 0, so [1][2] is row 2, column 3
        System.out.println("Element at position [1][2]: " + matrix[1][2]);

        // Print the entire matrix with row and column indices
        System.out.println("\nComplete matrix with indices:");
        System.out.print("    "); // Space for row indices

        // Print column headers
        for (int j = 0; j < columns; j++) {
            System.out.print("Col" + j + " ");
        }
        System.out.println();

        // Print matrix with row indices
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Row" + i + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%-4d ", matrix[i][j]); // Left-aligned with width 4
            }
            System.out.println();
        }
    }
}
