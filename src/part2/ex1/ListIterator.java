package part2.ex1;

import java.util.Iterator;

public interface ListIterator extends Iterator<Object> {

    boolean hasPrevious();

    Object previous();

    void set(Object e);

    @Override
    void remove();

}
