package numbers.ex3;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Fedor Mishchenko
 * @version 1.0
 * @link https://careers.epam.by/content/dam/epam/by/book_epam_by/JAVA_Methods_Programming_v2.march2015.pdf
 * page 28, exercises variant B.
 */
public class Numbers {
    static int[] numbers;
    /**
     * @param args array of numbers entered from the command line
     *             Use method validate in the case of
     *             receiving an array of numbers from command line
     */
    public static void main(String... args) {
        numbers = generate();
        validate(args);

        findEvenNumbers(numbers);
        findOddNumbers(numbers);
        print(findMinNumber(numbers));
        print(findMaxNumber(numbers));
        numbersDivisibleByThreeAndByNine(numbers);
        numbersDivisibleByFiveAndBySeven(numbers);
        sortNumbersWithBubbleReverseByAbs(numbers);
        findNumbersWithThreeDifferentDigits(numbers);
        print(findGreatestCommonDivisor(numbers));
        print(findLeastCommonMultiple(numbers));
        findPrimeNumbers(numbers);
        sortNumbersByAsc(numbers);
        sortNumbersByDesc(numbers);
        findNumbersFrequencyByDesc(numbers);
        findLuckyNumbers(numbers);
        findFibonacciNumbers(numbers);
        findPalindromeNumbers(numbers);
        findNumbersEqualHalfSumOfNeighbors(numbers);
        findPeriodForTwoFirstPositiveNumbersInARow(numbers);
        buildPascalTriangleForFirstPositiveNumber(numbers);
    }

