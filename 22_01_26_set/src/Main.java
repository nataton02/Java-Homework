import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        Set<Integer> numbers2 = new HashSet<>();

        // numbers: {1, 7, -5, 10}; numbers2: {8, 10, 7, 15, 17};
        //обьединение двух множеств в numbers, в numbers будут лежать все элементы из обоих множеств:
        // {1, 7, -5, 10, 8, 15, 17}
        numbers.addAll(numbers2);

        // в numbers будут лежать только те элементы, которые есть в numbers и которых нет в numbers2
        // {1, -5}
        numbers.removeAll(numbers2);

        // отсавит в numbers только те элементы, которые существуют в обоих множествах {7, 10}
        numbers.retainAll(numbers2);

        //если тип данных для TreeSet или TreeMap (ключи) является Comparable, то оьбект Компаратора при
        // инициализации этого TreeSet или TreeMap  не обязателен
        Set<Integer> numbers3 = new TreeSet<>();
        Set<Integer> numbers4 = new TreeSet<>();

    }
}
