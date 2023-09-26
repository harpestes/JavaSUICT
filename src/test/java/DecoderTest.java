import org.example.Decoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecoderTest {

    private Decoder dc;

    @BeforeEach
    void setUp() {
        dc = new Decoder();
    }

    @Test
    void testFirstCondition() {
        assertEquals("test", dc.decode("t2st"));
    }

    @Test
    void testSecondCondition() {
        assertEquals("test", dc.decode("sers"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", dc.decode(""));
    }

    @Test
    void testLetterZ() {
        assertEquals("books", dc.decode("zoojr"));
    }

    @Test
    void testDecodeWithNoMatchingCharacters() {
        assertEquals("67890", dc.decode("67890"));
    }
}
