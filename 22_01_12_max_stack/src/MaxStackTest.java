import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

abstract class MaxStackTest {
    MaxStack source;

    @Test
    public void testGetMax_empty() {
        assertThrows(NoSuchElementException.class, () ->{
            source.getMax();
        });
    }

    @Test
    public void testGet_empty() {
        assertThrows(NoSuchElementException.class, () ->{
            source.get();
        });
    }

    @Test
    public void TestRemove__empty() {
        assertThrows(NoSuchElementException.class, () ->{
            source.get();
        });
    }



    @Test
    public void testAddGet_empty() {
        source.add(5);
        assertEquals(5, source.get());
    }

    @Test
    public void testAddGet_twoElements() {
        source.add(5);
        source.add(10);
        assertEquals(10, source.get());
    }

    @Test
    public void testRemoveSize_oneElement() {
        source.add(5);
        assertEquals(5, source.remove());
        assertEquals(0, source.size());
    }

    @Test
    public void testRemoveSize_twoElements() {
        source.add(5);
        source.add(10);
        assertEquals(10, source.remove());
        assertEquals(1, source.size());
    }

    @Test
    public void testGetMax_1Element() {
        source.add(2);
        assertEquals(2, source.getMax());
    }

    @Test
    public void testGetMax_2Elements() {
        source.add(2);
        source.add(5);
        assertEquals(5, source.getMax());
    }

    @Test
    public void testGetMaxSize_severalElements() {
        source.add(2);
        source.add(5);
        source.add(10);
        source.add(5);
        source.add(25);
        source.remove();
        source.add(6);
        source.add(10);
        assertEquals(10, source.getMax());
        assertEquals(6, source.size());
    }
}