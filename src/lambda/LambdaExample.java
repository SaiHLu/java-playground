package lambda;

public class LambdaExample {
    String prefix = "=> ";

    public LambdaExample(String name) {}

    public static void show() {
        greet(message -> {
            System.out.println(message);
        });

//        greet(LambdaExample::new);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }
}
