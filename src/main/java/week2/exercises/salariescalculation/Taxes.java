package week2.exercises.salariescalculation;

/**
 * Taxes interface defines methods for salary calculations and tax rate
 * determination. This interface demonstrates the use of interface contracts
 * in Java, including both abstract methods and a static utility method for
 * tax rate calculation.
 */
public interface Taxes {

    /**
     * Gets the gross salary amount before taxes.
     *
     * @return The gross salary amount
     */
    double getGrossSalary();

    /**
     * Gets the net salary amount after taxes.
     *
     * @return The net salary amount
     */
    double getNetSalary();

    /**
     * Static utility method to determine the appropriate tax rate based on gross
     * salary.
     *
     * @param grossSalary The gross salary amount
     * @return The applicable tax rate as a decimal (e.g., 0.10 for 10%)
     */
    static double getTaxRate(double grossSalary) {
        if (grossSalary < 10000) {
            return 0.05; // 5% tax rate for salaries under 10,000
        } else if (grossSalary >= 10000 && grossSalary < 20000) {
            return 0.07; // 7% tax rate for salaries between 10,000 and 19,999
        } else if (grossSalary >= 20000 && grossSalary < 50000) {
            return 0.10; // 10% tax rate for salaries between 20,000 and 49,999
        } else {
            return 0.15; // 15% tax rate for salaries of 50,000 and above
        }
    }
}