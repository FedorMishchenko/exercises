package part2.ex3.matrix;

public class Demo {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(4,4);
        Matrix m2 = new Matrix(4,4);
        m1.fill(5);
        m2.fill(10);
        System.out.printf("%s%n%n","init m1");
        m1.printMatrix();
        System.out.printf("%n%s%n%n","init m2");
        m2.printMatrix();
        System.out.printf("%n%s%n%n","sum m1 + m2");
        Matrix m3 = Matrix.sum(m1, m2);
        m3.printMatrix();
        System.out.printf("%n%s%n%n","mult m1 * m2");
        Matrix m4 = Matrix.multiply(m1, m2);
        m4.printMatrix();
        System.out.printf("%n%s%n%n","mult m1 * 2");
        Matrix m5 = Matrix.multiplyByNumber(m1, 2);
        m5.printMatrix();
        System.out.printf("%n%s%n%n","transposing m1");
        Matrix m6 = Matrix.transposing(m1);
        m6.printMatrix();
        System.out.printf("%n%s%n%n","toString m1");
        System.out.println(m1.toString());
    }
}
