package temp;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List{

    private static final Object[] EMPTY_ELEMENT_DATA = {};
    private Object[] elements;
    private final int capacity;
    private static final int DEFAULT_CAPACITY;
    private int currentIndex;

    static {
        DEFAULT_CAPACITY = 16;
    }

    public ListImpl(){this(0);}

    public ListImpl(int initialCapacity){
        if(initialCapacity > 0){
            this.elements = new Object[initialCapacity];
            capacity = initialCapacity;
        }else if(initialCapacity == 0){
            capacity = DEFAULT_CAPACITY;
        }else {
            this.elements = EMPTY_ELEMENT_DATA;
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }
    
    public ListImpl(List obj){
        currentIndex = obj.size();
        if(currentIndex != 0) {
            elements = obj.toArray();
        }
        else {
            elements = EMPTY_ELEMENT_DATA;
        }
        capacity = DEFAULT_CAPACITY;        
    }

    @Override
    public void add(Object obj) {
        if(elements == EMPTY_ELEMENT_DATA){
            init(capacity);
        }
        if(currentIndex >= elements.length){
            resize(elements.length + (elements.length >> 1));
        }
        elements[currentIndex++] = obj;
    }

    private void resize(int size) {
        Object[] temp = new Object[size];
        System.arraycopy(elements, 0, temp, 0, currentIndex);
        elements = temp;
    }

    private void init(int size) {
        currentIndex = 0;
        elements = new Object[size];
    }

    @Override
    public Object get(int index) {
        if(index >= currentIndex){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public void clear() {
        elements = EMPTY_ELEMENT_DATA;
        init(capacity);
    }

    @Override
    public boolean remove(Object obj) {
        if(obj == null){
            for(int i = 0; i < currentIndex; i++){
                if(elements[i] == null){
                    rebuild(i);
                    return true;
                }
            }
        }else {
            for(int i = 0; i < currentIndex; i++){
                if(this.elements[i].equals(obj)){
                    rebuild(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void remove(int index) {
        if (index >= currentIndex) {
            throw new IndexOutOfBoundsException();
        }
        rebuild(index);
    }

    private void rebuild(int index) {
        if(index == size() - 1){
            elements[index] = null;
        }
        else {
            int length = size() - index - 1;
            System.arraycopy(elements, index + 1, elements, index, length);
        }
        currentIndex--;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size()];
        System.arraycopy(elements, 0, temp, 0, size());
        return temp;
    }

    @Override
    public int size() { return currentIndex; }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < currentIndex; i++){
            if(elements[i].equals(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(List list) {
        for (Object obj: list){
            if(!contains(obj))
                return false;
        }
        return true;
    }

    @Override
    public Iterator<Object> iterator() { return new IteratorImpl(); }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(elements[i].toString());
            if (i < size()) stringBuilder.append(", ");
        }
        return stringBuilder.insert(0,"[").append("]").toString();
    }

    private class IteratorImpl implements Iterator<Object>{

        private int cursor = 0;
        boolean condition = false;

        IteratorImpl(){}

        @Override
        public boolean hasNext() {
            return cursor != size() && elements[cursor] != null;
        }

        @Override
        public Object next() {
            if(cursor >= size()){
                throw new NoSuchElementException();
            }
            condition = true;
            return elements[cursor++];
        }

        @Override
        public void remove() {
            if(!condition){
                throw new IllegalStateException();
            }
            if(this.hasNext()){
                Object[] tmp = new Object[size() - 1];
                System.arraycopy(elements, 0, tmp, 0, cursor);
                System.arraycopy(elements, cursor + 1, tmp, cursor, tmp.length - 1);
                elements = tmp;
            }
            condition = false;
        }
    }
}
