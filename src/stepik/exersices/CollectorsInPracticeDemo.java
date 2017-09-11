package stepik.exersices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CollectorsInPracticeDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2));
        long val = numbers.stream().collect(Collectors.reducing(1, (a,  b) -> a*b));
        System.out.println(val);
    }
}
