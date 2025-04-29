package week3.exercises.arraylist.words;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Words - Demonstrates ArrayList usage with string manipulation
 * 
 * This program collects 10 unique words from the user, prints the list,
 * then asks for a letter and removes all words that begin with that letter.
 * Finally, it displays the modified list with its new size.
 */
public class Words {
    public static void main(String[] args) {
        // Initialize ArrayList to store words
        ArrayList<String> words = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // Collect 10 unique words from user
        System.out.println("Type 10 words separately. Press enter after each word entry");
        while (words.size() < 10) {
            String word = input.next().trim();
            // Only add the word if it's not already in the list
            if (!words.contains(word)) {
                words.add(word);
            } else {
                System.out.println("Duplicate word. Please enter a different word.");
            }
        }

        // Display the list and its size
        System.out.println("Original list: " + words);
        System.out.println("The words ArrayList size is: " + words.size());

        // Get a letter from the user to filter words
        System.out.print("Enter a letter: ");
        char letter = ' ';
        while (letter == ' ') {
            letter = input.next().charAt(0);
        }

        // Remove words that start with the specified letter
        // Note: When removing elements while iterating, we decrement the index
        // to compensate for the shifting of elements
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) == letter) {
                words.remove(i);
                i--; // Adjust index after removal
            }
        }

        // Display the modified list and its new size
        System.out.println("List with words removed that begin with letter '" + letter + "': " + words);
        System.out.println("The words ArrayList size is now: " + words.size());

        // Close the scanner to prevent resource leak
        input.close();
    }
}
