import java.util.*;

class PrimesGenerator implements Iterable<Integer> {
    private final int numberOfPrimes;

    public PrimesGenerator(int numberOfPrimes) {
        this.numberOfPrimes = numberOfPrimes;
    }

    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n < 2 || n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private int currentNum = 2;

            @Override
            public boolean hasNext() {
                return count < numberOfPrimes;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (!isPrime(currentNum)) {
                    currentNum++;
                }
                count++;
                return currentNum++;
            }
        };
    }
}

class PrimesGeneratorTest {
    public static void test(int n) {
        PrimesGenerator generator = new PrimesGenerator(n);
        List<Integer> list = new ArrayList<>();
        System.out.print("Forward order: ");
        Iterator<Integer> iterator = generator.iterator();
        while (iterator.hasNext()) {
            int prime = iterator.next();
            list.add(prime);
            System.out.print(prime + " ");
        }
        System.out.println();

        Collections.reverse(list);

        System.out.print("Reverse order: ");
        Iterator<Integer> reverseIterator = list.iterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
        System.out.println();
    }
}


public class Two {
    public static void main(String[] args) {
        PrimesGeneratorTest.test(25);
    }
}
