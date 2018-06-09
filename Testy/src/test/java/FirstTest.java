import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FirstTest {
    First first = new First();
    @Test
    public void concatString() {

        String a = "foo";
        String b = "bar";

        String actual = first.concatString(a,b);
        assertThat(actual, is( "foobar"));
    }

    @Test
    public void multiply() {
        int a = 40;
        int b = 2;
        int result = first.multiply(a,b);
        assertThat(result, is(80));
    }
}