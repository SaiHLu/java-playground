package threads;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Create Thread with runnable. Thread is started");
    }
}
