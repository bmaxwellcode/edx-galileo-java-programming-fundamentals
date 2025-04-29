package week5.exercises.lifeexpectancybycountry.CountriesExercise;

import javax.json.*;
import java.io.StringReader;

/**
 * This class handles parsing country data from JSON format.
 * It extracts country information and populates the Countries collection.
 */
public class CountriesJSONParser {
    /**
     * Parses country data from a JSON string and populates the Countries object.
     * 
     * @param countries The Countries object to populate with parsed data
     * @param json      The JSON string containing country data
     */
    public static void setCountries(Countries countries, String json) {
        // Create a JSON reader from the string
        JsonReader jsonReader = Json.createReader(new StringReader(json));

        // Parse the JSON into a tree structure
        JsonStructure jsonTreeStructure = jsonReader.read();

        // Start the recursive navigation of the JSON tree
        navigateTree(countries, jsonTreeStructure);

        // Close the reader when done
        jsonReader.close();
    }

    /**
     * Recursively navigates through the JSON tree structure to extract country
     * information.
     * This method traverses the entire JSON structure, looking for objects that
     * contain both "country_name" and "country_id" fields which represent a
     * complete country entry.
     * 
     * @param countries The Countries object to populate with found country data
     * @param tree      The current JSON value being processed
     */
    public static void navigateTree(Countries countries, JsonValue tree) {
        // Process based on the JSON value type
        JsonValue.ValueType valueType = tree.getValueType();

        if (valueType == JsonValue.ValueType.OBJECT) {
            // Process JSON objects
            JsonObject object = (JsonObject) tree;

            // Check if this object directly represents a country
            // (has both required country fields)
            if (object.containsKey("country_name") && object.containsKey("country_id")) {
                String name = object.getString("country_name");
                String iso2Code = object.getString("country_id");

                // Only add countries with valid data
                if (!name.isEmpty() && !iso2Code.isEmpty()) {
                    countries.addCountry(name, iso2Code);
                }
            } else {
                // This object doesn't directly represent a country,
                // so continue searching by processing all its key-value pairs
                for (String key : object.keySet()) {
                    navigateTree(countries, object.get(key));
                }
            }
        } else if (valueType == JsonValue.ValueType.ARRAY) {
            // Process JSON arrays
            // For arrays, process each element recursively
            JsonArray array = (JsonArray) tree;
            for (JsonValue arrayValue : array) {
                navigateTree(countries, arrayValue);
            }
        } else {
            // Handle primitive types (STRING, NUMBER, TRUE, FALSE, NULL)
            // No processing needed for these types as we're only interested
            // in objects that contain country data
            System.out.println();
        }
    }
}