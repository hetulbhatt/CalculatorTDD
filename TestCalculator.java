import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculator {
    
    @Test
    public void add_emptyis0() {
        assertEquals(0, new Calculator().add(""));
    }
    
    @Test
    public void add_singleNumberisTheNumberItself() {
        assertEquals(20, new Calculator().add("20"));
    }
}
