package da222mz_assign2.Exercise1_3;

//TODO Få javadoc att fungera korrekt, denna klass visas ej i indexet, CYKA BLYAT

import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A linked implementation of a queue that can store objects. Implements the <code>Queue</code>
 * interface.
 * 
 * Attempts to access an index that is not with the queue's range will throw
 * an unchecked exception of the type <code>NoSuchElementException</code>.
 * 
 * @author Sastac
 * 
 */

public class LinkedQueue implements Queue {
	private Node head;
	private Node tails;
	private int size;
	
	public LinkedQueue() {
		head = null;
		tails = null;
		size = 0;
	}
	
	/** 
	 * Adds object <code>element</code> at the end of the queue.
	 * 
	 * @param		element object to be added.
	 */
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
	
	/**
	 * {@inheritDoc}
	 */
	public Object dequeue() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
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
	
	/**
	 * {@inheritDoc}
	 */
	public Object first() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.element;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object last() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return tails.element;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return size;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @throws NoSuchElementException if the queue is empty
	 */
	public String toString() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		StringBuilder output = new StringBuilder("[");
		Node n = head;
		while (n != null) {
			output.append(n.element.toString());
			output.append(",");
			n = n.next;
		}
		output.deleteCharAt(output.length()-1);
		output.append("]");
		
		return output.toString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Iterator<Object> iterator() {
		return new LinkedQueueIterator(head);
	}
	
	
	/**
	 * Node used in <code>LinkedQueue</code> class
	 * 
	 * @author Sastac
	 *
	 */
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
	
	/**
	 * Iterator used in <code>LinkedQueue</code> class
	 * 
	 * @author Sastac
	 *
	 */
	public class LinkedQueueIterator implements Iterator<Object> {
		Node current;
		
		public LinkedQueueIterator(Node first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Object next() throws NoSuchElementException {
			if (current == null) {
				throw new NoSuchElementException();
			}
			Object value = current.element;
			current = current.next;
			return value;
		}
	}

}

