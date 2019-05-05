package regex;

import regex.ex1.Reg_1;
import regex.ex2.Reg_2;
import regex.ex3.Reg_3;
import regex.ex4.Reg_4;
import regex.ex5.Reg_5;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    private static final String MD5 = "MD5";
    private static final String SHA_256 = "SHA-256";
    private static final String SHA_512 = "SHA-512";
    private static final String STRING_INPUT = "password";
    private static final String ENCODING = "UTF-8";
    private static final String DELIMITER = " ==> ";
    private static final String COLON = ": ";

    private static String getSource(String path) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException ignore) {/*NOP*/}
        return lines.toString();
    }

    public static void main(String[] args) {
        System.out.printf("%20s%n", "== PART 1 ==");
        Reg_1.getData(getSource("E:\\File.txt"));
        System.out.printf("%s%n%s%n%s%n%s%n%s", "RESULT:",
                Reg_1.transfer1() + System.lineSeparator(),
                Reg_1.transfer2() + System.lineSeparator(),
                Reg_1.transfer3() + System.lineSeparator(),
                Reg_1.transfer4() + System.lineSeparator());

        System.out.printf("%n%20s%n%n", "== PART 2 ==");
        Reg_2 reg2 = new Reg_2(getSource("E:\\File2.txt"));
        System.out.println(reg2.firstMinMax());
        System.out.println(reg2.allMinMax());
        System.out.printf("%n%20s%n", "== PART 3 ==");
        System.out.printf("%n%s%n", Reg_3.firstCharToUpperCase(getSource("E:\\File2.txt")));

        System.out.printf("%n%20s%n", "== PART 4 ==");
        try {
            try {
                System.out.printf("%-10s%s%s%s%n",MD5.concat(COLON),STRING_INPUT,DELIMITER,
                        Reg_4.getHash(STRING_INPUT, MD5, ENCODING));
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.printf("%-10s%s%s%s%n",SHA_256.concat(COLON),STRING_INPUT,DELIMITER,
                        Reg_4.getHash(STRING_INPUT, SHA_256, ENCODING));
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.printf("%-10s%s%s%s%n",SHA_512.concat(COLON),STRING_INPUT,DELIMITER,
                        Reg_4.getHash(STRING_INPUT, SHA_512, ENCODING));
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.printf("%n%20s%n", "== PART 5 ==");
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%-10s%s%6s%n",
                    Reg_5.decimal2Romain(i),
                    DELIMITER,
                    Reg_5.romain2Decimal(Reg_5.decimal2Romain(i)));
        }

    }
}
