package list;
//TODO generify
public class CustomArrayList<T> implements CustomList<T>{
    private static final int INITIAL_CAPACITY = 8;
    private T[] source;
    private int size;


    public CustomArrayList() {
        source = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void set(int index, T value) {
        if(index < 0 || index >= size)
            throw new CustomOutOfBoundException();

        source[index] = value;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size)
            throw new CustomOutOfBoundException();

        return source[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if(size == source.length) {
            increaseCapacity();
        }
        source[size++] = value;
    }

    private void increaseCapacity() {
        T[] newSource = (T[]) new Object[source.length * 2];

        for (int i = 0; i < source.length; i++) {
            newSource[i] = source[i];
        }
        source = newSource;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (source[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public void insert(int index, T value) {
        if(index < 0 || index > size)
            throw new CustomOutOfBoundException();

        if(size == source.length)
            increaseCapacity();
        for (int i = size; i > index; i--) {
            source[i] = source[i -1];
        }
        source[index] = value;
        size++;
    }

    @Override
    public T removeById(int index) {
        if(index < 0 || index >= size)
            throw new CustomOutOfBoundException();

        T res = source[index];
        for (int i = index + 1; i < size; i++) {
            source[i - 1] = source[i];
        }
        size--;
        return res;
    }

    @Override
    public boolean removeByValue(T value) {
        int index = 0;
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (value.equals(source[i])) {
                isFound = true;
                index = i;
                break;
            }
        }

        if (!isFound)
            return false;

        T[] newSource = (T[]) new Object[source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }

        for (int i = index + 1; i < size; i++) {
            newSource[i - 1] = source[i];
        }
        source = newSource;
        size--;
        return true;
    }

    @Override
    public void println() {
        for (int i = 0; i < size; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }
}

