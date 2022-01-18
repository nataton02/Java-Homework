import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ImprovedMaxStackTest extends MaxStackTest {
    @BeforeEach
    public void init() {
        source = new ImprovedMaxStack();
    }

}