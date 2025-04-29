package week3.lessons.solid.liskovsubstitution;

/**
 * Animal - Base class for all pets in the pet shop
 * 
 * This abstract class provides a common interface for all animal types
 * and implements shared functionality. Subclasses must implement the
 * abstract methods to provide type-specific behavior.
 * 
 * Following Liskov Substitution Principle, any subclass of Animal
 * can be used wherever an Animal is expected.
 */
abstract class Animal {
    private String name;
    private int baseprice, suppliesprice;

    /**
     * Creates a new Animal with the specified properties
     * 
     * @param name          The name/type of animal
     * @param baseprice     The base price of the animal
     * @param suppliesprice The price of required supplies
     */
    public Animal(String name, int baseprice, int suppliesprice) {
        this.name = name;
        this.baseprice = baseprice;
        this.suppliesprice = suppliesprice;
    }

    /**
     * Gets the name/type of this animal
     * 
     * @return The animal name/type
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets a formatted string with pricing information
     * 
     * @return A string with base price, supplies price, and total
     */
    public String getCompletePrice() {
        return "Animal Price: $" + this.baseprice + ".00 + Supplies Price: $" + this.suppliesprice +
                ".00\n\tTotal Price: $" + (this.baseprice + this.suppliesprice) + ".00";
    }

    /**
     * Gets a list of extra supplies needed for this animal
     * 
     * @return A string describing required supplies
     */
    public abstract String getExtraSupplies();

    /**
     * Gets available purchase options for this animal
     * 
     * @return A string describing available options
     */
    public abstract String getBuyOptions();
}
