package stepik.exersices;

import java.util.function.Function;

public class NextEvenNumberGenerator {
    public static void main(String[] args) {
        Function<Long, Long> nextEvenNumber = (x) -> {
            Long result = ++x;

            while ( result%2 != 0 ) {
                result++;
            }

            return result;
        };

        System.out.println(nextEvenNumber.apply(317L));
    }
}
