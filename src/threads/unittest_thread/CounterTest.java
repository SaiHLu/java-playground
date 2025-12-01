package threads.unittest_thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterTest {
    @Test
    public void testCounterWithMultipleThreads() throws InterruptedException {
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int expectedCount = 1000;

        for (int i =0; i < expectedCount; i++) {
            executorService.submit(counter::increment);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        Assertions.assertEquals(expectedCount, counter.getCounter(), "Counter value is incorrect");
    }
}
