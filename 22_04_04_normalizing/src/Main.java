import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// Есть Stream<Double>. Написать коллектор, который из этого стрима получает лист нормализованных чисел.
        // Все числа должны быть от 0 до 1. Необходимо найти минимальное и максимальное числа
        // и затем к каждому числу применить формулу: x -> (x - min)/(max-min)

        Stream<Double> doubleStream = Stream.of(5.4, 18.1, 16.0, 83.7, 10.0, 0.66);
        Collector<Double, List<Double>, List<Double>> normalizedNumbersCollector = new  NormalizedNumbersCollector();
        List<Double> normalizedNumbers = doubleStream.collect(normalizedNumbersCollector);
        System.out.println(normalizedNumbers);
    }
}
