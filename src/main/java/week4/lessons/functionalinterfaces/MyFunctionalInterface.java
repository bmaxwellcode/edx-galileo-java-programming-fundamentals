package week4.lessons.functionalinterfaces;

/**
 * A functional interface that defines a simple operation on a text string.
 * This interface can be used with lambda expressions to implement custom text
 * processing behavior.
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    /**
     * Performs an operation on the given text.
     *
     * @param text The text to process
     */
    void doSomething(String text);
}