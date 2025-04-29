package week5.exercises.lifeexpectancybycountry.CountriesExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * The Countries class manages a collection of Country objects and provides
 * operations to manipulate and report on country data.
 * This class serves as the central data repository for the country information
 * collected from various data sources (JSON, XML).
 */
public class Countries {
    private List<Country> countries;

    /**
     * Constructs a new Countries object with an empty list of countries.
     */
    public Countries() {
        countries = new ArrayList<>();
    }

    /**
     * Adds a new country to the collection with the specified name and ISO2 code.
     *
     * @param name     The name of the country
     * @param iso2code The ISO 3166-1 alpha-2 code of the country (two-letter code)
     */
    public void addCountry(String name, String iso2code) {
        if (name == null || iso2code == null) {
            System.err.println("Cannot add country with null name or ISO2 code");
            return;
        }

        Country newCountry = new Country(name, iso2code);
        countries.add(newCountry);
    }

    /**
     * Finds the index of a country in the collection by its ISO2 code.
     *
     * @param iso2code The ISO 3166-1 alpha-2 code to search for
     * @return The index of the country in the collection, or -1 if not found
     */
    public int getIndexOfCountryByIso2Code(String iso2code) {
        if (iso2code == null) {
            return -1;
        }

        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getIso2Code().equals(iso2code)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Sets the region for a country identified by its ISO2 code.
     *
     * @param iso2code The ISO 3166-1 alpha-2 code of the country
     * @param region   The region to set for the country
     */
    public void setRegion(String iso2code, String region) {
        if (iso2code == null) {
            return;
        }

        int index = getIndexOfCountryByIso2Code(iso2code);
        if (index != -1) {
            countries.get(index).setRegion(region);
        }
    }

    /**
     * Sets the income level for a country identified by its ISO2 code.
     *
     * @param iso2code    The ISO 3166-1 alpha-2 code of the country
     * @param incomeLevel The income level to set for the country
     */
    public void setIncomeLevel(String iso2code, String incomeLevel) {
        if (iso2code == null) {
            return;
        }

        int index = getIndexOfCountryByIso2Code(iso2code);
        if (index != -1) {
            countries.get(index).setIncomeLevel(incomeLevel);
        }
    }

    /**
     * Sets the life expectancy for a country identified by its ISO2 code.
     * If the life expectancy string cannot be parsed as a double, no changes are
     * made.
     *
     * @param iso2code       The ISO 3166-1 alpha-2 code of the country
     * @param lifeExpectancy The life expectancy value as a string
     */
    public void setLifeExpectancy(String iso2code, String lifeExpectancy) {
        if (iso2code == null || lifeExpectancy == null) {
            return;
        }

        int index = getIndexOfCountryByIso2Code(iso2code);
        if (index != -1) {
            try {
                Double lifeExp = Double.parseDouble(lifeExpectancy);
                countries.get(index).setLifeExpectancy(lifeExp);
            } catch (NumberFormatException e) {
                System.err.println("Could not parse life expectancy value for "
                        + iso2code + ": " + lifeExpectancy);
            }
        }
    }

    /**
     * Generates a report of all countries with their details.
     * The report includes each country's name, region, income level, and life
     * expectancy.
     * Missing data is represented by a "-" character.
     *
     * @return A formatted string containing the country report
     */
    public String report() {
        StringBuilder str = new StringBuilder();
        str.append("Country, Region, Income Level, Life Expectancy\n");

        for (Country country : countries) {
            str.append(country.getReportRow());
        }

        return str.toString();
    }

    /**
     * Prints information about a specific country by its index in the collection.
     * This method is primarily used for testing purposes.
     *
     * @param idx The index of the country in the collection
     */
    public void printCountryInfo(int idx) {
        if (idx >= 0 && idx < countries.size()) {
            System.out.println(countries.get(idx).getReportRow());
        } else {
            System.err.println("Invalid country index: " + idx);
        }
    }
}
