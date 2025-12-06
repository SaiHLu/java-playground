package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private AtomicInteger totalBytesInAtomic = new AtomicInteger();
    private Lock lock = new ReentrantLock();
    private LongAdder longAdder = new LongAdder(); // DoubleAdder, etc.

    public int getTotalBytes() {
        return longAdder.intValue();

//        return totalBytesInAtomic.get();

//        return totalBytes;
    }

    public void increment() {
        longAdder.increment();
//        totalBytesInAtomic.getAndIncrement();

//        lock.lock();
//        try {
//            totalBytes++;
//        } finally {
//            lock.lock();
//        }
    }
}
