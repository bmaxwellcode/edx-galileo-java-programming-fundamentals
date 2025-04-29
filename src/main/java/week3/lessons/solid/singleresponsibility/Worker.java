package week3.lessons.solid.singleresponsibility;

/**
 * Worker - Responsible for managing worker data
 * 
 * This class demonstrates the Single Responsibility Principle by focusing
 * exclusively on employee data management. It doesn't calculate salaries
 * or handle any business logic beyond storing and providing access to
 * worker information.
 * 
 * Its single responsibility is: "Store and manage worker information"
 */
class Worker {
    private int baseSalary;
    private int workHours;
    private int extraHoursPerMonth;
    private int id;
    private String fullName;
    private String jobTitle;

    /**
     * Creates a new Worker instance with the specified attributes
     * 
     * @param id         The worker's ID number
     * @param baseSalary The worker's base salary amount
     * @param workHours  Regular work hours per week
     * @param fullName   The worker's full name
     * @param jobTitle   The worker's job title/position
     */
    public Worker(int id, int baseSalary, int workHours, String fullName, String jobTitle) {
        this.id = id;
        this.baseSalary = baseSalary;
        this.workHours = workHours;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.extraHoursPerMonth = 0; // Initialize with zero extra hours
    }

    /**
     * Adds extra hours to this worker's monthly total
     * 
     * @param hoursPerDay Number of extra hours to add
     * @return This Worker instance (for method chaining)
     */
    public Worker addExtraHour(int hoursPerDay) {
        this.extraHoursPerMonth += hoursPerDay;
        return this;
    }

    /**
     * Resets the worker's extra hours to zero (e.g., for a new month)
     */
    public void resetExtraHour() {
        this.extraHoursPerMonth = 0;
    }

    /**
     * Gets the worker's base salary amount
     * 
     * @return The base salary value
     */
    public int getBaseSalary() {
        return this.baseSalary;
    }

    /**
     * Gets the worker's regular work hours
     * 
     * @return The standard work hours
     */
    public int getWorkHours() {
        return this.workHours;
    }

    /**
     * Gets the worker's accumulated extra hours for the month
     * 
     * @return The extra hours value
     */
    public int getExtraHours() {
        return this.extraHoursPerMonth;
    }

    /**
     * Gets the worker's full name
     * 
     * @return The worker's name
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Gets the worker's job title
     * 
     * @return The job title
     */
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
     * Returns a string representation of this Worker
     * 
     * @return A formatted string with the worker's name and job title
     */
    @Override
    public String toString() {
        return this.fullName + " (" + this.jobTitle + ")";
    }
}
