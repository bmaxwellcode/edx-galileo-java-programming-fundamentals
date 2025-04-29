/**
 * Person class represents an individual in the city creator application.
 * Persons can own buildings and track how many buildings they own.
 */
package main2.week2.exercises.citycreator.persons;

public class Person {
    /** The name of this person */
    protected String name;

    /** The number of buildings owned by this person */
    protected int buildingsOwned;

    /**
     * Creates a new person with the specified name.
     * Initially, the person owns 0 buildings.
     * 
     * @param name The name of the person
     */
    public Person(String name) {
        this.name = name;
        buildingsOwned = 0;
    }

    /**
     * Increments the count of buildings owned by this person.
     * Called when a new building is created with this person as owner.
     */
    public void incBuildingsOwned() {
        buildingsOwned++;
    }

    /**
     * Returns a string representation of this person.
     * 
     * @return String containing the person's name and building count
     */
    @Override
    public String toString() {
        return "the person " + this.name + " who currently has " +
                buildingsOwned + " building(s) ";
    }
}
