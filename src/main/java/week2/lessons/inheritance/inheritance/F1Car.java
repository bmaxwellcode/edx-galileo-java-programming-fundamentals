package main2.week2.lessons.inheritance.inheritance;

/**
 * F1Car class represents a Formula 1 racing car.
 * 
 * This class demonstrates inheritance by extending the Car class
 * and overriding the printDescription method to provide a specialized
 * implementation while inheriting other functionality.
 */
public class F1Car extends Car {
    /**
     * Creates a new Formula 1 car with the specified top speed.
     * This constructor calls the parent class constructor using super().
     * 
     * @param topSpeed The maximum speed this F1 car can reach
     */
    public F1Car(int topSpeed) {
        super(topSpeed);
    }

    /**
     * Prints a description of this Formula 1 car.
     * This method overrides the parent class method to provide a more
     * specific description for F1 cars.
     */
    @Override
    public void printDescription() {
        System.out.println("F1 Car");
    }
}
