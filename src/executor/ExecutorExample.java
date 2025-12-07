package executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void show() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            var future = executorService.submit(() -> {
                LongTask.simulate();

                return 1;
            });

            System.out.println("Do another operations...");

            try {
                var result = future.get();
                System.out.println("Result: " + result);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
