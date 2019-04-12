package part1.ex5;

public class ColumnIndexTranslation {
    public static void main(String[] args) {
        digits2chars("1","2","100","200","703","704");
        defineRightColumn((int) (Math.random() * 100));
        chars2digit("AAA");
    }

    private static void digits2chars(String...param) {
        try {
            for (String str : param) {
                int number = Integer.parseInt(str);
                String res = "";
                for (int i = number; i != 0; i = (i - 1) / 26)
                    res = String.format("%c%s", ((i - 1) % 26 + 65), res);
                System.out.printf("%-3s%4s%4s%4s%4s%n", res, "==>", number, "==>", res);
            }
        } catch (Exception e) { /*NOP*/ }
    }

    private static int charToInt(char character) {
        return (character - 'A' + 1);
    }

    private static void chars2digit(String param) {
        int result = charToInt(param.charAt(param.length() - 1));
        int it = 1;
        for (int i = param.length() - 2; i >= 0; i--) {
            result += Math.pow(26, it) * charToInt(param.charAt(i));
            it++;
        }
        System.out.printf("%s%s%n","chars to digit: ",param);
        digits2chars(String.valueOf(result));
        System.out.println();
    }

    private static void defineRightColumn(int columnNumber) {
        System.out.printf("%n%s%d%n%s%n", "column index = ", columnNumber, "define right column:");
        String[] number = new String[]{String.valueOf(columnNumber + 1)};
        digits2chars(number);
        System.out.println();
    }
}


