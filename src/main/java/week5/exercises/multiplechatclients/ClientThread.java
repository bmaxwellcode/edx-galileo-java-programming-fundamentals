package week5.exercises.multiplechatclients;

import java.net.*;
import java.io.*;

/**
 * A thread that handles communication with a single client in the chat server.
 * This class manages the client's connection, receives messages, and forwards
 * them
 * to the server for broadcasting to all clients.
 */
public class ClientThread extends Thread {
    private ChatServer server;
    protected Socket socket;
    public int id;

    /**
     * Constructs a new ClientThread for handling a client connection.
     *
     * @param clientSocket The socket connected to the client
     * @param server       The chat server instance
     * @param id           The unique identifier for this client
     */
    public ClientThread(Socket clientSocket, ChatServer server, int id) {
        this.socket = clientSocket;
        this.server = server;
        this.id = id;
    }

    /**
     * The main execution method for the client thread.
     * Handles receiving messages from the client and forwarding them to the server.
     */
    @Override
    public void run() {
        InputStream inp = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            inp = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(inp));
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        out.println("Welcome user#" + id);
        out.flush();

        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println("Message received from user#" + id + ": " + line);
                // Instead of echoing back to just this client, broadcast to all
                server.broadcast(line, this);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        server.removeClient(this);
        server = null;
    }
}