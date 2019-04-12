package part2.ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ListIterator extends Iterator<Object> {
    /**
     * Returns true if this list iterator has more elements when traversing the
     * list in the reverse direction.
     *
     * @return true - true if the iteration previous has more elements.
     */
    boolean hasPrevious();

    /**
     * Returns the previous element in the list and moves the cursor position
     * backwards.
     *
     * @return previous element.
     * @throws NoSuchElementException
     *             if the iteration has no previous element
     */
    Object previous();

    /**
     * Replaces the last element returned by next or previous with the specified
     * element.
     *
     * @param e
     *            - element replacement.
     * @throws IllegalStateException
     *             if neither {@code next} nor {@code previous} have been
     *             called, or {@code remove} or {@code add} have been called
     *             after the last call to {@code next} or {@code previous}
     */
    void set(Object e);

    /*
     * (non-Javadoc)
     *
     * @see java.util.Iterator#remove()
     */
    @Override
    void remove();

}
