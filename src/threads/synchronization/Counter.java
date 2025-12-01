package threads.synchronization;

public class Counter {
    private int counter = 0;

//    'synchronized' make sure only one thread can access the method at the same time
    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
