package week3.exercises.fileio.Clients;

import java.io.Serializable;

/**
 * Client - Represents a client with basic contact information.
 *
 * This class implements Serializable to allow client objects to be
 * written to and read from files using Java's object serialization.
 * Each client has a name, email address, and phone number.
 */
public class Client implements Serializable {
    /** Serialization version UID for maintaining compatibility across versions */
    private static final long serialVersionUID = 1L;

    /** Client personal information fields */
    private String name;
    private String email;
    private String phoneNum;

    /**
     * Creates a new Client with specified contact information.
     *
     * @param name     The client's name
     * @param email    The client's email address
     * @param phoneNum The client's phone number
     */
    public Client(String name, String email, String phoneNum) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    /**
     * Gets the client's name.
     *
     * @return The client's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the client's email.
     *
     * @return The client's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the client's phone number.
     *
     * @return The client's phone number
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Returns a string representation of the Client.
     *
     * @return A formatted string with the client's information
     */
    @Override
    public String toString() {
        return "Name: " + name +
                ", Email: " + email +
                ", Phone number: " + phoneNum;
    }
}
