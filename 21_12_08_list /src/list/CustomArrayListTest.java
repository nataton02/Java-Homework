package list;

import org.junit.jupiter.api.BeforeEach;

class CustomArrayListTest extends CustomListTest {
    @BeforeEach
    public void init() {
        list = new CustomArrayList<>();
        stringList = new CustomArrayList<>();
    }
}