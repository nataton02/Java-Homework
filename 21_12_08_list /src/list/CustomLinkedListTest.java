package list;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest extends CustomListTest{
    @BeforeEach
    public void init() {
        list = new CustomLinkedList<>();
        stringList = new CustomLinkedList<>();
    }


}