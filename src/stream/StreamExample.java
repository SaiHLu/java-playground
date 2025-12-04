package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void show() {
//        Create stream from array
        int[] numbers = {1, 2, 3};
        var count = Arrays.stream(numbers).filter(n -> n >0).count();
        System.out.println("Number > 0 count: " + count);

//        Create Finite and Infinite(remove 'limit') stream
        var stream = Stream.generate(() -> Math.random());
        stream.limit(3).forEach(n -> System.out.println(n));

        var stream2 = Stream.iterate(1, (n) -> n+1);
        stream2.limit(3).forEach(n -> System.out.println(n));

        var stream3 = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
//        stream3.forEach(data -> System.out.println("Data without flat: " + data));
        stream3.flatMap(list -> list.stream()).forEach(n -> System.out.println("Data with flat: " + n));
    }
}
