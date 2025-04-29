package main2.week2.lessons.inheritance.inheritance;

/**
 * CityCar class represents a passenger car designed for urban use.
 * 
 * This class demonstrates inheritance by extending the Car class
 * and adding additional attributes (seatingCapacity) while also
 * overriding the printDescription method.
 */
public class CityCar extends Car {
    /** The number of people this city car can accommodate */
    private int seatingCapacity;

    /**
     * Creates a new city car with the specified top speed.
     * This constructor calls the parent class constructor using super().
     * 
     * @param topSpeed The maximum speed this city car can reach
     */
    public CityCar(int topSpeed) {
        super(topSpeed);
    }

    /**
     * Prints a description of this city car.
     * This method overrides the parent class method to provide a more
     * specific description for city cars.
     */
    @Override
    public void printDescription() {
        System.out.println("City Car");
    }
}
