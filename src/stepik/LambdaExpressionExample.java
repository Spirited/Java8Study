package stepik;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;

        // if the only one argument
        Function<Integer, Integer> identity = x -> x;

        // without type inference
        Function<Integer, Integer> mult = (Integer x) -> x*2;

        // with multiple statements
        Function<Integer, Integer> adder = (x) -> {
            x += 5;
            x += 10;

            return x;
        };
    }
}
