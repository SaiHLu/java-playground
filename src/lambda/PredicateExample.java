package lambda;

import java.util.function.Predicate;

public class PredicateExample {
    public static void show() {
//        input -> string, output -> boolean
        Predicate<String> hasColon = str -> str.contains(":");
        Predicate<String> hasEqual = str -> str.contains("=");

        Predicate<String> hasColonAndEqual = hasColon.and(hasEqual);
        Predicate<String> hasColonOrEqual = hasColon.or(hasEqual);

        boolean result;

        result = hasColon.test("good job");
        System.out.println("Has Colon: " + result);

        result = hasEqual.test("good=nice");
        System.out.println("Has Equal: " + result);

        result = hasColonAndEqual.test("good:job");
        System.out.println("Has Colon And Equal: " + result);

        result = hasColonOrEqual.test("good:job");
        System.out.println("Has Colon Or Equal: " + result);
    }
}

