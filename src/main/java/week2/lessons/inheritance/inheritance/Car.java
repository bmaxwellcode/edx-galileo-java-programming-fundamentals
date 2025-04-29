package main2.week2.lessons.inheritance.inheritance;

/**
 * Car class represents a base vehicle type.
 * 
 * This class demonstrates the parent class in an inheritance hierarchy,
 * providing common attributes and behaviors that child classes can inherit
 * and optionally override.
 */
public class Car {
    /** The maximum speed this car can reach in mph */
    private int topSpeed;

    /**
     * Creates a new car with the specified top speed.
     * 
     * @param topSpeed The maximum speed this car can reach
     */
    public Car(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    /**
     * Gets the top speed of this car.
     * 
     * @return The maximum speed in mph
     */
    public int getTopSpeed() {
        return topSpeed;
    }

    /**
     * Prints a description of this car.
     * This method can be overridden by child classes to provide more specific
     * descriptions.
     */
    public void printDescription() {
        System.out.println("Car");
    }
}
