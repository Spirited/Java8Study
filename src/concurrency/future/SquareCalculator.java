package concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    private Future<Integer> square(Integer input) {
        System.out.println("calculating square for: " + input);
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    private ExecutorService getExecutor() {
        return executor;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SquareCalculator calculator = new SquareCalculator();

        Future<Integer> future1 = calculator.square(10);
        Future<Integer> future2 = calculator.square(100);

        while ( !(future1.isDone() && future2.isDone()) ) {
            System.out.println(
                    String.format("future1 is %s and future2 is %s",
                            future1.isDone() ? "Done" : "not done",
                            future2.isDone() ? "Done" : "not done")
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        calculator.getExecutor().shutdown();
    }
}
