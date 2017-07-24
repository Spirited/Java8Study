package stepik;

import java.util.function.Function;

public class ClosureExample {
    public static void main(String[] args) {
        final String hello = "Hello, ";
        Function<String, String> helloFunction = (name) -> hello + name; //Attention: we are using final variable

        System.out.println(helloFunction.apply("Sergey"));
        System.out.println(helloFunction.apply("Nastya"));

        int constant = 100;
        Function<Integer, Integer> adder = (x) -> x + constant;
        System.out.println(adder.apply(200));
        System.out.println(adder.apply(300));
    }
}
