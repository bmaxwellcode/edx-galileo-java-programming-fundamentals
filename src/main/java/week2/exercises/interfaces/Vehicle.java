package main2.week2.exercises.interfaces;
/*
 Interface: contract to ensure that the classes that use it contain all the
 functionality it requires
  - cannot be instantiated

 */

/**
 * Vehicle interface defines the basic functionality required for all vehicle
 * types.
 * 
 * An interface serves as a contract to ensure that the classes that implement
 * it
 * contain all the required functionality. Interfaces:
 * - Cannot be instantiated directly
 * - Declare method signatures without implementations (except default/static
 * methods)
 * - Are implemented using the "implements" keyword
 * - Can be extended by other interfaces
 */
public interface Vehicle {
    /**
     * Gets the transport type of the vehicle (e.g., "terrestrial", "aerial").
     * 
     * @return String representing the transport type
     */
    String getTransportType();

    /**
     * Determines whether the vehicle has wheels.
     * 
     * @return true if the vehicle has one or more wheels, false otherwise
     */
    boolean hasWheels();

    /**
     * Gets the number of wheels on the vehicle.
     * 
     * @return the number of wheels
     */
    int getNumberOfWheels();
}
