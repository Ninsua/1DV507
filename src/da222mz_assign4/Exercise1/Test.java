package da222mz_assign4.Exercise1;

import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		LinkedQueue<Integer> q1 = new LinkedQueue<Integer>();
		LinkedQueue<String> q2 = new LinkedQueue<String>();
		
		q1.enqueue(1);
		q1.enqueue(2);
		q1.enqueue(3);
		q2.enqueue("ett");
		q2.enqueue("två");
		q2.enqueue("tre");
		
		Iterator<String> it = q2.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
