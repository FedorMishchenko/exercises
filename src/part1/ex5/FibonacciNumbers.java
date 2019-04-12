package part1.ex5;


import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class FibonacciNumbers implements Iterator<BigInteger> {

    private BigInteger first = BigInteger.ZERO;
    private BigInteger second = BigInteger.ONE;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public BigInteger next() {
        BigInteger result = first;
        first = second;
        second = result.add(second);
        return result;
    }

    public static void main(String[] args) {
        fibonacciGenerator();
    }

    private static void fibonacciGenerator(){
        System.out.printf("%s%n","Fibonacci numbers generator:");
        StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        new FibonacciNumbers(),
                        Spliterator.ORDERED | Spliterator.SORTED),
                false)
                .limit(20)
                .forEach(System.out::println);
        System.out.println();
    }
}
