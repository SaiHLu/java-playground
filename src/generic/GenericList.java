package generic;

public class GenericList<T> {
    private T[] items = (T[]) new Object[10];
    private int counter;

    public void add(T item) {
        items[counter++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
