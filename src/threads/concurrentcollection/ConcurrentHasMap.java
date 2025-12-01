package threads.concurrentcollection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHasMap {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Map<String, String> result = new ConcurrentHashMap<>();

        for (int i = 0; i < 5; i++) {
            String taskName = "task " + i;

            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();

                System.out.println(taskName + " is handled by " + threadName);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                result.put(taskName, "Completed by :" + threadName);
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Task Result: ");
        result.forEach((task, desc) -> {
            System.out.println(task + ": " + desc);
        });
    }
}
