package numbers.ex3;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class NumbersTest {

    @Test
    public void findEvenAndOddNumbersTest() {
        int[] source = {-2, 13, 0, -1000, 2_100_100_102, 11, 128, -351};

        arrayValueAndLengthCompare(IntStream.of(source)
                .filter(x -> x % 2 == 0)
                .toArray(), Numbers.findEvenNumbers(source));
        arrayValueAndLengthCompare(IntStream.of(source)
                .filter(x -> x % 2 != 0)
                .toArray(), Numbers.findOddNumbers(source));
    }

    @Test
    public void findMinAndMaxNumberTest() {
        List<Integer> list = new ArrayList<>();
        int[] numbers = new Random()
                .ints(10,-100, 100).toArray();
        IntStream.of(numbers).boxed().forEach(System.out::println);
        for (int number : numbers) {
            list.add(number);
        }
        int expectedMin = Collections.min(list);
        int expectedMax = Collections.max(list);
        assertEquals(expectedMin, Numbers.findMinNumber(numbers));
        System.out.printf("%d%n", expectedMin);
        assertEquals(expectedMax, Numbers.findMaxNumber(numbers));
        System.out.printf("%d%n", expectedMax);
    }

    @Test
    public void numbersDivisibleByThreeAndByNineTest() {
        int size = 10;
        int[] array = new int[size];
        List<Integer> list = new ArrayList<>();
        System.out.println("Added numbers in array:");
        for (int i = 0; i < size; i++) {
            array[i] = i * 3;
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
        for (int i : array) {
            if (i % 9 == 0 && i % 3 == 0)
                list.add(i);
        }
        int[] actual = Numbers.numbersDivisibleByThreeAndByNine(array);
        int[] expected = list.stream().mapToInt(Integer::intValue).toArray();
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void numbersDivisibleByFiveAndBySevenTest() {
        int size = 10;
        int[] array = new int[size];
        List<Integer> list = new ArrayList<>();
        System.out.println("Added numbers in array:");
        for (int i = 0; i < size; i++) {
            array[i] = i * 5;
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
        for (int i : array) {
            if (i % 5 == 0 && i % 7 == 0)
                list.add(i);
        }
        int[] actual = Numbers.numbersDivisibleByFiveAndBySeven(array);
        int[] expected = list.stream().mapToInt(Integer::intValue).toArray();
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void findNumbersWithThreeDifferentDigitsTest() {
        int[] sourceNumbers = {100, 101, 102, 112, 132, 12, 1024};
        int[] actualNumbers = Numbers
                .findNumbersWithThreeDifferentDigits(sourceNumbers);
        int[] expectedNumbers = {102, 132};
        arrayValueAndLengthCompare(expectedNumbers, actualNumbers);
    }

    @Test
    public void findGreatestCommonDivisorTest() {
        int[] sourceNumbers = {2, 8, 16, 24};
        long expected = 2;
        long actual = Numbers.findGreatestCommonDivisor(sourceNumbers);
        assertEquals(expected, actual);
        System.out.printf("%d", actual);
    }

    @Test
    public void findLeastCommonMultipleTest() {
        int[] sourceNumbers = {126, 70};
        long expected = 630;
        long actual = Numbers.findLeastCommonMultiple(sourceNumbers);
        assertEquals(expected, actual);
        System.out.printf("%d", actual);
    }

    @Test
    public void findPrimeNumbersTest() {
        int[] sourceNumbers = {1, 4, 2, 2, 2, 56, 17, 41, 83, 26, 17, 54, 9};
        int[] expected = {2, 17, 41, 83};
        int[] actual = Numbers.findPrimeNumbers(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);
    }
    @Test
    public void sortNumbersByAscAndDescTest() {
        int[] numbers = IntStream.of(new Random()
                .ints(10, 0, 999)
                .toArray())
                .toArray();
        int[] actual = Numbers.sortNumbersByAsc(numbers);
        int[] desc = Numbers.sortNumbersByDesc(numbers);
        List<Integer> list = new ArrayList<>();
        for (int number : actual) {
            list.add(number);
        }
        int[] expectedAsc = list.stream()
                .sorted()
                .mapToInt(x -> x)
                .toArray();
        arrayValueAndLengthCompare(expectedAsc, actual);
        list.clear();
        System.out.printf("%s%n", "reverse:");

        for (int i = actual.length - 1; i >= 0; i--) {
            list.add(actual[i]);
        }
        int[] expectedDesc = list.stream()
                .mapToInt(x -> x)
                .toArray();
        arrayValueAndLengthCompare(expectedDesc, desc);
    }

    @Test
    public void findNumbersFrequencyByDescTest() {
        int[] sourceNumbers = {22, 333, 0, 333, 22, 333, 40, 40, 1, 40, 40};
        int[] expected = {40, 333, 22, 1, 0};
        int[] actual = Numbers.findNumbersFrequencyByDesc(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);


    }

    @Test
    public void sortNumbersWithBubbleReverseByAbsTest() {
        int[] sourceNumbers = {-7, 12, 0, -45, 100, -17};
        int[] expected = {100, -45, -17, 12, -7, 0};
        int[] actual = Numbers.sortNumbersWithBubbleReverseByAbs(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void findLuckyNumbersTest() {
        int[] sourceNumbers = {1221, 345, 12, 3672, 0, 59, -1324};
        int[] expected = {1221, 3672};
        int[] actual = Numbers.findLuckyNumbers(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void findFibonacciNumbersTest() {
        int[] sourceNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        int[] actual = Numbers.findFibonacciNumbers(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void findPalindromeNumbersTest() {
        int[] sourceNumbers = {121, 12, 212, 4554};
        int[] expected = {121, 212, 4554};
        int[] actual = Numbers.findPalindromeNumbers(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void findFirstTwoPositiveNumbersInARowTest() {
        int[] sourceNumbers = {0, 1, -12, 21, 45, -54};
        int[] expected = {1, 21};
        int[] actual = Numbers.findFirstTwoPositiveNumbersInARow(sourceNumbers);
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void findNumbersEqualHalfSumOfNeighborsTest() {
        int[] sourceNumbers = {1,3,5,7,9};
        int[] expected = {3,5,7};
        int[] actual = Numbers.findNumbersEqualHalfSumOfNeighbors(sourceNumbers);
        arrayValueAndLengthCompare(expected,actual);
    }


    @Test
    public void findFirstPositiveNumberTest() {
        int[] sourceNumbers = {-7, -100, 0, 1, -21, 45, -54};
        int[] expected = {1};
        int[] actual = {Numbers.findFirstPositiveNumber(sourceNumbers)};
        arrayValueAndLengthCompare(expected, actual);
    }

    @Test
    public void validateTest() {
        String[] sourceNumbers = {"1","2","3","4","5"};
        boolean actual = Numbers.validate(sourceNumbers);

        String[] wrongArgsInArray = {"1","two","1000000000000","-1000000000000","2","3"};
        boolean actual2 = Numbers.validate(wrongArgsInArray);

        String[] zeroString = new String[0];
        boolean actual3 = Numbers.validate(zeroString);

        boolean actual4 = Numbers.validate(null);

        assertTrue(actual);
        assertFalse(actual2);
        assertFalse(actual3);
        assertFalse(actual4);




    }

    private void arrayValueAndLengthCompare(int[] expected, int[] actual) {

        assertEquals(Objects.requireNonNull(expected).length,
                Objects.requireNonNull(actual).length);
        int i = 0;
        for (int number : expected) {
            assertEquals(number, actual[i]);
            i++;
            System.out.printf("%d ", number);
        }
        System.out.println();


    }

}