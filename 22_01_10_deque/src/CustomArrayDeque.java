//TODO implement other methods. Write tests
public class CustomArrayDeque<T> implements CustomDeque<T>{
    private T[] source;
    private int size = 0;
    private int firstElementIndex = 0;

    public CustomArrayDeque() {
        source = (T[]) new Object[8];
    }

    @Override
    public void addFirst(T elt) {
        if(size == source.length)
            increaseCapacity();

        firstElementIndex = firstElementIndex - 1;

        if(firstElementIndex == -1)
            firstElementIndex = source.length - 1;

        source[firstElementIndex] = elt;
        size++;
    }

    private void increaseCapacity() {
        T[] newSource = (T[]) new Object[source.length * 2];

        int j = 0;
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j] = source[i];
            j++;
        }

        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j] = source[i];
            j++;
        }

        source = newSource;
        firstElementIndex = 0;
    }

    @Override
    public T getFirst() {
        if(size == 0)
            throw new IndexOutOfBoundsException();

        return source[firstElementIndex];
    }

    @Override
    public T removeFirst() {
        if(size == 0)
            throw new IndexOutOfBoundsException();

        T res = source[firstElementIndex];
        firstElementIndex = firstElementIndex + 1;
        size--;
        return res;
    }

    @Override
    public void addLast(T elt) {
        if(size == source.length) {
            increaseCapacity();
        }

        source[size] = elt;
        size++;
    }

    @Override
    public T getLast() {
        if(size == 0)
            throw new IndexOutOfBoundsException();

        return source[size - 1];
    }

    @Override
    public T removeLast() {
        if(size == 0)
            throw new IndexOutOfBoundsException();

        T res = source[size - 1];
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}
