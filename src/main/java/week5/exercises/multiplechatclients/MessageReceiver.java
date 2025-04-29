package week5.exercises.multiplechatclients;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * A thread that continuously receives and displays messages from the chat
 * server.
 * This class runs in parallel with the main chat client to handle incoming
 * messages
 * while allowing the user to type new messages.
 */
public class MessageReceiver extends Thread {
    private BufferedReader serverMessageIn = null;

    /**
     * Constructs a new MessageReceiver with the specified input stream.
     *
     * @param chatIn The BufferedReader connected to the server's output stream
     */
    public MessageReceiver(BufferedReader chatIn) {
        this.serverMessageIn = chatIn;
    }

    /**
     * The main execution method for the message receiver thread.
     * Continuously reads messages from the server and displays them to the user.
     */
    @Override
    public void run() {
        try {
            String message = null;
            while ((message = serverMessageIn.readLine()) != null) {
                // prints messages from the ClientThread
                System.out.println(message);
            }
        } catch (IOException e) {
            System.err.println("Connection to server lost");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
