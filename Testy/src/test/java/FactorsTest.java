import org.junit.Test;

import static org.junit.Assert.*;

public class FactorsTest {


    @Test
    public void shouldGeneratePrimeFactorsOfOne() {
        int n = 1;
        Integer[] factors = {1};
        assertArrayEquals(factors,Factors.generatePrimeFactors(n));
    }

    @Test
    public void shouldGeneratePrimeFactorsOfTen() {
        int n = 10;
        Integer[] factors = {1,2,5,10};
        assertArrayEquals(factors,Factors.generatePrimeFactors(n));
    }

    @Test
    public void shouldGeneratePrimeFactorsOfNine() {
        int n = 9;
        Integer[] factors = {1,3,9};

        assertArrayEquals(factors,Factors.generatePrimeFactors(n));
    }
}