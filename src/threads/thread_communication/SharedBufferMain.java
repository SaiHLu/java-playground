package threads.thread_communication;

public class SharedBufferMain {
    static void main() {
        SharedBuffer sharedBuffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBuffer.produce(i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer Thread");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBuffer.consume();

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
