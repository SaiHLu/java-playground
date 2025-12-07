package executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void show() {
//        Wait multiple async operations
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

//        wait for all operations are done
        var result = CompletableFuture.allOf(first, second, third);
        result.thenRun(() -> {
            try {
                var firstResult = first.get();
                System.out.println("First result: " + firstResult);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

            System.out.println("All tasks are done.");
        });
//        wait for any operation
        var longTask = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 100;
        });

        var anyOperation = CompletableFuture.anyOf(first, longTask);
        anyOperation.thenAccept((fastestResult) -> System.out.println(fastestResult));

//        Combine completable
//        var price = CompletableFuture.supplyAsync(() -> 100.0); // usd
//        var exchangeRate = CompletableFuture.supplyAsync(() -> 0.8);
//
//        price.thenCombine(exchangeRate, (unitPrice, rate) -> unitPrice * rate)
//                .thenAccept(result -> System.out.println(result));

//        Compose completable
//        getEmailAsync().thenCompose(CompletableFutureExample::getPlaylistAsync).thenAccept(System.out::println);

//        Chain completable
//        var future = CompletableFuture.supplyAsync(() -> 10);
//        future.thenApply(n -> n * 2).thenAccept(r -> System.out.println(r));

//        CompletableFuture.runAsync(() -> System.out.println("I'm not returning any value"));
//        var future = CompletableFuture.supplyAsync(() -> 10);
//
//        try {
//            var result = future.thenApply(n -> n * 2).get();
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static CompletableFuture<String> getEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> email + ": playlist");
    }
}
