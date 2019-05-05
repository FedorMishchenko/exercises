package numbers.ex4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class cNumbers {
    private Scanner scanner = new Scanner(System.in);
    private Utils util = Utils.getInstance();
    private int[][] numbers = initMatrix();

    public void execute() {
        arrangeKRowIncreasingOrder(numbers);
        matrixCyclicShift(numbers,Shift.DOWN,2);
    }

    private void arrangeKRowIncreasingOrder(int[][] source) {
        int size = source.length;
        System.out.printf("%n%s%d%s%d%n", "Enter row number between ", 1, " and ", size);
        int row = scanner.nextInt() - 1;
        if (row < 0 || row >= size) {
            System.out.printf("%s%n", "Entering number out of bounds of array size");
            return;
        }
        for (int i = 0; i < size; i++)
            for (int k = i + 1; k < size; k++) {
                if (source[i][row] > source[k][row]) {
                    for (int j = 0; j < size; j++) {
                        source[i][j] = source[i][j] + source[k][j];
                        source[k][j] = source[i][j] - source[k][j];
                        source[i][j] = source[i][j] - source[k][j];
                    }
                }
            }
        System.out.printf("%s%n%n", "After sort:");
        matrixOutput(source);
    }

    private int[][] matrixCyclicShift(int[][] source, Shift shift, int position) {
        System.out.printf("%n%s%n%n", "Matrix cyclic shift");
        int column = source[0].length;
        int row = source.length;

        int[][] result = new int[row][column];

        if (shift == Shift.LEFT || shift == Shift.RIGHT) {
            position %= column;
        } else {
            position %= row;
        }
        if (position == 0) {
            matrixOutput(source);
            return source;
        }
        switch (shift) {
            case LEFT:
                for (int i = 0; i < source.length; ++i) {
                    System.arraycopy(source[i], position, result[i],
                            0, source[i].length - position);
                    System.arraycopy(source[i], 0, result[i],
                            source[i].length - position, position);
                }
                break;
            case RIGHT:
                for (int i = 0; i < source.length; ++i) {
                    System.arraycopy(source[i], source[i].length - position,
                            result[i], 0, position);
                    System.arraycopy(source[i], 0, result[i], position,
                            source[i].length - position);
                }
                break;
            case UP:
                for (int i = 0; i < position; ++i) {
                    result[source.length - position + i] = Arrays.copyOf(source[i],
                            source[i].length);
                }
                for (int i = position; i < source.length; ++i) {
                    result[i - position] = Arrays.copyOf(source[i], source[i].length);
                }
                break;
            case DOWN:
                for (int i = 0; i < source.length - position; ++i) {
                    result[i + position] = Arrays.copyOf(source[i], source[i].length);
                }
                for (int i = source.length - position; i < source.length; ++i) {
                    result[i - source.length + position] = Arrays.copyOf(source[i],
                            source[i].length);
                }
                break;
        }
        matrixOutput(result);
        return result;
    }


    /*|----------------------------------------------------------------------------|*/
    private void matrixOutput(int[][] source) {
        for (int[] i : source) {
            for (int j : i)
                System.out.printf("%5d", j);
            System.out.printf("%n%n");
        }
    }

    private int[][] initMatrix() {
        System.out.printf("%s%n", "Enter number to set the matrix a[N][N] size");
        int N = scanner.nextInt();
        Random random = new Random();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                matrix[i][j] = random.nextInt(100);
        }
        matrixOutput(matrix);
        return matrix;
    }

}

