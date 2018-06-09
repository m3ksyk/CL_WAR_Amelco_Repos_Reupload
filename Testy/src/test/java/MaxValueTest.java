import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValueTest {

    MaxValue maxValue = new MaxValue();

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenEmptyList() {
        int [] list = {};
        int  max = maxValue.largest(list);
    }
    @Test
    public void shouldFindLargest() {
        int[] list = {1,2,3,4,5,6};
        int max = maxValue.largest(list);
        assertEquals(6, max);
    }
}