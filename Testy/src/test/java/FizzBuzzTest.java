import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void shouldReturnFizz(){
        int n = 3;
        String actual = FizzBuzz.fizzBuzz(n);
        String expected = "12Fizz";
//        String expected = "Fizz";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnBuzz(){
        int n = 5;
        String actual = FizzBuzz.fizzBuzz(n);
        String expected = "12Fizz4Buzz";
//        String expected = "Buzz";
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnBuzzFizz(){
        int n = 15;
        String actual = FizzBuzz.fizzBuzz(n);
        String expected = "12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz";
//        String expected = "FizzBuzz";
        assertEquals(expected, actual);
    }
}
