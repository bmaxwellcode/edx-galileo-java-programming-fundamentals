package week4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week4.exercises.studentorganization.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Lesson 4 Student Organization.
 * 
 * This class contains test cases for the Student Organization functionality.
 * Each test focuses on a specific behavior or functionality.
 */
public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testStudentNameFormatting() {
        Main.runExample();
        String output = outContent.toString();
        assertTrue(output.contains("Joe Clay"));
        assertTrue(output.contains("Marie Smith"));
        assertTrue(output.contains("Ann Thompson"));
        assertEquals(10, output.split("\n").length, "Should print all 10 students");
    }

    @Test
    public void testLastNameUppercaseTransformation() {
        Main.runExercise1();
        String output = outContent.toString();
        assertTrue(output.contains("CLAY"));
        assertTrue(output.contains("SMITH"));
        assertTrue(output.contains("THOMPSON"));
        assertFalse(output.matches(".*[a-z].*"), "All last names should be uppercase");
    }

    @Test
    public void testMaleStudentFiltering() {
        Main.runExercise2();
        String output = outContent.toString();
        assertTrue(output.contains("Joe"));
        assertTrue(output.contains("James"));
        assertTrue(output.contains("Jason"));
        assertFalse(output.contains("Marie"), "Should not contain female students");
        assertEquals(5, output.split("\n").length, "Should contain all 5 male students");
    }

    @Test
    public void testAgeFilteringAndFormatting() {
        Main.runExercise3();
        String output = outContent.toString();
        assertTrue(output.contains("23"));
        assertTrue(output.contains("28"));
        assertTrue(output.contains("22"));
        assertEquals(5, output.split("\n").length, "Should limit to 5 students");
    }

    @Test
    public void testAverageAgeCalculation() {
        Main.runExercise4();
        String output = outContent.toString();
        double averageAge = Double.parseDouble(output.trim());
        assertTrue(averageAge > 20 && averageAge < 30, "Average age should be reasonable");
    }

    @Test
    public void testAgeCountFiltering() {
        Main.runExercise5();
        String output = outContent.toString();
        int count = Integer.parseInt(output.trim());
        assertTrue(count > 0 && count < 10, "Count should be between 0 and total students");
    }

    @Test
    public void testAgeSorting() {
        Main.runExercise6();
        String output = outContent.toString();
        String[] lines = output.split("\n");
        int previousAge = 0;
        for (String line : lines) {
            int currentAge = Integer.parseInt(line.split(" ")[0]);
            assertTrue(currentAge >= previousAge, "Ages should be in ascending order");
            previousAge = currentAge;
        }
    }

    @Test
    public void testAlphabeticalSortingAndFormatting() {
        Main.runExercise7();
        String output = outContent.toString();
        String[] lines = output.split("\n");
        String previousName = "";
        for (String line : lines) {
            assertTrue(line.matches("^[A-Z][a-z]+, [A-Z][a-z]+$"),
                    "Names should be in 'Lastname, Firstname' format");
            assertTrue(line.compareTo(previousName) >= 0,
                    "Names should be in alphabetical order");
            previousName = line;
        }
    }

    @Test
    public void testBirthYearCollectionAndSorting() {
        Main.runExercise8();
        String output = outContent.toString().trim();
        // Remove any brackets and split by commas or newlines
        String[] years = output.replaceAll("[\\[\\]]", "")
                .split("[, \n]+");
        int previousYear = Integer.MAX_VALUE;
        for (String year : years) {
            if (!year.isEmpty()) {
                int currentYear = Integer.parseInt(year.trim());
                assertTrue(currentYear <= previousYear,
                        "Years should be in descending order");
                previousYear = currentYear;
            }
        }
    }
}
