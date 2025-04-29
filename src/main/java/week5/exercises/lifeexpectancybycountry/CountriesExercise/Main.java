package week5.exercises.lifeexpectancybycountry.CountriesExercise;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    /**
     * The application entry point.
     * 
     * Retrieves data from various web API endpoints, parses the data,
     * integrates it into a unified country database, and generates a report.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define API endpoints for data retrieval
        final String COUNTRY_BASE_URL = "http://vocab.nic.in/rest.php/country/json";
        final String COUNTRY_INFO_URL = "http://api.worldbank.org/v2/countries"
                + "/?format=xml&per_page=304";
        final String LIFE_EXPECTANCY_URL = "http://api.worldbank.org/"
                + "v2/countries/all/indicators/SP.DYN.LE00.IN/?format=xml&date=2014&per_page=264";

        try {
            // Step 1: Retrieve data from web APIs
            System.out.println("Retrieving country base data...");
            String countryJsonData = InternetContent.get(COUNTRY_BASE_URL);

            System.out.println("Retrieving country information data...");
            String countryXmlData = InternetContent.get(COUNTRY_INFO_URL);

            System.out.println("Retrieving life expectancy data...");
            String lifeExpectancyXmlData = InternetContent.get(LIFE_EXPECTANCY_URL);

            // Step 2: Parse and integrate data
            System.out.println("Processing and integrating data...");
            Countries countries = new Countries();

            // Parse JSON data for country names and ISO codes
            CountriesJSONParser.setCountries(countries, countryJsonData);

            // Parse XML data for region and income level
            CountriesSAXParser.setWorldBankData(countries, countryXmlData);

            // Parse XML data for life expectancy
            CountriesDOMParser.setLifeExpectancy(countries, lifeExpectancyXmlData);

            // Step 3: Generate and display report
            System.out.println("\nCountry Life Expectancy Report:");
            System.out.println("-------------------------------");
            System.out.println(countries.report());

        } catch (IOException e) {
            System.err.println("Error connecting to data source: " + e.getMessage());
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.err.println("Invalid URL format: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
