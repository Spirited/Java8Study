package examples.functional_interfaces.predicate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by spirited on 18.06.2017.
 */
public class CreatePredicateFromReferencesAndMethodsExample {
    public static void main(String[] args) {
        List<Box> inventory = Arrays.asList(new Box(80, "green"),
                                            new Box(155, "green"),
                                            new Box(120, "red"));

        List<Box> greenApples = filter(inventory, CreatePredicateFromReferencesAndMethodsExample::isGreanApple);
        System.out.println(greenApples);

        List<Box> heavyApples = filter(inventory, CreatePredicateFromReferencesAndMethodsExample::isHeavyApple);
        System.out.println(heavyApples);

        List<Box> greenApplesFromLambda = filter(inventory, (Box p)->"green".equals(p.getColor()));
        System.out.println(greenApplesFromLambda);

        List<Box> heavyApplesFromLambda = filter(inventory, (Box p) -> p.getWeight() > 150);
        System.out.println(heavyApplesFromLambda);
    }

    public static boolean isGreanApple(Box apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Box apple) {
        return apple.getWeight() > 150;
    }

    public static List<Box> filter(List<Box> inventory, Predicate<Box> predicate) {
        List<Box> resultList = new ArrayList<>();

        for (Box apple : inventory ) {
            if ( predicate.test(apple) )
                resultList.add(apple);
        }

        return resultList;
    }
}

class Box {
    private int weight = 0;
    private String color = "";

    public Box(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Box{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
