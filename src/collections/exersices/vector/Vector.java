package collections.exersices.vector;

public class Vector {
    private Object[] array;
    private int size;

    public Vector(){
        size = 0;
        array = new Object[size];
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        size = 0;
        this.array = new Object[size];
    }

    public void add(Object o){
        size++;
        Object[] newArr = new Object[size];
        System.arraycopy(array, 0, newArr, 0,size - 1);
        newArr[size- 1] = o;
        array = newArr;
    }

    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[--size];
        System.arraycopy(array, 0,newArr, 0, index);
        if(index == size) return;
        System.arraycopy(array, index + 1, newArr, index, size - 2);
        array = newArr;
    }

    public void print(){
        System.out.printf("%n%s%n","Print:");
        for(Object o: array)
            System.out.printf("%s : ",o);
    }

}
