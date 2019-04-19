package part3.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo1 {
    public static String getSource(String path){
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            lines = stream.collect(Collectors.toList());
        }catch (IOException ignore){/*NOP*/}
        return lines.toString();
    }

    public static void main(String[] args) {
        Transfer transfer = new Part1(getSource("E:\\File.txt"));
        System.out.printf("%s%n%s%n%s%n%s%n%s","RESULT:",
                transfer.transfer1() + System.lineSeparator(),
                transfer.transfer2() + System.lineSeparator(),
                transfer.transfer3() + System.lineSeparator(),
                transfer.transfer4() + System.lineSeparator());

    }
}
