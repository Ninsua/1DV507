package da222mz_assign2.Exercise2;

//TODO: Fix toString

import java.util.Iterator;
import java.lang.StringBuilder;
import java.util.NoSuchElementException;

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
		size++;
		array[last] = obj;
		last = (last+1)%array.length;
	}
	
	public Object dequeue() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Object toDequeue = array[first];
		array[first] = null;
		first = (first+1)%array.length;
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
		if (size == 0) {
			return "[]";
		}
		StringBuilder buff = new StringBuilder("[");
		for (int i = 0;i<size;i++) {
			buff.append(array[(first+i)%array.length]);
			buff.append(",");
		}
		
		buff.deleteCharAt(buff.length()-1);
		buff.append("]");	
		
		return buff.toString();
	}
	
	//Resize if necessary
	private void resizeCheck() {
		if (size == array.length) {
			resize();
		}
	}
	
	/*
	 * Starts from first, loops around until it's covered all elements.
	 * First element is now 0 and last is the size of the queue.
	*/
	private void resize() {
		Object[] newArray = new Object[array.length*2];
		for (int i = 0;i<array.length;i++) {
			newArray[i] = array[(first+i)%array.length];
		}
		first = 0;
		last = size;
		array = newArray;
	}
	
	public Iterator<Object> iterator() {
		return new ArrayQueueIterator(array,first,size);
	}
	
	public class ArrayQueueIterator implements Iterator<Object> {
		private Object[] array;
		private int first;
		private int current;
		private int count;
		private int size;
		
		public ArrayQueueIterator(Object[] arr,int f,int s) {
			array = arr;
			first = f;
			current = first;
			size = s;
			count = 0;
		}
		
		public boolean hasNext() {
			return count != size;
		}
		
		public Object next() {
			count++;
			return array[(current++)%array.length];
		}
	}


}
