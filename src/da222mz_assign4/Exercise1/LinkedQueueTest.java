package da222mz_assign4.Exercise1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedQueueTest {
	static final int ONE_MILLION = 1000000;

	@BeforeEach
	void setUp() throws Exception {
	}

	//Testing the constructor
	@Test
	void testLinkedQueue() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		assertTrue(testIntQueue instanceof LinkedQueue<?>);
		assertTrue(testStringQueue instanceof LinkedQueue<?>);
	}
	
	@Test
	void testEnqueue() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		//Fills with 1 million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			Integer random = randToFill.nextInt(9000);
			testIntQueue.enqueue(random);
			assertEquals(random,testIntQueue.last());
		}
		
		StringBuilder sB1 = new StringBuilder();
		for (int i = 0;i<ONE_MILLION;i++) {
			for (int j = 0;j<20;j++) {
				sB1.append((randToFill.nextInt(26) + 'a'));
			}
			testStringQueue.enqueue(sB1.toString());
			assertEquals(sB1.toString(),testStringQueue.last());
			sB1.delete(0, sB1.length()-1);
		}		
	}
	
	@Test
	void testDequeue() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		//Exceptions
		assertThrows(NoSuchElementException.class,() -> testIntQueue.dequeue());
		assertThrows(NoSuchElementException.class,() -> testStringQueue.dequeue());

		//Fills with 1 million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			Integer random = randToFill.nextInt(9000);
			testIntQueue.enqueue(random);
			assertEquals(random,testIntQueue.dequeue());
		}
		
		StringBuilder sB1 = new StringBuilder();
		for (int i = 0;i<ONE_MILLION;i++) {
			for (int j = 0;j<20;j++) {
				sB1.append((randToFill.nextInt(26) + 'a'));
			}
			testStringQueue.enqueue(sB1.toString());
			assertEquals(sB1.toString(),testStringQueue.dequeue());
			sB1.delete(0, sB1.length()-1);
		}		
	}
	
	@Test
	void testFirst() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		//Exceptions
		assertThrows(NoSuchElementException.class,() -> testIntQueue.first());
		assertThrows(NoSuchElementException.class,() -> testStringQueue.first());
		
		//Fills with one million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			Integer random = randToFill.nextInt(9000);
			testIntQueue.enqueue(random);
			assertEquals(random,testIntQueue.first());
			testIntQueue.dequeue();
		}
		
		StringBuilder sB1 = new StringBuilder();
		for (int i = 0;i<ONE_MILLION;i++) {
			for (int j = 0;j<20;j++) {
				sB1.append((randToFill.nextInt(26) + 'a'));
			}
			testStringQueue.enqueue(sB1.toString());
			assertEquals(sB1.toString(),testStringQueue.first());
			testStringQueue.dequeue();
			sB1.delete(0, sB1.length()-1);
		}		
	}
	
	
	@Test
	void testLast() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		//Exceptions
		assertThrows(NoSuchElementException.class,() -> testIntQueue.last());
		assertThrows(NoSuchElementException.class,() -> testStringQueue.last());
		
		//Fills with one million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			Integer random = randToFill.nextInt(9000);
			testIntQueue.enqueue(random);
			assertEquals(random,testIntQueue.last());
		}
		
		StringBuilder sB1 = new StringBuilder();
		for (int i = 0;i<ONE_MILLION;i++) {
			for (int j = 0;j<20;j++) {
				sB1.append((randToFill.nextInt(26) + 'a'));
			}
			testStringQueue.enqueue(sB1.toString());
			assertEquals(sB1.toString(),testStringQueue.last());
			sB1.delete(0, sB1.length()-1);
		}		
	}
	
	@Test
	void testSize() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		//Fills with one million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			Integer random = randToFill.nextInt(9000);
			assertEquals(i,testIntQueue.size);
			testIntQueue.enqueue(random);
		}
		
		StringBuilder sB1 = new StringBuilder();
		for (int i = 0;i<ONE_MILLION;i++) {
			for (int j = 0;j<20;j++) {
				sB1.append((randToFill.nextInt(26) + 'a'));
			}
			assertEquals(i,testStringQueue.size);
			testStringQueue.enqueue(sB1.toString());
			sB1.delete(0, sB1.length()-1);
		}	
		
		//Removes all elements
		for (int i = 0;i<ONE_MILLION;i++) {
			assertEquals(ONE_MILLION-i,testIntQueue.size);
			assertEquals(ONE_MILLION-i,testStringQueue.size);
			testIntQueue.dequeue();
			testStringQueue.dequeue();
		}
	}
	
	@Test
	void testIsEmpty() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		assertTrue(testIntQueue.isEmpty());
		assertTrue(testStringQueue.isEmpty());
		
		testIntQueue.enqueue(0);
		testStringQueue.enqueue("test");
		
		assertFalse(testIntQueue.isEmpty());
		assertFalse(testStringQueue.isEmpty());
	}
	
	@Test
	void testIterator() {
		LinkedQueue<Integer> testIntQueue = new LinkedQueue<Integer>();
		LinkedQueue<String> testStringQueue = new LinkedQueue<String>();
		
		for (int i = 0;i<ONE_MILLION;i++) {
			testIntQueue.enqueue(i);
			testStringQueue.enqueue(""+i);
		}
		
		Iterator<Integer> intIt = testIntQueue.iterator();
		Iterator<String> strIt = testStringQueue.iterator();
		
		Integer count = 0;
		while (intIt.hasNext()) {
			assertEquals(count,intIt.next());
			count++;
		}
		
		count = 0;
		while (strIt.hasNext()) {
			assertEquals(""+count,strIt.next());
			count++;
		}
		
		//Exceptions
		assertThrows(NoSuchElementException.class,() -> intIt.next());
		assertThrows(NoSuchElementException.class,() -> strIt.next());
	}
}
