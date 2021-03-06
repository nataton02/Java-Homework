import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.NoSuchElementException;


public class NaiveMaxStack implements MaxStack{

    private final Deque<Integer> source = new ArrayDeque<>();

    @Override
    public void add(int elt) {
        source.addLast(elt);
    }

    @Override
    public int get() {
        return source.getLast();
    }

    @Override
    public int remove() {
        return source.removeLast();
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public int getMax() {
        if (source.size() == 0)
            throw new NoSuchElementException();

        int max = source.getFirst();
        for (int elt : source) {
            if (elt > max)
                max = elt;
        }
        return max;
    }

}
