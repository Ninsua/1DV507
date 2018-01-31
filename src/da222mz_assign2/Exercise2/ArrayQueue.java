package da222mz_assign2.Exercise2;

import java.util.Arrays;

public class ArrayQueue {
	private Object[] array;
	private int size;
	private int first;
	private int last;
	
	
	public ArrayQueue() {
		array = new Object[2];
		size = 0;
		first = 0;
		last = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(Object obj) {
		resizeCheck();
		if (size > 0) {
			last = size;
		}
		array[size] = obj;
		size++;
	}
	
	public Object dequeue() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		Object toDequeue = array[first];
		array[first] = null;
		first++;
		size--;
		return toDequeue;
	}
	
	public Object first() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		return array[first];

	}
	
	public Object last() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		return array[last];
	}
	
	public String toString() {
		return "a";
	}
	
	private void resizeCheck() {
		if (size == array.length) {
			resize();
		}
	}
	
	private void resize() {
		Object[] temp = Arrays.copyOf(array, array.length*2);
		array = temp;
	}


}
