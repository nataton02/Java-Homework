package list;

import java.util.Iterator;

/**
 * The interface describes the List data structure
 */

public interface CustomList<T> extends Iterable<T>{

    /**
     * The method swaps the value at the index position
     * @param index the position
     * @param value the new value for the index position
     * @throws CustomOutOfBoundException if index < 0 or index >= size
     */
    public void set(int index, T value);

    /**
     * The method gets the value on the index position
     * @param index the position, whose value to be returned
     * @return the value by its position
     * @throws CustomOutOfBoundException if index < 0 or index >= size
     */
    public T get(int index);

    /**
     *
     *
     * @return the umber of elements in the list
     */
    public int size();

    /**
     *
     * @param value to be found
     * @return whether the value is in the list
     */
    public boolean contains(T value);

    /**
     * removes the value by its position. The elements which are after the index move to the left by 1 position.
     *
     * @param index of the value to remove
     * @return the value of the element to be removed
     * @throws CustomOutOfBoundException if index < 0 or index >= size
     */
    public T removeById(int index);

    /**
     * removes an element by its value. Only one element must be removed if exists in the list.
     * The elements which are after the index move to the left by 1 position.
     *
     * @param value the value of the element to be removed
     * @return true if the element found and removed, false otherwise
     */
    public boolean removeByValue(T value);

    /**
     * Add an element to the end of the list
     *
     * @param value to append
     */
    public void add(T value);

    /**
     * Inserts the value to the index place. All the elements which are after the index move to the right by 1 position.
     *
     * @param index the place to insert
     * @param value the element to insert
     * @throws CustomOutOfBoundException if index < 0 or index > size
     */
    public void insert(int index, T value);

    /**
     * prints the element to the console
     */
    public void println();

}
