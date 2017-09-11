package stepik.exersices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SumOddExample {
    public static void main(String[] args) {
        long start = 21;
        long end = 30;
        long res = LongStream.rangeClosed(start, end).filter(value -> value % 2 != 0 ).reduce( 0, (acc, elem) -> acc + elem);
        System.out.println(res);

        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        List<Integer> generated = numbers.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());
        generated.forEach(System.out::println);


    }
}
