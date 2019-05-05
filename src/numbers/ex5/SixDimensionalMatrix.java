package numbers.ex5;

import java.util.Arrays;

public class SixDimensionalMatrix {
    public static void main(String[] args) {
        fillMatrix();
    }

    private static void fillMatrix(){
        int size = 2;
        int[][][][][][] matrix = new int[size][size][size][size][size][size];

        for(int num = 0; num < Math.pow(size, 6); num++){
            int i = num % size;
            int j = num / size % size;
            int k = num / (size * size) % size;
            int l = num / (size * size * size) % size;
            int m = num / (size * size * size * size) % size;
            int n = num / (size * size * size * size * size) % size;
            matrix[n][m][l][k][j][i] = num;
        }
        System.out.printf("%s%n%s%n","Six dimension matrix:",Arrays.deepToString(matrix));
    }
}

