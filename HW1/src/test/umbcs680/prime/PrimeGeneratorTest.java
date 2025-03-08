package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PrimeGeneratorTest{

    @Test
    public void Primes_from_1_to_10() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals(expectedPrimes,
                gen.getPrimes().toArray());

    }



    @Test
    public void Primes_from_11_to_20() {
        PrimeGenerator gen = new PrimeGenerator(11, 20);
        gen.generatePrimes();
        Long[] expectedPrimes = {11L, 13L, 17L, 19L};
        assertArrayEquals(expectedPrimes,
                gen.getPrimes().toArray());


    }


    @Test
    public void Primes_from_Negative_10_To_Positive_10_using_TryAndCatch() {
        try {
            PrimeGenerator gen = new PrimeGenerator(-10, 10);
            fail("Expected an exception for negative range");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-10 to=10", ex.getMessage());
        }
    }

    @Test
    public void Primes_from_Positive_18_To_Negative_10_using_TryAndCatch() {
        try {
            PrimeGenerator gen = new PrimeGenerator(18, -10);
            fail("Expected an exception for negative range");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=18 to=-10", ex.getMessage());
        }
    }

    @Test
    public void Primes_from_Negative_19_To_Negative_15_using_TryAndCatch() {
        try {
            PrimeGenerator gen = new PrimeGenerator(-19, -15);
            fail("Expected an exception when 'from' is greater than 'to'");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-19 to=-15", ex.getMessage());
        }
    }

    @Test
    public void Primes_from_12_to_3_using_TryAndCatch() {
        try {
            PrimeGenerator gen = new PrimeGenerator(12, 3);
            fail("Expected an exception when 'from' is greater than 'to'");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=12 to=3", ex.getMessage());
        }
    }


}
