package week4.exercises.playground;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* 
* standard Java functional interfaces include:
 * Function<T,R> - takes one argument
 * BiFunction<T,U,R> - takes two arguments
 * Consumer<T> - takes one argument, returns nothing
 * BiConsumer<T,U> - takes two arguments, returns nothing
 * Predicate<T> - takes one argument, returns boolean
 * Supplier<T> - takes no arguments, returns a value
 */

/**
 * A playground for testing and demonstrating Java lambda expressions and
 * functional interfaces.
 * 
 * This class provides examples of various functional interfaces and lambda
 * expressions,
 * including custom functional interfaces like TriFunction and BiPredicate.
 */
public class LambdaTestPlayground {
    /**
     * Represents a function that takes three arguments and returns a result.
     * 
     * @param <A> The type of the first argument
     * @param <B> The type of the second argument
     * @param <C> The type of the third argument
     * @param <R> The type of the result
     */
    @FunctionalInterface
    interface TriFunction<A, B, C, R> {
        /**
         * Applies this function to the given arguments.
         *
         * @param a the first function argument
         * @param b the second function argument
         * @param c the third function argument
         * @return the function result
         */
        R apply(A a, B b, C c);
    }

    /**
     * Represents a predicate (boolean-valued function) of two arguments.
     *
     * @param <T> the type of the first argument to the predicate
     * @param <U> the type of the second argument to the predicate
     */
    @FunctionalInterface
    interface BiPredicate<T, U> {
        /**
         * Evaluates this predicate on the given arguments.
         *
         * @param t the first input argument
         * @param u the second input argument
         * @return true if the input arguments match the predicate, otherwise false
         */
        boolean test(T t, U u);
    }

    /**
     * Main method demonstrating various lambda expressions and functional
     * interfaces.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int a = 37;
        int b = 2;
        int c = 42;
        String d = "Hello";
        String e = "Java 8";

        // (a, b, c) -> a*b+c
        TriFunction<Integer, Integer, Integer, Integer> expr1 = (x, y, z) -> x * y + z;
        System.out.println(expr1.apply(a, b, c)); // 116

        // (d, e) -> System.out.println(d + " " + e)
        BiConsumer<String, String> expr2 = (x, y) -> System.out.println(x + " " + y);
        expr2.accept(d, e); // Hello Java 8

        // a -> a%2 != 0
        Predicate<Integer> expr3 = x -> x % 2 != 0;
        System.out.println(expr3.test(a)); // true

        // () -> 999;
        Supplier<Integer> exp4 = () -> 999;
        System.out.println(exp4.get());

        // (e, d) -> e.compareTo(d)
        BiFunction<String, String, Integer> exp5 = (y, x) -> y.compareTo(x);
        System.out.println(exp5.apply("Java 8", "Hello"));
        // System.out.println(e.compareTo(d));

        // (b, c) -> b > c
        BiPredicate<Integer, Integer> exp6 = (x, y) -> x > y;
        System.out.println(exp6.test(b, c));

        // d.toUpperCase()???
        // Why not (d) -> d.toUpperCase(), if so would be:
        Function<String, String> exp7 = (x) -> x.toUpperCase();
        System.out.println(exp7.apply(d));

        // (d,e) -> d.length() + e.length()
        BiFunction<String, String, Integer> exp8 = (x, y) -> x.length() + y.length();
        System.out.println(exp8.apply(d, e));
    }
}
