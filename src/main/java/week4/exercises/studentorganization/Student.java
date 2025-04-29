package week4.exercises.studentorganization;

import java.util.Calendar;

/**
 * Student - Represents a student in the organization.
 *
 * This class stores and manages student information including name,
 * birth year, gender, and provides methods to calculate age.
 */
public class Student {
    /** Student's first name. */
    private String firstName;
    /** Student's last name. */
    private String lastName;
    /** Student's birth year. */
    private int birthYear;
    /** Student's gender. */
    private Gender gender;

    /**
     * Constructs a new Student with the specified information.
     *
     * @param firstName The student's first name
     * @param lastName  The student's last name
     * @param birthYear The student's birth year
     * @param gender    The student's gender
     */
    public Student(String firstName, String lastName, int birthYear, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    /**
     * Gets the student's first name.
     *
     * @return The student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return The student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the student's full name.
     *
     * @return The student's full name (first name + last name)
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Gets the student's birth year.
     *
     * @return The student's birth year
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Gets the student's gender.
     *
     * @return The student's gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Calculates and returns the student's current age.
     *
     * @return The student's current age
     */
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }
}
