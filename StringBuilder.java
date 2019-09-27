import java.util.Arrays; 

public class StringBuilder {
	private char[] ary;
	private int capacity = 0;
	private int chars = 0;

	public StringBuilder() {
		this(10);
	}

	public StringBuilder(String initialValue) {
		this(initialValue.length() * 2 + 1);
		add(initialValue);
	}
	public StringBuilder(int initialCapacity) {
		ary = new char[initialCapacity];
		capacity = initialCapacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getLength() {
		return chars;
	}

	public void print() {
		System.out.println(new String(ary));
		System.out.println(String.format("Length: %d, Capacity: %d", 
			getLength(), getCapacity()));
	}

	public void add(String value) {
		if (chars + value.length() >= capacity) {
			makeBigger();
			add(value);
		} 
		else {
			for (int i = 0; i < value.length(); i++) {
				ary[chars + i] = value.charAt(i);
			}
			chars += value.length();
		}
	}

	private void makeBigger() {
		capacity = (capacity * 2 + 1);
		ary = Arrays.copyOf(ary, capacity);
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("test");
		sb.print();

		sb.add("ing stuff. ");
		sb.print();

		sb.add("The array is about to get much bigger!");
		sb.print();
	}
}