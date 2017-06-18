package examples.functional_interfaces.predicate;

import java.util.function.Predicate;

/**
 * Created by spirited on 18.06.2017.
 */
public class SimpleExample {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = (s) -> s.length() > 5;

        System.out.println(stringPredicate.test("ten letters"));
    }
}
