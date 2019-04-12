package part1.ex4;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author Fedor Mishchenko
 */
public class aNumbers {
    private Utils util = Utils.getInstance();

    public void execute(Integer... source) {
        findShortestNumber(source);
        findLongestNumber(source);
        sortNumbersInOrderIncreasingValueLength(source);
        sortNumbersInOrderDecreasingValueLength(source);
        findNumbersWithLengthShorterThanAverageLength(source);
        findNumbersWithLengthLongerThanAverageLength(source);
        findNumberWithMinDifferentDigits(source);
        findEvenNumbersWithEqualCountEvenAndOddDigits(source);
        findNumbersWhereDigitsSortedInAscOrderDistinct(source);
        findFirsNumberConsistUniqueDigits(source);
        findSecondPalindromeNumberInArray(source);
    }

    private void findShortestNumber(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Least number of digits");
        int min = Integer.parseInt(Arrays.stream(source)
                .map(String::valueOf)
                .min(Comparator.comparingInt(String::length)).get());
        System.out.printf("%s%d%n%s%s", "Shortest number: ",
                min, "Digits count: ", String.valueOf(Math.abs(min)).length());
    }

    private void findLongestNumber(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%n%s%n", "Greatest number of digits");
        int max = Integer.parseInt(Arrays.stream(source)
                .map(String::valueOf)
                .max(Comparator.comparingInt(String::length)).get());
        System.out.printf("%s%d%n%s%s", "Longest number: ", max, "Digits count: ",
                String.valueOf(Math.abs(max)).length());
    }

    private void sortNumbersInOrderIncreasingValueLength(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%n%s%n", "Numbers in order increasing value length");
        List<Integer> result = Arrays.stream(source)
                .map(Math::abs)
                .map(String::valueOf)
                .sorted(Comparator.comparingInt(String::length))
                .peek(System.out::println)
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    private void sortNumbersInOrderDecreasingValueLength(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Numbers in order decreasing value length");
        List<Integer> result = Stream.of(source)
                .map(Math::abs)
                .map(String::valueOf)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .peek(System.out::println)
                .map(Integer::new)
                .collect(Collectors.toList());

    }

    private void findNumbersWithLengthShorterThanAverageLength(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s", "Numbers with least number of digits" +
                " than average number's length in array");
        double average = average(source);
        System.out.printf("%n%s%.2f%n", "Average number's length = ", average);
        List<String> result = Stream.of(source)
                .map(Math::abs)
                .map(String::valueOf)
                .filter(x -> x.length() < average)
                .sorted(Comparator.comparingInt(String::length))
                .peek(x -> System.out.format("%-10s%s%d%n", x, " length = ", x.length()))
                .collect(Collectors.toList());
    }

    private void findNumbersWithLengthLongerThanAverageLength(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s", "Numbers with greatest number of digits" +
                "than average number's length in array");
        double average = average(source);
        System.out.printf("%n%s%.2f%n", "Average number's length = ", average);
        List<String> result = Stream.of(source)
                .map(Math::abs)
                .map(String::valueOf)
                .filter(x -> x.length() > average)
                .sorted(Comparator.comparingInt(String::length))
                .peek(x -> System.out.format("%-10s%s%d%n", x, " length = ", x.length()))
                .collect(Collectors.toList());
    }

    private Double average(Integer... source) {
        return Stream.of(source)
                .map(String::valueOf)
                .mapToInt(String::length)
                .average()
                .getAsDouble();
    }

    private void findNumberWithMinDifferentDigits(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Number with least number of different digits");
        List<String> numbers = Stream.of(source)
                .map(Math::abs)
                .map(String::valueOf)
                .collect(Collectors.toList());
        String result = numbers.get(0);
        int minDigitsCount = new HashSet<>(Arrays.asList(numbers.get(0).split(""))).size();
        for (String number : numbers) {
            Set<String> set = new HashSet<>(Arrays.asList(number.split("")));
            if (set.size() < minDigitsCount) {
                result = number;
                minDigitsCount = set.size();
            }
        }
        System.out.println(result);
    }

    private boolean findNumbers(String str) {  //todo: переделать реализацию, работает некорректно
        int count = str.length() / 2;
        int[] evenCount = Stream.of(str)
                .filter(x -> x.length() % 2 == 0).peek(x -> System.out.printf("%s%n", x))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (count == evenCount.length) {
            System.out.println("\n" + "Size = " + evenCount.length + '\n');
            return true;
        } else return false;
    }

    private void findEvenNumbersWithEqualCountEvenAndOddDigits(Integer... source) { //todo: переделать
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Even numbers where even and odd digits equals in a number");
        int[] arr = Arrays.stream(source)
                .mapToInt(x -> x)
                .filter(x -> x % 2 == 0)
                .toArray();
        Arrays.stream(arr).boxed().map(String::valueOf)
                .filter(this::findNumbers).peek(x -> System.out.printf("<%s>%n", x)).toArray();

    }

    private void findNumbersWhereDigitsSortedInAscOrderDistinct(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Numbers, the digits in which" +
                " they are followed in ascending order, unique");
        Stream.of(getNumsWithDigitsInAscOrder(Arrays.stream(source)
                .map(String::valueOf)
                .distinct().collect(Collectors.toList())))
                .peek(x -> System.out.printf("%s ", x)).toArray();
    }

    private List<String> getNumsWithDigitsInAscOrder(List<String> list) {
        List<String> result = new ArrayList<>();
        boolean flag = true;
        for (String number : list) {
            for (int i = 0; i < number.length() - 1; ++i) {
                if (Character.getNumericValue(number.charAt(i)) >
                        Character.getNumericValue(number.charAt(i + 1)))
                    flag = false;
            }
            if (flag) result.add(number);
        }
        return result;
    }

    private void findFirsNumberConsistUniqueDigits(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%n%s%n", "Number consisting only of different digits");
        Stream.of(Arrays.stream(source).map(String::valueOf)
                .distinct().toArray())
                .map(String::valueOf)
                .filter(this::getNumWithUniqueDigits).limit(1)
                .peek(x -> System.out.printf("%s ", x)).toArray();
    }

    private boolean getNumWithUniqueDigits(String source) {
        int[] number = new int[10];
        boolean flag = true;
        for (char digit : source.toCharArray()) {
            number[Character.getNumericValue(digit)] += 1;
            if (number[Character.getNumericValue(digit)] > 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void findSecondPalindromeNumberInArray(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%n%s%n", "Second Palindrome number in array");
        List<Integer> result = new ArrayList<>();
        for (Integer sourceNumber : source) {
            StringBuilder s = new StringBuilder(sourceNumber.toString());
            if (s.toString().equals(s.reverse().toString())) {
                result.add(Integer.parseInt(s.toString()));
            }
        }
        result.stream().skip(1).limit(1).peek(x -> System.out.format("%d", x))
                .mapToInt(x -> x).toArray();
    }

}