    /**
     * @param sourceNumbers array of numbers
     * @return even numbers if contained in sourceNumbers
     */
    static int[] findEvenNumbers(int... sourceNumbers) {
        massage("%s%n", "even numbers:");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.format("%d, ", x))
                .toArray();

    }

    /**
     * @param sourceNumbers array of numbers
     * @return odd numbers if contained in sourceNumbers
     */
    static int[] findOddNumbers(int... sourceNumbers) {
        massage("%n%n%s%n", "odd numbers:");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .filter(x -> x % 2 != 0)
                .peek(x -> System.out.format("%d, ", x))
                .toArray();

    }

    /**
     * @param sourceNumbers array of numbers
     * @return smallest number in the sourceNumbers
     */
    static int findMinNumber(int... sourceNumbers) {
        massage("%n%n%s%n", "min number:");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers).min().getAsInt();

    }

    /**
     * @param sourceNumbers array of numbers
     * @return largest number in the sourceNumbers
     */
    static int findMaxNumber(int... sourceNumbers) {
        massage("%n%s%n", "max number:");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers).max().getAsInt();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Elements divisible by three and nine
     */

    static int[] numbersDivisibleByThreeAndByNine(int... sourceNumbers) {
        massage("%n%s%n", "numbers divisible by 3 and 9");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .filter(x -> x % 3 == 0 && x % 9 == 0)
                .peek(x -> System.out.format("%d, ", x))
                .toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Elements divisible by five and seven
     */
    static int[] numbersDivisibleByFiveAndBySeven(int... sourceNumbers) {
        massage("%n%n%s%n", "numbers divisible by 5 and 7");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .filter(x -> x % 5 == 0 && x % 7 == 0)
                .peek(x -> System.out.format("%d, ", x))
                .toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Elements sorted by bubble method for decreasing modules
     */
    static int[] sortNumbersWithBubbleReverseByAbs(int... sourceNumbers) {
        massage("%n%n%s%n", "bubble sort reverse by abs");
        sourceNumbers = validate(sourceNumbers);
        boolean swapped = true;
        int barrier = 0;
        while (swapped) {
            swapped = false;
            barrier++;
            for (int i = 0; i < sourceNumbers.length - barrier; i++) {
                if (Math.abs(sourceNumbers[i]) < Math.abs(sourceNumbers[i + 1])) {
                    sourceNumbers[i + 1] = sourceNumbers[i] + sourceNumbers[i + 1];
                    sourceNumbers[i] = sourceNumbers[i + 1] - sourceNumbers[i];
                    sourceNumbers[i + 1] = sourceNumbers[i + 1] - sourceNumbers[i];
                    swapped = true;
                }
            }
        }
        return IntStream.of(sourceNumbers).peek(x -> System.out.format("%d, ", x)).toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return All three-digit numbers, in the decimal notation of which
     * there are no identical digits
     */
    static int[] findNumbersWithThreeDifferentDigits(int... sourceNumbers) {
        massage("%n%n%s%n", "number with three different digits");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .boxed()
                .filter(x -> x.toString().length() == 3)
                .filter(x -> x.toString().charAt(0) != x.toString().charAt(1) &&
                        x.toString().charAt(1) != x.toString().charAt(2) &&
                        x.toString().charAt(0) != x.toString().charAt(2))
                .distinct()
                .sorted()
                .mapToInt(x -> x)
                .peek(x -> System.out.format("%d, ", x))
                .toArray();
    }

    static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * @param sourceNumbers array of numbers
     * @return The greatest common divisor
     */
    static long findGreatestCommonDivisor(int... sourceNumbers) {
        massage("%n%n%s%n", "greatest common divisor");
        sourceNumbers = validate(sourceNumbers);
        long result = sourceNumbers[0];
        for (int i = 1; i < sourceNumbers.length; i++)
            result = gcd(result, sourceNumbers[i]);
        return result;
    }

    static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    /**
     * @param sourceNumbers array of numbers
     * @return The least common multiple
     * In case of overflow, the result is undefined
     */
    static long findLeastCommonMultiple(int... sourceNumbers) {
        massage("%n%s%n", "least common multiple");
        sourceNumbers = validate(sourceNumbers);
        long result = sourceNumbers[0];
        for (int i = 1; i < sourceNumbers.length; i++) {
            if ((sourceNumbers[i] == 0 || sourceNumbers[0] == 0)
                    || (sourceNumbers[i] < 0 || sourceNumbers[0] < 0))
                break;
            result = lcm(result, sourceNumbers[i]);
        }
        return result;
    }

    /**
     * @param sourceNumbers array of numbers
     * @return All prime numbers contained in sourceNumbers
     */
    static int[] findPrimeNumbers(int... sourceNumbers) {
        massage("%n%s%n", "prime numbers");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .filter(Numbers::isPrimeNumber)
                .peek(x -> System.out.format("%d, ", x))
                .sorted().distinct().toArray();
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

    /**
     * @param sourceNumbers array of numbers
     * @return Sorted numbers in ascending order
     */
    static int[] sortNumbersByAsc(int... sourceNumbers) {
        massage("%n%n%s%n", "sort numbers by Asc order");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers).sorted()
                .peek(x -> System.out.format("%d, ", x)).toArray();

    }

    /**
     * @param sourceNumbers array of numbers
     * @return Sorted numbers in descending order
     */
    static int[] sortNumbersByDesc(int... sourceNumbers) {
        massage("%n%n%s%n", "sort numbers by Desc order");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .peek(x -> System.out.format("%d, ", x))
                .mapToInt(x -> x)
                .toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Numbers in order of decreasing frequency occurrence of numbers
     */
    static int[] findNumbersFrequencyByDesc(int... sourceNumbers) {
        massage("%n%n%s%n", "numbers in order of decreasing frequency of occurrence");
        sourceNumbers = validate(sourceNumbers);
        List<Integer> numbers = IntStream.of(sourceNumbers)
                .boxed()
                .collect(Collectors.toList());
        return numbers.stream().sorted((o1, o2) -> {
            int compareFreq = Collections.frequency(numbers, o2) - Collections.frequency(numbers, o1);
            return compareFreq != 0 ? compareFreq : o2 - o1;
        })
                .distinct().mapToInt(x -> x).peek(x -> System.out.format("%d, ", x)).toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return lucky numbers: the sum of one
     * pair is equal to the sum of the
     * second pair
     */
    static int[] findLuckyNumbers(int... sourceNumbers) {
        massage("%n%n%s%n", "lucky numbers");
        sourceNumbers = validate(sourceNumbers);
        return IntStream.of(sourceNumbers)
                .boxed()
                .filter(x -> x.toString().length() % 2 == 0)
                .filter(x -> x.toString().length() == 4)//todo: реализовать неограниченое количество цифр в числе
                .filter(x -> x.toString().charAt(0) + x.toString().charAt(1)
                        == x.toString().charAt(2) + x.toString().charAt(3))
                .sorted().peek(x -> System.out.format("%d, ", x))
                .mapToInt(x -> x).toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Fibonacci numbers
     */
    static int[] findFibonacciNumbers(int... sourceNumbers) {
        massage("%n%n%s%n", "Fibonacci numbers");
        sourceNumbers = validate(sourceNumbers);
        List<Integer> result = new ArrayList<>();
        if (sourceNumbers.length < 3)
            return new int[0];
        if (sourceNumbers[0] == 0) {
            result.add(0);
            if (sourceNumbers[1] == 1)
                result.add(1);
        }
        for (int i = 2; i < sourceNumbers.length; i++) {
            sourceNumbers[i] = sourceNumbers[i - 1] + sourceNumbers[i - 2];
            result.add(sourceNumbers[i]);
        }
        return result.stream().peek(x -> System.out.format("%d, ", x))
                .mapToInt(x -> x).toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Palindrome numbers, whose values
     *         equals directly and in reverse order
     */
    static int[] findPalindromeNumbers(int... sourceNumbers) {
        massage("%n%n%s%n", "Palindrome numbers");
        sourceNumbers = validate(sourceNumbers);
        List<Integer> result = new ArrayList<>();
        for (Integer sourceNumber : sourceNumbers) {
            StringBuilder s = new StringBuilder(sourceNumber.toString());
            if (s.toString().equals(s.reverse().toString())) {
                result.add(Integer.parseInt(s.toString()));
            }
        }
        return result.stream().peek(x -> System.out.format("%d, ", x))
                .mapToInt(x -> x).toArray();
    }

    /**
     * additional method for
     * method findPeriodForTwoFirstPositiveNumbersInARow
     *
     * @param sourceNumbers int array
     * @return first two positive numbers
     */
    static int[] findFirstTwoPositiveNumbersInARow(int... sourceNumbers) {
        return IntStream.of(sourceNumbers)
                .filter(x -> x > 0)
                .peek(x -> System.out.format("%d, ", x))
                .limit(2).toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     *                      The decimal period p = m / n for
     *                      the first two positive integers
     *                      n and m arranged in a row
     */
    private static void findPeriodForTwoFirstPositiveNumbersInARow(int... sourceNumbers) {
        final String message = "The decimal period for " +
                "the first two positive integers arranged in a row: ";
        sourceNumbers = validate(sourceNumbers);
        if (sourceNumbers.length < 2) {
            System.out.format("%n%s%s%n",message,"numbers count < 2");
            return;
        }
        int[] twoPositiveNumbers = findFirstTwoPositiveNumbersInARow(sourceNumbers);
        if ((twoPositiveNumbers[0] <= 0) && (twoPositiveNumbers[1] <= 0)) {
            System.out.format("%n%s%n%s%n", message,
                    "no two positive integers in a row");
            return;
        }
        int numerator = twoPositiveNumbers[0];
        int denominator = twoPositiveNumbers[1];
        if (numerator % denominator == 0) {
            System.out.format("%n%s%d%s%d%s%d", message, numerator / denominator, ".(0) = ",
                    numerator, " / ", denominator);
            return;
        }
        // Selection from the highest denominator 2^
        int s = denominator % 2;
        int l = 0;
        while (s == 0) {
            denominator = denominator / 2;
            s = denominator % 2;
            l++;
        }
        // Selection from the highest denominator 5^
        s = denominator % 5;
        int l1 = 0;
        while (s == 0) {
            denominator = denominator / 5;
            s = denominator % 5;
            l1++;
        }
        // Calculating the length of a period with a new denominator
        int periodLenth = 1;
        int r = 10;
        while (r != 1) {
            r = (10 * r) % denominator;
            if (r == 0) {
                break;
            }
            periodLenth++;
        }
        long beforePeriodLenth;
        if (l1 > l) {
            beforePeriodLenth = l1;
        } else {
            beforePeriodLenth = l;
        }
        denominator = twoPositiveNumbers[1];
        System.out.format("%n%n%s%d%s%n", message, numerator / denominator, ".");
        numerator = numerator % denominator;
        for (int i = 0; i < beforePeriodLenth; i++) {
            System.out.print((numerator * 10) / denominator);
            numerator = (numerator * 10) % denominator;
        }
        System.out.print("(");

        for (int i = 0; i < periodLenth; i++) {
            System.out.format("%d ", (numerator * 10) / denominator);
            numerator = (numerator * 10) % denominator;
        }
        System.out.format("%s%d%s%d%n", ") = ", twoPositiveNumbers[0], " / ", twoPositiveNumbers[1]);
    }

    /**
     * @param sourceNumbers array of numbers
     * @return Elements that are equal to the half-sum of neighboring elements
     */
    static int[] findNumbersEqualHalfSumOfNeighbors(int... sourceNumbers) {
        massage("%n%n%s%n", "numbers equals to the half-sum of neighboring elements");
        sourceNumbers = validate(sourceNumbers);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < sourceNumbers.length - 1; i++) {
            if (sourceNumbers.length < 3)
                break;
            if (sourceNumbers[i] == (sourceNumbers[i - 1] + sourceNumbers[i + 1]) / 2)
                result.add(sourceNumbers[i]);
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

    /**
     * @param sourceNumbers array of numbers
     *                      Pascal's triangle for the first positive number
     */
    private static void buildPascalTriangleForFirstPositiveNumber(int... sourceNumbers) {
        massage("%n%s%n", "Pascal's triangle for the first positive number:");
        sourceNumbers = validate(sourceNumbers);
        int firstPositiveNumber = findFirstPositiveNumber(sourceNumbers);
        if (firstPositiveNumber == 0)
            massage("%s%n", "No numbers > 0");
        final int rows = 5;
        for (int y = 0; y < rows; y++) {
            int c = firstPositiveNumber;
            for (int i = 0; i < rows - y; i++) {
                massage("%-3s", "");
            }
            for (int x = 0; x <= y; x++) {
                System.out.format("%-3s%-3s", c, "");
                c = c * (y - x) / (x + 1);
            }
            System.out.println();
        }
    }

    static int findFirstPositiveNumber(int... sourceNumbers) {
        return IntStream.of(sourceNumbers)
                .filter(x -> x > 0)
                .findFirst()
                .getAsInt();

    }


    /**
     * @param sourceNumbers
     * @return does validation and generates an array of random
     *         numbers in case the input parameters are invalid
     */
    private static int[] validate(int[] sourceNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) {
            sourceNumbers = generate();
        }
        return sourceNumbers;
    }

    /**
     * @param sourceNumbers array of numbers written in strings
     * @return checks validity and returns an array of numbers
     */
    static boolean validate(String[] sourceNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) {
            massage("%s%n", "Input parameters is null");
            return false;
        }
        try {
            numbers =  Stream.of(sourceNumbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return true;
        }catch (NumberFormatException e){
            massage("%s%n", "NumberFormatException was caught");
            return false;
        }
    }

    private static PrintStream massage(String s, String s2) {
        return System.out.format(s, s2);
    }


    private static int[] generate() {
        return Stream.iterate(1, x -> new Random().nextInt(1000))
                .mapToInt(x -> x).limit(10).toArray();

    }

    private static void print(long number) {
        System.out.println(number);
    }

}
