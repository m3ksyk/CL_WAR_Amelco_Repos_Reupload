import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalculatorTest {

    SimpleCalculator calculator = new SimpleCalculator();
    @Test
    public void shouldAdd() {
        int a = 2;
        int b = 3;
        int result = calculator.add(a,b);
        assertEquals(result, a+b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenFirstArgumentNegative() {
        calculator.addPositive(-40, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSecondArgumentNegative() {
        calculator.addPositive(40, -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBothArgumentsNegative() {
        calculator.addPositive(-40, -2);
    }
}