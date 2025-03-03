package umbcs680.singletonprime;
import java.util.Iterator;
import java.util.LinkedList;

public class SingletonPrimeGenerator {
    private static SingletonPrimeGenerator instance = null; // Singleton instance
    private long from, to;
    private LinkedList<Long> primes = new LinkedList<>();

    // Private constructor (Singleton)
    private SingletonPrimeGenerator(long from, long to) {
        if (from >= 1 && to > from) {
            this.from = from;
            this.to = to;
        } else {
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    // Static factory method to get the single instance
    public static SingletonPrimeGenerator getInstance(long from, long to) {
        if (instance == null) {
            instance = new SingletonPrimeGenerator(from, to);
        }
        return instance;
    }

    // Getter for primes list
    public LinkedList<Long> getPrimes() {
        return primes;
    }

    // Method to check if a number is even
    private boolean isEven(long n) {
        return n % 2 == 0;
    }

    // Method to check if a number is prime
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n > 2 && isEven(n)) return false;

        long i;
        for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {}

        return i == 1;
    }

    // Method to generate prime numbers in the given range
    public void generatePrimes() {
        for (long n = from; n <= to; n++) {
            if (isPrime(n)) {
                primes.add(n);
            }
        }
    }

    // Main method to test the SingletonPrimeGenerator
    public static void main(String[] args) {
        SingletonPrimeGenerator generator = SingletonPrimeGenerator.getInstance(1, 100);
        generator.generatePrimes();
        LinkedList<Long> primes = generator.getPrimes();

        // Print prime numbers
        Iterator<Long> it = primes.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }

        System.out.println("\n" + generator.getPrimes().size() + " primes are found.");

        // Trying to get another instance with different range (should return same object)
        SingletonPrimeGenerator anotherGenerator = SingletonPrimeGenerator.getInstance(500, 800);
        System.out.println("Same instance? " + (generator == anotherGenerator)); // Should print true
    }
}
