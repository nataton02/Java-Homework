import java.util.*;

public class Main {

    public static void main(String[] args) {
	    // Написать лямбду, которая принимает лист строк, а возвращает лист неповторяющихся строк
        // (Использовать интерфейс Function<List<String>, List<String>> )unique


        Function unification = (List<String> strings) -> {
            Set<String> hashSet = new HashSet<>(strings);
            List<String> uniqueStrings = new ArrayList<>(hashSet);
            return uniqueStrings;
        };

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("a");
        strings.add("c");
        strings.add("a");
        strings.add("d");
        strings.add("b");
        System.out.println(unification.unify(strings));
    }
}
