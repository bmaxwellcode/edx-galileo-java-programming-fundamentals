package week5.exercises.lifeexpectancybycountry.CountriesExercise;

/**
 * The Country class represents a country with its associated data.
 * This class stores information about a country including its name, region,
 * income level, ISO2 code, and life expectancy.
 */
public class Country {
    private String name;
    private String region;
    private String incomeLevel;
    private String iso2code;
    private Double lifeExpectancy;

    /**
     * Constructs a new Country with the specified name and ISO2 code.
     * Other attributes (region, income level, life expectancy) are initially null
     * and can be set using the appropriate setter methods.
     *
     * @param name     The name of the country
     * @param iso2code The ISO 3166-1 alpha-2 code of the country (two-letter code)
     */
    public Country(String name, String iso2code) {
        this.name = name;
        this.iso2code = iso2code;
    }

    /**
     * Gets the name of the country.
     *
     * @return The country name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ISO 3166-1 alpha-2 code of the country.
     *
     * @return The two-letter country code
     */
    public String getIso2Code() {
        return iso2code;
    }

    /**
     * Sets the region for this country.
     *
     * @param region The region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Sets the income level for this country.
     *
     * @param incomeLevel The income level to set
     */
    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    /**
     * Sets the life expectancy for this country.
     *
     * @param lifeExpectancy The life expectancy value in years
     */
    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Generates a formatted string representation of this country's data for
     * reporting.
     * Missing values (null) are represented by a "-" character.
     *
     * @return A comma-separated string with the country's name, region, income
     *         level, and life expectancy
     */
    public String getReportRow() {
        return name + ", "
                + (region != null ? region : "-")
                + ", " + (incomeLevel != null ? incomeLevel : "-") + ", "
                + (lifeExpectancy != null ? lifeExpectancy : "-") + "\n";
    }
}
