package numbers.ex5;

public class ChessMatrix {
    public static void main(String[] args) {
        buildBoard();
    }

    private static void buildBoard() {
        char[][] array = new char[8][8];
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i][0] = 'Ч';
            } else {
                array[i][0] = 'Б';
            }
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = getOpposite(array[i][j - 1]);
            }
        }
        System.out.printf("%n%s%n","Chess matrix:");
        printBoard(array);
        System.out.println();
    }

    private static void printBoard(char[][] array) {
        for (int i = 0; i < array.length; i++, System.out.println()) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-3s",array[i][j]);
            }
        }
    }

    private static char getOpposite(char ch) {
        if (ch == 'Ч') return 'Б';
        else return 'Ч';
    }
}
