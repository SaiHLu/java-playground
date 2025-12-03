package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void show() {
        List<String> list = new ArrayList<>();
        list.add("one");
        Collections.addAll(list, "two", "three");
        list.set(0, "zero");

        System.out.println("Original: " + list);
        System.out.println(list.get(0));
        System.out.println(list.subList(0, 2));
        list.remove(2);
        System.out.println("After removed: " + list);
    }
}
