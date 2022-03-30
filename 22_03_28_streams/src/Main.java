import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    // 1. Написать методы intersect и union, которые принимают лист предикатов,
    //  а возвращают их пересечение и объединение соответственно. Использовать стрим. Протестировать


    // 1 вариант
    public <T> Predicate<T> union(List<Predicate<T>> predicates) {
        Predicate<T> res = (t) -> false;
        return predicates.stream()
                .reduce(res, Predicate :: or); // reduce(res, (currentRes, element) -> currentRes.or(element)
    };

    // 2 вариант
    public <T> Predicate<T> union2(List<Predicate<T>> predicates) {
        Optional <Predicate<T>> optionalTPredicate = predicates.stream()
                .reduce(Predicate :: or);
        Predicate<T> res = optionalTPredicate.orElse((T t) -> true);
        return res;
    };


    //1 вариант
    public <T> Predicate<T> intersect(List<Predicate<T>> predicates){
        if(predicates.size() == 0)
            throw new IllegalArgumentException();

        Predicate<T> res = (t) -> true;
        return predicates.stream()
                .reduce(res, Predicate :: and);
    }
    //2 вариант
    public <T> Predicate<T> intersect2(List<Predicate<T>> predicates){
        return predicates.stream()
                .reduce(Predicate :: and)
                .orElseThrow(NoSuchElementException::new);
    }

    //2. Есть словарь плохих слов (Set<String>) и текст. Написать метод, который принимает словарь
    // плохих слов и текст, а возвращает список (лист) плохих слов, найденных в тексте в алфавитном порядке
    // (не повторяясь). List<String> function(Set<String> badWords, String text);

    //1 вариант
    List<String> findBadWords(Set<String> badWords, String text) {
        List<String> words = Arrays.asList(text.split(" "));
        return words.stream()
                .map(s -> s.toLowerCase(Locale.ROOT))
                .filter(badWords::contains)//.filter(badWord -> words.contains(badWord))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    };
    // 2 вариант
    List<String> check(Set<String> badWords, String text) {
         return Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .filter(badWords::contains)//.filter(badWord -> words.contains(badWord))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    };

}

