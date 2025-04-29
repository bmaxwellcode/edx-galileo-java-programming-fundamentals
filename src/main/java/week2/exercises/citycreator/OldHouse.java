/**
 * OldHouse class represents a historic building with a construction year.
 * This class demonstrates inheritance by extending the Building class.
 */
package main2.week2.exercises.citycreator;

import main2.week2.exercises.citycreator.buildings.Building;
import main2.week2.exercises.citycreator.persons.Person;

public class OldHouse extends Building {
    /** The year this house was built */
    private int yearBuilt;

    /**
     * Creates a new old house with the specified owner, color, and construction
     * year.
     * 
     * @param person    The owner of the old house
     * @param color     The exterior color of the old house
     * @param yearBuilt The year the house was constructed
     */
    public OldHouse(Person person, String color, int yearBuilt) {
        super(person, color);
        this.yearBuilt = yearBuilt;
    }

    /**
     * Returns a string representation of this old house.
     * 
     * @return String containing building information and construction year
     */
    @Override
    public String toString() {
        return super.toString() + "\nIt is an old house built in year "
                + yearBuilt;
    }
}
