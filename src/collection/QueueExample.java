package collection;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueExample {
    public static void show() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
//        c -> b -> a
        System.out.println("Original: " + queue);

        var first = queue.peek();
        System.out.println("Get first item of queue: " + first);
        System.out.println("After get Queues: " + queue);
        var remove = queue.remove();  // queue.poll()
        System.out.println("Remove first item of queue: " + remove);
        System.out.println("After remove Queues: " + queue);
    }
}
