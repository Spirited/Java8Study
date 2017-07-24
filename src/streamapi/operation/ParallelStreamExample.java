package streamapi.operation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by spirited on 04.07.2017.
 */
public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        int sum = numbers.parallelStream().filter(n->n % 2 == 1).map(n -> n*n).reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
