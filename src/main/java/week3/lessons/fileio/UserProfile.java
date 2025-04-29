package week3.lessons.fileio;

import java.io.Serializable;

/**
 * UserProfile - A serializable class storing user profile information
 * 
 * This class implements Serializable interface, which means its instances
 * can be converted to a stream of bytes and later reconstructed back into
 * objects - a process called serialization/deserialization.
 * 
 * It demonstrates basic serialization concepts including the transient keyword.
 */
class UserProfile implements Serializable {
    // Serializable fields (will be saved during serialization)
    private String name;
    private String email;
    private String themeColor;

    // Uncomment to demonstrate transient fields:
    // public transient String temporaryData;
    // Transient fields are not serialized - useful for:
    // 1. Security-sensitive data you don't want to persist
    // 2. Runtime-only data that doesn't make sense to save
    // 3. Derived data that can be recalculated

    /**
     * Constructs a new UserProfile with the specified details
     * 
     * @param name       The user's name
     * @param email      The user's email address
     * @param themeColor The user's preferred theme color
     */
    public UserProfile(String name, String email, String themeColor) {
        this.name = name;
        this.email = email;
        this.themeColor = themeColor;

        // Uncomment if using the transient field:
        // this.temporaryData = temporaryData;
    }

    /**
     * Returns a string representation of this UserProfile
     * 
     * @return Formatted string with user details
     */
    @Override
    public String toString() {
        return "User: " + name +
                "\nEmail: " + email +
                "\nTheme Color: " + themeColor;

        // Uncomment if using the transient field:
        // + "\nTemporary Data (transient): " +
        // (temporaryData != null ? temporaryData : "null - not serialized");
    }
}