package week3.exercises.hashmap.contactlist;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactList - Demonstrates HashMap usage for a simple contact management
 * system.
 *
 * This class shows how to use a HashMap to store and retrieve contact
 * information where phone numbers are keys and contact names are values.
 */
public class ContactList {

    /**
     * Main method demonstrating contact list operations using HashMap.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a HashMap with phone number (String) as key and contact name (String)
        // as value
        Map<String, String> contactList = new HashMap<>();

        // Add contacts to the HashMap
        // Note: Using consistent format for phone numbers (555-555-5550)
        contactList.put("555-555-5550", "Bryce");
        contactList.put("555-555-5551", "John");
        contactList.put("555-555-5552", "Jane");
        contactList.put("555-555-5553", "Gabe");
        contactList.put("555-555-5554", "Gabby");

        // Print all contacts with their phone numbers
        System.out.println("--- Contact List ---");
        contactList.forEach((phoneNumber, name) -> System.out.println("Phone: " + phoneNumber + " | Contact: " + name));

        // Demonstrate other HashMap operations
        System.out.println("\n--- HashMap Operations ---");

        // Get a specific contact by phone number
        String lookupNumber = "555-555-5552";
        System.out.println("Looking up " + lookupNumber + ": " + contactList.get(lookupNumber));

        // Check if a contact exists
        String checkNumber = "555-555-5555";
        if (contactList.containsKey(checkNumber)) {
            System.out.println(checkNumber + " exists in contacts");
        } else {
            System.out.println(checkNumber + " is not in contacts");
        }

        // Count contacts
        System.out.println("Total contacts: " + contactList.size());

        // Remove a contact
        String removeNumber = "555-555-5554";
        contactList.remove(removeNumber);
        System.out.println("Removed " + removeNumber + ". New contact count: " + contactList.size());

        // Check if HashMap is empty
        System.out.println("Contact list is empty: " + contactList.isEmpty());
    }
}
