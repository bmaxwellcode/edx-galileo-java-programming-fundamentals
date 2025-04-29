package main2.week2.exercises.interfaces;

/**
 * Car class represents a type of vehicle with wheels.
 * This class demonstrates implementation of the Vehicle interface.
 */
public class Car implements Vehicle {
    /** The transport type of this car */
    private String transportType = "terrestrial";

    /** The number of wheels on this car */
    private int wheels;

    /**
     * Default constructor creates a car with 4 wheels.
     */
    public Car() {
        this.wheels = 4;
    }

    /**
     * Creates a car with a specified number of wheels.
     * 
     * @param wheels The number of wheels for this car
     */
    public Car(int wheels) {
        this.wheels = wheels;
    }

    /**
     * Gets the transport type of this car.
     * 
     * @return String representing the transport type
     */
    @Override
    public String getTransportType() {
        return this.transportType;
    }

    /**
     * Determines whether this car has wheels.
     * 
     * @return true if the car has one or more wheels, false otherwise
     */
    @Override
    public boolean hasWheels() {
        return wheels > 0;
    }

    /**
     * Gets the number of wheels on this car.
     * 
     * @return the number of wheels
     */
    @Override
    public int getNumberOfWheels() {
        return wheels;
    }
}
