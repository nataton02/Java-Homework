import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    // 1. Написать методы intersect и union, которые принимают лист предикатов,
    //  а возвращают их пересечение и объединение соответственно. Использовать стрим. Протестировать


    public <T> Predicate<T> union(List<Predicate<T>> predicates) {
        Predicate<T> res = (t) -> false;
        return predicates.stream()
                .reduce(res, Predicate :: or); // reduce(res, (currentRes, element) -> currentRes.or(element)
    };


    public <T> Predicate<T> intersect(List<Predicate<T>> predicates){
        if(predicates.size() == 0)
            throw new IllegalArgumentException();

        Predicate<T> res = (t) -> true;
        return predicates.stream()
                .reduce(res, Predicate :: and);
    }

    //2. Есть словарь плохих слов (Set<String>) и текст. Написать метод, который принимает словарь
    // плохих слов и текст, а возвращает список (лист) плохих слов, найденных в тексте в алфавитном порядке
    // (не повторяясь). List<String> function(Set<String> badWords, String text);

    List<String> findBadWords(Set<String> badWords, String text) {
        List<String> words = Arrays.asList(text.split(" "));
        return badWords.stream()
                .filter(words :: contains)
                .sorted()
                .collect(Collectors.toList());
    };

}

