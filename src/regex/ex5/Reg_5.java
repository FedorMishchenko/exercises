package regex.ex5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_5 {

    private static final String REGEX = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static final String ROMAIN = "(M|CM|D|CD|C|XC|L|XL|X|IX|V|IV|I)";

    static int[] decimalValues =
            {1,4,5,9,10,40,50,90,100,400,500,900,1000};

    static String[] romanNumerals =
            {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

    public static String decimal2Romain(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = romanNumerals.length - 1; i >= 0; i--) {
            while (x >= decimalValues[i]) {
                sb.append(romanNumerals[i]);
                x -= decimalValues[i];
            }
        }
        return sb.toString();
    }

    public static String romain2Decimal(String s) {
        if (s == null || s.isEmpty() || !s.matches(REGEX))
            return String.valueOf(-1);

        Matcher matcher = Pattern.compile(ROMAIN).matcher(s);
        int result = 0;

        while (matcher.find())
            for (int i = 0; i < romanNumerals.length; i++)
                if (romanNumerals[i].equals(matcher.group(0)))
                    result += decimalValues[i];

        return String.valueOf(result);
    }
}
