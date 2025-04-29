package week2;

import org.junit.jupiter.api.Test;
import week2.exercises.salariescalculation.Employee;
import week2.exercises.salariescalculation.Manager;
import week2.exercises.salariescalculation.Taxes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ExerciseTest contains unit tests for the salary calculation system.
 * 
 * This class demonstrates test-driven development and verifies the
 * correct implementation of inheritance, interfaces, and salary calculations.
 */
public class MainTest {

    /**
     * Tests that Employee implements the Taxes interface.
     */
    @Test
    public final void testInterface() {
        Employee e = new Employee(0);
        assertTrue(e instanceof Taxes, "Test implementation of interface Taxes");
    }

    /**
     * Tests that Manager inherits from Employee.
     */
    @Test
    public final void testInheritance() {
        assertTrue(Employee.class.isAssignableFrom(Manager.class), "Test inheritance");
    }

    /**
     * Tests the gross salary calculation for an Employee.
     */
    @Test
    public final void testEmployeeGrossSalary() {
        Employee peter = new Employee(2);
        assertEquals(42000, peter.getGrossSalary(), "Testing employee gross salary");
    }

    /**
     * Tests the net salary calculation for an Employee.
     */
    @Test
    public final void testEmployeeNetSalary() {
        Employee peter = new Employee(2);
        assertEquals(37800, peter.getNetSalary(), "Testing employee net salary");
    }

    /**
     * Tests the net salary calculation for a Manager.
     */
    @Test
    public final void testManagerNetSalary() {
        Employee judith = new Manager(3);
        assertEquals(45050, judith.getNetSalary(), "Testing manager net salary");
    }
}
