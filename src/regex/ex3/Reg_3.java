package regex.ex3;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reg_3 {

    private static final String REGEX = "([\\p{L}\\p{Nd}]+\\s*)";

    public static String firstCharToUpperCase(String data){
        StringJoiner joiner = new StringJoiner(" ");
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()){
            joiner.add(Stream.of(matcher.group())
                    .map(x -> String.valueOf(x.charAt(0)).toUpperCase() +
                            x.substring(1).toLowerCase())
                    .collect(Collectors.joining()));
        }
        return joiner.toString();
    }
}
