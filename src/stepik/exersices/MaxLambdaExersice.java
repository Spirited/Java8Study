package stepik.exersices;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MaxLambdaExersice {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> maxInt = (x, y) -> {
            if ( x > y )
                return x;
            else
                return y;
        };

        System.out.println(maxInt.apply(10,5));
    }
}
