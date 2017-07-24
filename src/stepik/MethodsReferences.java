package stepik;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodsReferences {
    public static void main(String[] args) {
        //reference to a static method
        Function<Double, Double> sqrt = Math::sqrt;

        //reference to a non-static method
        BiFunction<Double, Double, Double> multip = Math::atan2;

        //reference to a constructor of String class
        Supplier<String> generator = String::new;
        // equalent
        Supplier<String> generatorEq = () -> new String();
    }

}
