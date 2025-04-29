package week1.classesobjectsmethods;

import java.util.Random;

/**
 * Represents a house with various attributes and modification methods.
 * Demonstrates object state, method behavior, and switch-case control flow.
 */
public class House {

    /** The color of the house. */
    private String color;

    /** Number of bedrooms. */
    private int bedrooms;

    /** Number of full bathrooms. */
    private int bathrooms;

    /** Number of half bathrooms. */
    private int halfBathrooms;

    /** Whether the house has a garage. */
    private Boolean garage;

    /**
     * Creates a new house with the specified color and randomly generated features.
     *
     * @param color The color of the house
     */
    public House(String color) {
        this.color = color;
        Random ranNum = new Random();
        bedrooms = ranNum.nextInt(6) + 1;
        bathrooms = ranNum.nextInt(4) + 1;
        halfBathrooms = ranNum.nextInt(2);
        garage = ranNum.nextBoolean();
    }

    /**
     * Returns the color of the house.
     *
     * @return The house color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Returns the number of bedrooms.
     *
     * @return Bedroom count
     */
    public int getBedrooms() {
        return this.bedrooms;
    }

    /**
     * Returns the number of full bathrooms.
     *
     * @return Bathroom count
     */
    public int getBathrooms() {
        return this.bathrooms;
    }

    /**
     * Returns the number of half bathrooms.
     *
     * @return Half bathroom count
     */
    public int getHalfBathrooms() {
        return this.halfBathrooms;
    }

    /**
     * Indicates whether the house has a garage.
     *
     * @return true if the house has a garage, false otherwise
     */
    public Boolean getGarage() {
        return this.garage;
    }

    /**
     * Changes the color of the house.
     *
     * @param color The new color
     */
    public void paintHouse(String color) {
        this.color = color;
        System.out.println("The house has been painted " + color + ".");
    }

    /**
     * Adds a structure to the house if possible.
     * Demonstrates the use of switch-case and boolean logic.
     *
     * @param structure The type of structure to add (bedroom, bathroom, etc.)
     */
    public void build(String structure) {
        Boolean built = false;
        String addition = structure.toLowerCase();

        switch (addition) {
            case "bedroom":
                this.bedrooms += 1;
                built = true;
                break;
            case "bathroom":
                this.bathrooms += 1;
                built = true;
                break;
            case "half bathroom":
                this.halfBathrooms += 1;
                built = true;
                break;
            case "garage":
                if (this.getGarage()) {
                    System.out.println("This house already has a garage.");
                } else {
                    this.garage = true;
                    built = true;
                }
                break;
            default:
                System.out.println("You don't have the necessary permits to build a "
                        + structure + ".");
        }
        if (built) {
            System.out.println("A " + structure + " was added to the house.");
        }
    }

    /**
     * Prints a description of the house to the console.
     */
    public void describeHouse() {
        System.out.print("My house is " + this.color + ", ");
        System.out.print("it has " + this.bedrooms + " bedrooms, ");
        System.out.print(this.bathrooms + " bathrooms, ");
        System.out.print(this.halfBathrooms + " half bathrooms, ");
        if (this.garage) {
            System.out.println("and it has a built in garage.");
        } else {
            System.out.println("but it does not have a built in garage.");
        }
    }
}