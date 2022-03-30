import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main solution = new Main();

    // union
    @Test
    public void testUnion_0Elements() {
        List<Predicate<Integer>> predicates = new ArrayList<>();
        Predicate<Integer> pr = solution.union(predicates);
        assertFalse(pr.test(2));
    }

    @Test
    public void testUnion_1ElementFalse() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 50);
        Predicate<Integer> pr = solution.union(predicates);
        assertFalse(pr.test(60));
    }

    @Test
    public void testUnion_1ElementTrue() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 50);
        Predicate<Integer> pr = solution.union(predicates);
        assertTrue(pr.test(2));
    }

    @Test
    public void testUnion_3ElementsTrue() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 10, y -> y < 20, z -> z % 2 == 0);
        Predicate<Integer> pr = solution.union(predicates);
        assertTrue(pr.test(2));
    }

    @Test
    public void testUnion_3ElementsFalse() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 10, y -> y < 20, z -> z % 2 == 0);
        Predicate<Integer> pr = solution.union(predicates);
        assertFalse(pr.test(21));
    }

    // intersect

    @Test
    public void testIntersect_0Elements() {
        List<Predicate<Integer>> predicates = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
             solution.intersect(predicates).test(2);
        });
    }

    @Test
    public void testIntersect_1ElementFalse() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 10);
        Predicate<Integer> pr = solution.intersect(predicates);
        assertFalse(pr.test(20));
    }

    @Test
    public void testIntersect_1ElementTrue() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 10);
        Predicate<Integer> pr = solution.intersect(predicates);
        assertTrue(pr.test(2));
    }

    @Test
    public void testIntersect_3ElementsTrue() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 10, y -> y < 20, z -> z % 2 == 0);
        Predicate<Integer> pr = solution.intersect(predicates);
        assertTrue(pr.test(2));
    }

    @Test
    public void testIntersect_3ElementsFalse() {
        List<Predicate<Integer>> predicates = Arrays.asList(x -> x < 10, y -> y < 20, z -> z % 2 == 0);
        Predicate<Integer> pr = solution.intersect(predicates);
        assertFalse(pr.test(3));
    }

    // bad words
    @Test
    public void testFindBadWords() {
        String text = "Lorem ipsum is simply Dummy text of the printing and typesetting industry.";
        Set<String> badWords = new HashSet<>();
        badWords.add("ipsum");
        badWords.add("of");
        badWords.add("dummy");
        List<String> actual = solution.findBadWords(badWords, text);
        List<String> expected = Arrays.asList("dummy", "ipsum", "of");
        assertEquals(expected, actual);
    }


}