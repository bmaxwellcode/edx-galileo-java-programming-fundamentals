package week3.lessons.solid.singleresponsibility;

import java.util.HashMap;

/**
 * SingleResponsibility - Demonstrates the Single Responsibility Principle (SRP)
 * 
 * The Single Responsibility Principle states:
 * "A class should have only one reason to change."
 * 
 * Benefits of SRP:
 * - Improved maintainability: Classes with focused responsibilities are easier
 * to maintain
 * - Reduced complexity: Each class does one thing well instead of many things
 * poorly
 * - Better testability: Focused classes are easier to test in isolation
 * - Enhanced readability: Classes with clear purposes are easier to understand
 * 
 * This example demonstrates SRP through three classes with distinct
 * responsibilities:
 * 1. Worker - Responsible ONLY for managing worker data (employee information)
 * 2. SalaryCalculator - Responsible ONLY for calculating salaries
 * 3. SingleResponsibility - Responsible ONLY for orchestrating the
 * demonstration
 */
public class SingleResponsibility {

    public static void main(String[] args) throws Exception {
        System.out.println("=== Single Responsibility Principle Demonstration ===\n");

        // Create a collection to store company workers
        HashMap<Integer, Worker> companyWorkers = new HashMap<Integer, Worker>();

        // Add two workers with different job titles
        System.out.println("Creating workers with different roles:");
        companyWorkers.put(170015,
                new Worker(170015, 5000, 20, "John Johnz", "Project Developer"));
        companyWorkers.put(170016,
                new Worker(170016, 5100, 20, "Rubi Ramos", "Project Manager"));

        // Initialize overtime hour payment rates for different job titles
        // This demonstrates SRP by having SalaryCalculator handle all payment logic
        System.out.println("Initializing salary calculation rules...");
        SalaryCalculator.initOvertimeHourPayment();

        // Calculate salaries before adding extra hours
        // Worker class has no salary calculation logic (following SRP)
        HashMap<Integer, Integer> companyWorkersSalaries = SalaryCalculator.calculateWorkersSalary(companyWorkers);

        // Display results - base salaries without extra hours
        System.out.println("\nSalaries without extra hours:");
        System.out.println(companyWorkers.get(170015) + ",\n\tSalary: " +
                companyWorkersSalaries.get(170015) + " money units");
        System.out.println(companyWorkers.get(170016) + ",\n\tSalary: " +
                companyWorkersSalaries.get(170016) + " money units");

        // Add extra hours to both workers
        // Worker class manages its own data (following SRP)
        System.out.println("\nAdding extra hours to workers...");
        companyWorkers.replace(170015,
                companyWorkers.get(170015).addExtraHour(10));
        companyWorkers.replace(170016,
                companyWorkers.get(170016).addExtraHour(5));

        // Recalculate salaries with extra hours
        // SalaryCalculator handles all calculation logic (following SRP)
        companyWorkersSalaries = SalaryCalculator.calculateWorkersSalary(companyWorkers);

        // Display updated results with extra hours
        System.out.println("\nSalaries with extra hours:");
        System.out.println(companyWorkers.get(170015) + ",\n\tSalary: " +
                companyWorkersSalaries.get(170015) + " money units");
        System.out.println(companyWorkers.get(170016) + ",\n\tSalary: " +
                companyWorkersSalaries.get(170016) + " money units");

        // Explain the Single Responsibility Principle as demonstrated
        System.out.println("\n=== Single Responsibility Principle Explanation ===");
        System.out.println("This example demonstrates SRP through clear separation of concerns:");
        System.out.println("1. Worker class - Responsible ONLY for employee data management");
        System.out.println("   - Stores employee information");
        System.out.println("   - Tracks work hours and extra hours");
        System.out.println("   - Has no salary calculation logic");
        System.out.println("2. SalaryCalculator class - Responsible ONLY for salary calculations");
        System.out.println("   - Defines payment rates for overtime");
        System.out.println("   - Calculates total salary based on hours worked");
        System.out.println("   - Has no employee data management logic");
        System.out.println("3. Benefit: Changes to calculation rules only affect SalaryCalculator");
        System.out.println("   Changes to employee data only affect Worker class");
    }
}
