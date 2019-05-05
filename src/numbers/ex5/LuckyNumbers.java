package numbers.ex5;

import java.util.stream.Stream;

public class LuckyNumbers {
    public static void main(String[] args) {
        findLuckyNumbers(args);
    }
    /**
     * @param source array of numbers
     * print lucky numbers: the sum of one
     * pair is equal to the sum of the
     * second pair
     */
    private static void findLuckyNumbers(String... source) {
        System.out.printf("%n%s", "lucky numbers");
        Stream.of(source).filter(x -> x.length() == 6)
                .map(Integer::new)
                .filter(x -> x.toString().charAt(0) + x.toString().charAt(1) + x.toString().charAt(2)
                        == x.toString().charAt(3) + x.toString().charAt(4) + x.toString().charAt(5))
                .sorted().forEach(x -> System.out.format("%7d", x));
        System.out.println();
    }
}

