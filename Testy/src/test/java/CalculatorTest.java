import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void add() {
        int a = 2;
        int b = 2;
        int result = calculator.add(a,b);
        assertEquals(result, a+b);
    }

    @Test
    public void subtract() {
        int a = 2;
        int b = 2;
        int result = calculator.subtract(a, b);
        assertEquals(result, a - b);
    }

    @Test
    public void multiply() {
        int a = 2;
        int b = 2;
        int result = calculator.multiply(a,b);
        assertEquals(result, a*b);

    }

    @Test
    public void divide() {
        int a = 2;
        int b = 2;
        int result = calculator.divide(a,b);
        assertEquals(result, a/b);

    }
    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        int a = 2;
        int b = 0;
        int result = calculator.divide(a,b);
        assertEquals(result, a/b);

    }

    @Test
    public void greater() {
        int a = 3;
        int b = 2;
        assertTrue(calculator.greater(a,b));
    }
    @Test
    public void notGreater() {
        int a = 1;
        int b = 2;
        assertFalse(calculator.greater(a,b));
    }

    @Test
    public void evaluatesExpression() {
        double sum = calculator.eval("1+2+3");
        assertEquals(6, sum, 0.1);
    }
}