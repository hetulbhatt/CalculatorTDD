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

    @Test
    public void add_twoNumbersisTheSum() {
        assertEquals(20, new Calculator().add("8,12"));
    }

    @Test
    public void add_multipleNumbersisTheSum() {
        assertEquals(30, new Calculator().add("8,12,10"));
    }
}
