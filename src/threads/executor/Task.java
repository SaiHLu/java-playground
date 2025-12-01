package threads.executor;

public class Task implements Runnable{
    private String taskName;

    public Task(String name) {
        taskName = name;
    }

    @Override
    public void run() {
        System.out.println("Task: " + taskName + " is started and handled by: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
            System.out.println(taskName + " is completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
