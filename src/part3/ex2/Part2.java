package part3.ex2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private String data;
    private static final String REGEX = "([\\p{L}&&[^\\p{Nd}]]+)";

    Part2(String data) {
        this.data = data;
    }


    String firstMinMax() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return "First min: " + Arrays.stream(sb.toString().split("\\s"))
                .min(Comparator.comparingInt(String::length)).orElse(null) +
                System.lineSeparator() +
                "First max: " + Arrays.stream(sb.toString().split("\\s"))
                .max(Comparator.comparingInt(String::length)).orElse(null);
    }

    String allMinMax() {
        StringJoiner joiner = new StringJoiner(" ");
        Set<String> set = new HashSet<>();
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()) {
            joiner.add(matcher.group());
            set.add(matcher.group());
        }
        StringJoiner min = new StringJoiner(" ","Min: ","");
        StringJoiner max = new StringJoiner(" ","Max: ","");
        for (String str: set){
            if(str.length() == Pattern.compile("\\s")
                    .splitAsStream(joiner.toString())
                    .min(Comparator.comparingInt(String::length)).get().length()){
                min.add(str);
            }
        }
        for (String str: set){
            if(str.length() == Pattern.compile("\\s")
                    .splitAsStream(joiner.toString())
                    .max(Comparator.comparingInt(String::length)).get().length()){
                max.add(str);
            }
        }
        return min.add(System.lineSeparator()).add(max.toString()).toString();
    }
}
