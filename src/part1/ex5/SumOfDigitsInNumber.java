package part1.ex5;

import java.util.regex.Pattern;


public class SumOfDigitsInNumber {
    public static void main(String[] args) {
        System.out.println(sum(args));
    }

    private static int sum(String... param) {
        if(param == null) return -1;
        String regex = "[a-zA-Z]";
        return Pattern.compile("")
                .splitAsStream(param[0])
                .filter(x -> !Pattern.compile(regex).matcher(x).find())
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
