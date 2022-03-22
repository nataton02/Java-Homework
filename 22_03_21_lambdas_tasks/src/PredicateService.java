import java.util.List;
import java.util.function.Predicate;

public class PredicateService<T> {
    public Predicate<T> intersect(List<Predicate<T>> list) {
        Predicate<T> result = list.get(0);
        for (int i = 1; i < list.size(); i++)
            result = result.and(list.get(i));
        return result;
    }

    public Predicate<T> union(List<Predicate<T>> list) {
        Predicate<T> result = list.get(0);
        for (int i = 1; i < list.size(); i++)
            result = result.or(list.get(i));
        return result;
    }


}
