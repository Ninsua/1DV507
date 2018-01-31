package da222mz_assign2.Exercise2;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue {
	private Object[] array;
	private int size;
	private int first;
	private int last;
	
	
	public ArrayQueue() {
		array = new Object[5];
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
		if (last-1 == array.length && first > 0) {
			last = 0;
			
		}
		else if (last == first && first > 0) {
			last = size;
		}
		else if (last > first && first > 0) {
			last = first-1;
		}
		
		array[last] = obj;
		size++;
	}
	
	public Object dequeue() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (first == array.length) {
			first = 0;
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
		return "first: "+first+" last: "+last+" arr length: "+array.length;
	}
	
	private void resizeCheck() {
		if (size+1 > array.length) {
			last = array.length;
			resize();
			
		}
	}
	
	private void resize() {
		Object[] temp = Arrays.copyOf(array, array.length*2);
		array = temp;
	}
	
	public Iterator<Object> iterator() {
		return new ArrayQueueIterator(array,first,last);
	}
	
	public class ArrayQueueIterator implements Iterator<Object> {
		private Object[] array;
		private int first;
		private int last;
		private int current;
		
		public ArrayQueueIterator(Object[] arr,int f,int l) {
			array = arr;
			first = f;
			last = l;
			current = first;
		}
		
		public boolean hasNext() {
			return current < last;
		}
		
		public Object next() {
			return array[current++];
		}
	}


}
