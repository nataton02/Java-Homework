import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;


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
            throw new IllegalStateException();

        //first implementation
        //return Collections.max(source);

        // second implementation
        int max = 0;
        for (int elt : source) {
            if (elt > max)
                max = elt;
        }
        return max;
    }

}
