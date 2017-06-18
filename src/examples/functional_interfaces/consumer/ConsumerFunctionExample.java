package examples.functional_interfaces.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by spirited on 18.06.2017.
 */
public class ConsumerFunctionExample {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (integer) -> System.out.print(" " + integer);
        Consumer<Integer> consumerWithAndThen = consumer.andThen(integer -> System.out.println("(printed "+integer+")"));

        Runnable task = () -> System.out.println("My task");

        new Thread(task).start();

        new Thread( () -> System.out.println("Second task")).start();

        List<Integer> integerList = Arrays.asList(  new Integer(1),
                                                    new Integer(10), new Integer(200),
                                                    new Integer(101), new Integer(-10),
                                                    new Integer(0));
        printList(integerList, consumerWithAndThen);
    }

    public static void printList(List<Integer> listOfInteger, Consumer<Integer> consumer) {
        for ( Integer i : listOfInteger ) {
            consumer.accept(i);
        }
    }
}
