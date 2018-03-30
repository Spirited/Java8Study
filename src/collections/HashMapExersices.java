package collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapExersices {
    public static void main(String[] args) throws Exception{
        Object o = new Object();
        HashMap d = new HashMap();

        ThreadLocal<String> f = new ThreadLocal<>();


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        //for ( int i = 0; i < 10; i++ ) {
            SimpleThreadLocalTask simpleThreadLocalTask1 = new SimpleThreadLocalTask(1);
            SimpleThreadLocalTask simpleThreadLocalTask2 = new SimpleThreadLocalTask(200);
            SimpleThreadLocalTask simpleThreadLocalTask3 = new SimpleThreadLocalTask(3);
            Thread thread1 = new Thread(simpleThreadLocalTask1);
            Thread thread2 = new Thread(simpleThreadLocalTask2);
            Thread thread3 = new Thread(simpleThreadLocalTask3);

            thread1.run();
            thread2.run();
            thread3.run();
            //simpleThreadLocalTask.setFieldVariable(i*2);
            thread1.join();
            thread2.join();
            thread3.join();
        //}

//        ExecutorService executor = Executors.newCachedThreadPool();
//
//        for ( int i = 0; i < 5; i++) {
//            executor.submit(new SimpleThreadLocalTask());
//        }
//
//        executor.shutdown();
    }
}

class SimpleThreadLocalTask implements Runnable {
    private ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    private int fieldVariable;

    public SimpleThreadLocalTask(int fieldVariable) {
        this.fieldVariable = fieldVariable;
    }

    @Override
    public void run() {
        int localVariable = (int)(Math.random() * 1000);
        fieldVariable = 2*fieldVariable;
        integerThreadLocal.set(localVariable);

        try {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.err.println("Exception was happened");
        }

        System.out.println(Thread.currentThread().getName() + " thread local variable " + integerThreadLocal.get() + "; field variable " + fieldVariable);
    }

//    public void setFieldVariable(int fieldVariable) {
//        this.fieldVariable = fieldVariable;
//    }
}