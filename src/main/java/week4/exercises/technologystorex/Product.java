package week4.exercises.technologystorex;

/**
 * Represents a product in the Technology Store X.
 * This class stores information about a product including its ID, name,
 * category, price, and stock quantity.
 */
public class Product {
    /** The unique identifier of the product. */
    private int id;

    /** The current stock quantity of the product. */
    private int stock;

    /** The name of the product. */
    private String name;

    /** The category to which the product belongs. */
    private String category;

    /** The price of the product. */
    private float price;

    /**
     * Constructs a new Product with the specified details.
     *
     * @param id       the unique identifier of the product
     * @param name     the name of the product
     * @param category the category of the product
     * @param price    the price of the product
     * @param stock    the stock quantity of the product
     */
    public Product(int id, String name, String category, float price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the product stock quantity.
     *
     * @return the stock quantity
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the product price.
     *
     * @return the product price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the product.
     * Currently returns an empty string as per the original implementation.
     *
     * @return an empty string
     */
    @Override
    public String toString() {
        return "";
    }
}