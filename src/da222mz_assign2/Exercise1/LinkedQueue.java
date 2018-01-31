package da222mz_assign2.Exercise1;

import java.lang.StringBuilder;
import java.util.Iterator;

public class LinkedQueue {
	private Node head;
	private Node tails;
	private int size;
	
	public LinkedQueue() {
		head = null;
		tails = null;
		size = 0;
	}
	
	public void enqueue(Object element) {
		if (head == null) {
			tails = new Node(element);
			head = tails;
		}
		else {
			tails.next = new Node(element);
			tails = tails.next;
		}
		size++;
	}
	
	public Object dequeue() throws IndexOutOfBoundsException {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		else if (!head.hasNext()) {
			Object e = head.element;
			head = null;
			tails = null;
			size--;
			return e;
		}
		Object e = head.element;
		head = head.next;
		size--;
		return e;
	}
	
	public Object first() throws IndexOutOfBoundsException {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		return head.element;
	}
	
	public Object last() throws IndexOutOfBoundsException {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		return tails.element;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() throws IndexOutOfBoundsException {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		StringBuilder output = new StringBuilder("[");
		Node n = head;
		while (n.hasNext()) {
			output.append(n.element.toString());
			output.append(",");
			n = n.next;
		}
		output.append(tails.element.toString());
		output.append("]");
		
		return output.toString();
	}
	
	public Iterator<Object> iterator() {
		return new LinkedQueueIterator(head);
	}
	
	private class Node {
		private Object element;
		private Node next;
		
		public Node(Object e) {
			element = e;
			next = null;
		}
		
		public boolean hasNext() {
			if (next != null) {
				return true;
			}
			return false;
		}
		
	}
	
	public class LinkedQueueIterator implements Iterator<Object> {
		Node current;
		
		public LinkedQueueIterator(Node first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Object next() {
			Object value = current.element;
			current = current.next;
			return value;
		}		
	}

}

