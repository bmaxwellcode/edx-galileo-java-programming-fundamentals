package week3.exercises.restaurantmanager;

/**
 * Combo - Represents a meal combination with a main dish, drink, and dessert
 * 
 * This class demonstrates the Composite pattern, combining multiple Food
 * objects
 * and applying a discount to create a special offer.
 */
class Combo {
    /** Components of the combo */
    private MainDish mainDish;
    private Drink drink;
    private Dessert dessert;
    private double comboPrice;

    /**
     * Creates a new Combo with specified food items
     * The combo price is calculated automatically with a random discount
     * 
     * @param mainDish The main dish component
     * @param drink    The drink component
     * @param dessert  The dessert component
     */
    public Combo(MainDish mainDish, Drink drink, Dessert dessert) {
        this.mainDish = mainDish;
        this.drink = drink;
        this.dessert = dessert;
        this.comboPrice = calculateComboPrice();
    }

    /**
     * Calculates the final price of the combo after applying the discount
     * 
     * @return The discounted combo price
     */
    private double calculateComboPrice() {
        double discount = calculateComboDiscount();
        return mainDish.getPrice() + drink.getPrice() + dessert.getPrice() - discount;
    }

    /**
     * Generates a random discount between $0.00 and $5.00
     * 
     * @return The discount amount
     */
    private double calculateComboDiscount() {
        // Each combo can have a random discount range (from $0.00 to $5.00)
        return (int) (Math.random() * 5);
    }

    /**
     * Returns a formatted string representation of the combo
     * 
     * @return String with the combo components and final price
     */
    @Override
    public String toString() {
        return "\t" + mainDish.getName() + " " + drink.getName() + " " + dessert.getName() + "\n" +
        // Uncomment to show price before discount:
        // "\t$" + (mainDish.getPrice() + drink.getPrice() + dessert.getPrice()) + "\n"
        // +
                "\t    $" + String.format("%.2f", comboPrice) + "\n";
    }
}
