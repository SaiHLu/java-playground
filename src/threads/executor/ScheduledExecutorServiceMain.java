package threads.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMain {
    static void main() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 6; i++) {
            Task task = new Task("Task " + i);
            scheduledExecutorService.schedule(task, 2, TimeUnit.SECONDS);
        }

//        start execute the task every 5s(period) and doesn't wait the previous tasks are done or not
        scheduledExecutorService.scheduleAtFixedRate(
                new Task("Fixed Rate Task"),
                1,
                5,
                TimeUnit.SECONDS);

//        if the first task completes at 2s after the execution start(initial delay),
//        the second task won't wait until 5s(delay) and start the next task immediately
        scheduledExecutorService.scheduleWithFixedDelay(new Task("Fixed Delay Task"), 1, 5, TimeUnit.SECONDS);


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        scheduledExecutorService.shutdown();

        System.out.println("ScheduledExecutorService shutdown.");
    }
}
