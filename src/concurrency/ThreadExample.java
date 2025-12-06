package concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ThreadExample {
    public static void show() {
        System.out.println(Thread.currentThread().getName());

        /**
         * Synchronize collection (using 'lock' internally), can slow down the operations
         * Prefer `Concurrent Collection` which is faster than synchronize collection
         *
         * Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());
         *
         *         Thread thread1 = new Thread(() -> collection.addAll(List.of(1, 2, 3)));
         *         Thread thread2 = new Thread(() -> collection.addAll(List.of(4, 5, 6)));
         *
         *         thread1.start();
         *         thread2.start();
         *
         *         try {
         *             thread1.join();
         *             thread2.join();
         *         } catch (InterruptedException e) {
         *             throw new RuntimeException(e);
         *         }
         *         System.out.println("Collections: " + collection);
         */


        /**
         * Race Condition Example
         *
         * DownloadStatus status = new DownloadStatus();
         *         List<Thread> threads = new ArrayList<>();
         *
         *         for (int i = 0; i < 10; i ++) {
         *             Thread thread = new Thread(new DownloadFileTask(status));
         *             thread.start();
         *
         *             threads.add(thread);
         *         }
         *
         *         for(var thread: threads) {
         *             try {
         *                 thread.join();
         *             } catch (InterruptedException e) {
         *                 throw new RuntimeException(e);
         *             }
         *         }
         *
         *         System.out.println("Completed bytes: " + status.getTotalBytes());
         */


        /**
         * Simple Thread Example
         *
         * Thread thread = new Thread(new DownloadFileTask());
         *         thread.start();
         *
         *         try {
         *             Thread.sleep(1000);
         *         } catch (InterruptedException e) {
         *             throw new RuntimeException(e);
         *         }
         *
         *         thread.interrupt();
         */
    }
}
