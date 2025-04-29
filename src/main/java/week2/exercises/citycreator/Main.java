/**
 * Main class for the City Creator application.
 * This class demonstrates the use of inheritance, interfaces, and polymorphism
 * by creating and displaying different types of buildings.
 */
package main2.week2.exercises.citycreator;

import main2.week2.exercises.citycreator.buildings.Building;
import main2.week2.exercises.citycreator.persons.Person;

public class Main {
    public static void main(String[] args) {
        // Create people who will own buildings
        Person gabe = new Person("Gabriel");
        Person gabby = new Person("Gabrielle");

        // Demonstrate polymorphism - a FarmHouse can be treated as a Building
        Building b1 = new Building(gabe, "beige");
        Building b2 = new FarmHouse(gabby, "green", "20 sqft");

        // Display the buildings
        System.out.println(b1);
        System.out.println();
        System.out.println(b2);

        System.out.println();
        System.out.println("************************************************************************************");
        System.out.println("************************************************************************************");
        System.out.println();

        // Create specific building types
        FarmHouse fh1 = new FarmHouse(gabe, "blue", "10 sqft");
        OldHouse oh1 = new OldHouse(gabby, "white", 1960);

        // Display the specialized buildings
        System.out.println(fh1);
        System.out.println();
        System.out.println(oh1);
    }
}
