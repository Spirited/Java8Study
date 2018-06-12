package concurrency.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {
    private Integer n;

    private FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if ( n <= 1 ) {
            return n;
        }

        FactorialSquareCalculator factorialSquareCalculator = new FactorialSquareCalculator(n);

        factorialSquareCalculator.fork();

        return n * n + factorialSquareCalculator.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);
        pool.execute(calculator);
    }
}
