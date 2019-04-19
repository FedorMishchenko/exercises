package part3.ex1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 implements Transfer {

    private String data;

    private static final String PASSWORD = "Password";
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int PASSWORD_SIZE = 9;

    private static final String REGEX_Log = "\\s*(([\\w]+)\\s*;\\s*)";
    private static final String REGEX_Middle = "((\\s*([\\p{L}]+))\\s*([\\p{L}]+))\\s*;\\s*";
    private static final String REGEX_Net= "([\\w]+(@)(\\w+\\.(com|ua|ru|net){1,4}))\\s*";
    private static final String REGEX = REGEX_Log + REGEX_Middle + REGEX_Net;

    private static final int GROUP_LOGIN = 2;
    private static final int GROUP_NAME = 3;
    private static final int GROUP_EMAIL = 7;
    private static final int GROUP_DOMAIN = 9;

    public Part1(String data) {
        this.data = data;
    }

    @Override
    public String transfer1() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()) {
            sb.append(matcher.group(GROUP_LOGIN))
                    .append(" ==> ")
                    .append(matcher.group(GROUP_EMAIL)
                            .replaceAll("\\s", ""))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String transfer2() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()) {
            sb.append(matcher.group(GROUP_NAME))
                    .append(" [email: ")
                    .append(matcher.group(GROUP_EMAIL)
                            .replaceAll("\\s", ""))
                    .append("]").append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String transfer3() {
        StringBuilder sb = new StringBuilder();
        StringBuilder[] buffer;
        Set<String> domain = new HashSet<>();
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()) {
            domain.add(matcher.group(GROUP_DOMAIN)
                    .replaceAll("\\s", ""));
        }
        buffer = new StringBuilder[domain.size()];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = new StringBuilder();
        }
        matcher.reset();
        int index;
        while (matcher.find()) {
            index = 0;
            for (String str : domain) {
                if (str.equals(matcher.group(GROUP_DOMAIN)
                        .replaceAll("\\s", ""))) {
                    buffer[index].append(matcher.group(GROUP_LOGIN)).append(", ");
                }
                index++;
            }
            index = 0;
            for (String str : domain) {
                buffer[index].setLength(buffer[index].length());
                sb.append(str)
                        .append(" ==> ")
                        .append(buffer[index])
                        .append(System.lineSeparator());
                index++;
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String transfer4() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(data);
        while (matcher.find()) {
            sb.append(matcher.group().replaceAll("\\s",""))
                    .append(" ==> ")
                    .append(PASSWORD).append(": ");
            for (int i = 0; i < PASSWORD_SIZE; i++) {
                sb.append(new Random().nextInt(MAX_VALUE - MIN_VALUE));
            }
                    sb.append("\n");
        }
        return sb.toString().trim();
    }
}
