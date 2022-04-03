import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {

    }

    // 1. Есть стрим Stream<Integer>. Посчитать сумму квадратов чисел из него. (Используя коллекторы)
    public int sumOfSquares(Stream<Integer> stream) {
        return stream.collect(summingInt(n -> n * n));
    }

    // 2. Есть стрим Stream<Integer>. Посчитать произведение квадратов чисел из него. (Используя коллекторы)
    public long multiplicationOfSquares(Stream<Integer> stream) {
        return stream.collect(reducing(1, n -> n * n, (res, current) -> res * current));
    }

    // 3-a. Есть лист строк.
    // - Получить из него Map<Boolean, List<String>>, напротив true в котором будут собраны все палиндромы из листа,
    // а напротив false все остальное
    public Map<Boolean, List<String>> containsPalindrome(List<String> strings) {
        return strings.stream()
                .collect(partitioningBy((str) -> isPalindrome(str)));
    }

    public static boolean isPalindrome(String string) {
        StringBuilder sb =  new StringBuilder(string);
        String newString = sb.reverse().toString();
        return string.equalsIgnoreCase(newString);
    }

    // 3-b. Есть лист строк.
    // - получить Map<Boolean, Long>, который в качестве значений содержит количества палиндромов и непалинромов.
    public Map<Boolean, Long> countPalindromeAndNonPalindrome(List<String> strings) {
        return strings.stream()
                .collect(partitioningBy((str) -> isPalindrome(str), counting()));
    }

    // 4. Есть class Transaction{String uuid; long sum; String accountUuid}. Посчитать сумму транзакций
    // для каждого аккаунта.  Map<String, Long> totalTransactionsByAccount

    public Map<String, Long> sumOfTransactionsByAccount(List<Transaction> transactions) {
        return transactions.stream()
                .collect(groupingBy(Transaction::getAccountUuid, summingLong(Transaction::getSum)));
    }

    // 5-a. Есть class LogEntry{String login, String url}
    // Посчитать для каждого url, сколько раз он был тыкнут

    public Map<String, Long> countNumberOfVisits(List<LogEntry> visits) {
        return visits.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }

    //* 5-b Посчитать количество уникальных посещений каждого url
    // (необходимо обратить внимание на некоторые коллекторы, которые не были упомянуты на занятии)


    //* 5-c Вывести для каждого аккаунта Set посещенных страниц

}





