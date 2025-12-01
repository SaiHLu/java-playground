package threads.future_callable;

import java.util.concurrent.*;

public class FutureCallable {
    static void main() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            String threadName = Thread.currentThread().getName();

            System.out.println("Start processing task1...");
            Thread.sleep(1000);

            return "Result: " + threadName;
        };

        Callable<String> task2 = () -> {
            String threadName = Thread.currentThread().getName();

            System.out.println("Start processing task2...");
            Thread.sleep(1000);

            return "Result: " + threadName;
        };

        Callable<String> task3 = () -> {
            String threadName = Thread.currentThread().getName();

            System.out.println("Start processing task3...");
            Thread.sleep(1000);

            return "Result: " + threadName;
        };

        Future<String> task1Result = executorService.submit(task1);
        Future<String> task2Result = executorService.submit(task2);
        Future<String> task3Result = executorService.submit(task3);

        executorService.shutdown();
        System.out.println("Main thread is running...");
        String task1Res = task1Result.get();
        System.out.println("Thread Result: " + task1Res);
        String task2Res = task2Result.get();
        System.out.println("Thread Result: " + task2Res);
        String task3Res = task3Result.get();
        System.out.println("Thread Result: " + task3Res);
    }
}
