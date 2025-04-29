package week2.exercises.salariescalculation;

/**
 * Main class demonstrates the salary calculation system. This class showcases
 * inheritance, polymorphism, and interface implementation by creating employee
 * objects and calculating their salaries.
 */
public class Main {

    /**
     * Main method executes the salary calculation demonstration.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a regular employee with 6 years of experience
        Employee jackie = new Employee(6);

        // Create a manager with 8 years of experience
        // Demonstrates polymorphism - a Manager can be treated as an Employee
        Employee joe = new Manager(8);

        // Display salary calculations for both employees
        System.out.println("Jackie Gross Salary: " + jackie.getGrossSalary()
                + " Net Salary: " + jackie.getNetSalary());
        System.out.println("Joe Gross Salary: " + joe.getGrossSalary()
                + " Net Salary: " + joe.getNetSalary());

        /*
         * Expected output:
         * Jackie Gross Salary: 46000.0 Net Salary: 41400.0
         * Joe Gross Salary: 58000.0 Net Salary: 49300.0
         */
    }
}
