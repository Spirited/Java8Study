package stepik.exersices;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FactorialDemo {
    public static void main(String[] args) {
        int num = 5;
        long fact = LongStream.iterate(1, val -> val + 1).limit(num).reduce(1, (acc, elem) -> acc * elem);
        System.out.println(fact);
    }
}
