package da222mz_assign2.Exercise1_3;

import java.util.Iterator;

public class QueueMain {

	public static void main(String[] args) {
		LinkedQueue q1 = new LinkedQueue();
		
		q1.enqueue(5);
		q1.enqueue(6);
		q1.enqueue(7);
		q1.enqueue("asd");
		System.out.println("size: "+q1.size());
		System.out.println("toString: "+q1.toString());
		
		System.out.println("First: "+q1.first());
		System.out.println("Last: "+q1.last());
		
		Iterator<Object> q1Iterator = q1.iterator();
		
		while (q1Iterator.hasNext()) {
			System.out.println("Iterator element: "+q1Iterator.next());
		}
		
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		
		System.out.println("size: "+q1.size());


	}

}
