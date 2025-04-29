package week3.lessons.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferReaders - Demonstrates reading and writing with buffered streams
 * 
 * This class shows how to use BufferedReader and BufferedWriter to efficiently
 * read from and write to files. Buffered streams improve performance by
 * reducing
 * the number of disk/IO operations through internal buffering.
 */
public class BufferReaders {
    public static void main(String[] args) {
        BufferedReader input = null;
        BufferedWriter output = null;

        System.out.println("Reading file using BufferedReader:");

        try {
            // Create buffered streams for reading and writing
            input = new BufferedReader(new FileReader("src/main/resources/week3/listofFigures.txt"));
            output = new BufferedWriter(new FileWriter("src/main/resources/week3/listofFigures_out.txt"));

            int character;
            int charCount = 0;

            // BufferedReader.read() returns int value of character or -1 at end of file
            while ((character = input.read()) != -1) {
                System.out.printf("0x%02X ('%c') ", character, (char) character);

                // Print newline every 4 characters for better readability
                if (character == ' ') {
                    System.out.println();
                }

                // Write to output file
                output.write(character);
                charCount++;
            }

            System.out.println("\nTotal characters processed: " + charCount);
            System.out.println("File processing completed");

        } catch (IOException ex) {
            System.err.println("Error: I/O exception - " + ex.getMessage());
        } finally {
            // Close resources in finally block
            try {
                if (input != null) {
                    input.close();
                    System.out.println("BufferedReader closed");
                }
                if (output != null) {
                    output.close();
                    System.out.println("BufferedWriter closed");
                }
            } catch (IOException ex) {
                System.err.println("Error closing buffer streams: " + ex.getMessage());
            }
        }

        /*
         * Benefits of BufferedReader over FileReader:
         * 1. Performance: Reduces system calls by reading chunks at once
         * 2. Convenience: Provides readLine() method for line-by-line reading
         * 3. Efficiency: Internal buffer management optimizes I/O operations
         */
    }
}