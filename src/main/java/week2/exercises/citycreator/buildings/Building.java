/**
 * Building class represents a basic building in the city creator application.
 * This is the base class for different building types and demonstrates inheritance.
 */
package main2.week2.exercises.citycreator.buildings;

import main2.week2.exercises.citycreator.persons.Person;

public class Building {
    /** The owner of this building */
    protected Person owner;

    /** The exterior color of this building */
    protected String color;

    /**
     * Creates a new building with the specified owner and color.
     * Increments the owner's building count when created.
     * 
     * @param owner The person who owns this building
     * @param color The exterior color of the building
     */
    public Building(Person owner, String color) {
        this.owner = owner;
        this.owner.incBuildingsOwned();
        this.color = color;
    }

    /**
     * Returns a string representation of this building.
     * 
     * @return String containing building color and owner information
     */
    @Override
    public String toString() {
        return "This is a " + this.color + " colored building, owned by "
                + this.owner.toString();
    }
}
