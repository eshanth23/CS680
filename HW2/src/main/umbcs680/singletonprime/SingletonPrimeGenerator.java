package umbcs680.singletonprime;
import java.util.Iterator;
import java.util.LinkedList;

public class SingletonPrimeGenerator {
    private static SingletonPrimeGenerator instance = null; // Singleton instance
    protected long from, to;
    protected LinkedList<Long> primes = new LinkedList<>();

    // Private constructor (Singleton)
    private SingletonPrimeGenerator() {

    }
    protected void setValues(long from,long to){
        if (from >= 1 && to > from) {
            this.from = from;
            this.to = to;
        } else {
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    public static SingletonPrimeGenerator getInstance() {
        if (instance == null) {
            instance = new SingletonPrimeGenerator();
        }
        return instance;
    }


    public LinkedList<Long> getPrimes() {
        return primes;
    }

    // Method to check if a number is even
    private boolean isEven(long n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check if a number is prime
    private boolean isPrime(long n) {
        // 1 or lower numbers are not prime.
        if (n <= 1) {
            return false;
        }
        // Even numbers are not prime, except for 2.
        if (n > 2 && isEven(n)) {
            return false;
        }
        long i;
        // Find a number "i" that can divide "n"
        for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {
        }
        // If such a number "i" is found, n is not prime. Otherwise, n is prime.
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Method to generate prime numbers in the given range
    public void generatePrimes() {
        for (long n = from; n <= to; n++) {
            if (isPrime(n)) {
                primes.add(n);
            }
        }
    }

}