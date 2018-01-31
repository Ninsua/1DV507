package da222mz_assign1.Exercise_1;

import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		ArrayIntList listu = new ArrayIntList();
		ArrayIntStack stacku = new ArrayIntStack();
		
		listu.add(10);
		listu.add(11);
		listu.add(12);
		listu.add(13);
		listu.add(14);
		System.out.println("List:\n"+listu);
		listu.addAt(9000, 3);
		System.out.println("addAt 9000 at index 3: "+listu);
		System.out.println("indexOf 9000: "+listu.indexOf(9000));
		System.out.println("get "+listu.indexOf(9000)+": "+listu.get(listu.indexOf(9000)));
		listu.remove(listu.indexOf(9000));
		System.out.println(listu);
		
		Iterator<Integer> asd = listu.iterator();
		while (asd.hasNext()) {
			System.out.println(asd.next());
		}
		
		stacku.push(10);
		stacku.push(11);
		stacku.push(12);
		stacku.push(13);
		System.out.println("Stack:\n"+stacku);
		System.out.println("Pop: "+stacku.pop());
		System.out.println("Peek: "+stacku.peek());
		System.out.println(stacku);
		
		Iterator<Integer> asd2 = stacku.iterator();
		while (asd2.hasNext()) {
			System.out.println(asd2.next());
		}
		
	}

}
