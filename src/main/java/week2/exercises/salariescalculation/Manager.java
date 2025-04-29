package week2.exercises.salariescalculation;

/**
 * Manager class represents a specialized type of Employee with a different
 * bonus structure. This class demonstrates inheritance in Java by extending
 * the Employee class and overriding the getBonus method to provide
 * manager-specific bonus calculation.
 */
public class Manager extends Employee {

    /** The number of years the manager has worked. */
    private int years;

    /**
     * Creates a new Manager with the specified years of experience.
     *
     * @param years The number of years the manager has worked
     */
    public Manager(int years) {
        super(years);
        this.years = years;
    }

    /**
     * Calculates the manager's bonus based on years of experience.
     * Overrides the Employee's getBonus method to provide a higher bonus:
     * 1,000 per year plus a base 10,000.
     *
     * @return The calculated bonus amount
     */
    @Override
    public double getBonus() {
        return (years * 1_000) + 10_000;
    }
}
