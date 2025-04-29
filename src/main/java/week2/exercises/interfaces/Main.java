package main2.week2.exercises.interfaces;

/**
 * Main class demonstrates the use of interfaces in Java.
 * 
 * This example shows how different vehicle classes implement
 * the Vehicle interface and how they can be used.
 */
public class Main {
    public static void main(String[] args) {
        // Create a Car object
        Car taxi = new Car(4);
        System.out.println("Taxi has wheels? " + taxi.hasWheels()
                + "\nNumber of wheels: " + taxi.getNumberOfWheels());

        // Create a Motorcycle object
        Motorcycle bmw = new Motorcycle();
        System.out.println("\nMotorcycle has wheels? " + bmw.hasWheels()
                + "\nNumber of wheels: " + bmw.getNumberOfWheels()
                + "\nTransport type: " + bmw.getTransportType());

        // Demonstrate polymorphism using the interface type
        Vehicle vehicle = new Motorcycle();
        System.out.println("\nVehicle (Motorcycle) transport type: " + vehicle.getTransportType());
    }
}
