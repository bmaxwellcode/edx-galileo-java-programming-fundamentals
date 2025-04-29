package week3.lessons.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileStreams - Demonstrates reading and writing raw bytes with
 * FileInputStream/FileOutputStream
 * 
 * This class shows how to read a file byte by byte using FileInputStream
 * and write the contents to a new file using FileOutputStream.
 * It also displays each byte's hexadecimal value.
 */
public class FileStreams {
    public static void main(String[] args) {
        FileInputStream input = null;
        FileOutputStream output = null;

        System.out.println("Reading file byte by byte using FileInputStream:");

        try {
            // Open input and output files
            input = new FileInputStream("src/main/resources/week3/listofFigures.txt");
            output = new FileOutputStream("src/main/resources/week3/listofFigures_out.txt");

            int byteValue;
            int byteCount = 0;

            System.out.println("Each byte in hexadecimal:");

            // Read byte by byte until end of file (-1)
            while ((byteValue = input.read()) != -1) {
                System.out.printf("0x%02X ", byteValue);

                // Print newline every 8 bytes for better readability
                if (++byteCount % 8 == 0) {
                    System.out.println();
                }

                // Write byte to output file
                output.write(byteValue);
            }

            System.out.println("\nTotal bytes read: " + byteCount);
            System.out.println("File copy completed successfully");

        } catch (IOException ex) {
            System.err.println("Error: I/O exception - " + ex.getMessage());
        } finally {
            // Close resources in finally block to ensure they're always closed
            try {
                if (input != null) {
                    input.close();
                    System.out.println("Input stream closed");
                }
                if (output != null) {
                    output.close(); // Fixed: was closing input twice in original code
                    System.out.println("Output stream closed");
                }
            } catch (IOException ex) {
                System.err.println("Error closing file streams: " + ex.getMessage());
            }
        }
    }
}