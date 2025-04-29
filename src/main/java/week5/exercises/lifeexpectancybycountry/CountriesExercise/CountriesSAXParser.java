package week5.exercises.lifeexpectancybycountry.CountriesExercise;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.StringReader;

/**
 * This class uses the SAX (Simple API for XML) parser to extract country
 * information from XML data provided by the World Bank API.
 * It updates the Countries object with region and income level information.
 */
public class CountriesSAXParser {

    /**
     * Parses XML content and updates a Countries object with region and income
     * level data.
     * The XML is expected to be in the World Bank API format.
     * 
     * @param countries The Countries object to update with the parsed information
     * @param xml       The XML string containing country data from World Bank
     */
    public static void setWorldBankData(Countries countries, String xml) {
        if (xml == null || xml.isEmpty()) {
            System.err.println("XML data is null or empty");
            return;
        }

        // Removing the first blank space
        xml = xml.substring(1, xml.length());
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        SAXHandler handler = new SAXHandler(countries);

        try {
            parser = parserFactory.newSAXParser();
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (ParserConfigurationException e) {
            System.err.println("Error configuring SAX parser: " + e.getMessage());
            e.printStackTrace();
        } catch (SAXException e) {
            System.err.println("Error during SAX parsing: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error during parsing: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error during XML parsing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/**
 * Handler class for processing SAX parsing events.
 * This handler extracts ISO2 codes, regions, and income levels from the XML
 * and updates the Countries object accordingly.
 */
class SAXHandler extends DefaultHandler {
    private Countries countries;
    private String iso2Code = "";
    private String elementValue = null;
    private final StringBuilder contentBuilder = new StringBuilder();

    /**
     * Constructs a new SAXHandler with the specified Countries object.
     * 
     * @param countries The Countries object to update with parsed data
     */
    public SAXHandler(Countries countries) {
        if (countries == null) {
            throw new IllegalArgumentException("Countries object cannot be null");
        }
        this.countries = countries;
    }

    /**
     * Called at the start of an XML element.
     * Resets the content builder to prepare for new element content.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Reset the builder at the start of each element
        contentBuilder.setLength(0);
    }

    /**
     * Called when character data is found within an element.
     * Accumulates the character data in the content builder.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Append the characters to the builder
        contentBuilder.append(ch, start, length);
    }

    /**
     * Called at the end of an XML element.
     * Processes the accumulated content based on the element name (qName).
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Get the complete content at the end of the element
        elementValue = contentBuilder.toString().trim();

        switch (qName) {
            case "wb:iso2Code":
                if (!elementValue.isEmpty()) {
                    iso2Code = elementValue;
                }
                break;

            case "wb:region":
                if (!iso2Code.isEmpty() && !elementValue.isEmpty()) {
                    countries.setRegion(iso2Code, elementValue);
                }
                break;

            case "wb:incomeLevel":
                if (!iso2Code.isEmpty() && !elementValue.isEmpty()) {
                    countries.setIncomeLevel(iso2Code, elementValue);
                }
                break;

            default:
                // No action needed for other elements
                break;
        }
    }
}
