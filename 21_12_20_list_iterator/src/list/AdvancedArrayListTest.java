package list;

import org.junit.jupiter.api.BeforeEach;

class AdvancedArrayListTest extends CustomListTest{
    @BeforeEach
    public void init() {
        list = new AdvancedArrayList<>();
        stringList = new AdvancedArrayList<>();
    }
}