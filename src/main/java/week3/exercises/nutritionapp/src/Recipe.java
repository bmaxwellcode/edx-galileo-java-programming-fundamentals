package week3.exercises.nutritionapp.src;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Recipe - Represents a cooking recipe with ingredients and preparation steps
 * 
 * This class implements Serializable to allow Recipe objects to be written to
 * and read from files using Java's object serialization.
 */
public class Recipe implements Serializable {
    // Serialization version UID for maintaining compatibility across versions
    private static final long serialVersionUID = 1L;

    // Recipe information fields
    private String name;
    private List<String> ingredients;
    private List<String> steps;

    /**
     * Default constructor required for serialization
     */
    public Recipe() {
        this.name = "";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    /**
     * Creates a new Recipe with the given details
     * 
     * @param name        The recipe name
     * @param ingredients List of ingredients with their categories
     * @param steps       List of preparation steps
     */
    public Recipe(String name, List<String> ingredients, List<String> steps) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients); // Create defensive copy
        this.steps = new ArrayList<>(steps); // Create defensive copy
    }

    /**
     * Gets the recipe name
     * 
     * @return The recipe name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of ingredients
     * 
     * @return The ingredients list
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * Gets the list of preparation steps
     * 
     * @return The steps list
     */
    public List<String> getSteps() {
        return steps;
    }

    /**
     * Formats the ingredients list as a string with proper indentation
     * 
     * @return Formatted string of ingredients
     */
    public String getIngredientsString() {
        StringBuilder str = new StringBuilder();
        for (String ingredient : getIngredients()) {
            str.append("\t\t").append(ingredient).append("\n");
        }
        return str.toString();
    }

    /**
     * Gets the number of ingredients in the recipe
     * 
     * @return Number of ingredients
     */
    public int getNumIngredients() {
        return getIngredients().size();
    }

    /**
     * Gets the number of preparation steps in the recipe
     * 
     * @return Number of steps
     */
    public int getNumSteps() {
        return getSteps().size();
    }

    /**
     * Formats the preparation steps as a string with proper numbering and
     * indentation
     * 
     * @return Formatted string of numbered steps
     */
    public String getStepsString() {
        StringBuilder str = new StringBuilder();
        for (int x = 0; x < getSteps().size(); x++) {
            str.append("\t\t")
                    .append(x + 1)
                    .append(". ")
                    .append(getSteps().get(x))
                    .append("\n");
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the Recipe
     * 
     * @return Formatted string with the recipe's name, ingredients, and steps
     */
    @Override
    public String toString() {
        return getName() + "\n" +
                "\tingredients:" + "\n" +
                getIngredientsString() +
                "\tsteps:" + "\n" +
                getStepsString();
    }
}
