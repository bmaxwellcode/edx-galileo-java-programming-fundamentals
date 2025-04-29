package week3.lessons.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SerializeObject - Demonstrates object serialization and deserialization
 * 
 * Object Serialization is the process of converting an object's state into a
 * byte stream
 * which can then be stored in a file, transmitted over a network, or persisted
 * in a database.
 * 
 * Deserialization is the reverse process, reconstructing the object from the
 * byte stream.
 * 
 * For a class to be serializable, it must implement the Serializable interface.
 */
public class SerializeObject {
    public static void main(String[] args) {
        // Create a local UserProfile object to serialize
        UserProfile localProfile = new UserProfile(
                "Jaime",
                "jaimito@gmail.com",
                "Green"
        // "Some other data" - uncomment if transient field is used
        );

        System.out.println("Original UserProfile:");
        System.out.println(localProfile);
        System.out.println("------------------------");

        // === SERIALIZATION PROCESS ===
        System.out.println("Serializing object to file...");
        serializeToFile(localProfile, "userProfile.txt");

        // === DESERIALIZATION PROCESS ===
        System.out.println("Deserializing object from file...");
        UserProfile restoredProfile = deserializeFromFile("userProfile.txt");

        if (restoredProfile != null) {
            System.out.println("------------------------");
            System.out.println("Restored UserProfile:");
            System.out.println(restoredProfile);
        }
    }

    /**
     * Serializes a UserProfile object to a file
     * 
     * @param profile  The UserProfile object to serialize
     * @param filename The target file name
     */
    private static void serializeToFile(UserProfile profile, String filename) {
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(filename))) {

            output.writeObject(profile);
            System.out.println("Object successfully serialized to " + filename);

        } catch (IOException ex) {
            System.err.println("Error during serialization: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Deserializes a UserProfile object from a file
     * 
     * @param filename The source file name
     * @return The deserialized UserProfile object, or null if deserialization
     *         failed
     */
    private static UserProfile deserializeFromFile(String filename) {
        UserProfile profile = null;

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(filename))) {

            profile = (UserProfile) input.readObject();
            System.out.println("Object successfully deserialized from " + filename);

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error during deserialization: " + ex.getMessage());
            ex.printStackTrace();
        }

        return profile;
    }
}
