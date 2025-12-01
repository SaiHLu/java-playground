package threads.thread_communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBufferWithLock {
    public int data;
    public boolean hasData = false;
    public final Lock lock = new ReentrantLock();
    public final Condition condition = lock.newCondition();

    public void produce(int value) {
        lock.lock();

        try {
            while(hasData) {
                condition.await();
            }

            data = value;
            System.out.println(Thread.currentThread().getName() + " processed " + data);

            hasData = true;
            condition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();

        try {
            while (!hasData) {
                condition.await();
            }

            System.out.println(Thread.currentThread().getName() + " consumed " + data);

            hasData = false;
            condition.signal();
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
