package week2.exercises.salariescalculation;

/**
 * Represents an employee in the salary calculation system.
 * This class implements the Taxes interface to handle salary calculations
 * including base salary, years-based bonuses, and tax deductions.
 */
public class Employee implements Taxes {

    /** The base annual salary for all employees in dollars. */
    private double baseSalary = 40000;

    /** The number of years the employee has worked for the company. */
    private int years;

    /**
     * Constructs a new Employee with the specified years of service.
     * The base salary is set to the default value of $40,000.
     *
     * @param years The number of years the employee has worked for the company
     */
    public Employee(int years) {
        this.years = years;
    }

    /**
     * Calculates the employee's annual bonus based on years of service.
     * The bonus is calculated as $1,000 per year of service.
     *
     * @return The annual bonus amount in dollars
     */
    public double getBonus() {
        return years * 1000;
    }

    /**
     * Calculates the employee's gross salary including base salary and bonus.
     * Gross salary is the total earnings before tax deductions.
     *
     * @return The gross salary in dollars
     */
    public double getGrossSalary() {
        return baseSalary + getBonus();
    }

    /**
     * Calculates the employee's net salary after tax deductions.
     * Net salary is the amount the employee receives after taxes are deducted
     * from the gross salary. The tax rate is determined by the Taxes interface
     * based on the gross salary amount.
     *
     * @return The net salary in dollars
     */
    public double getNetSalary() {
        return getGrossSalary() - (getGrossSalary()
                * Taxes.getTaxRate(getGrossSalary()));
    }
}
