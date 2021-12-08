package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    CustomArrayList list;

    @Test
    public void testSet_emptyList_throwsCustomOutOfBoundsException() {
        list = new CustomArrayList();

        assertThrows(CustomOutOfBoundException.class, () ->{
            list.set(0, 10);
        });
    }


}