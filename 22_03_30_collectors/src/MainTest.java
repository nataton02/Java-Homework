import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main solution = new Main();

    @Test
    public void testSunOfSquares_1number() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{2});
        assertEquals(4, solution.sumOfSquares(numbers));
    }

    @Test
    public void testSunOfSquares_severalNumbers() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4});
        assertEquals(30, solution.sumOfSquares(numbers));
    }

    @Test
    public void testMultiplicationOfSquares_1number() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{2});
        assertEquals(4, solution.multiplicationOfSquares(numbers));
    }

    @Test
    public void testMultiplicationOfSquares_severalNumbers() {
        Stream<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4});
        assertEquals(576, solution.multiplicationOfSquares(numbers));
    }

    @Test
    public void testContainsPalindrome_TrueAndFalse() {
        List<String> strings = Arrays.asList("anna", "abc", "banan", "a", "madam");
        Map<Boolean, List<String>> map  =  new HashMap<>();
        map.put(true, Arrays.asList("anna", "a", "madam"));
        map.put(false, Arrays.asList("abc", "banan"));
        assertEquals(map, solution.containsPalindrome(strings));
    }

    @Test
    public void testContainsPalindrome_noTrue() {
        List<String> strings = Arrays.asList("abc", "banan");
        Map<Boolean, List<String>> map  =  new HashMap<>();
        map.put(true, Arrays.asList());
        map.put(false, Arrays.asList("abc", "banan"));
        assertEquals(map, solution.containsPalindrome(strings));
    }

    @Test
    public void testContainsPalindrome_noFalse() {
        List<String> strings = Arrays.asList("anna", "a", "madam");
        Map<Boolean, List<String>> map  =  new HashMap<>();
        map.put(true, Arrays.asList("anna", "a", "madam"));
        map.put(false, Arrays.asList());
        assertEquals(map, solution.containsPalindrome(strings));
    }

    @Test
    public void testCountPalindromeAndNonPalindrome() {
        List<String> strings = Arrays.asList("anna", "abc", "banan", "a", "madam");
        Map<Boolean, Long> map = new HashMap<>();
        map.put(true, 3L);
        map.put(false, 2L);
        assertEquals(map, solution.countPalindromeAndNonPalindrome(strings));
    }

    @Test
    public void testCountPalindromeAndNonPalindrome_0True() {
        List<String> strings = Arrays.asList("abc", "banan");
        Map<Boolean, Long> map = new HashMap<>();
        map.put(true, 0L);
        map.put(false, 2L);
        assertEquals(map, solution.countPalindromeAndNonPalindrome(strings));
    }

    @Test
    public void testCountPalindromeAndNonPalindrome_0False() {
        List<String> strings = Arrays.asList("anna", "a", "madam");
        Map<Boolean, Long> map = new HashMap<>();
        map.put(true, 3L);
        map.put(false, 0L);
        assertEquals(map, solution.countPalindromeAndNonPalindrome(strings));
    }

    @Test
    public void testSumOfTransactionsByAccount() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", 5000, "2"),
                new Transaction("2", 1000, "3"),
                new Transaction("3", 200, "1"),
                new Transaction("4", 15000, "3"),
                new Transaction("5", 800, "3"),
                new Transaction("6", 25000, "1")
        );
        Map<String, Long> map = new HashMap<>();
        map.put("1", 25200L);
        map.put("2", 5000L);
        map.put("3", 16800L);
        assertEquals(map, solution.sumOfTransactionsByAccount(transactions));
    }

    @Test
    public void testCountNumberOfVisits() {
        List<LogEntry> entries = Arrays.asList(
                new LogEntry("vasya@gmail.com", "http://www.courses/java"),
                new LogEntry("petya@gmail.com", "http://www.courses/php"),
                new LogEntry("masha@gmail.com", "http://www.courses/javascript"),
                new LogEntry("olga@gmail.com", "http://www.courses/java"),
                new LogEntry("masha@gmail.com", "http://www.courses/java"),
                new LogEntry("vasya@gmail.com", "http://www.courses/php"),
                new LogEntry("alex@gmail.com", "http://www.courses/mysql"),
                new LogEntry("vasya@gmail.com", "http://www.courses/java"),
                new LogEntry("alex@gmail.com", "http://www.courses/mysql"),
                new LogEntry("masha@gmail.com", "http://www.courses/javascript")
        );
        Map<String, Long> map = new HashMap<>();
        map.put("http://www.courses/java", 4L);
        map.put("http://www.courses/php", 2L);
        map.put("http://www.courses/javascript", 2L);
        map.put("http://www.courses/mysql", 2L);
        assertEquals(map, solution.countClicksByUrl(entries));
    }
}