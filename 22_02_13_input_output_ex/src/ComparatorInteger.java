import java.util.Comparator;

public class ComparatorInteger implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
