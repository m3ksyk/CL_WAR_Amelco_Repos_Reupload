import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void shouldReturnCircleArea(){
        double r = 2;
        assertEquals(12.56, Circle.circleArea(r), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException(){
        double r = -1;
        Circle.circleArea(r);
    }
    @Test
    public void shouldRoundUpToTwoDecimalPlaces() {
        int actual = (int) (Circle.circleArea(5) * 100);
        assertEquals(7854, actual);
    }
}
