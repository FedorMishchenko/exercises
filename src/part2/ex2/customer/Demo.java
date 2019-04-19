package part2.ex2.customer;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    private static int id = 1;
    public static void main(String[] args) {
        Customer customer = new Customer.Builder()
                .withID(id++)
                .withName("John")
                .withLastName("Johnson")
                .withCreditNumber(112201)
                .withAccount(33003)
                .build();
        System.out.println(customer.toString());

        System.out.println(new Customer.Builder()
                .withID(id++)
                .withName("Rick")
                .withLastName("Robson")
                .withCreditNumber(942201)
                .withAccount(76203)
                .build().toString().toUpperCase());

        System.out.println(new StringJoiner("\n\t","\t","")
                .add(new Customer.Builder()
                        .withID(id++)
                        .withName("Bob")
                        .withLastName("Henderson")
                        .withCreditNumber(952771)
                        .withAccount(14203)
                        .build().toString().toUpperCase()).merge(
                                new StringJoiner("==>","[","]")
                .add(new Customer.Builder()
                        .withID(id++)
                        .withName("Billy")
                        .withLastName("Henderson")
                        .withCreditNumber(952666)
                        .withAccount(14219)
                        .build().toString().toUpperCase()
                )));

        StringJoiner joiner = new StringJoiner("-");
        Stream.of(1,2,3,4,5,6,7)
                .map(String::valueOf)
                .map(x -> joiner.merge(new StringJoiner("").add(x)))
                .forEach(System.out::println);

    }
}
