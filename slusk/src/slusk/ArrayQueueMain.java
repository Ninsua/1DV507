package slusk;

public class ArrayQueueMain {

	public static void main(String[] args) {
		ArrayQueue aq1 = new ArrayQueue();
		
		aq1.enqueue(2);
		aq1.enqueue(52);
		aq1.enqueue(23);
		aq1.enqueue(25);
		aq1.enqueue(22);
		aq1.enqueue("asd");
		
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());
		System.out.println(aq1.dequeue());

	}

}
