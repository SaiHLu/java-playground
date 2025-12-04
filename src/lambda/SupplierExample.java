package lambda;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void show() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        IntSupplier intSupplier = () -> (int) (Math.random() * 100);

        var doubleValue = doubleSupplier.get();
        var intValue = intSupplier.getAsInt();

        System.out.println("Double: " + doubleValue);
        System.out.println("Primitive int: " + intValue);
    }
}
