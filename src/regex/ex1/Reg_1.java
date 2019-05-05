package regex.ex1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_1 {

    private static String input;

    private static final String PASSWORD = "Password";
    private static final int BOUND = 9;
    private static final int PASSWORD_LENGTH = 9;

    private static final String REGEX = "\\s*(([\\w]+)\\s*;)\\s*" +
            "(([\\p{L}]+)\\s*([\\p{L}]+))\\s*;" +
            "\\s*([\\w]+(@)(\\w+\\.(com|ua|ru|net)))";

    private static final int GROUP_LOGIN = 2;
    private static final int GROUP_NAME = 3;
    private static final int GROUP_EMAIL = 6;
    private static final int GROUP_DOMAIN = 8;

    private static final String DELIMITER = " ==> ";

    public static void getData(String input) {
        Reg_1.input = input;
    }

    public static String transfer1() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group(GROUP_LOGIN))
                    .append(DELIMITER)
                    .append(matcher.group(GROUP_EMAIL)
                            .replaceAll("\\s", ""))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String transfer2() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group(GROUP_NAME))
                    .append(" [email: ")
                    .append(matcher.group(GROUP_EMAIL)
                            .replaceAll("\\s", ""))
                    .append("]").append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String transfer3() {
        StringBuilder sb = new StringBuilder();
        Set<String> domain = new HashSet<>();
        Matcher matcher = Pattern.compile(REGEX).matcher(input);

        while (matcher.find()) {
            domain.add(matcher.group(GROUP_DOMAIN)
                    .replaceAll(" ", ""));
        }
        matcher.reset();
        while (matcher.find()) {
            for (String str : domain) {
                StringBuilder tmp = new StringBuilder();
                if (str.equals(matcher.group(GROUP_DOMAIN))) {
                    tmp.append(str)
                            .append(DELIMITER)
                            .append(matcher.group(GROUP_LOGIN));
                }
                sb.append(tmp);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String transfer4() {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(REGEX).matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group().replaceAll("\\s", ""))
                    .append(DELIMITER)
                    .append(PASSWORD).append(": ");
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                sb.append(new Random().nextInt(BOUND));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
