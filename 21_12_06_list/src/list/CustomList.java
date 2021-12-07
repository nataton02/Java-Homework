package list;

/**
 * The interface describes the List data structure
 */
    //TODO
    // Implement all the methods of AdvancedArrayList and CustomArrayList according to the contract (some methods
    // must throw CustomOutOfBoundException). See CustomList
public interface CustomList {

    /**
     * The method swaps the value at the index position
     * @param index the position
     * @param value the new value for the index position
     * @throws CustomOutOfBoundException if index < 0 or index >= size
     */
    void set(int index, int value);

    /**
     * The method gets the value on the index position
     * @param index the position, whose value to be returned
     * @return the value by its position
     * @throws CustomOutOfBoundException if index < 0 or index >= size
     */
    int get(int index);

    /**
     *
     *
     * @return the umber of elements in the list
     */
    int size();

    /**
     *
     * @param value to be found
     * @return whether the value is in the list
     */
    boolean contains(int value);

    /**
     * removes the value by its position. The elements which are after the index move to the left by 1 position.
     *
     * @param index of the value to remove
     * @throws CustomOutOfBoundException if index < 0 or index >= size
     */
    public void removeById(int index);

    /**
     * Add an element to the end of the list
     *
     * @param value to append
     */
    void add(int value);

    /**
     * Inserts the value to the index place. All the elements which are after the index move to the right by 1 position.
     *
     * @param index the place to insert
     * @param value the element to insert
     * @throws CustomOutOfBoundException if index < 0 or index > size
     */
    void insert(int index, int value);

    /**
     * prints the element to the console
     */
    public void println();
}
