import java.util.NoSuchElementException;

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

        firstElementIndex = 0;
        source = newSource;
    }

    @Override
    public T getFirst() {
        if(size == 0)
            throw new NoSuchElementException();

        return source[firstElementIndex];
    }

    @Override
    public T removeFirst() {
        T res = getFirst();
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return res;
    }

    @Override
    public void addLast(T elt) {
        if(size == source.length) {
            increaseCapacity();
        }

        int newLastIndex = (firstElementIndex + size) % source.length;
        source[newLastIndex] = elt;
        size++;
    }

    @Override
    public T getLast() {
        if(size == 0)
            throw new NoSuchElementException();

        int newLastIndex = (firstElementIndex + size - 1) % source.length;
        return source[newLastIndex];
    }

    @Override
    public T removeLast() {
        T res = getLast();
        size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}
