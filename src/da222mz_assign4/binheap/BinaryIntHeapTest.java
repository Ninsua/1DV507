package da222mz_assign4.binheap;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryIntHeapTest {
	static final int ONE_MILLION = 1000000;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	//Testing the constructor
	@Test
	void testBinaryIntHeap() {
		BinaryIntHeap testHeap = new BinaryIntHeap();
		assertTrue(testHeap instanceof BinaryIntHeap);
	}
	

	@Test
	void testSize() {
		BinaryIntHeap testHeap = new BinaryIntHeap();
		
		//Fills with one million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			int random = randToFill.nextInt(9000);
			assertEquals(i,testHeap.size());
			testHeap.insert(random);
		}	
		
		//Removes all elements
		for (int i = 0;i<ONE_MILLION;i++) {
			assertEquals(ONE_MILLION-i,testHeap.size());
			testHeap.pullHighest();
		}
	}
	
	@Test
	void testIsEmpty() {
		BinaryIntHeap testHeap = new BinaryIntHeap();
		
		assertTrue(testHeap.isEmpty());

		testHeap.insert(1);

		assertFalse(testHeap.isEmpty());
	}
	
	
	@Test
	void insertTest() {
		BinaryIntHeap testHeap = new BinaryIntHeap();
		
		//Add 1 item
		testHeap.insert(9000);
		
		testHeap = new BinaryIntHeap();
		
		//Fills with one million elements
		Random randToFill = new Random();
		for (int i = 0;i<ONE_MILLION;i++) {
			int random = randToFill.nextInt(9000);
			assertEquals(i,testHeap.size());
			testHeap.insert(random);
		}
		
	}
	
	@Test
	void pullHighestTest() {
		final BinaryIntHeap emptyHeap = new BinaryIntHeap();	

		//Exception
		assertThrows(NoSuchElementException.class,() -> emptyHeap.pullHighest());
		
		//Add and pull 1 item
		BinaryIntHeap testHeap = new BinaryIntHeap();
		testHeap.insert(9000);
		assertEquals(9000,testHeap.pullHighest());
		
		testHeap = new BinaryIntHeap();
		
		//Add and pull one thousand items
		Random randToFill = new Random();
		for (int i = 0;i<1000;i++) {
			int random = randToFill.nextInt(9000);
			testHeap.insert(random);
		}
		
		int high = testHeap.pullHighest();
		int low;
		while (testHeap.size() > 0) {
			low = testHeap.pullHighest();
			assertTrue(high > low);
		}
		
	}
	
	

}
