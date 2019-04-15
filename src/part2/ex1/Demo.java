package part2.ex1;

import java.util.Arrays;
import java.util.Iterator;

public final class Demo {

    private Demo() {
        throw new UnsupportedOperationException("non instance Demo");
    }

    public static void main(String[] args) {
        MyListImpl con = new MyListImpl();
        con.remove("V");
        con.add("A");
        con.add("B");
        con.add(433);
        con.add(888);
        con.add(new Object());
        con.remove("A");
        System.out.println("Show con: " + con);
        String str = "fedor";
        con.add(str);
        System.out.println("\nShow con.contains(" + str + "): " + con.contains("fedor"));

        MyListImpl con2 = new MyListImpl(con);
        System.out.println("\ncon2: " + con2.toString());
        con2.clear();
        System.out.println("clear con2: " + con2);
        con2.add(1);
        con2.add(2);
        System.out.println("Show con2 after added item: " + con2);

        MyList con1 = new MyListImpl(con);
        System.out.println("\nCopy con to con1");
        System.out.println("Show con: " + con);
        System.out.println("Show con1: " + con1);
        con1.remove(0);
        con1.remove(con1.size() - 1);
        System.out.println("\nShow con: " + con);
        System.out.println("Show remove first and last item con1: " + con1);
        System.out.println("nShow con.containsAll(con1): " + con.containsAll(con1));

        str += "2316";
        con1.add(str);
        System.out.println("\ncon: " + con);
        System.out.println("con1: " + con1);
        System.out.println("Show con.containsAll(con1) " + con.containsAll(con1));

        System.out.println("\nShow foreach iterator:");
        for (Object o : con) {
            System.out.print(o + " ");
        }

        System.out.println("\n\nShow to array " + Arrays.toString(con.toArray()));

        System.out.println("Show while iterator: ");
        Iterator<Object> it = con.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\nShow con1" + con1);

        System.out.println("\nShow remove iterator \ncon1: " + con1);
        Iterator<Object> it1 = con1.iterator();
        while (it1.hasNext()) {
            it1.next();
            it1.remove();
        }

//        System.out.println("Show con1: " + con1);
//
//        ListIterator listIt = con.listIterator();
//        System.out.println("\nShow set: \ncon:" + con);
//        int i = 1;
//        System.out.println("Show ListIterator next:");
//        while (listIt.hasNext()) {
//            System.out.print(listIt.next() + " ");
//            listIt.set(i++);
//        }
//        System.out.println("\ncon1: " + con);
//        System.out.println("Show ListIterator previous:");
//        while (listIt.hasPrevious()) {
//            System.out.print(listIt.previous() + " ");
//        }
    }

}
