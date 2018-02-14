package da222mz_assign3.Exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortingAlgorithmsTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	

	@Test
	void testInsertionSort() {
		
		//Testing arraysize 0
		int[] intArray = new int[0];
		assertEquals(intArray.length,SortingAlgorithms.insertionSort(intArray).length);
		
		//Testing sorting arraysize 1
		intArray = new int[1];
		intArray[0] = 5;
		int []sorrtedInt = SortingAlgorithms.insertionSort(intArray);
		assertEquals(intArray[0],sorrtedInt[0]);
		
		//Testing sorting arraysize 2
		intArray = new int[2];
		intArray[0] = 10;
		intArray[1] = 5;
		sorrtedInt = SortingAlgorithms.insertionSort(intArray);
		assertEquals(intArray[0],sorrtedInt[1]);
		assertEquals(intArray[1],sorrtedInt[0]);
		
		//Testing arraysize 10
		intArray = new int[] {10,9,8,7,6,5,4,3,2,1};
		sorrtedInt = SortingAlgorithms.insertionSort(intArray);
		for (int i = 0;i<intArray.length;i++) {
			assertEquals(intArray[i],sorrtedInt[intArray.length-1]);
		}
				
	}

}
