import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NaiveMaxStackTest extends MaxStackTest {
    @BeforeEach
    public void init() {
        source = new NaiveMaxStack();
    }

}