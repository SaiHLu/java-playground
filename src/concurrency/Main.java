package concurrency;

public class Main {
    static void main() {
        System.out.println("Active Threads: " + Thread.activeCount());
        System.out.println("Total Threads: " + Runtime.getRuntime().availableProcessors());

        ThreadExample.show();
    }
}
