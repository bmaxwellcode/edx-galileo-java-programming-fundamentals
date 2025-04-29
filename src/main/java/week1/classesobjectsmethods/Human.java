package week1.classesobjectsmethods;

import java.time.LocalDate;

/**
 * Represents a human being with basic attributes and relationships.
 * This class models a person with personal information such as name, gender,
 * birth date, and relationships with other humans.
 */
public class Human {
    /** Gender of the human ('F' for female, 'M' for male). */
    private char gender;

    /** First name(s) of the human. */
    private String firstNames;

    /** Last name of the human. */
    private String lastName;

    /** Reference to another Human object representing this human's partner. */
    private Human partner;

    /** Unique identification number for this human. */
    private int identificationNumber;

    /** Year component of birth date. */
    private int yearBirth;

    /** Month component of birth date (1-12). */
    private int monthBirth;

    /** Day component of birth date (1-31). */
    private int dayBirth;

    /**
     * Constructs a new Human with the specified names and gender.
     *
     * @param firstNames The first name(s) of the human
     * @param lastName   The last name of the human
     * @param gender     The gender of the human ('F' for female, 'M' for male)
     */
    public Human(String firstNames, String lastName, char gender) {
        this.firstNames = firstNames;
        this.lastName = lastName;
        this.gender = gender;
    }

    /**
     * Makes the human speak the specified words.
     * This simulates the human saying something by printing the words.
     *
     * @param words The text to be spoken
     */
    public void speak(String words) {
        System.out.println(words);
    }

    /**
     * Establishes a bidirectional partner relationship between this human and
     * another human. This method sets the partner of both this human and the
     * specified human to refer to each other.
     *
     * @param humanCouple The human to establish a partnership with
     * @throws IllegalArgumentException if humanCouple is null
     */
    public void addPartner(Human humanCouple) {
        if (humanCouple == null) {
            throw new IllegalArgumentException("Partner cannot be null");
        }
        this.partner = humanCouple;
        humanCouple.partner = this;
    }

    /**
     * Gets the partner of this human.
     *
     * @return The Human object representing this human's partner, or null if no
     *         partner
     */
    public Human getPartner() {
        return this.partner;
    }

    /**
     * Sets the identification number for this human.
     *
     * @param id The identification number to set
     */
    public void setId(int id) {
        identificationNumber = id;
    }

    /**
     * Gets the identification number of this human.
     *
     * @return The identification number
     */
    public int getId() {
        return identificationNumber;
    }

    /**
     * Sets the birth date of this human.
     *
     * @param yearBirth  The year of birth
     * @param monthBirth The month of birth (1-12, where 1 is January)
     * @param dayBirth   The day of birth (1-31)
     */
    public void setBirthDate(int yearBirth, int monthBirth, int dayBirth) {
        this.monthBirth = monthBirth;
        this.dayBirth = dayBirth;
        this.yearBirth = yearBirth;
    }

    /**
     * Calculates the current age of this human based on the birth date.
     * The calculation accounts for the exact day, month, and year to provide an
     * accurate age, taking into account that a birthday may not have occurred yet
     * in the current year.
     *
     * @return The age in years
     */
    public int getAge() {
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int age = currentYear - yearBirth;

        int currentMonth = today.getMonthValue();
        if (currentMonth < monthBirth) {
            age--;
        } else if (currentMonth == monthBirth) {
            int currentDay = today.getDayOfMonth();
            if (dayBirth > currentDay) {
                age--;
            }
        }

        return age;
    }

    /**
     * Gets the full name of this human's partner.
     *
     * @return The full name of the partner
     * @throws NullPointerException if this human has no partner
     */
    public String getPartnerName() {
        if (this.partner == null) {
            throw new NullPointerException("This human has no partner");
        }
        return this.partner.getFullName();
    }

    /**
     * Gets the gender as a string representation.
     *
     * @return "Male" if gender is 'M', "Female" if gender is 'F'
     */
    public String getGenderString() {
        return gender == 'M' ? "Male" : "Female";
    }

    /**
     * Gets the full name of this human, combining first name(s) and last name.
     *
     * @return The full name as a string
     */
    public String getFullName() {
        return this.firstNames + " " + this.lastName;
    }
}