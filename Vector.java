package datastructures;
/**
 * @author ibagr
 */

public class Vector {
	private Object data[];
	private int count;
	private int container;

	public Vector(int capacity) {
		data = new Object[capacity];
		count = 0;
		container = capacity;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Object get(int index) {
		return data[index];
	}

	public void set(int index, Object obj) {
		data[index] = obj;
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return true;
		}
		return false;
	}

	public int getIndex(Object obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return i;
		}
		return -1;
	}

	public Object getObj(Object obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return obj;
		}
		return null;
	}

	public void addFirst(Object item) {
		if (size() == container) {
			extendCapacity();

		}

		for (int i = size(); i > 0; i--) {
			data[i] = data[i - 1];
		}

		data[0] = item;
		count++;

	}

	public void addLast(Object o) {
		if (size() == container) {
			extendCapacity();

		}

		data[count] = o;
		count++;
	}

	public Object getFirst() {

		return data[0];
	}

	public Object getLast() {

		return data[count - 1];
	}

	public void removeLast() {
		data[count - 1] = null;
		count = count - 1;
	}

	public void removeFirst() {
		data[0] = null;

		for (int i = 0; i < size(); i++) {
			data[i] = data[i + 1];
		}
		removeLast();

	}

	private void extendCapacity() {

		Object data2[] = new Object[2 * count];

		for (int i = 0; i < size(); i++) {
			data2[i] = data[i];
		}

		data = data2;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < size(); i++) {
			temp = temp + data[i] + "\t";
		}
		return temp;
	}

}