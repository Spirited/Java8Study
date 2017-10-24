package stepik.exersices;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;

public class ProductOfSquareCollectors {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2);
        int identity = numbers.get(0);

        long val = numbers.stream().map(x->x*x).collect(reducing(numbers.get(0), Math::multiplyExact));
        System.out.println(val);


        Function<Integer, Integer> mapper = (Integer x) -> x*x;
        BinaryOperator<Integer> op = (Integer a, Integer b) -> Math.multiplyExact(a*a,b*b);
        long asd = numbers
                .stream()
                .collect(reducing(numbers.get(0)*numbers.get(0), (Integer x) -> x, (Integer a, Integer b) -> Math.multiplyExact(a,b)));
        System.out.println(asd);



        numbers.stream().collect(reducing(op));
        System.out.println(numbers.stream().collect(reducing((Integer a, Integer b) -> Math.multiplyExact(a*a,b*b))).get());

        long res = numbers.stream().collect(reducing(1, (Integer x) -> x*x, (Integer a, Integer b) -> Math.multiplyExact(a,b)));
        System.out.println("res = " + res);
//        boxSupplier(identity);
//        BiConsumer<Integer, Integer> accumulator = (a, t) -> { a[0] = op.apply(a[0], mapper.apply(t)); };
//        BinaryOperator<Integer> combiner = (a, b) -> { a[0] = op.apply(a[0], b[0]); return a; };
    }

    private static <T> Supplier<T[]> boxSupplier(T identity) {
        return () -> (T[]) new Object[] { identity };
    }
}
