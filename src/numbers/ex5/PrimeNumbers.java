package numbers.ex5;


import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumbers {
    public static void main(String[] args) {
        findPrimeNumbers();
    }

    private static void findPrimeNumbers() {
        System.out.printf("%n%s", "prime numbers:");
        IntStream.of(Stream.iterate(1, x -> new Random().nextInt(100))
                .mapToInt(x -> x).limit(20).toArray())
                .filter(PrimeNumbers::isPrimeNumber)
                .sorted().distinct()
                .forEach(x -> System.out.format("%3d", x));
        System.out.println();
    }

    /**
     * @param number source from findPrimeNumbers
     * @return checks if the number is simple and return
     */
    private static boolean isPrimeNumber(int number) {
        final double numberSquareRoot = Math.sqrt(number);
        if (number <= 1)
            return false;
        if (number == 2)
            return true;
        for (long i = 3; i <= numberSquareRoot; i += 2) {
            if (number % i == 0)
                return false;
        }
        return number % 2 != 0;
    }

}
