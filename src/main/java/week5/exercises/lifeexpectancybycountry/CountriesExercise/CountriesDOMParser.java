package week5.exercises.lifeexpectancybycountry.CountriesExercise;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * DOM Parser for extracting life expectancy data from XML
 * and updating the Countries object.
 * This class uses the Document Object Model (DOM) approach to parse XML data
 * containing life expectancy information from the World Bank API.
 */
public class CountriesDOMParser {

    /**
     * Sets the life expectancy for countries based on XML data.
     * 
     * @param countries The Countries object to update with life expectancy data
     * @param xml       The XML data containing life expectancy information
     * @throws Exception If an error occurs during parsing
     */
    public static void setLifeExpectancy(Countries countries, String xml) throws Exception {
        if (xml == null || xml.isEmpty()) {
            System.err.println("XML data is null or empty");
            return;
        }

        // Removing the first blank space
        xml = xml.substring(1, xml.length());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Error parsing life expectancy XML: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Iterating through the nodes list and extracting the data
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            // Get the current node
            Node node = nodeList.item(i);

            // Check if the current node is an element
            if (node instanceof Element) {
                NodeList childNodes = node.getChildNodes();
                String countryCode = null;

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);

                    // We only care about element nodes with content
                    if (childNode instanceof Element) {
                        Element element = (Element) childNode;
                        if (childNode.getLastChild() != null) {
                            String nodeName = element.getNodeName();

                            if ("wb:country".equals(nodeName)) {
                                // Extract country code directly using getAttribute
                                countryCode = element.getAttribute("id");

                                // Only proceed if we got a non-empty country code
                                if (countryCode.isEmpty()) {
                                    countryCode = null; // Reset to null if empty
                                }
                            } else if ("wb:value".equals(nodeName) && countryCode != null) {
                                // Process life expectancy value if country code exists
                                if (countries.getIndexOfCountryByIso2Code(countryCode) != -1) {
                                    String lifeExpectancyValue = element.getTextContent().trim();

                                    if (!lifeExpectancyValue.isEmpty()) {
                                        // Add life expectancy to the country
                                        countries.setLifeExpectancy(countryCode, lifeExpectancyValue);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}