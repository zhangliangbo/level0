package xxl.mathematica.function;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 */

public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);
}