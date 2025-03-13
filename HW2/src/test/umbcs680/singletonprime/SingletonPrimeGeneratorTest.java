package umbcs680.singletonprime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {
    @Test
    public void Singleton_Instance() {
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance(1, 20);
        SingletonPrimeGenerator instance2 = SingletonPrimeGenerator.getInstance(30, 40);

        assertSame(instance1, instance2);
    }


    @Test
    public void Primes_from_from_30_to_40() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(30, 40);
        gen.generatePrimes();
        Long[] expectedPrimes = {31L, 37L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }



    @Test
    public void Primes_from_negative_19_To_Negative_15_With_TryCatch() {
        try {
            SingletonPrimeGenerator.getInstance(-19, -15);
            fail("Invalid and negative range was passed");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-19 to=-15", ex.getMessage());
        }
    }
    @Test
    public void Primes_from_Positive_20_To_Positive_20_With_TryCatch() {
        try {
            SingletonPrimeGenerator.getInstance(20, 20);
            fail("Invalid range as from==to");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=20 to=20", ex.getMessage());
        }
    }

}
