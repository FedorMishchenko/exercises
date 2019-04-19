package part3.ex2;

import part3.ex1.Demo1;

public class Demo2 {

    public static void main(String[] args) {
        Part2 part2 = new Part2(Demo1.getSource("E:\\File2.txt"));
        System.out.println(part2.firstMinMax());
        System.out.println(part2.allMinMax());
    }
}
