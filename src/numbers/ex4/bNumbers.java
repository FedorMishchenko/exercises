package numbers.ex4;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class bNumbers {

    private Utils util = Utils.getInstance();

    public void execute(Integer... source) {
        determineNumbersInIntervals(source);
        determineNumbersInIntervalGenerics(source);
        printNumbersInFormMatrix(source[0]);
        rootQuadraticEquation(source);
        getMonthByNumber(source[0]);

    }

    private void determineNumbersInIntervals(Integer... source) {
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Determine number belonging to the interval");
        Stream.builder()
                .add(Stream.of(source).filter(x -> x >= 0 && x < 10)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval (0,10]")).toArray())
                .add(Stream.of(source).filter(x -> x > 15 && x <= 20)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval [15,20]")).toArray())
                .add(Stream.of(source).filter(x -> x >= 25 && x <= 35)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval (25,35)")).toArray())
                .add(Stream.of(source).filter(x -> x > 40 && x < 50)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval [40,50]")).toArray())
                .build()
                .collect(Collectors.toList());
    }

    private void determineNumbersInIntervalGenerics(Integer... source){
        if (!util.validate(source)) return;
        System.out.printf("%n%s%n", "Determine number belonging to the interval");
        List<Integer> firstList = IntStream.concat(
                Arrays.stream(source).filter(x -> x >= 0 && x < 10)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval (0,10]")),
                Arrays.stream(source).filter(x -> x >= 15 && x < 20)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval [15,20]")))
                .boxed().collect(Collectors.toList());
        List<Integer> secondList = IntStream.concat(
                Arrays.stream(source).filter(x -> x >= 25 && x <= 35)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval (25,35)")),
                Arrays.stream(source).filter(x -> x > 40 && x < 50)
                        .mapToInt(x -> x)
                        .peek(x -> System.out.printf("%s%d%s%n", "Number: ",
                                x, " belonging to interval [40,50]")))
                .boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        result.addAll(firstList);
        result.addAll(secondList);
        Stream.of(result).forEach(System.out::println);

    }

    private void printNumbersInFormMatrix(Integer number) {
        if(number == null) return;
        int N = number;
        System.out.printf("%n%s%d%n%s%n", "Numbers in form of a matrix N * N where N = ",
                N, "horizontal matrix:");
        Stream.of(IntStream.rangeClosed(1, N * N)
                .mapToObj(x -> x % N == 0 ? x + "\t\n" : x + "\t")
                .collect(Collectors.joining())).forEach(System.out::println); //todo: vertical matrix
    }

    private void rootQuadraticEquation(Integer... source) {
        if (!util.validate(source) || source.length < 3) return;
        System.out.printf("%s%n", "find roots of quadratic equation");
        double a = source[0], b = source[1], c = source[2], num;
        num = b * b - 4 * a * c;
        double root1, root2;
        if (num > 0) {
            root1 = (-b - Math.sqrt(num)) / (2 * a);
            root2 = (-b + Math.sqrt(num)) / (2 * a);
            System.out.printf("%s%.1f  %.1f%n", "Roots: ", root1, root2);
        } else if (num == 0) {
            double root;
            root = -b / (2 * a);
            System.out.printf("%s%.1f%n", "Root: ", root);
        } else {
            System.out.println("Equation has no roots");
        }
    }

    private void getMonthByNumber(Integer number){
        if(number == null || number < 1 || number > 12)return;
        System.out.println(new DateFormatSymbols().getMonths()[number-1]);
    }
}