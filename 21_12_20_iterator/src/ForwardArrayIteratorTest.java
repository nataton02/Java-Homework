import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ForwardArrayIteratorTest {
    @Test
    public void testIterator_emptyArray_nothing() {
        int[] array = {};

        int[] res = iterateToArray(array);
        assertArrayEquals(new int[]{}, res);
    }

    @Test
    public void testIterator_oneElement() {
        int[] array = {10};

        int[] res = iterateToArray(array);
        assertArrayEquals(new int[]{10}, res);
    }

    @Test
    public void testIterator_severalElements() {
        int[] array = {2, 6, -11, 35};

        int[] res = iterateToArray(array);
        assertArrayEquals(new int[]{2, 6, -11, 35}, res);
        assertArrayEquals(new int[]{2, 6, -11, 35}, array);
    }

    private int[] iterateToArray(int[] array) {
        int[] res = new int[array.length];

        Iterator<Integer> iterator = new ForwardArrayIterator(array);
        int i = 0;
        while(iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }
}