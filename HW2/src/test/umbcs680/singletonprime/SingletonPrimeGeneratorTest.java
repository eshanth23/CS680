package umbcs680.singletonprime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    public void from1to10() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }





    @Test
    public void negativeRangeToNegativeRangeWithTryCatch() {
        try {
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(-19, -15);
            fail("Expected an exception for negative range");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-19 to=-15", ex.getMessage());
        }
    }

    @Test
    public void invalidRangeWithTryCatch() {
        try {
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(12, 3);
            fail("Expected an exception when 'from' is greater than 'to'");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=12 to=3", ex.getMessage());
        }
    }
}
