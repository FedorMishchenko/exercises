package part2.ex1;

import java.util.Arrays;
import java.util.Iterator;

public final class Demo {

    private Demo() {
        throw new UnsupportedOperationException("non instance Demo");
    }

    public static void main(String[] args) {
        System.out.printf("%25s%n","=== PART 1 ===");
        MyListImpl list = new MyListImpl();
        list.add("A");
        list.add("B");
        System.out.printf("%n%s%s%n","List: ",list);
        list.clear();
        System.out.printf("%s%s%n","List after clear: ",list);
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        System.out.printf("%s%s%n","List: ",list);
        System.out.print("foreach: ");
        for(Object obj: list.toArray()){
            System.out.printf("%s ",obj);
        }
        System.out.printf("%n%s%d%n","list size = ",list.size());
        System.out.println(String.format(
                "%s%s%s%s","List contains '","B","': ",list.contains("B")));
        System.out.println(String.format(
                "%s%s%s%s","List contains '","A","': ",list.contains("A")));
        MyList list2 = new MyListImpl(list);
        list2.remove("A");
        System.out.println(String.format("%s%s%n","list2 after added items:",list2));
        System.out.printf("%s%s%n%n","Is list containsAll(list2): ",list.containsAll(list2));
        list2.add("A");
        list2.add("B");
        System.out.printf("%s%s%n%n","Is list containsAll(list2): ",list.containsAll(list2));
        list.add("B");

        System.out.printf("%25s%n","=== PART 2 ===");

        list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.printf("%n%s%n","while iterator: ");
        Iterator<Object> it = list.iterator();
        System.out.print("[");
        while (it.hasNext()) {
            System.out.printf("%s,",it.next());
        }
        System.out.println("]");
        it = list.iterator();
        it.next();
        it.next();
        it.remove();
        System.out.printf("%s%s%n","List: ",list);
        System.out.printf("%s%n",it.next());
        it.remove();
        System.out.printf("%s%s%n","List: ",list);
        try {
            it.remove();
        }catch (IllegalStateException e){
            System.out.println(e.getClass());
        }

        System.out.printf("%n%25s%n%n","=== PART 3 ===");

        list = new MyListImpl();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        ListIterator lit = ((ListIterable)list).listIterator();
        System.out.print("[");
        while (lit.hasNext()) {
            System.out.printf("%s,",lit.next());
        }
        System.out.print("]");
        System.out.printf("%n%s","[");
        while (lit.hasPrevious()) {
            System.out.printf("%s,",lit.previous());
        }
        System.out.println("]");

        list = new MyListImpl();
        lit = ((ListIterable)list).listIterator();
        System.out.println(lit.hasNext());
        System.out.println(lit.hasPrevious());

        list.add("Element");
        System.out.println(lit.next());
        System.out.println(lit.hasNext());
        System.out.println(lit.hasPrevious());

    }

}
