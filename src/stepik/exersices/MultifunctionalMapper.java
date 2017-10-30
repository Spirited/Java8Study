package stepik.exersices;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2.34 Multifunctional mapper
 */
public class MultifunctionalMapper {
    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
            intUnaryOperators -> operators -> operators.stream().collect(Collectors.toList());
    public static  UnaryOperator<List<Integer>> identityTransformation = multifunctionalMapper.apply(Arrays.asList(x->x, x->x, x->x));
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
            multifunctionalMapper.apply(Arrays.asList(x->2*x, x->2*x+1, x->2*x));
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
            multifunctionalMapper.apply(Arrays.asList(x->x*x, x->x*x, x->x*x));

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(1,1,1);

//        System.out.println(identityTransformation.apply(list));
//        System.out.println(multTwoAndThenAddOneTransformation.apply(list));
//        System.out.println(squareAndThenGetNextEvenNumberTransformation.apply(list));

        System.out.println();

        UnaryOperator<Integer> sample = x -> x+1;
        System.out.println(sample.apply(1));

//        UnaryOperator<List<Integer>> sample2 = x -> { for (int i = 0; i < x.size(); i++) {
//            x.set(i, 2*x.get(i));
//        } return x;};
//
//        System.out.println(sample2.apply(list));

        Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> temp = intUnaryOperators -> x -> {
            List<Integer> temp2 = new ArrayList<>(x);

            for ( int j = 0; j < intUnaryOperators.size(); j++ ) {
                for (int i = 0; i < temp2.size(); i++) {
                    temp2.set(i, intUnaryOperators.get(j).applyAsInt(temp2.get(i)));
                }
            }
            return temp2;
        };

        identityTransformation = temp.apply(Arrays.asList(x->2*x, x->x+1));
        System.out.println(identityTransformation.apply(list2));

        identityTransformation = temp.apply(Arrays.asList(x->x*x, x -> {if ( ((x+1) % 2) == 0 )
                                                                            return x+1;
                                                                        else
                                                                            return x+2;
                                                                        }));
        System.out.println(identityTransformation.apply(list2));
    }
}