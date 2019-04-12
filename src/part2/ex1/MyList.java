package part2.ex1;

/**
 * An iterator over a collection. Extends <tt>{@link Iterable}</tt> interface.
 *
 * @author fedor mishchenko.
 * @version 1.0.
 */
public interface MyList extends Iterable<Object> {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e
     *            - add item.
     */
    void add(Object e);

    /**
     * Return item the index.
     *
     * @param index
     *            - index item.
     * @return item by the index.
     */
    Object get(int index);

    /**
     * Removes all of the elements from the list.
     *
     */
    void clear();

    /**
     * Removes the first occurrence of the specified element from this list.
     *
     * @param o
     *            - cleaning element.
     * @return cleaning result.
     */
    boolean remove(Object o);

    /**
     * Returns an array containing all of the elements in list in proper
     * sequence.
     *
     * @return array object collections.
     */
    Object[] toArray();

    /**
     * Returns the number of elements in list.
     *
     * @return size collections.
     */
    int size();

    /**
     * Returns true if list contains the specified element.
     *
     * @param o
     *            - item the contains.
     * @return result contains (true - contains / false - does not exist).
     */
    boolean contains(Object o);

    /**
     * Returns true if list contains all of the elements of the specified
     * list.
     *
     * @param c
     *            - item the contains.
     * @return result contains (true - contains / false - does not exist).
     */
    boolean containsAll(MyList c);

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index
     *            - the index of the element to be removed.
     * @throws IndexOutOfBoundsException
     *             index out of length array.
     */
    void remove(int index);
}

