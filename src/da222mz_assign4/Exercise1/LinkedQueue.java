package da222mz_assign4.Exercise1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T>,Iterable<T> {
	int size;
	Node head;
	Node tail;
	
	public LinkedQueue() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public void enqueue(T elem) {
		if (size == 0) {
			head = new Node(elem);
			tail = head;
		}
		
		else {
			tail.next = new Node(elem);
			tail = tail.next;
		}
		
		size++;
	}

	public T dequeue() throws IndexOutOfBoundsException {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		
		else if (!head.hasNext()) {
			T toReturn = head.value;
			head = null;
			tail = null;
			size--;
			return toReturn;
		}
		
		T rT = head.value;
		head = head.next;
		size--;
		return rT;
	}
	

	public T first() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		return head.value;
	}

	public T last() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		return tail.value;
	}

	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size < 1) {
			return true;
		}
		return false;
	}

	public Iterator<T> iterator() {
		return new LinkedQueueIterator(head);
	}
	
	
	private class Node {
		T value;
		Node next;
		
		public Node(T val) {
			value = val;
			next = null;
		}
		
		public boolean hasNext() {
			if (next != null) {
				return true;
			}
			return false;
		}
	}
	
	private class LinkedQueueIterator implements Iterator<T> {
		Node current;
		
		public LinkedQueueIterator(Node first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public T next() throws NoSuchElementException {
			if (current == null) {
				throw new NoSuchElementException();
			}
			T value = current.value;
			current = current.next;
			return value;
		}
	}
}
