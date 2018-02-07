package da222mz_assign2.Exercise1_3;

/*TODO:
 * Try test cases with just 1.
 * VG: Modify to test ArrayQueue as well, not another file
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class LinkedQueueTest {
	
	static LinkedQueue testQueueMain;
	static final int ONE_MILLION = 1000000;
	
	void clearAndFill(int ammount) {
		LinkedQueue newQ = new LinkedQueue();
		fill(newQ,ammount);
		testQueueMain = newQ;
	}
	
	void fill(LinkedQueue q, int ammount) {
		Random randToFill = new Random();
		for (int i = 0;i<ammount;i++) {
			q.enqueue(randToFill.nextInt(9000));
		}
	}
	
	@BeforeEach
	void setUp() throws Exception {
		testQueueMain = new LinkedQueue();
	}

	//Testing the constructor
	@Test
	void testLinkedQueue() {
		LinkedQueue testQueue = new LinkedQueue();
		assertTrue(testQueue instanceof LinkedQueue);
	}

	@Test
	void testEnqueue() {
		//Testing one object, testing size and value
		testQueueMain.enqueue(9000);
		assertEquals(9000,testQueueMain.first());
		assertEquals(1,testQueueMain.size());
		
		//Testing a million objects, testing size and value
		clearAndFill(ONE_MILLION-1);
		testQueueMain.enqueue(9000);
		assertEquals(9000,testQueueMain.last());
		assertEquals(ONE_MILLION,testQueueMain.size());
	}

	@Test
	void testDequeue() {
		//Exception test of a empty queue
		assertThrows(NoSuchElementException.class,() -> testQueueMain.dequeue());
		
		//Testing dequeuing all 10 elements
		clearAndFill(10);
		for (int i = 0;i<testQueueMain.size();i++) {
			assertEquals(testQueueMain.first(),testQueueMain.dequeue());
		}
		
		//Testing dequeuing all 1000000 elements
		clearAndFill(1000000);
		for (int i = 0;i<testQueueMain.size();i++) {
			assertEquals(testQueueMain.first(),testQueueMain.dequeue());
		}
	}

	@Test
	void testFirst() {
		//Exception test of a empty queue
		assertThrows(NoSuchElementException.class,() -> testQueueMain.first());
		
		//Testing the first
		testQueueMain.enqueue(9000);
		testQueueMain.enqueue(9001);
		testQueueMain.enqueue(9002);
		assertEquals(9000,testQueueMain.first());
		
		//Testing the first with one million elements
		testQueueMain.enqueue(9000);
		fill(testQueueMain,ONE_MILLION);
		assertEquals(9000,testQueueMain.first());		
	}

	@Test
	void testLast() {
		//Exception test of a empty queue
		assertThrows(NoSuchElementException.class,() -> testQueueMain.last());
		
		//Testing finding the last
		testQueueMain.enqueue(9000);
		testQueueMain.enqueue(9001);
		testQueueMain.enqueue(9002);
		assertEquals(9002,testQueueMain.last());
		
		//Testing the last with one million elements
		testQueueMain = new LinkedQueue();
		clearAndFill(ONE_MILLION);
		testQueueMain.enqueue(9000);
		assertEquals(9000,testQueueMain.last());	
	}

	@Test
	void testSize() {
		//Testing an empty queue
		assertEquals(0,testQueueMain.size());
		
		//Testing an half filled queue;
		clearAndFill(25);
		assertEquals(25,testQueueMain.size());
		
		//Testing size = one million
		clearAndFill(ONE_MILLION);
		assertEquals(ONE_MILLION,testQueueMain.size());
		
	}

	@Test
	void testIsEmpty() {
		//Testing an Empty Queue
		assertTrue(testQueueMain.isEmpty());
		
		//Testing an filled queue
		clearAndFill(ONE_MILLION);
		assertFalse(testQueueMain.isEmpty());
	}

	@Test
	void testIterator() {
		final Iterator<Object> testEmptyIt;
		Iterator<Object> testIt;
		
		//Testing an empty queue
		testEmptyIt = testQueueMain.iterator();
		assertFalse(testEmptyIt.hasNext());
		
		//Exception test of a empty queue
		assertThrows(NoSuchElementException.class,() -> testEmptyIt.next());
		
		//Testing an iterator with one million elements
		clearAndFill(ONE_MILLION);
		testIt = testQueueMain.iterator();
		
		while (testIt.hasNext()) {
			assertEquals(testQueueMain.dequeue(),testIt.next());
		}
	}

}
