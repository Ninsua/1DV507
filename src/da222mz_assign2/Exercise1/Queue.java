package da222mz_assign2.Exercise1;

import java.util.Iterator;

/**
 * Interface for a Queue. Provides the methods required for
 * a simple implementation of a Queue. It provides the methods for object
 * interactivity (enqueue, dequeue, first, last), queue status checks (size, isEmpty, toString)
 * and an iterator that can iterate through all the objects in the queue.
 * </p>
 * Attempts to access an index that is not with the queue's range will throw
 * an unchecked exception of the type <code>IndexOutOfBoundsException</code>.
 * </p>
 * Classes implementing this interface:
 * <ul> 
 * <li> {@link da222mz_assign2.LinkedQueue} </li>
 * 
 * @author Sastac
 * 
 */

public interface Queue {
	
	/** Returns the current amount of stored elements */
	public int size();                     // current queue size 
	
	/** Returns true if the queue doesn't contain any elements */
	public boolean isEmpty();              // true if queue is empty 
	
	/** 
	 * Adds object <code>element</code> at the end of the queue.
	 * 
	 * @param		<code>element</code> object to be added.
	 * 
	 *  */
	public void enqueue(Object element);   // add element at end of queue 
	
	/** 
	 * Returns and removes the first <code>element</code> into the queue.
	 * 
	 * @return		First element in the queue
	 * @throws		IndexOutOfBoundsException if empty queue
	 *  */
	public Object dequeue();               // return and remove first element. 
	
	/** 
	 * Returns the first element in the queue.
	 * 
	 * @return		First element in the queue
	 * @throws		IndexOutOfBoundsException if empty queue
	 * */
	public Object first();                 // return (without removing) first element 
	
	/** 
	 * Returns the last element in the queue.
	 * 
	 * @return		Last element in the queue
	 * @throws		IndexOutOfBoundsException if empty queue
	 * */
	public Object last();                  // return (without removing) last element 
	
	/**
	 * Returns a string representation of the elements in the queue.
	 * Example: [1,2,3,4,5,6,8,9,10]
	 * 
	 * @return		String representation of the queue
	 */
	public String toString();              // return a string representation of the queue content
	
	/** 
	 * Returns an Iterator<object> that can iterate over the queue's elements
	 * 
	 * @return		Iterator<Object> that iterates over the queue's elements
	 */
	public Iterator<Object> iterator();    // element iterator
}
