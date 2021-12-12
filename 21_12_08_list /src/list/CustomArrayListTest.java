package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest<list> {
    CustomArrayList<Integer> intList = new CustomArrayList();
    CustomArrayList<String> stringList = new CustomArrayList();

    @Test
    public void testSet_emptyList_throwsCustomOutOfBoundsException() {
        //intList = new CustomArrayList();

        assertThrows(CustomOutOfBoundException.class, () ->{
            intList.set(0, 10);
        });
    }


    @Test
    public void testAdd_Get_Integer() {
        intList.add(1);
        assertEquals(intList.get(0), 1);
    }

    @Test
    public void testAdd_Get_String() {
        stringList.add("Hello");
        assertEquals(stringList.get(0), "Hello");
    }

    @Test
    public void testSet_Integer() {
        intList.add(1);
        intList.add(5);
        intList.set(0, 2);
        assertEquals(intList.get(0), 2);
    }

    @Test
    public void testSet_String() {
        stringList.add("Hello ");
        stringList.add("world");
        stringList.set(1, "Natalia");
        assertEquals(stringList.get(1), "Natalia");
    }

    @Test
    public void testSize_Integer() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        assertEquals(intList.size(), 3);
    }

    @Test
    public void testSize_String() {
        stringList.add("Hello");
        stringList.add("world");
        assertEquals(stringList.size(), 2);
    }

    @Test
    public void testContains_Integer_3() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        assertTrue(intList.contains(3));
    }

    @Test
    public void testContains_Integer_5() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        assertFalse(intList.contains(5));
    }

    @Test
    public void testInsert_Integer() {
        intList.add(1);
        intList.add(5);
        intList.add(3);
        intList.insert(3, 2);
        assertEquals(intList.get(3), 2);
        assertEquals(intList.size(), 4);
    }

    @Test
    public void testInsert_String() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.insert(1, "ddd");
        assertEquals(stringList.get(1), "ddd");
        assertEquals(stringList.size(), 4);
    }

    @Test public void testRemoveById_Integer() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.removeById(1);
        assertEquals(intList.get(1), 3);
        assertEquals(intList.size(), 2);
    }

    @Test public void testRemoveById_String() {
        stringList.add("aa");
        stringList.add("bb");
        stringList.add("cc");
        stringList.removeById(1);
        assertEquals(stringList.get(1), "cc");
        assertEquals(stringList.size(), 2);
    }

    @Test public void testRemoveByValue_Integer() {
        intList.add(1);
        intList.add(22);
        intList.add(3);
        intList.removeByValue(22);
        assertEquals(intList.get(1), 3);
        assertEquals(intList.size(), 2);
    }

    @Test public void testRemoveByValue_String() {
        stringList.add("aa");
        stringList.add("bb");
        stringList.add("cc");
        stringList.removeByValue("bb");
        assertEquals(stringList.get(1), "cc");
        assertEquals(stringList.size(), 2);
    }



}