package da222mz_assign4.Exercise1;

import java.util.Iterator;

public interface Queue<T> {
	public int size();
	public boolean isEmpty();
	public void enqueue(T element);
	public T dequeue();
	public T first();
	public T last();
	public String toString();
	public Iterator<T> iterator();
}
