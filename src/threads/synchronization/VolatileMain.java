package threads.synchronization;

public class VolatileMain {
    static void main() {
        VolatileExample vo = new VolatileExample();

        Thread thread = new Thread(() -> vo.run());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        vo.stopRunning();
    }
}
