package umbcs680.singletonprime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    public void NotNull_Instance_test(){
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
        instance1.setValues(5,11);
        assertNotNull(instance1);
    }
    @Test
    public void Singleton_Instance() {
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
        instance1.setValues(1,20);
        instance1.generatePrimes();
        SingletonPrimeGenerator instance2 = SingletonPrimeGenerator.getInstance();
        instance2.setValues(5,15);
        instance2.generatePrimes();
        assertSame(instance1, instance2);
        assertEquals(instance1,instance2);
    }


    @Test
    public void Primes_from_from_30_to_40() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
        gen.setValues(30,40);
        gen.generatePrimes();
        Long[] expectedPrimes = {31L, 37L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }



    @Test
    public void Primes_from_negative_19_To_Negative_15_With_TryCatch() {
        try {
            SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
            instance1.setValues(-19,-15);
            instance1.generatePrimes();
            fail("Invalid and negative range was passed");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-19 to=-15", ex.getMessage());
        }
    }
    @Test
    public void Primes_from_Positive_20_To_Positive_20_With_TryCatch() {
        try {
            SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
            instance1.setValues(20,20);
            instance1.generatePrimes();
            fail("Invalid range as from==to");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=20 to=20", ex.getMessage());
        }
    }

}
