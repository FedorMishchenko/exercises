package temp;

public interface List extends Iterable<Object> {

    void add(Object obj);

    Object get(int index);

    void clear();

    boolean remove(Object obj);

    Object[] toArray();

    int size();

    boolean contains(Object obj);

    boolean containsAll(List c);

    void remove(int index);
}
