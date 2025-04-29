package week3.lessons.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileReaders - Demonstrates reading and writing characters with
 * FileReader/FileWriter
 * 
 * This class shows how to read a file character by character using FileReader
 * and write the contents to a new file using FileWriter.
 * It also displays each character's hexadecimal value.
 */
public class FileReaders {
    public static void main(String[] args) {
        FileReader input = null;
        FileWriter output = null;

        System.out.println("Reading file character by character using FileReader:");

        try {
            // Open input and output files
            input = new FileReader("src/main/resources/week3/listofFigures.txt");
            output = new FileWriter("src/main/resources/week3/listofFigures_out.txt");

            int character;

            // Read character by character until end of file (-1)
            while ((character = input.read()) != -1) {
                // Display character as hexadecimal

                if (character == ' ') {
                    System.out.printf("0x%02X('%c') \n", character, (char) character);
                } else {
                    System.out.printf("0x%02X('%c') ", character, (char) character);
                }

                // Write character to output file
                output.write(character);
            }

            System.out.println("\nFile copy completed successfully");

        } catch (FileNotFoundException ex) {
            System.err.println("Error: Input file not found - " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: I/O exception during file operation - " + ex.getMessage());
        } finally {
            // Close resources in finally block to ensure they're always closed
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                    System.out.println("Output file closed successfully");
                }
            } catch (IOException ex) {
                System.err.println("Error closing file streams: " + ex.getMessage());
            }
        }
    }
}
