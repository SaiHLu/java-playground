package threads.synchronization;

public class VolatileExample {
//    'volatile' make sure whenever the variable changes happen, all threads will notice the changes.
    private volatile boolean running = true;

    public void stopRunning() {
        running = false;
    }

    public void run() {
        while(running) {
            System.out.println("Thread is running...");
        }

        System.out.println("Thread is stopped.");
    }
}
