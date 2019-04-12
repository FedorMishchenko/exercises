package part2.ex1;

import java.util.Iterator;

public class MyListImpl implements MyList, ListIterable {
    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY;
    /**
     * Current capacity for creation array.
     */
    private final int capacity = 10;
    /**
     * Current position to index array.
     */
    private int pointer;
    /**
     * Mod count.
     */
    private int modCount;
    /**
     * {@link Object}.
     */
    private Object[] array;

    static { DEFAULT_CAPACITY = 10;}

    {
        modCount = 0;
    }


    @Override
    public void add(Object e) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        return false;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < size(); i++) {
            builder.append("[" + array[i].toString() + "]");
            if (i < size()) builder.append(", ");
        }
        builder.append("}");
        return builder.toString();
    }
}
