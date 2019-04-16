package part2.ex1;

import java.util.ConcurrentModificationException;
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


    MyListImpl() {
        this(0);
    }

    private MyListImpl(final int initialCapacity) {
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

    MyListImpl(MyList list) {
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
            resize(array.length + (array.length >> 1));
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
    public boolean containsAll(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
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
            if (i < size() - 1) stringBuilder.append(", ");
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

        int cursor = 0;
        boolean condition = false;
        boolean con = false;

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
            int index = cursor--;
            if (!condition && !con) {
                throw new IllegalStateException();
            }
            if (this.hasNext()) {
                MyListImpl.this.remove(array[--index]);
            }
            condition = false;
        }
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public Object previous() {
            int index = cursor - 1;
            if (index < 0) {
                throw new NoSuchElementException();
            }
            if (index >= array.length) {
                throw new ConcurrentModificationException();
            }
            cursor = index;
            con = true;
            return array[index];
        }

        @Override
        public void set(Object obj) {
            if (!condition && !con) {
                throw new IllegalStateException();
            }
            if (condition) {
                int index = cursor - 1;
                array[index] = obj;
                condition = false;
            }
            if (con) {
                array[cursor] = obj;
                con = false;
            }
        }

        @Override
        public void remove() {   //todo: realize correct reverse delete
            if (!condition && !con) {
                throw new IllegalStateException();
            }
            if (condition) {
                super.remove();
                condition = false;
            }
            if (con) {
                ++cursor;
                super.remove();
                con = false;
            }
        }
    }
}


