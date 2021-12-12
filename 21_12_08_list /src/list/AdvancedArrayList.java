package list;

public class AdvancedArrayList<T> implements CustomList<T>{

    private T[] source;

    public AdvancedArrayList() {
        source = (T[]) new Object[0];
    }

    public AdvancedArrayList(int initialSize) {
        source = (T[]) new Object[initialSize];
    }

    @Override
    public void set(int index, T value) {
        if(index < 0 || index >= source.length)
            throw new CustomOutOfBoundException();

        source[index] = value;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= source.length)
            throw new CustomOutOfBoundException();

        return source[index];
    }

    @Override
    public int size() {
        return source.length;
    }

    @Override
    public void add(T value) {
        insert(source.length, value);
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < source.length; i++) {
            if (value.equals(source[i]))
                return true;
        }
        return false;
    }

    @Override
    public void insert(int index, T value) {
        if(index < 0 || index > source.length)
            throw new CustomOutOfBoundException();

        T[] newSource = (T[]) new Object[source.length + 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        newSource[index] = value;
        for (int i = index; i < source.length; i++) {
            newSource[i + 1] = source[i];
        }
        source = newSource;
    }

    @Override
    public T removeById(int index) {
        if(index < 0 || index >= source.length)
            throw new CustomOutOfBoundException();

        T[] newSource = (T[]) new Object[source.length - 1];
        T res = source[index];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        for (int i = index; i < newSource.length; i++) {
            newSource[i] = source[i + 1];
        }
        source = newSource;
        return res;
    }

    //TODO complete
    @Override
    public boolean removeByValue(T value) {
        int index = 0;
        boolean isFound = false;
        for (int i = 0; i < source.length; i++) {
            if(value.equals(source[i]))
                isFound = true;
                index = i;
                break;
        }

         if (!isFound)
            return false;

        T[] newSource = (T[]) new Object[source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        for (int i = index; i < newSource.length; i++) {
            newSource[i] = source[i + 1];
        }
        source = newSource;
        return true;
    }

    public void println() {
        for (int i = 0; i < source.length; i++) {
            System.out.println(source[i] + " ");
        }
        System.out.println();
    }
}
