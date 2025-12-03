package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void show() {
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("d", "b", "f"));

//        Intersection
//        set1.retainAll(set2);
//        System.out.println("Intersection: " + set1);

//        Differences
        set1.removeAll(set2);
        System.out.println("Differences: " + set1);
    }
}
