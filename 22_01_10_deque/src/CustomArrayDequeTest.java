import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayDequeTest {
    CustomArrayDeque<Integer> deque = new CustomArrayDeque<>();

    @Test
    public void testGetFirst_emptyArray_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () ->{
            deque.getFirst();
        });
    }

    @Test
    public void testGetLast_emptyArray_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () ->{
            deque.getLast();
        });
    }

    @Test
    public void testRemoveFirst_emptyArray_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () ->{
            deque.removeFirst();
        });
    }

    @Test
    public void testRemoveLast_emptyArray_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () ->{
            deque.removeLast();
        });
    }



    @Test
    public void testAddGetLast() {
        deque.addLast(3);
        deque.addLast(8);

        assertEquals(8, deque.getLast());
    }

    @Test
    public void testAddLastSize_9Numbers() {
        deque.addLast(10);
        deque.addLast(3);
        deque.addLast(8);
        deque.addLast(1);
        deque.addLast(-6);
        deque.addLast(80);
        deque.addLast(24);
        deque.addLast(30);
        deque.addLast(17);

        assertEquals(17, deque.getLast());
        assertEquals(9, deque.size());
    }

    @Test
    public void testAddFirstSize_emptyArray() {
        deque.addFirst(4);

        assertEquals(4, deque.getFirst());
        assertEquals(1, deque.size());
    }

    @Test
    public void testAddFirstSize_severalNumbers() {
        deque.addLast(10);
        deque.addLast(3);
        deque.addLast(-4);
        deque.addLast(18);

        deque.addFirst(1);

        assertEquals(1, deque.getFirst());
        assertEquals(5, deque.size());
    }

    @Test
    public void testAddFirstSize_9Numbers() {
        deque.addLast(10);
        deque.addLast(3);
        deque.addLast(8);
        deque.addLast(1);
        deque.addLast(-6);
        deque.addLast(80);
        deque.addLast(24);
        deque.addLast(30);
        deque.addLast(15);

        deque.addFirst(1);

        assertEquals(1, deque.getFirst());
        assertEquals(10, deque.size());
    }

    @Test
    public void testRemoveLastSize_oneElement() {
        deque.addLast(10);

        assertEquals(10, deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveLastSize_severalNumbers() {
        deque.addLast(10);
        deque.addLast(3);
        deque.addLast(-4);
        deque.addLast(18);

        assertEquals(18, deque.removeLast());
        assertEquals(-4, deque.getLast());
        assertEquals(3, deque.size());
    }

    @Test
    public void testRemoveFirstSize_oneElement() {
        deque.addLast(3);

        assertEquals(3, deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirstSize_severalNumbers() {
        deque.addLast(10);
        deque.addLast(3);
        deque.addLast(-4);
        deque.addLast(18);

        assertEquals(10, deque.removeFirst());
        assertEquals(3, deque.getFirst());
        assertEquals(3, deque.size());
    }
}