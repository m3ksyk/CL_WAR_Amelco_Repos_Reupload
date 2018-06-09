import org.junit.Test;


import static org.junit.Assert.*;

public class HW_YearUtilsTest {

    YearUtils yearUtils = new YearUtils();

    @Test
    public void shouldReturnTrue(){
        assertTrue(yearUtils.isYearLeap(2000));
    }

    @Test
    public void shouldReturnFalse(){
        assertFalse(yearUtils.isYearLeap(2001));
    }
}
