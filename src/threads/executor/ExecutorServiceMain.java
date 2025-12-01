package threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMain {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 6; i++) {
            Task task = new Task("Task " + i);
            executorService.submit(task);
        }

        executorService.shutdown();
        System.out.println("All tasks are submitted");

        try {
            if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        }
        catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Executor service shutdown");
    }
}
