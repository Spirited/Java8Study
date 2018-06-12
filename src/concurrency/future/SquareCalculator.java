package concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private Future<Integer> square(Integer input) {
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
        Future<Integer> future = calculator.square(10);

        while ( !future.isDone() ) {
            System.out.println("Calculation...");
            Thread.sleep(300);
        }

        System.out.println(future.get());
        calculator.getExecutor().shutdown();
    }
}
