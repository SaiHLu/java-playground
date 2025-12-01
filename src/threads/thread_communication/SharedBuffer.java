package threads.thread_communication;

public class SharedBuffer {
    public int data;
    public boolean hasData = false;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        data = value;
        System.out.println(Thread.currentThread().getName() + " processed " + data);

        hasData = true;
        notify();
    }

    public synchronized void consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName() + " consumed " + data);
        hasData = false;
        notify();
    }
}
