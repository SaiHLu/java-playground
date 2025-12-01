package threads.thread_communication;

public class SharedBufferWithLockMain {
    static void main() {
        SharedBufferWithLock sharedBufferWithLock = new SharedBufferWithLock();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBufferWithLock.produce(i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer Thread");

        Thread consumer = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                sharedBufferWithLock.consume();

                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer Thread");

        producer.start();
        consumer.start();
    }
}
