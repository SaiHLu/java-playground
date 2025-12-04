package lambda;

import java.util.List;

public class ConsumerExample {
    public static void show() {
        List<String> list = List.of("a", "b", "c");
        java.util.function.Consumer<String> print = (val) -> System.out.println(val);
        java.util.function.Consumer<String> upperCase = (val) -> System.out.println(val.toUpperCase());
        java.util.function.Consumer<String> lowerCase = (val) -> System.out.println(val.toLowerCase());

        list.forEach(print.andThen(upperCase).andThen(lowerCase));
    }
}
