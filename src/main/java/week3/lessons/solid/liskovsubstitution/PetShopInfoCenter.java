package week3.lessons.solid.liskovsubstitution;

import java.util.ArrayList;

/**
 * PetShopInfoCenter - Manages the pet shop's product catalog
 * 
 * This class demonstrates the Liskov Substitution Principle by working with
 * the base Animal type and treating all subtypes polymorphically. It doesn't
 * need specific knowledge of each animal type, just the common interface.
 */
final class PetShopInfoCenter {
    private static ArrayList<Animal> productCatalogue = new ArrayList<Animal>();

    /**
     * Creates a new PetShopInfoCenter
     */
    public PetShopInfoCenter() {
        // Empty constructor
    }

    /**
     * Adds a pet product to the catalog
     * 
     * @param pet The animal to add (can be any subtype of Animal)
     */
    public static void addProduct(Animal pet) {
        productCatalogue.add(pet);
    }

    /**
     * Generates a formatted catalog of all available pets
     * 
     * @return A string containing details of all pets in the catalog
     */
    public static String generateCatalogue() {
        StringBuilder catalogue = new StringBuilder();

        for (Animal pet : productCatalogue) {
            // Works with any Animal subtype (Liskov Substitution Principle)
            catalogue.append(pet.getName())
                    .append(":\n\t")
                    .append(pet.getCompletePrice())
                    .append("\n\t")
                    .append(pet.getExtraSupplies())
                    .append("\n\t")
                    .append(pet.getBuyOptions())
                    .append("\n\n");
        }

        return catalogue.toString();
    }
}
