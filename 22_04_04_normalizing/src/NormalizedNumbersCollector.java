import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class NormalizedNumbersCollector implements Collector<Double, List<Double>, List<Double>> {
    @Override
    public Supplier<List<Double>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Double>, Double> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Double>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Double>, List<Double>> finisher() {
        return (doubleNumbers) -> {
            Collections.sort(doubleNumbers);

            List<Double> normalizedNumbers =  new ArrayList<>();
            double min = doubleNumbers.get(0);
            double max = doubleNumbers.get(doubleNumbers.size() - 1);

            // x -> (x - min)/(max-min)
            for(double elt : doubleNumbers) {
                elt = (elt - min) / (max - min);
                normalizedNumbers.add(elt);
            }
            return normalizedNumbers;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Set.of(Characteristics.CONCURRENT));
    }
}
