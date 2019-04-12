package part1.ex5;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Nod {
    public static void main(String[] args) { System.out.println(findGreatestCommonDivisor(args));
    }

    private static int findGreatestCommonDivisor(int value1, int value2) {
        while (value2 != 0) {
            int temp = value2;
            value2 = value1 % value2;
            value1 = temp;
        }
        return value1;
    }

    private static int findGreatestCommonDivisor(String... param) {
        if(param == null) return -1;
        String regex = "[a-zA-Z]";
        int[] numbers = Stream.of(param)
                .filter(x -> !Pattern.compile(regex).matcher(x).find())
                .mapToInt(Integer::valueOf)
                .filter(x -> x > 0)
                .toArray();
        if(numbers.length == 0) return 0;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = findGreatestCommonDivisor(result, numbers[i]);
        }
        return result;
    }

}
