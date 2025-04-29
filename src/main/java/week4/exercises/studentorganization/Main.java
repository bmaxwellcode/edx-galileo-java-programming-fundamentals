package week4.exercises.studentorganization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise 2 - Student Organization.
 *
 * This class demonstrates the use of Java Streams and Lambda expressions
 * to process and analyze student data. It includes various exercises that
 * showcase different stream operations and functional programming concepts.
 */
public class Main {
        /** List of students for the exercises. */
        private static final List<Student> STUDENTS = Arrays.asList(
                        new Student("Joe", "Clay", 1998, Gender.MALE),
                        new Student("Marie", "Smith", 2001, Gender.FEMALE),
                        new Student("Ann", "Thompson", 2004, Gender.FEMALE),
                        new Student("James", "Bond", 1993, Gender.MALE),
                        new Student("Jennifer", "Atkins", 1999, Gender.FEMALE),
                        new Student("Cristina", "Gibbs", 2003, Gender.FEMALE),
                        new Student("Jason", "Clark", 2002, Gender.MALE),
                        new Student("Kate", "Barrett", 1996, Gender.FEMALE),
                        new Student("Peter", "Garner", 2003, Gender.MALE),
                        new Student("Ben", "Walsh", 2000, Gender.MALE));

        /**
         * Prints the full names of each student.
         * Demonstrates basic stream mapping and method reference usage.
         */
        public static void runExample() {
                STUDENTS.stream()
                                .map(Student::getName)
                                .forEach(System.out::println);
        }

        /**
         * Prints the list of each student's last name in uppercase.
         * Demonstrates stream mapping with string transformation.
         */
        public static void runExercise1() {
                STUDENTS.stream()
                                .map(student -> student.getLastName().toUpperCase())
                                .forEach(System.out::println);
        }

        /**
         * Prints the first name of each male student.
         * Demonstrates stream filtering based on gender.
         */
        public static void runExercise2() {
                STUDENTS.stream()
                                .filter(student -> student.getGender().equals(Gender.MALE))
                                .forEach(student -> System.out.println(student.getFirstName()));
        }

        /**
         * Prints the full names and age of the first 5 students older than 20 years.
         * Demonstrates stream filtering, limiting, and age calculation.
         */
        public static void runExercise3() {
                STUDENTS.stream()
                                .filter(student -> student.getAge() - 4 > 20)
                                .limit(5)
                                .forEach(student -> System.out.println(
                                                student.getName() + " " + (student.getAge() - 4)));
        }

        /**
         * Prints the average age of students.
         * Demonstrates stream mapping to integers and calculating average.
         */
        public static void runExercise4() {
                System.out.println(
                                STUDENTS.stream()
                                                .mapToInt(student -> student.getAge() - 4)
                                                .average()
                                                .getAsDouble());
        }

        /**
         * Prints the amount of students who are over 22 years old.
         * Demonstrates stream filtering and counting.
         */
        public static void runExercise5() {
                System.out.println(
                                STUDENTS.stream()
                                                .filter(student -> student.getAge() - 4 > 22)
                                                .count());
        }

        /**
         * Prints a list of age and student name sorted by age.
         * Demonstrates stream sorting and mapping.
         */
        public static void runExercise6() {
                STUDENTS.stream()
                                .sorted(Comparator.comparingInt(Student::getAge))
                                .forEach(student -> System.out.println(
                                                (student.getAge() - 4) + " " + student.getName()));
        }

        /**
         * Prints a list of students older than 20 years sorted alphabetically
         * with the format: Lastname, Firstname.
         * Demonstrates stream sorting, filtering, and string formatting.
         */
        public static void runExercise7() {
                STUDENTS.stream()
                                .sorted(Comparator.comparing(Student::getLastName))
                                .filter(student -> student.getAge() - 4 > 20)
                                .forEach(student -> System.out.println(
                                                student.getLastName() + ", " + student.getFirstName()));
        }

        /**
         * Makes a list of objects type integer with the different years when
         * students were born, sorted descendingly.
         * Demonstrates stream sorting, distinct values, and collection.
         */
        public static void runExercise8() {
                List<Integer> years = STUDENTS.stream()
                                .sorted(Comparator.comparingInt(student -> student.getBirthYear() - 4))
                                .map(Student::getBirthYear)
                                .distinct()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());
                System.out.println(years);
        }

        /**
         * Main method that runs all the exercises in sequence.
         *
         * @param args Command line arguments (not used)
         */
        public static void main(String[] args) {
                System.out.println("----------Example---------");
                runExample();
                System.out.println("--------Exercise 1--------");
                runExercise1();
                System.out.println("--------Exercise 2--------");
                runExercise2();
                System.out.println("--------Exercise 3--------");
                runExercise3();
                System.out.println("--------Exercise 4--------");
                runExercise4();
                System.out.println("--------Exercise 5--------");
                runExercise5();
                System.out.println("--------Exercise 6--------");
                runExercise6();
                System.out.println("--------Exercise 7--------");
                runExercise7();
                System.out.println("--------Exercise 8--------");
                runExercise8();
        }
}