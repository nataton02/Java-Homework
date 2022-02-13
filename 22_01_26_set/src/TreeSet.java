import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

// TODO Complete. Use TreeMap as a source
public class TreeSet<T> implements Set<T>{

    Comparator<T> comparator;
    private final Object o = new Object();
    private TreeMap<T, Object> source;


    public TreeSet(Comparator<T> comparator) {
        this.comparator = comparator;
        TreeMap<T, Object> source = new TreeMap<>(comparator);
    }

    @Override
    public boolean add(T elt) {
        return source.put(elt, o) == null;
    }

    @Override
    public boolean remove(T elt) {
        return source.remove(elt) != null;
    }

    @Override
    public boolean contains(T elt) {
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public void addAll(Set<T> another) {
        for (T newElt : another) {
            this.add(newElt);
        }
    }

    @Override
    public void removeAll(Set<T> another) {
        for (T newElt : another) {
            this.remove(newElt);
        }
    }

    @Override
    public void retainAll(Set<T> another) {
        Set<T> temp = new TreeSet<>(comparator);

        for (T elt : this) {
            if (!another.contains(elt))
                temp.add(elt);
        }

        this.removeAll(temp);
    }

    @Override
    public Iterator<T> iterator() {
        return source.keySet().iterator();
    }
}
