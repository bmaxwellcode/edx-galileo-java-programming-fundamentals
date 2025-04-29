package week5.exercises.multiplechatclients;

/**
 * Exercise 1 - Chat Server
 *
 * Complete the following procedure in order to create a multiple client
 * chat application using sockets. The chat client receives a text written
 * by the user, and send it to the server. Until now, the server works as an
 * echo which means that anything that is sent, will be returned back.
 * Your task is to implement the functionality in order to convert the
 * EchoServer to an actual chat server which will distribute to all the clients
 * all of the received messages.
 *
 * For this exercise we will use two applications; one for the server and
 * one for the client.
 *
 * The procedure is the following:
 *
 * 1. Specify a port number where the server is going to run. A valid port
 * value is between 1024 and 65535.
 * 2. Place the IP and port number of the server on the client's side .
 * The server's IP can be found in a message which is printed on the
 * console when the server is ran.
 * 3.  At the moment, the chat client gets a message from the server
 * when a user sends the message from the keyboard input. Modify the
 * chat client so that it can receive messages from the
 * server and receive messages from the keyboard without a specific order.
 * Hint: Use threads.
 * 4.  Modify the server so that when it receives a client's message,
 * the server forwards this message to all the clients along with the
 * client's id who sent the message. For example:
 *
 * user#(ID): Hello
 *
 * 5. Modify the server to notify all clients when a new user is connected
 * and disconnected. The format for these messages is the following:
 *
 * The user#(ID) has connected
 * The user#(ID) has disconnected
 */

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * This class implements a chat server that can handle multiple clients
 * simultaneously.
 * The server receives messages from clients and broadcasts them to all
 * connected clients.
 * It also notifies clients when new users connect or disconnect.
 */
public class ChatServer {
    private int port;
    private int clientIdCounter;
    private List<ClientThread> clients;
    private ServerSocket serverSocket = null;

    /**
     * Constructs a new ChatServer with the specified port.
     *
     * @param port The port number to listen on
     */
    public ChatServer(int port) {
        this.port = port;
        this.clientIdCounter = 1;
        this.clients = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the chat server and begins accepting client connections.
     */
    public void start() {
        Socket socket = null;
        ClientThread newClient = null;
        System.out.println("Waiting for clients to connect...");
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            newClient = new ClientThread(socket, this, clientIdCounter++);
            newClient.start();
            clients.add(newClient);

            // Notify all clients about the new connection
            notifyClientStatus(newClient.id, true);

            newClient = null;
        }
    }

    /**
     * Removes a client from the list of connected clients and notifies others.
     *
     * @param clientClosed The client thread to remove
     */
    public void removeClient(ClientThread clientClosed) {
        clients.remove(clientClosed);
        notifyClientStatus(clientClosed.id, false);
        System.out.println("Client #" + clientClosed.id + " has disconnected");
    }

    /**
     * Broadcasts a message to all connected clients.
     *
     * @param message The message to broadcast
     * @param sender  The client thread that sent the message
     */
    public void broadcast(String message, ClientThread sender) {
        synchronized (clients) {
            for (ClientThread client : clients) {
                try {
                    PrintWriter out = new PrintWriter(client.socket.getOutputStream(), true);
                    out.println("user#" + sender.id + ": " + message);
                } catch (IOException e) {
                    System.err.println("Error broadcasting to client");
                }
            }
        }
    }

    /**
     * Notifies all clients about a client's connection status change.
     *
     * @param clientId     The ID of the client whose status changed
     * @param isConnecting True if the client is connecting, false if disconnecting
     */
    public void notifyClientStatus(int clientId, boolean isConnecting) {
        String message = isConnecting
                ? "The user#" + clientId + " has connected"
                : "The user#" + clientId + " has disconnected";

        synchronized (clients) {
            for (ClientThread client : clients) {
                try {
                    PrintWriter out = new PrintWriter(client.socket.getOutputStream(), true);
                    out.println(message);
                } catch (IOException e) {
                    System.err.println("Error notifying client about status change");
                }
            }
        }
    }

    /**
     * The main method to start the chat server.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            System.out.println("Server IP: " + InetAddress.getLocalHost().getHostAddress());
            // this is a local hostname that refers to the local computer that
            // a program is running on
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException: " + e);
        }
        /*
         * should specify a port number in the dynamic/private port range (49152-65535)
         * to avoid conflicts with standard services. Common choices for educational
         * applications include:
         * 55555
         * 54321
         * 50000
         * 60000
         */
        int port = 54321;
        ChatServer chatServer = new ChatServer(port);
        chatServer.start();
    }
}