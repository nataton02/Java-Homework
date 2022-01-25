import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoPairTest {
    NoPair noPair = new NoPair();

    @Test
    public void testElementWithoutPair() {
        List<Integer> numbers = Arrays.asList(5, 1, 5, 7, 5, 1, 7, 7, 5);
        assertEquals(7, noPair.elementWithoutPair(numbers));
    }

}