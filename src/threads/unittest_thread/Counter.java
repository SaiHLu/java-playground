package threads.unittest_thread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public int getCounter() {
        lock.lock();

        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }


}
