package week3.exercises.nutritionapp.src;

/**
 * Exercise 3 - Nutrition APP
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Nutrition APP - Recipe Management Application
 *
 * This application demonstrates file I/O operations with recipe objects:
 * 1. Reading recipes from a text file
 * 2. Creating Recipe objects and storing them in memory
 * 3. Serializing a recipe object to a file
 * 4. Deserializing a recipe object from a file
 */
public class Main {
    /** ArrayList to store all recipes read from file */
    private static List<Recipe> recipeList = new ArrayList<>();

    /**
     * Main method that executes the three exercises in sequence
     *
     * @param args Command line arguments (not used)
     * @throws Exception If an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        firstExercise();
        secondExercise();
        thirdExercise();
    }

    /**
     * Exercise 1: Read recipes from a text file and create Recipe objects
     *
     * This method parses a text file containing recipe information and
     * creates Recipe objects to store in the recipeList.
     */
    public static void firstExercise() {
        BufferedReader input = null;

        String recipeName = null;
        List<String> ingredients = new ArrayList<>();
        List<String> steps = new ArrayList<>();
        List<String> lineList = null;

        try {
            // Select input file path
            String filenameTXT = "src/main/resources/week3/recipes.txt";
            // Note: JSON file option is available but not used in this exercise
            // String filenameJSON = "week3Resources/recipes.json";

            // Open file reader
            input = new BufferedReader(new FileReader(filenameTXT));

            // Parse the file line by line to extract recipe information
            String line = input.readLine();
            while (line != null) {
                line = line.trim();

                if (recipeName == null) {
                    // First non-empty line is the recipe name
                    recipeName = line;
                } else if (line.equals("ingredients:")) {
                    // Start collecting ingredients
                    lineList = ingredients;
                } else if (line.equals("steps:")) {
                    // Start collecting steps
                    lineList = steps;
                } else if (!line.isEmpty() && lineList != null) {
                    // Add line to current collection (ingredients or steps)
                    lineList.add(line);
                } else if (line.isEmpty()) {
                    // Empty line indicates end of recipe
                    // Add complete recipe to the list and reset variables for next recipe
                    recipeList.add(new Recipe(recipeName, ingredients, steps));
                    recipeName = null;
                    ingredients = new ArrayList<>();
                    steps = new ArrayList<>();
                }

                // Read next line
                line = input.readLine();
            }

            // Add the last recipe (which doesn't end with an empty line)
            recipeList.add(new Recipe(recipeName, ingredients, steps));

        } catch (IOException e) {
            System.err.println("Error reading recipe file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure file is closed properly
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                System.err.println("Error closing file: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        // Display all recipes read from the file
        for (Recipe recipe : recipeList) {
            System.out.print(recipe);
        }

        // Expected output. (Use tab instead of space to give format to the output)
        /*
         *
         * Crock Pot Roast
         * ingredients:
         * 1 beef roast, Meat
         * 1 package brown gravy mix, Baking
         * 1 package dried Italian salad dressing mix, Condiments
         * 1 package dry ranch dressing mix, Condiments
         * 1/2 cup water, Drinks
         * steps:
         * 1. Place beef roast in crock pot
         * 2. Mix the dried mixes together in a bowl and sprinkle over the roast.
         * 3. Pour the water around the roast.
         * 4. Cook on low for 7-9 hours.
         * Roasted asparagus
         * ingredients:
         * 1 lb asparagus, Produce
         * 1 1/2 tbsp olive oil, Condiments
         * 1/2 tsp kosher salt, Baking
         * steps:
         * 1. Preheat oven to 425F.
         * 2. Cut off the woody bottom part of the asparagus spears and discard.
         * 3. With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the
         * spears.
         * 4. Place asparagus on foil-lined baking sheet and drizzle with olive oil.
         * 5. Sprinkle with salt.
         * 6. With your hands, roll the asparagus around until they are evenly coated
         * with oil and salt.
         * 7. Roast for 10-15 minutes, depending on the thickness of your stalks and how
         * tender you like them.
         * 8. They should be tender when pierced with the tip of a knife.
         * 9. The tips of the spears will get very brown but watch them to prevent
         * burning.
         * 10. They are great plain, but sometimes I serve them with a light vinaigrette
         * if we need something acidic to balance out our meal.
         * Curried Lentils and Rice
         * ingredients:
         * 1 quart beef broth, Misc
         * 1 cup dried green lentils, Misc
         * 1/2 cup basmati rice, Misc
         * 1 tsp curry powder, Condiments
         * 1 tsp salt, Condiments
         * steps:
         * 1. Bring broth to a low boil.
         * 2. Add curry powder and salt.
         * 3. Cook lentils for 20 minutes.
         * 4. Add rice and simmer for 20 minutes.
         *
         */
    }

    /**
     * Exercise 2: Serialize a Recipe object to a file
     *
     * This method takes the first recipe from recipeList and
     * serializes it to a file as the "favorite recipe".
     */
    public static void secondExercise() {
        try {
            // Create output streams for file and object serialization
            FileOutputStream outputFile = new FileOutputStream("src/main/resources/week3/favorite_recipe.txt");
            ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);

            // Write the first recipe object to the file
            outputObject.writeObject(recipeList.get(0));

            // Close the output stream
            outputObject.close();

        } catch (IOException e) {
            System.err.println("Error serializing favorite recipe: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Exercise 3: Deserialize a Recipe object from a file
     *
     * This method reads the favorite recipe from a file and
     * displays summary information about it.
     */
    public static void thirdExercise() {
        ObjectInputStream inputObject = null;

        try {
            // Open input stream to read the serialized object
            inputObject = new ObjectInputStream(new FileInputStream("src/main/resources/week3/favorite_recipe.txt"));

            // Read and cast the object to Recipe type
            Recipe favoriteRecipe = (Recipe) inputObject.readObject();

            // Display summary information about the favorite recipe
            System.out.println(
                    favoriteRecipe.getName() +
                            "\n\tingredients: " + favoriteRecipe.getNumIngredients() +
                            "\n\tsteps: " + favoriteRecipe.getNumSteps());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing favorite recipe: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure input stream is closed properly
            if (inputObject != null) {
                try {
                    inputObject.close();
                } catch (IOException e) {
                    System.err.println("Error closing input stream: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
