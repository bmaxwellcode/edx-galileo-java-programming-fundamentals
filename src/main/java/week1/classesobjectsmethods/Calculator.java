package week1.classesobjectsmethods;

/**
 * A simple calculator that performs basic arithmetic operations.
 * Demonstrates switch statements, method overloading, and operators.
 */
public class Calculator {
    /** Stores the current calculation result. */
    private Number result;

    /**
     * Creates a new calculator with initial result of 0.
     */
    public Calculator() {
        this.result = 0;
    }

    /**
     * Performs an arithmetic operation between the current result and the given
     * number. Uses switch control flow to handle different operators.
     *
     * @param operator The arithmetic operation (+, -, *, /)
     * @param num1     The number to operate with
     */
    public void operate(String operator, Number num1) {
        Number result = 0;
        switch (operator) {
            case "+":
                result = this.result.doubleValue() + num1.doubleValue();
                break;
            case "-":
                result = this.result.doubleValue() - num1.doubleValue();
                break;
            case "/":
                result = this.result.doubleValue() / num1.doubleValue();
                break;
            case "*":
                result = this.result.doubleValue() * num1.doubleValue();
                break;
            case "cos":
                result = Math.cos(num1.doubleValue());
                break;
            case "sin":
                result = Math.sin(num1.doubleValue());
                break;
            case "tan":
                result = Math.tan(num1.doubleValue());
                break;
            case "!":
                result = factorial(num1.intValue());
                break;
            default:
                result = num1;
        }
        System.out.println(this.result.doubleValue() + " " + operator + " "
                + num1.doubleValue() + " = " + result.doubleValue());
        this.result = result;
    }

    /**
     * Performs an operation on the current result without additional input.
     * Used for operations like square root, negate, etc.
     *
     * @param operator The operation to perform on the current result
     */
    public void operate(String operator) {
        Number result = this.result;

        switch (operator) {
            case "sqrt":
                result = Math.sqrt(this.result.doubleValue());
                break;
            case "negate":
                result = -this.result.doubleValue();
                break;
            case "square":
                double val = this.result.doubleValue();
                result = val * val;
                break;
            case "C":
                result = 0;
                break;
            case "e":
                result = Math.E;
                break;
            default:
                System.out.println("Unknown operation: " + operator);
                return;
        }

        System.out.println(operator + "(" + this.result.doubleValue() + ") = "
                + result.doubleValue());
        this.result = result;
    }

    /**
     * Performs an operation using a string constant like "pi".
     *
     * @param operator The arithmetic operation (+, -, *, /)
     * @param constant The string constant to use (e.g., "pi")
     */
    public void operate(String operator, String constant) {
        Number value = 0;

        switch (constant.toLowerCase()) {
            case "pi":
                value = Math.PI;
                break;
            case "e":
                value = Math.E;
                break;
            default:
                System.out.println("Unknown constant: " + constant);
                return;
        }

        operate(operator, value);
    }

    /**
     * Sets the initial value for calculations.
     *
     * @param num1 The value to set as the current result
     */
    public void firstValue(Number num1) {
        this.result = num1;
        System.out.println(this.result.doubleValue());
    }

    /**
     * Calculates the factorial of a number.
     *
     * @param n The number to calculate factorial for
     * @return The factorial result
     */
    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
