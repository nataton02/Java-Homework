import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class NaiveMaxStackTest {
    NaiveMaxStack source = new NaiveMaxStack();

    @Test
    public void testMaxStack_empty() {
        assertThrows(IllegalStateException.class, () ->{
            source.getMax();
        });
    }

    @Test
    public void testMaxStack_1Elements() {
        source.add(2);
        assertEquals(2, source.getMax());
        assertEquals(1, source.size());
    }

    @Test
    public void testMaxStack_2Elements() {
        source.add(2);
        source.add(5);
        assertEquals(5, source.getMax());
        assertEquals(2, source.size());
    }

    @Test
    public void testMaxStack_severalElements() {
        source.add(2);
        source.add(5);
        source.add(10);
        source.add(5);
        source.add(25);
        source.remove();
        source.add(6);
        source.add(9);
        assertEquals(10, source.getMax());
        assertEquals(6, source.size());
    }
}