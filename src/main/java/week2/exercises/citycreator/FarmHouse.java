/**
 * FarmHouse class represents a special type of building with a garden.
 * This class demonstrates both inheritance (extends Building) and 
 * interface implementation (implements Paintable).
 */
package main2.week2.exercises.citycreator;

import main2.week2.exercises.citycreator.buildings.Building;
import main2.week2.exercises.citycreator.persons.Person;

public class FarmHouse extends Building implements Paintable {
    /** The size of the garden associated with this farmhouse */
    private String gardenSize;

    /**
     * Creates a new farmhouse with the specified owner, color, and garden size.
     * 
     * @param person     The owner of the farmhouse
     * @param color      The exterior color of the farmhouse
     * @param gardenSize The size of the garden (e.g., "20 sqft")
     */
    public FarmHouse(Person person, String color, String gardenSize) {
        super(person, color);
        this.gardenSize = gardenSize;
    }

    /**
     * Implements the paint method from the Paintable interface.
     * Changes the color of this farmhouse.
     * 
     * @param color The new color to paint the farmhouse
     */
    public void paint(String color) {
        super.color = color;
    }

    /**
     * Returns a string representation of this farmhouse.
     * 
     * @return String containing building information and garden size
     */
    @Override
    public String toString() {
        return super.toString() + "\nIt is a farmhouse with garden size "
                + gardenSize;
    }
}
