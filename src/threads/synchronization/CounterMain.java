package threads.synchronization;

public class CounterMain {
    static void main() {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("Counter result: " + counter.getCounter());
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
