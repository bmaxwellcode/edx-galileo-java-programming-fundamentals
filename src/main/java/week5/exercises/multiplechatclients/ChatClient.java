package week5.exercises.multiplechatclients;

import java.io.*;
import java.net.*;

/**
 * Exercise 1 - Chat Client
 * This class implements a simple chat client that connects to a chat server
 * and allows users to send and receive messages.
 */
public class ChatClient {
    private String hostName;
    private int portNumber;
    private Socket clientSocket;

    /**
     * Constructs a new ChatClient and establishes a connection to the server.
     *
     * @param hostName   The hostname of the server to connect to
     * @param portNumber The port number of the server
     */
    public ChatClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        try {
            clientSocket = new Socket(hostName, portNumber);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName
                    + ":" + portNumber + ". Check that the server is running.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Starts the chat client, setting up input/output streams and message handling.
     */
    public void start() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));

            // Read the welcome message from the server
            // System.out.println(in.readLine());

            // Start a separate thread for listening to server messages
            MessageReceiver mr = new MessageReceiver(in);
            mr.start();

            String userInput = null;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                // Remove this line that waits for an echo response
                // System.out.println(in.readLine());
            }
        } catch (IOException e) {
            System.err.println("I/O Exception");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * The main method to start the chat client.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("127.0.0.1", 54321);
        chatClient.start();
    }
}
