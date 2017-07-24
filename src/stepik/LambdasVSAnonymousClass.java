package stepik;

import java.util.concurrent.Callable;

public class LambdasVSAnonymousClass {
    public static void main(String[] args) {
        Callable<Integer> anonymosCallableInstance = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10;
            }
        };

        Callable<Integer> lambdaInstance = () -> 10;
    }
}
