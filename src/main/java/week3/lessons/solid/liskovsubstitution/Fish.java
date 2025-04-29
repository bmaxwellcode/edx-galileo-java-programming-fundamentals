package week3.lessons.solid.liskovsubstitution;

/**
 * Fish - Represents a fish available for purchase
 * 
 * This class extends the base Animal class and provides fish-specific
 * implementation of the abstract methods. It's a simpler implementation
 * than Dog, demonstrating how different subclasses can have different
 * complexities while still conforming to the same interface.
 */
class Fish extends Animal {
    /**
     * Creates a new Fish with specified prices
     * 
     * @param baseprice     The base price of the fish
     * @param suppliesprice The price of supplies
     */
    public Fish(int baseprice, int suppliesprice) {
        super("Fish", baseprice, suppliesprice);
    }

    /**
     * Gets a list of extra supplies needed for a fish
     * 
     * @return A string describing required supplies for a fish
     */
    @Override
    public String getExtraSupplies() {
        return "\tFishbowl, Food, Fungicide Drops";
    }

    /**
     * Gets available fish breeds
     * 
     * @return A string describing available fish breeds
     */
    @Override
    public String getBuyOptions() {
        return "Breeds: Beta, Koi, Angel\n\t";
    }
}
