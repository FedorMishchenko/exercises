package part2.ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl implements MyList, ListIterable {

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final int DEFAULT_CAPACITY;

    private final int capacity;

    private int pointer;

    private Object[] array;

    static {
        DEFAULT_CAPACITY = 10;
    }


    public MyListImpl() {
        this(0);
    }

    public MyListImpl(final int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
            capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.array = EMPTY_ELEMENT_DATA;
            capacity = DEFAULT_CAPACITY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public MyListImpl(MyList list) {
        pointer = list.size();
        if (pointer != 0) {
            array = list.toArray();
        } else {
            array = EMPTY_ELEMENT_DATA;
        }
        capacity = DEFAULT_CAPACITY;
    }

    @Override
    public void add(Object obj) {
        if (array == EMPTY_ELEMENT_DATA) {
            init(capacity);
        }
        if (pointer >= array.length) {
            resize(array.length * (7 / 3));
        }
        array[pointer++] = obj;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return array[index];
    }

    @Override
    public void clear() {
        array = EMPTY_ELEMENT_DATA;
        init(capacity);

    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null) {
            for (int i = 0; i < pointer; i++) {
                if (array[i] == null) {
                    rebuild(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < pointer; i++) {
                if (this.array[i].equals(obj)) {
                    rebuild(i);
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size()];
        System.arraycopy(array, 0, temp, 0, size());
        return temp;

    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void remove(int index) {
        rangeCheck(index);
        rebuild(index);
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(array[i].toString());
            if (i < size()) stringBuilder.append(", ");
        }
        return stringBuilder.insert(0, "[").append("]").toString();
    }

    private void init(final int size) {
        pointer = 0;
        array = new Object[size];
    }

    private void resize(final int len) {
        Object[] temp = new Object[len];
        System.arraycopy(array, 0, temp, 0, pointer);
        array = temp;
    }

    private void rangeCheck(final int index) {
        if (index >= pointer) {
            throw new IndexOutOfBoundsException(
                    "size = " + size() + ", index = " + index);
        }
    }

    private void rebuild(final int index) {
        if (index == size() - 1) {
            array[index] = null;
        } else {
            int lengthCopy = size() - index - 1;
            System.arraycopy(array, index + 1, array, index, lengthCopy);
        }
        pointer--;
    }

    private class IteratorImpl implements Iterator<Object> {

        private int cursor = 0;
        boolean condition = false;

        @Override
        public boolean hasNext() {
            return cursor != size() && array[cursor] != null;
        }

        @Override
        public Object next() {
            if (cursor >= size()) {
                throw new NoSuchElementException();
            }
            condition = true;
            return array[cursor++];
        }

        @Override
        public void remove() {
            if (!condition) {
                throw new IllegalStateException();
            }
            if (this.hasNext()) {
                MyListImpl.this.remove(cursor);
            }
            condition = false;
        }
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            return null;
        }

        @Override
        public void set(Object e) {

        }

        @Override
        public void remove() {

        }
    }
}


