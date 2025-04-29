package week3.lessons.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ScannerFile - Demonstrates using Scanner to tokenize file content
 * 
 * This class shows how to read a file token by token using Scanner.
 * It uses BufferedReader for efficient reading and Scanner for parsing.
 * Scanner provides convenient methods for tokenizing input based on delimiters.
 */
public class ScannerFile {
    public static void main(String[] args) {
        // Using try-with-resources ensures Scanner is closed automatically
        try (Scanner input = new Scanner(
                new BufferedReader(
                        new FileReader("src/main/resources/week3/listofFigures.txt")))) {

            System.out.println("Reading file token by token using Scanner:");
            System.out.println("----------------------------------------");

            int tokenCount = 0;

            // Read token by token (default delimiter is whitespace)
            while (input.hasNext()) {
                String token = input.next();
                System.out.printf("%3d: %s\n", ++tokenCount, token);
            }

            System.out.println("----------------------------------------");
            System.out.println("Total tokens read: " + tokenCount);

        } catch (IOException ex) {
            System.err.println("Error: I/O exception - " + ex.getMessage());
        }

        /*
         * Note on reading efficiency:
         * - FileReader reads character by character (slow for large files)
         * - BufferedReader reads larger chunks at once into memory (faster)
         * - Scanner provides parsing functionality on top of the reader
         */
    }
}
