package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionExample {
    public static void show() {
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("one");
        Collections.addAll(collection1, "two", "three");

        System.out.println("Collection 1: " + collection1);
        System.out.println("Collection 1 contains: " + collection1.contains("ones"));

        Collection<String> collection2 = new ArrayList<>();
        collection2.addAll(collection1);

        System.out.println(collection1 == collection2);
        System.out.println(collection1.equals(collection2));
    }
}
