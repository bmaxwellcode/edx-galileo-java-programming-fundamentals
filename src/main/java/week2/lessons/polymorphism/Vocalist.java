package main2.week2.lessons.polymorphism;

/**
 * Vocalist interface defines the basic functionality required for singers.
 * 
 * This interface demonstrates a simple contract that classes must implement
 * if they represent an entity that can sing. It contains a single abstract
 * method that implementing classes must provide.
 */
public interface Vocalist {
    /**
     * Makes the vocalist sing.
     * Implementing classes must provide their own implementation of this method.
     */
    void sing();
}
