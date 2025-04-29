package week3.exercises.fileio.Clients;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * BufferedReaderFile - Demonstrates file I/O operations with client data.
 *
 * This class shows how to:
 * 1. Read client information from a text file using BufferedReader
 * 2. Serialize client objects to a backup file
 * 3. Deserialize client objects from the backup file
 */
public class BufferedReaderFile {

    /**
     * Main method demonstrating file I/O operations with client data.
     *
     * @param args Command line arguments (not used)
     * @throws Exception If an error occurs during file operations
     */
    public static void main(String[] args) throws Exception {
        // Create a List of Clients
        List<Client> clientList = new ArrayList<>();
        final String FILE_NAME = "src/main/resources/week3/clients_info.txt";
        final String BACK_UP_FILE = "src/main/resources/week3/client_info_backup.txt";

        // Read client information from file
        try (BufferedReader fileRead = new BufferedReader(new FileReader(FILE_NAME))) {
            // Read file clients_info.txt, in every line there is a client information
            // Each client has name, email and phone, separated with spaces
            while (true) {
                String line = fileRead.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("\\s+");
                // Create a Client object and add it to the clients list
                Client client = new Client(info[0], info[1], info[2]);
                clientList.add(client);
            }
        }

        // Serialize client objects to backup file
        try (ObjectOutputStream saveContacts = new ObjectOutputStream(
                new FileOutputStream(BACK_UP_FILE))) {
            // Save the contacts list object on a file named client_info_backup.txt
            for (Client client : clientList) {
                saveContacts.writeObject(client);
            }
        }

        // Deserialize client objects from backup file
        try (ObjectInputStream restoring = new ObjectInputStream(new FileInputStream(BACK_UP_FILE))) {
            // Restore the Contact List
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    Client restoredClient = (Client) restoring.readObject();
                    System.out.println(restoredClient);
                } catch (EOFException exc) {
                    endOfFile = true;
                }
            }
        }
    }
}