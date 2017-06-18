package examples.functional_interfaces.function;

import java.util.function.Function;

/**
 * Created by spirited on 18.06.2017.
 */
public class FunctionAndThenExample {
    public static void main(String[] args) {
        Function<Integer, String> intToStringConverter = (i) -> Integer.toString(i);
        Function<String, Integer> stringToIntConverter = s -> Integer.parseInt(s);

        System.out.println(intToStringConverter.apply(25).length());
        System.out.println(intToStringConverter.andThen(stringToIntConverter).apply(78).byteValue());
    }
}
