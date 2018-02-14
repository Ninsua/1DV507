package da222mz_assign3.Exercise2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortingAlgorithmsTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	

	@Test
	void testInsertionSortInt() {
		
		//Testing arraysize 0
		int[] intArray = new int[0];
		assertEquals(intArray.length,SortingAlgorithms.insertionSort(intArray).length);
		
		//Testing sorting arraysize 1
		intArray = new int[1];
		intArray[0] = 5;
		int []sortedInt = SortingAlgorithms.insertionSort(intArray);
		assertEquals(intArray[0],sortedInt[0]);
		
		//Testing sorting arraysize 2
		intArray = new int[2];
		intArray[0] = 10;
		intArray[1] = 5;
		sortedInt = SortingAlgorithms.insertionSort(intArray);
		assertEquals(intArray[0],sortedInt[1]);
		assertEquals(intArray[1],sortedInt[0]);
		
		//Testing arraysize 10
		intArray = new int[] {10,9,8,7,6,5,4,3,2,1};
		sortedInt = SortingAlgorithms.insertionSort(intArray);
		for (int i = 0;i<intArray.length;i++) {
			System.out.println();
			assertEquals(intArray[i],sortedInt[intArray.length-1-i]);
		}
		
		//Testing arraysize 100000
		Random r1 = new Random();
		int min = 0;
		int max = 10000;
		int size = 100000;
		
		//Set last elemnet to min and first element to max
		intArray = new int[size];
		intArray[size-1] = min;
		intArray[0] = max;
		
		for (int i = 1;i<size-1; i++) {
			intArray[i] = r1.nextInt(max-1)+1;
		}		
		
		sortedInt = SortingAlgorithms.insertionSort(intArray);;
		
		//Check if first element is min and if last element is max (properly sorted)
		assertEquals(intArray[0],sortedInt[size-1]);
		assertEquals(intArray[size-1],sortedInt[0]);
	}
	
	@Test
	void testInsertionSortString() {
		//Testing arraysize 0
		String[] stringArray = new String[0];
		assertEquals(stringArray.length,SortingAlgorithms.insertionSort(stringArray,(String s1,String s2) -> s1.compareTo(s2)).length);
		
		//Testing sorting arraysize 1
		stringArray = new String[1];
		stringArray[0] = "test";
		String [] sortedString = SortingAlgorithms.insertionSort(stringArray,(String s1,String s2) -> s1.compareTo(s2));
		assertEquals(stringArray[0],sortedString[0]);
		
		//Testing sorting arraysize 2
		stringArray = new String[2];
		stringArray[0] = "Bertil";
		stringArray[1] = "Adam";
		sortedString = SortingAlgorithms.insertionSort(stringArray,(String s1,String s2) -> s1.compareTo(s2));
		assertEquals(stringArray[0],sortedString[1]);
		assertEquals(stringArray[1],sortedString[0]);
		
		//Testing arraysize 10
		stringArray = new String[] {"Josef","Inge","Harald","Gustaf","Fredrik","Erik","David","Caesar","Bertil","Adam"};;
		sortedString = SortingAlgorithms.insertionSort(stringArray,(String s1,String s2) -> s1.compareTo(s2));
		for (int i = 0;i<stringArray.length;i++) {
			assertEquals(stringArray[i],sortedString[stringArray.length-1-i]);
		}
		
		//Testing arraysize 100000
		Random r1 = new Random();
		String min = "aaaaa";
		String max = "zzzzz";
		int size = 100;
		
		//Set last elemnet to min and first element to max
		stringArray = new String[size];
		stringArray[size-1] = min;
		stringArray[0] = max;
		
		//Generate 3 random letter "words" (b-y), not max and min pos
		for (int i = 1;i<size-1; i++) {
			String randomLetters = "";
			for (int j = 0 ; j<3 ; j++) {
				char c = (char) ((char) r1.nextInt(24)+1+'a');
				randomLetters=randomLetters+c;
			}
			stringArray[i] = randomLetters;
		}		
		
		sortedString = SortingAlgorithms.insertionSort(stringArray,(String s1,String s2) -> s1.compareTo(s2));
		
		//Check if first element is min and if last element is max (properly sorted)
		assertEquals(stringArray[0],sortedString[size-1]);
		assertEquals(stringArray[size-1],sortedString[0]);
	}

}
