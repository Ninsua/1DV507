package da222mz_assign2.Exercise2;

import java.util.Iterator;

public class ArrayQueueMain {

	public static void main(String[] args) {
		ArrayQueue aq1 = new ArrayQueue();
		
		
		aq1.enqueue(0);
		aq1.enqueue(1);
		aq1.enqueue(2);
		aq1.enqueue(3);
		aq1.enqueue(4);
		aq1.enqueue("asd"); 
		
		System.out.println(aq1.toString());
		System.out.println(aq1.last());
		
		Iterator<Object> it = aq1.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		/*
		System.out.println(aq1.toString());
		System.out.println(aq1.dequeue());
		
		
		System.out.println(aq1.toString());
		System.out.println(aq1.dequeue());
		
		System.out.println(aq1.toString());
		System.out.println(aq1.dequeue());
		
		aq1.enqueue("ny");
		System.out.println("added ny "+aq1.toString());
		
	
		System.out.println(aq1.dequeue());
		System.out.println(aq1.toString());
		
		System.out.println(aq1.dequeue());
		System.out.println(aq1.toString());
		
		System.out.println(aq1.dequeue());
		System.out.println(aq1.toString());
		*/
		
		
		
		
		/*aq1.enqueue(22);
		aq1.enqueue("asd");*/
		
		/* System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue()); */

	}

}
