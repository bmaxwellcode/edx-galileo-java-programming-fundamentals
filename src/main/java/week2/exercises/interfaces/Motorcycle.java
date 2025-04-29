package main2.week2.exercises.interfaces;

/**
 * Motorcycle class represents a type of vehicle with two wheels.
 * This class demonstrates implementation of the Vehicle interface.
 */
public class Motorcycle implements Vehicle {
    /** The transport type of this motorcycle */
    private String transportType = "terrestrial";

    /** The number of wheels on this motorcycle */
    private int wheels;

    /**
     * Default constructor creates a motorcycle with 2 wheels.
     */
    public Motorcycle() {
        this.wheels = 2;
    }

    /**
     * Creates a motorcycle with a specified number of wheels.
     * 
     * @param wheels The number of wheels for this motorcycle
     */
    public Motorcycle(int wheels) {
        this.wheels = wheels;
    }

    /**
     * Gets the transport type of this motorcycle.
     * 
     * @return String representing the transport type
     */
    @Override
    public String getTransportType() {
        return this.transportType;
    }

    /**
     * Determines whether this motorcycle has wheels.
     * 
     * @return true if the motorcycle has one or more wheels, false otherwise
     */
    @Override
    public boolean hasWheels() {
        return wheels > 0;
    }

    /**
     * Gets the number of wheels on this motorcycle.
     * 
     * @return the number of wheels
     */
    @Override
    public int getNumberOfWheels() {
        return wheels;
    }
}
