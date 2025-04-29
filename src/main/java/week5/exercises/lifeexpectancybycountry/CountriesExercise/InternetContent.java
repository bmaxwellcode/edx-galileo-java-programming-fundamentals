package week5.exercises.lifeexpectancybycountry.CountriesExercise;

import java.io.*;
import java.net.*;

/**
 * Utility class for retrieving content from web APIs.
 * This class provides methods to fetch data from internet resources
 * using HTTP connections.
 */
public class InternetContent {

    /**
     * Retrieves the content from a specified URL as a string.
     * This method establishes a connection to the provided URL, reads its
     * content using a BufferedReader, and returns the entire content as a string.
     * 
     * @param url The URL to retrieve content from
     * @return The content of the URL as a string
     * @throws IOException          If an I/O error occurs while reading from the
     *                              URL
     * @throws URISyntaxException   If the URL string is not properly formatted
     * @throws NullPointerException If the URL parameter is null
     */
    public static String get(String url) throws IOException, URISyntaxException {
        if (url == null) {
            throw new IllegalArgumentException("URL cannot be null");
        }

        // Use URI for better URL parsing and handling of special characters
        URI uri = new URI(url);
        URL urlLink = uri.toURL();

        // Create a connection to the URL
        URLConnection urlConnection = urlLink.openConnection();

        // Set reasonable timeout values to prevent hanging
        urlConnection.setConnectTimeout(10000); // 10 seconds
        urlConnection.setReadTimeout(30000); // 30 seconds

        StringBuilder contentBuilder = new StringBuilder();

        // Use try-with-resources to ensure proper resource cleanup
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()))) {

            String line;
            // Read the content line by line
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line);
            }
        } catch (IOException e) {
            throw new IOException("Failed to retrieve content from URL: " + url, e);
        }

        return contentBuilder.toString();
    }
}
