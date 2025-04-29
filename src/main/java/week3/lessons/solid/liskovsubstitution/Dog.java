package week3.lessons.solid.liskovsubstitution;

/**
 * Dog - Represents a dog available for purchase
 * 
 * This class extends the base Animal class and provides dog-specific
 * implementation of the abstract methods. It also adds additional
 * dog-specific properties like separating obligatory and optional supplies.
 */
class Dog extends Animal {
    private String additionalInfo;
    private int obligatorySuppliesprice, optionalSuppliesprice;

    /**
     * Creates a new Dog with specified prices and information
     * 
     * @param baseprice      The base price of the dog
     * @param obligatory     The price of obligatory supplies
     * @param optional       The price of optional supplies
     * @param additionalInfo Additional information about the dog
     */
    public Dog(int baseprice, int obligatory, int optional, String additionalInfo) {
        super("Dog", baseprice, obligatory + optional);
        this.additionalInfo = additionalInfo;
        this.obligatorySuppliesprice = obligatory;
        this.optionalSuppliesprice = optional;
    }

    /**
     * Gets a list of extra supplies needed for a dog
     * 
     * @return A string describing required and optional supplies with prices
     */
    @Override
    public String getExtraSupplies() {
        return "\tObligatory: Vaccines, Food 50kg\t($" +
                this.obligatorySuppliesprice +
                ".00)\n\t\tOptional: dog collar & harness\t($" +
                this.optionalSuppliesprice + ".00)";
    }

    /**
     * Gets available dog breeds and additional purchase information
     * 
     * @return A string describing available dog breeds and additional info
     */
    @Override
    public String getBuyOptions() {
        return "Breeds: Golden Retriever, Schnauzer, Husky\n\t" + this.additionalInfo;
    }
}
