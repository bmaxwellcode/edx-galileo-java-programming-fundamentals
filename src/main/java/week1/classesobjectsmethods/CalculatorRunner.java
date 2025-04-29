package week1.classesobjectsmethods;

/**
 * CalculatorRunner class demonstrates the usage and functionality of the
 * Calculator class.
 * This class shows how to use both basic and advanced calculator operations.
 */
public class CalculatorRunner {

    /**
     * Main method to demonstrate Calculator class functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        demonstrateBasicCalculator();
        demonstrateAdvancedCalculator();
    }

    /**
     * Demonstrates basic calculator operations: addition, subtraction,
     * multiplication, and division.
     */
    private static void demonstrateBasicCalculator() {
        System.out.println("===== BASIC CALCULATOR DEMONSTRATION =====");

        // Create a new calculator
        Calculator basic = new Calculator();

        // Perform basic arithmetic operations
        basic.operate("+", 3);
        basic.operate("-", 1);
        basic.operate("*", 15);
        basic.operate("/", 3);
    }

    /**
     * Demonstrates advanced calculator operations: trigonometric functions,
     * constants, factorial, and combined operations.
     */
    private static void demonstrateAdvancedCalculator() {
        System.out.println("\n===== ADVANCED CALCULATOR DEMONSTRATION =====");

        // Create a new calculator for advanced operations
        Calculator advanced = new Calculator();

        // Setting an initial value
        advanced.firstValue(10);

        // Reset to 0
        advanced.operate("C");

        // Trigonometric functions
        advanced.operate("cos", 0);
        advanced.operate("C");
        advanced.operate("sin", 1);
        advanced.operate("C");
        advanced.operate("tan", 0);
        advanced.operate("C");

        // Factorial
        advanced.operate("!", 5);
        advanced.operate("C");

        // Mathematical constants and operations
        advanced.operate("e");
        advanced.operate("+", 1.25);
        advanced.operate("+", "pi");
    }
}