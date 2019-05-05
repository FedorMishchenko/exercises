package regex.ex2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_2 {
    private String data;
    private static final String REGEX = "([\\p{L}&&[^\\p{Nd}]]+)";

    public Reg_2(String data) {
        this.data = data;
    }


    public String firstMinMax() {
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

    public String allMinMax() {
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
            if(Pattern.compile("\\s")
                    .splitAsStream(joiner.toString())
                    .min(Comparator.comparingInt(String::length)).get().length() == str.length()){
                min.add(str);
            }
        }
        for (String str: set){
            if(Pattern.compile("\\s")
                    .splitAsStream(joiner.toString())
                    .max(Comparator.comparingInt(String::length)).get().length() == str.length()){
                max.add(str);
            }
        }
        return min.add(System.lineSeparator()).add(max.toString()).toString();
    }
}
