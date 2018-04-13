package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by spirited on 18.06.2017.
 */
public class WorkingWithFunction {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();

        for ( T s : list ) {
            result.add(f.apply(s));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = map(Arrays.asList("Java", "C++", "Cobol", "C#", "Go", "Cobol", "Spark"), (String s) -> s.length());

        System.out.println(list);
    }
}
