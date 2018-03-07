package da222mz_assign4.Exercise1;

import static org.junit.jupiter.api.Assertions.*;

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
		
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			testIntQueue.enqueue(randToFill.nextInt(9000));
		}
		
		for (int i = 0;i<ONE_MILLION;i++) {
			Integer random = randToFill.nextInt(9000);
			testIntQueue.enqueue(random);
			assertEquals(random,testIntQueue.last());
		}
		
		StringBuilder sB1 = new StringBuilder();
		for (int i = 0;i<ONE_MILLION;i++) {
			for (int j = 0;i<20;i++) {
				sB1.append((randToFill.nextInt(26) + 'a'));
			}
			testStringQueue.enqueue(sB1.toString());
			assertEquals(sB1.toString(),testStringQueue.last());
			sB1.delete(0, sB1.length()-1);
		}		
	}

}
