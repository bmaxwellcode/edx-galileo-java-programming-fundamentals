package week3.lessons.solid.singleresponsibility;

import java.util.HashMap;
import java.util.Map;

/**
 * SalaryCalculator - Responsible for calculating worker salaries
 * 
 * This class demonstrates the Single Responsibility Principle by focusing
 * exclusively on salary calculations. It doesn't manage worker data or
 * handle any other responsibilities.
 * 
 * Its single responsibility is: "Calculate worker salaries based on hours
 * worked"
 */
final class SalaryCalculator {
    // Stores overtime hour payment rates for different job titles
    private static HashMap<String, Integer> extraHours = new HashMap<String, Integer>();

    /**
     * Private constructor to prevent instantiation
     * This class only provides static utility methods
     */
    private SalaryCalculator() {
        // Empty constructor to prevent instantiation
    }

    /**
     * Initializes the overtime payment rates for different job titles
     * In a real application, these might come from a database or configuration
     */
    public static void initOvertimeHourPayment() {
        extraHours.put("Project Developer", 40); // Developers earn $40 per extra hour
        extraHours.put("Project Manager", 25); // Managers earn $25 per extra hour
    }

    /**
     * Calculates salaries for all workers in the company
     * 
     * The calculation includes base salary plus any payment for extra hours
     * based on the worker's job title and corresponding overtime rate.
     * 
     * @param companyWorkers Map of worker IDs to Worker objects
     * @return Map of worker IDs to calculated salaries
     */
    public static HashMap<Integer, Integer> calculateWorkersSalary(HashMap<Integer, Worker> companyWorkers) {
        HashMap<Integer, Integer> companyWorkersSalaries = new HashMap<Integer, Integer>();

        for (Map.Entry<Integer, Worker> entry : companyWorkers.entrySet()) {
            Integer id = entry.getKey();
            Worker worker = entry.getValue();

            // Calculate total salary: base salary + (extra hours × overtime rate)
            int salary = worker.getBaseSalary() +
                    worker.getExtraHours() * extraHours.get(worker.getJobTitle());

            companyWorkersSalaries.put(id, salary);
        }

        return companyWorkersSalaries;
    }
}
