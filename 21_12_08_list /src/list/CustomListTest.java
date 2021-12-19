package list;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

abstract class CustomListTest {
    CustomList<Integer> list;
    CustomList<String> stringList;


    @Test
    public void testSet_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundException.class, () ->{
            list.set(0, 10);
        });
    }

    @Test
    public void testGet_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundException.class, () ->{
            list.get(0);
        });
    }

    @Test
    public void testRemoveById_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundException.class, () ->{
            list.removeById(0);
        });
    }

    @Test
    public void testInsert_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundException.class, () ->{
            list.insert(1, 10);
        });
    }

    @Test
    public void testAddSize_threeNumbers() {
        list.add(20);
        list.add(10);
        list.add(-5);
        assertEquals(3, list.size());
    }

    @Test
    public void testAddSize_9Numbers() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(3);
        list.add(8);
        list.add(-20);
        list.add(11);
        list.add(18);
        list.add(-1);
        assertEquals(9, list.size());
    }

    @Test
    public void testAddGet_threeNumbers() {
        list.add(20);
        list.add(10);
        list.add(-5);
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(-5, list.get(2));
    }

    @Test
    public void testAddGet_100RandomNumbers() {
        int[] randomNumbers = generateRandomNumbers(100);

        for (int i = 0; i < randomNumbers.length; i++) {
            list.add(randomNumbers[i]);
        }

        assertListContents(randomNumbers);
    }

    private void assertListContents(int[] array) {
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], list.get(i));
        }
    }

    private int[] generateRandomNumbers(int n) {
        int[] res = new int[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            res[i] = rnd.nextInt();
        }
        return res;
    }

    @Test
    public void testContains_severalNumbers_true() {
        list.add(20);
        list.add(10);
        list.add(-5);
        assertTrue(list.contains(10));
    }

    @Test
    public void testContains_severalNumbers_false() {
        list.add(20);
        list.add(10);
        list.add(-5);
        assertFalse(list.contains(15));
    }

    @Test
    public void testRemoveById_idTwo() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(8);
        assertEquals(-5, list.removeById(2));
        assertListContents(new int[]{20, 10, 8});
    }

    @Test
    public void testRemoveById_idThree() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(8);
        assertEquals(8, list.removeById(3));
        assertListContents(new int[]{20, 10, -5});
    }

    @Test
    public void testRemoveById_idZero() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(8);
        assertEquals(20, list.removeById(0));
        assertListContents(new int[]{10, -5, 8});
    }

    @Test
    public void testRemoveByValue_10() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(8);
        assertTrue(list.removeByValue(10));
        assertListContents(new int[]{20, -5, 8});
    }

    @Test
    public void testRemoveByValue_8() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(8);
        assertTrue(list.removeByValue(8));
        assertListContents(new int[]{20, 10, -5});
    }

    @Test
    public void testRemoveByValue_2false() {
        list.add(20);
        list.add(10);
        list.add(-5);
        list.add(8);
        assertFalse(list.removeByValue(2));
        assertListContents(new int[]{20, 10, -5, 8});
    }

    @Test
    public void testInsert_emptyListZeroIndex() {
        list.insert(0, 10);

        assertEquals(1, list.size());
        assertListContents(new int[]{10});
    }

    @Test
    public void testInsert_emptyListNoneZeroIndex() {
        assertThrows(CustomOutOfBoundException.class, () -> list.insert(1, 10));
        assertThrows(CustomOutOfBoundException.class, () -> list.insert(-1, 10));
    }

    @Test
    public void testInsert_noneEmptyListZeroIndex() {
        list.add(10);
        list.insert(0, 15);

        assertEquals(2, list.size());
        assertListContents(new int[]{15, 10});
    }

    @Test
    public void testInsert_noneEmptyListSizeIndex() {
        list.add(10);
        list.insert(1, 15);

        assertEquals(2, list.size());
        assertListContents(new int[]{10, 15});
    }

    @Test
    public void testInsert_noneEmptyListMiddleIndex() {
        list.add(10);
        list.add(18);
        list.insert(1, 15);

        assertEquals(3, list.size());
        assertListContents(new int[]{10, 15, 18});

    }


}