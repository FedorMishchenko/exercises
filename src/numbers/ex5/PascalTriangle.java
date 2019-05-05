package numbers.ex5;

public class PascalTriangle {
    public static void main(String[] args) {
        buildPascalTriangle();
    }

    private static void buildPascalTriangle() {
        System.out.printf("%s%n%n", "Pascal's triangle for the first positive number:");
        int startNumber = 10;
        final int rows = 10;
        for (int y = 0; y < rows; y++) {
            int number = startNumber;
            for (int i = 0; i < rows - y; i++) {
                System.out.printf("%-3s", "");
            }
            for (int x = 0; x <= y; x++) {
                System.out.format("%-3s%-3s", number, "");
                number = number * (y - x) / (x + 1);
            }
            System.out.printf("%n%n");
        }
    }
}
