package part1.ex4;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    private static Scanner scanner = new Scanner(System.in);
    private static Integer[] numbers;
    private static aNumbers aNumbers;
    private static bNumbers bNumbers;
    private static cNumbers cNumbers;

    public static void main(String[] args) {
        init();
        if (!validate()) return;
        aNumbers.execute(numbers);
        bNumbers.execute(numbers);
        cNumbers.execute();
    }

    private static void init(){
        System.out.printf("%s%n%s%n","Enter numbers:",
                "Enter q to stop entering");
        aNumbers = new aNumbers();
        bNumbers = new bNumbers();
        cNumbers = new cNumbers();
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        numbers = list.toArray(new Integer[0]);
    }

    private static boolean validate() {
        if(numbers == null || numbers.length == 0){
            System.out.printf("%s%n","Input param has no numbers");
            return false;
        }return true;
    }
}
