package examples.functional_interfaces.function;

import java.util.function.Function;

/**
 * Created by spirited on 18.06.2017.
 */
public class SimpleExample {
    public static void main(String[] args) {
        //Integer is input type
        //String is output type
        Function<Integer, String> converter = (i) -> Integer.toString(i);

        System.out.println(converter.apply(30).length());
    }
}
