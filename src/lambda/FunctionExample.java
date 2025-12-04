package lambda;

import java.util.function.Function;

public class FunctionExample {
    public static void show() {
//      Function<input, output>
        Function<String, Integer> func = (str) -> str.length();
        var result = func.apply("Good Job");
        System.out.println(result);

//        Compose Function
        Function<String, String> replaceColon = (str) -> str.replace(":", "=");
        Function<String, String> addBraces = (str) -> "{"+str+"}";

        String composeResult;
//        Compose with chain
        composeResult = replaceColon.andThen(addBraces).apply("key:value");
        System.out.println("Compose With Chain: " + composeResult);

//        Compose with compose(reverse order functions)
        composeResult = addBraces.compose(replaceColon).apply("key:value");
        System.out.println("Compose with compose: " + composeResult);
    }
}
