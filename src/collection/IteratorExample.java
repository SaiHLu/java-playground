package collection;

import java.util.Iterator;

public class IteratorExample<T> implements Iterable<T>{
    private T[] items = (T[]) new Object[10];
    private int index;

    public void add(T item) {
        items[index++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericListIterator(this);
    }

    private class GenericListIterator implements Iterator<T> {
        private final IteratorExample<T> list;
        private int index;

        public GenericListIterator(IteratorExample<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.index);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
