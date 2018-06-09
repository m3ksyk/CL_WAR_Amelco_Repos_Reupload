import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HW_NWDTest {
    NWD nwd = new NWD();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnFirstArg(){
        int a = -2;
        int b = 2;
        nwd.greatestCommonDivisor(a,b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnSecondArg(){
        int a = 2;
        int b = -2;
        nwd.greatestCommonDivisor(a,b);
    }

    @Test
    public void shouldReturnGreatestCommonDivisor(){
        int a = 6;
        int b = 9;
        int gdc = 3;
        assertEquals(gdc, nwd.greatestCommonDivisor(a,b));
    }
}
