package week3.exercises.nutritionapp.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week3.exercises.nutritionapp.src.Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Recipe and Main classes
 * 
 * This test class verifies the functionality of the Recipe and Main classes.
 * All tests in the "test" folder are executed when the "Test" action is
 * invoked.
 */
public class RecipeTest {
    // Stream to capture console output for testing
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Set up the test environment by redirecting System.out
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Clean up the test environment
     */
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    /**
     * Test the firstExercise method in Main
     * 
     * This test verifies that the recipe parsing and display functionality
     * works correctly by checking the captured console output.
     */
    @Test
    public final void testMain() {
        Main.firstExercise();

        // Expected output for the first recipe
        String firstParagraph = "Crock Pot Roast\n\tingredients:\n\t\t1 beef roast, Meat\n\t\t1 package brown gravy mix, Baking\n\t\t1 package dried Italian salad dressing mix, Condiments\n\t\t1 package dry ranch dressing mix, Condiments\n\t\t1/2 cup water, Drinks\n\tsteps:\n\t\t1. Place beef roast in crock pot\n\t\t2. Mix the dried mixes together in a bowl and sprinkle over the roast.\n\t\t3. Pour the water around the roast.\n\t\t4. Cook on low for 7-9 hours.";

        // Expected output for the second recipe
        String secondParagraph = "\nRoasted asparagus\n\tingredients:\n\t\t1 lb asparagus, Produce\n\t\t1 1/2 tbsp olive oil, Condiments\n\t\t1/2 tsp kosher salt, Baking\n\tsteps:\n\t\t1. Preheat oven to 425F.\n\t\t2. Cut off the woody bottom part of the asparagus spears and discard.\n\t\t3. With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the spears.\n\t\t4. Place asparagus on foil-lined baking sheet and drizzle with olive oil.\n\t\t5. Sprinkle with salt.\n\t\t6. With your hands, roll the asparagus around until they are evenly coated with oil and salt.\n\t\t7. Roast for 10-15 minutes, depending on the thickness of your stalks and how tender you like them.\n\t\t8. They should be tender when pierced with the tip of a knife.\n\t\t9. The tips of the spears will get very brown but watch them to prevent burning.\n\t\t10. They are great plain, but sometimes I serve them with a light vinaigrette if we need something acidic to balance out our meal.";

        // Expected output for the third recipe
        String thirdParagraph = "\nCurried Lentils and Rice\n\tingredients:\n\t\t1 quart beef broth, Misc\n\t\t1 cup dried green lentils, Misc\n\t\t1/2 cup basmati rice, Misc\n\t\t1 tsp curry powder, Condiments\n\t\t1 tsp salt, Condiments\n\tsteps:\n\t\t1. Bring broth to a low boil.\n\t\t2. Add curry powder and salt.\n\t\t3. Cook lentils for 20 minutes.\n\t\t4. Add rice and simmer for 20 minutes.\n";

        // Combined expected output
        String completeParagraph = firstParagraph + secondParagraph + thirdParagraph;

        // Verify the output matches the expected result
        assertEquals(completeParagraph, outContent.toString());
    }

    /**
     * Test secondExercise and thirdExercise methods in Main
     * 
     * This test verifies that the recipe serialization and deserialization
     * functions work correctly.
     */
    @Test
    public final void testSecond() {
        // First populate the recipeList
        Main.firstExercise();

        // Execute the serialization exercise
        Main.secondExercise();

        // Verify the file was created
        File favoriteRecipe = new File("src/main/resources/week3/favorite_recipe.txt");
        assertTrue(favoriteRecipe.isFile(), "Favorite recipe file should exist");
        // Execute the deserialization exercise
        Main.thirdExercise();

        // Expected output for favorite recipe info
        String favorite = "Crock Pot Roast\n\tingredients: 5\n\tsteps: 4\n";

        try {
            // Verify the deserialized output contains the expected text
            assertTrue(outContent.toString("utf-8").contains(favorite));
        } catch (IOException ioe) {
            fail("IOException during test: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
