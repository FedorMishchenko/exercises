package part2.ex3.vector;

public class Demo {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(new Object());
        vector.add(new Object());
        vector.add(new Object());
        vector.add(new Object());
        vector.add(new Demo());
        System.out.println();
        System.out.println(vector.size());
        vector.print();
        vector.remove(2);
        System.out.println();
        System.out.println(vector.size());
        vector.print();
        System.out.println('\n' + vector.get(1).toString());
        vector.clear();
        System.out.println(vector.size());
        vector.print();
    }
}
