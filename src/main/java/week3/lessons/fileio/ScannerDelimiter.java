package week3.lessons.fileio;

import java.util.Scanner;

/**
 * ScannerDelimiter - Demonstrates Scanner's custom delimiter functionality
 * 
 * This class shows how to use regular expression patterns as delimiters
 * to filter specific content from a string. It separates alphabetic characters
 * from numeric characters using regex pattern delimiters.
 */
public class ScannerDelimiter {

    public static void main(String[] args) {
        // Input string containing mixed content
        String input = "John 18 Phil 26 Sally 22 Molly 17";
        System.out.println("Original input: " + input);
        System.out.println("----------------------------------");

        // === EXTRACT WORDS (ALPHABETIC CHARACTERS) ===
        System.out.println("Extracting words (alphabetic characters):");

        // Create scanner with original input
        Scanner wordScanner = new Scanner(input);

        // Set delimiter to match any sequence NOT containing letters
        // [^A-Za-z]+ means "one or more characters that are not A-Z or a-z"
        wordScanner.useDelimiter("[^A-Za-z]+");

        // Extract and display words
        System.out.print("Words: ");
        while (wordScanner.hasNext()) {
            System.out.print(wordScanner.next() + " ");
        }
        wordScanner.close();

        System.out.println("\n----------------------------------");

        // === EXTRACT NUMBERS (NUMERIC CHARACTERS) ===
        System.out.println("Extracting numbers (numeric characters):");

        // Create new scanner with original input
        Scanner numberScanner = new Scanner(input);

        // Set delimiter to match any sequence NOT containing digits
        // [^0-9]+ means "one or more characters that are not 0-9"
        numberScanner.useDelimiter("[^0-9]+");

        // Extract and display numbers
        System.out.print("Numbers: ");
        while (numberScanner.hasNext()) {
            System.out.print(numberScanner.next() + " ");
        }
        numberScanner.close();

        System.out.println("\n----------------------------------");
        System.out.println("Regular Expression Delimiter Pattern Examples:");
        System.out.println("[^A-Za-z]+ - Matches anything that's not a letter");
        System.out.println("[^0-9]+   - Matches anything that's not a digit");
    }
}