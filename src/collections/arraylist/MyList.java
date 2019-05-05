package collections.arraylist;

public interface MyList extends Iterable<Object> {

    void add(Object e);

    Object get(int index);

    void clear();

    boolean remove(Object o);

    Object[] toArray();

    int size();

    boolean contains(Object o);

    boolean containsAll(MyList c);

    void remove(int index);
}

