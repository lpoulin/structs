import java.util.Arrays;

public class ArrayList<T> {
    private Object ary[];
    private int capacity;
    private int size;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }
    public ArrayList(int initCap) {
        ary = new Object[initCap];
    }

    public void add(T elem) {
        if (size + 1 >= capacity) {
            makeBigger();
            add(elem);
        }
        else {
            ary[size] = elem;
            size++;
        }
    }

    // todo: add(element, index)

    private void makeBigger() {
        capacity = capacity * 2 + 1;
        ary = Arrays.copyOf(ary, capacity);
    }

    public void trimToSize() {
        capacity = size;
        ary = Arrays.copyOf(ary, capacity);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)ary[index];
    }
    
    @Override
    public String toString() {
        String values = "";

        for (int i = 0; i < size; i++) {
            values += ary[i].toString() + " ";
        }

        return values;
    }

    public void print() {
        System.out.println("Array: " + toString());
        System.out.println(String.format("Size: %d, Capacity: %d", size, capacity));
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.print();

        intList.add(4);
        intList.print();

        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }

        intList.print();
        intList.trimToSize();
        intList.print();
    }
}