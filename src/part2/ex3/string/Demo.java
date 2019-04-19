package part2.ex3.string;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(" == ");
        joiner.add("One").add("Two").add("Three");
        StringJoiner joiner2 = new StringJoiner(" >> ");
        joiner2.add("AAAA").add("BBB").add("CC").merge(joiner);
        System.out.println(joiner);
        System.out.println(joiner2);

        joiner = new StringJoiner(" ==> ","[","]")
                .add("X").add("Y").add("Z");
        System.out.println(joiner);

        String nums = String.join("-","1","2","3","4");
        System.out.println(nums);

        List<String> list = Arrays.asList("XXX","YYY","ZZZ");
        String str = String.join(" == ", list);
        System.out.println(str);

        System.out.println(String.join("::", list));

        System.out.println(list.stream().collect(Collectors.joining("::")));

        System.out.println(list.stream().peek(System.out::println)
                .collect(Collectors.joining("; ", "[", "]")));


    }
}
