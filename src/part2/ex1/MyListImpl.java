package part2.ex1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private final int capacity;
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

    static {
        DEFAULT_CAPACITY = 10;
    }

    {
        modCount = 0;
    }

    /**
     * Default constructor.
     */
    public MyListImpl() {
        this(0);
    }

    /**
     * Constructor with parameters.
     *
     * @param initialCapacity - initialCapacity the initial capacity of the list.
     * @throws IllegalArgumentException - {@link IllegalArgumentException}.
     */
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

    /**
     * Copy constructor.
     *
     * @param obj - object MyListImp
     */
    public MyListImpl(final MyList obj) {
        pointer = obj.size();
        if (pointer != 0) {
            array = obj.toArray();
        } else {
            array = EMPTY_ELEMENT_DATA;
        }
        capacity = DEFAULT_CAPACITY;
    }

    @Override
    public void add(Object e) {
        if (array == EMPTY_ELEMENT_DATA) {
            init(capacity);
        }
        if (pointer >= array.length) {
            resize(array.length * (7 / 3));
        }
        modCount++;
        array[pointer++] = e;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return array[index];
    }

    @Override
    public void clear() {
        modCount++;
        array = EMPTY_ELEMENT_DATA;
        pointer = 0;
        init(capacity);

    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < pointer; i++) {
                if (array[i] == null) {
                    restructMyList(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < pointer; i++) {
                if (this.array[i].equals(o)) {
                    restructMyList(i);
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
    public boolean contains(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(o)) {
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
        restructMyList(index);
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
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < size(); i++) {
            builder.append("[" + array[i].toString() + "]");
            if (i < size()) builder.append(", ");
        }
        builder.append("}");
        return builder.toString();
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
                    "going beyond the array: size == >" + size() + " index " + "==>" + index);
        }
    }

    private void restructMyList(final int index) {
        modCount++;
        if (index == size() - 1) {
            array[index] = null;
        } else {
            int lengthCopy = size() - index - 1;
            System.arraycopy(array, index + 1, array, index, lengthCopy);
        }
        pointer--;
        if (pointer == (array.length / 4)) {
            resize(pointer + (array.length / 4));
        }
    }

    private class IteratorImpl implements Iterator<Object> {

        /**
         * Expected modifications count.
         */
        private int expectedModCount;
        /**
         * Current index iterator.
         */
        private int currentIndex;

        /**
         * Index last return item.
         */
        private int lastRet;

        {
            expectedModCount = MyListImpl.this.modCount;
            currentIndex = 0;
            lastRet = -1;
        }

        /**
         * Getter {@link IteratorImpl#expectedModCount}.
         *
         * @return the expectedModCount.
         */
        @SuppressWarnings("unused")
        public final int getExpectedModCount() {
            return expectedModCount;
        }

        /**
         * Setter {@link IteratorImpl#expectedModCount}.
         *
         * @param expectedModCount the expectedModCount to set.
         */
        @SuppressWarnings("unused")
        public final void setExpectedModCount(final int expectedModCount) {
            this.expectedModCount = expectedModCount;
        }

        /**
         * Getter {@link IteratorImpl#currentIndex}.
         *
         * @return the currentIndex.
         */
        public final int getCurrentIndex() {
            return currentIndex;
        }

        /**
         * Setter {@link IteratorImpl#currentIndex}.
         *
         * @param currentIndex the currentIndex to set.
         */
        public final void setCurrentIndex(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        /**
         * Getter {@link IteratorImpl#lastRet}.
         *
         * @return the lastRet.
         */
        public final int getLastRet() {
            return lastRet;
        }

        /**
         * Setter {@link IteratorImpl#lastRet}.
         *
         * @param lastRet the lastRet to set.
         */
        public final void setLastRet(final int lastRet) {
            this.lastRet = lastRet;
        }

        @Override
        public boolean hasNext() {
            return currentIndex != size();
        }

        @Override
        public Object next() {
            if (currentIndex >= size()) {
                throw new NoSuchElementException("Error No Such Element from next");
            }
            checkForComodification();
            lastRet = currentIndex;
            currentIndex++;
            return get(lastRet);
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException("remove: Not does not indicate which item");
            }
            checkForComodification();
            MyListImpl.this.remove(lastRet);
            if (lastRet < currentIndex) {
                currentIndex--;
            }
            expectedModCount = modCount;
            lastRet = -1;
        }

        /**
         * Check modifications object state.
         */
        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * Extends class IteratorImpl and implements ListIterator.
     *
     * @author vydrya_vitaliy.
     * @version 1.0.
     */
    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return getCurrentIndex() != 0;
        }


        @Override
        public Object previous() {
            if (getCurrentIndex() < 0) {
                throw new NoSuchElementException("Error No Such Element from previous");
            }
            checkForComodification();
            int index = getCurrentIndex() - 1;
            setCurrentIndex(index);
            setLastRet(index);
            return get(index);
        }

        @Override
        public void set(final Object e) {
            if (getLastRet() < 0) {
                throw new IllegalStateException("set: Not does not indicate which item");
            }
            checkForComodification();
            array[getLastRet()] = e;
            setLastRet(-1);
        }
    }
}


