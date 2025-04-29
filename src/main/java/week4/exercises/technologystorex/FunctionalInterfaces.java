package week4.exercises.technologystorex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Practice class for Functional Interfaces and Lambda Expressions.
 * This class implements an application for Technology Store X, demonstrating
 * various functional programming concepts in Java.
 */
public class FunctionalInterfaces {
    /** The list of products in the technology store. */
    private static final List<Product> TECHNOLOGY_STORE = new LinkedList<>();

    /**
     * Reads product information from a file and populates the technology store.
     * The file should be in the format: Name Category Stock Price
     */
    public static void readProductsFile() {
        // Clear the list before reading to ensure a fresh state
        TECHNOLOGY_STORE.clear();

        String filePath = "src/main/resources/week4/products.txt";
        try (Scanner inFile = new Scanner(new BufferedReader(new FileReader(filePath)))) {
            // Create the Product List
            int id = 1;
            while (inFile.hasNext()) {
                String productName = inFile.next();
                String category = inFile.next();
                int stock = Integer.parseInt(inFile.next());
                float price = Float.parseFloat(inFile.next());
                TECHNOLOGY_STORE.add(new Product(id++, productName, category, price, stock));
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        }
    }

    /**
     * Prints all product names in the technology store.
     */
    public static void printProducts() {
        String productNames = TECHNOLOGY_STORE.stream()
                .map(Product::getName)
                .collect(Collectors.joining(" "));
        System.out.println(productNames);
    }

    /**
     * Filters and prints all products that are in the Accessories category.
     */
    public static void filter2() {
        System.out.println(
                TECHNOLOGY_STORE.stream()
                        .filter(product -> product.getCategory().equals("Accessories"))
                        .map(Product::getName)
                        .collect(Collectors.joining(" ")));
    }

    /**
     * Filters and prints all products that have a stock quantity of 50 or more.
     */
    public static void filter3() {
        System.out.println(
                TECHNOLOGY_STORE.stream()
                        .filter(product -> product.getStock() >= 50)
                        .map(Product::getName)
                        .collect(Collectors.joining(" ")));
    }

    /**
     * Filters and prints all products that are cheaper than $150.00
     * and have more than 25 in stock.
     */
    public static void filter4() {
        System.out.println(
                TECHNOLOGY_STORE.stream()
                        .filter(product -> product.getPrice() < 150 && product.getStock() > 25)
                        .map(Product::getName)
                        .collect(Collectors.joining(" ")));
    }

    /**
     * Filters products based on multiple criteria:
     * - Removes Office category products
     * - Removes products with stock over 30
     * - Removes products cheaper than $250.00
     * Prints the remaining products.
     */
    public static void filter5() {
        // Create a copy of the list to work with
        List<Product> filteredList = new LinkedList<>(TECHNOLOGY_STORE);

        // Remove from the list (don't print) if product: the category is Office
        Predicate<Product> officeProduct = product -> "Office".equals(product.getCategory());
        filteredList.removeIf(officeProduct);

        // Remove from the list (don't print) if product: has greater than 30 in stock
        Predicate<Product> stockOver30 = product -> product.getStock() > 30;
        filteredList.removeIf(stockOver30);

        // Remove from the list (don't print) if product: are cheaper than $250.00
        Predicate<Product> cheaperThan250 = product -> product.getPrice() < 250;
        filteredList.removeIf(cheaperThan250);

        // Print each of the products that left
        System.out.println(
                filteredList.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(" ")));
    }

    /**
     * Main method that demonstrates the functionality of the Technology Store X.
     *
     * @param args command line arguments (not used)
     * @throws Exception if an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        readProductsFile();
        System.out.println("----------Filter 1---------");
        printProducts();
        System.out.println("----------Filter 2---------");
        filter2();
        System.out.println("----------Filter 3---------");
        filter3();
        System.out.println("----------Filter 4---------");
        filter4();
        System.out.println("----------Filter 5---------");
        filter5();

        /*
         * ANSWER
         * 
         * ----------Filter 1---------
         * Laptop-12GB_RAM-HDD_1T Printer Headphones HDMI-VGA-Adapter
         * Laptop-16GB_RAM-SSD_750GB Scanner Computer-Keyboard AUX_5ft Ink-Cartridge
         * Mouse-Wireless Laptop-8GB_RAM-HDD_500GB USB-microUSB
         * ----------Filter 2---------
         * Headphones Computer-Keyboard Mouse-Wireless
         * ----------Filter 3---------
         * Printer Headphones AUX_5ft Ink-Cartridge Mouse-Wireless USB-microUSB
         * ----------Filter 4---------
         * Headphones Computer-Keyboard AUX_5ft Ink-Cartridge Mouse-Wireless
         * USB-microUSB
         * ----------Filter 5---------
         * Laptop-12GB_RAM-HDD_1T Laptop-16GB_RAM-SSD_750GB Laptop-8GB_RAM-HDD_500GB
         */
    }
}
