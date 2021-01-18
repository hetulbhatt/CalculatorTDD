import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculator {
    
    @Test
    public void testAdd() {
        assertEquals(0, new Calculator().add(""));
    }
}
