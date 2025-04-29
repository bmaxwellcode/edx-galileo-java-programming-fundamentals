package week4.lessons.lambdas;

/**
 * This class demonstrates various ways to implement functional interfaces in
 * Java,
 * contrasting traditional pre-Java 8 approaches with modern lambda expressions.
 */
public class Main {

    // A functional interface is an interface with exactly one abstract method.
    // This allows us to treat the interface as a function and implement it using
    // different syntaxes - traditional anonymous classes, lambda expressions, or
    // method references.

    /**
     * Demonstrates the traditional pre-Java 8 approach using anonymous inner
     * classes
     * to implement a functional interface.
     */
    private void demonstrateTraditionalApproach() {
        // Traditional approach: create an anonymous class that implements the interface
        final MyFunctionalInterface implementation = new MyFunctionalInterface() {
            @Override
            public void doSomething(String text) {
                System.out.println(text);
            }
        };
        implementation.doSomething("Hello in the traditional way");
    }

    /**
     * Demonstrates Java 8+ approach using lambda expressions to implement
     * the same functionality with much less boilerplate code.
     */
    private void demonstrateLambdaApproaches() {
        // Lambda expression with explicit parameter type
        final MyFunctionalInterface explicitTypeLambda = (String text) -> System.out.println(text);

        // Lambda expression with inferred parameter type (more concise)
        final MyFunctionalInterface implicitTypeLambda = text -> System.out.println(text);

        // Multi-line lambda expression with a code block
        final MyFunctionalInterface complexLambda = text -> {
            System.out.println("Beginning complex lambda execution");
            System.out.println(text);
            System.out.println("Ending complex lambda execution");
        };

        // Demonstrate different lambda implementations
        explicitTypeLambda.doSomething("Using explicit parameter type");
        implicitTypeLambda.doSomething("Using type inference");
        complexLambda.doSomething("Using multi-line lambda block");

        // Demonstrate higher-order function with lambda
        processWithBehavior(complexLambda);
    }

    /**
     * Higher-order function that accepts a functional interface as a parameter.
     * This demonstrates how behavior can be passed as an argument.
     * 
     * @param behavior The implementation of MyFunctionalInterface to execute
     */
    private void processWithBehavior(final MyFunctionalInterface behavior) {
        behavior.doSomething("Processing with provided behavior");
    }

    /**
     * Main method demonstrating different ways to use functional interfaces.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        final Main demo = new Main();

        // Method reference example
        final MyFunctionalInterface methodReference = System.out::println;

        // Custom lambda implementation
        final MyFunctionalInterface customBehavior = text -> {
            final String modifiedText = "Processing: " + text;
            System.out.println(modifiedText);
            System.out.println("Custom behavior executed successfully");
        };

        // Demonstrate different approaches
        demo.demonstrateTraditionalApproach();
        System.out.println();

        demo.demonstrateLambdaApproaches();
        System.out.println();

        System.out.println("Using method reference:");
        demo.processWithBehavior(methodReference);
        System.out.println();

        System.out.println("Using custom behavior:");
        demo.processWithBehavior(customBehavior);
    }
}
