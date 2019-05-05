package collections.exersices.matrix;

import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrix;

    {
        this.rows = 1;
        this.columns = 1;
        this.matrix = new int[rows][columns];
    }

    public Matrix() {
    }

    public Matrix(int rows, int columns) {
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public Matrix(int[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    public static Matrix sum(Matrix m1, Matrix m2) {
        validate(m1, m2);
        Matrix res = new Matrix(m1.rows, m1.columns);
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.columns; j++) {
                res.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
            }
        }
        return res;
    }

    public static Matrix multiplyByNumber(Matrix m1, int number) {
        Matrix res = new Matrix(m1.rows, m1.columns);
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.columns; j++) {
                res.matrix[i][j] = m1.matrix[i][j] * number;
            }
        }
        return res;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        validate(m1, m2);
        Matrix res = new Matrix(m1.rows, m1.columns);
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.columns; j++) {
                res.matrix[i][j] = m1.matrix[i][j] * m2.matrix[i][j];
            }
        }
        return res;
    }

    public static Matrix transposing(Matrix m1) {
        for (int i = 0; i < m1.rows; i++) {
            for (int j = i + 1; j < m1.columns; j++) {
                int temp = m1.matrix[i][j];
                m1.matrix[i][j] = m1.matrix[j][i];
                m1.matrix[j][i] = temp;
            }
        }
        return m1;
    }

    public void printMatrix() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.printf("%4d", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void fill(int number) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] = number++;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix);
    }

    private static void validate(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new IllegalArgumentException("Matrix sizes doesn't match");
        }
    }
}
