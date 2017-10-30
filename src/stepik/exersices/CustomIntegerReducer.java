package stepik.exersices;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2.35 Custom integer reducer
 */

public class CustomIntegerReducer {
    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            //(Integer x, IntBinaryOperator y) -> (z,t) -> IntStream.rangeClosed(z,t).reduce(y).getAsInt();
            (seed, combiner) ->
                    (l, r) -> {
                        int acc = seed;
                        for (int el = l; el <= r; el++) {
                            acc = combiner.applyAsInt(acc, el);
                        }
                        return acc;
                    };


    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x,y)->x+y);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x,y)->x*y);

    public static void main(String[] args) {
        //IntBinaryOperator one = reduceIntOperator.apply(1, sumOperator);
        System.out.println(reduceIntOperator.apply(0, sumOperator).applyAsInt(1,4));
        System.out.println(reduceIntOperator.apply(1, productOperator).applyAsInt(5,6));

        System.out.println(sumOperator.applyAsInt(1, 4));
        System.out.println(productOperator.applyAsInt(1,4));
    }
}
