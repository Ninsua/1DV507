package da222mz_assign4.Exercise3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortTimeMain  {
	static int runs = 5; //Amount of runs dipswitch
	static int intArrayRange = 9000; //Range of the numbers in the int array
	static int stringArrayRange = 10; //Size of the strings to sort in the array
	static int timeToMeasure = 1; //Time to measure, in seconds
	
	private static int[] insertionSort(int[] in) {
		
		//Array size == 1 = already sorted
		if (in.length<2) {
			return in;
		}
		
		//Create copy of the array
		int[] sortedInt = Arrays.copyOf(in, in.length);

		//For loop keeps track of current array "size" to swap chars in
		for (int i = 1; i<in.length ; i++) {
			
			int pos = i;
			
			//Compares and swaps pos and pos-1
			while (pos>0 && sortedInt[pos] < sortedInt[pos-1]) {
				
				int temp = sortedInt[pos];
				sortedInt[pos] = sortedInt[pos-1];
				sortedInt[pos-1] = temp;
				
				pos--;
			}
		}
		
		return sortedInt;
	}
	
	private static String[] insertionSort(String[] in, Comparator<String> c) {
		
		//Array size == 1 = already sorted
		if (in.length<2) {
			return in;
		}
		
		//Create copy of the array
		String[] sortedStrings = Arrays.copyOf(in, in.length);

		//For loop keeps track of current array "size" to swap chars in
		for (int i = 1; i<in.length ; i++) {
			
			int pos = i;
			
			//Compares and swaps pos and pos-1
			while (pos>0 && c.compare(sortedStrings[pos], sortedStrings[pos-1]) < 0) {
				String temp = sortedStrings[pos];
				sortedStrings[pos] = sortedStrings[pos-1];
				sortedStrings[pos-1] = temp;
				
				pos--;
			}
		}
		
		return sortedStrings;
	}
	
	private static String randomString(int size) throws IllegalArgumentException {
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		Random randToFill = new Random();
		String randStr = "";
		for (int i = 0;i<size;i++) {
			randStr = randStr+""+((char) (randToFill.nextInt(26) + 'a'));
		}
		return randStr;
	}
	
	private static int[] randomIntArray(int size, int range) throws IllegalArgumentException {
		if (size < 0 || range <= 0) {
			throw new IllegalArgumentException();
		}
		
		int[] array = new int[size];
		Random rand = new Random();
		
		for (int i = 0;i<size;i++) {
			array[i] = rand.nextInt(range);
		}
		
		return array;
	}
	
	private static String[] randomStringArray(int size,int stringSize) throws IllegalArgumentException {
		if (size < 0 || stringSize <= 0) {
			throw new IllegalArgumentException();
		}
		
		String[] array = new String[size];

		for (int i = 0;i<size;i++) {
			array[i] = randomString(stringSize);
		}
		
		return array;
	}
	
	private static long insertionSortMeasureTime(int[] arr) {
		long before;
		long after;
		before = System.currentTimeMillis();
		arr = insertionSort(arr);								//Bad practice, etc
		after = System.currentTimeMillis(); 

		return after-before;
	}
	
	private static long insertionSortMeasureTime(String[] arr) {
		long before;
		long after;
		before = System.currentTimeMillis();
		arr = insertionSort(arr,(String s1,String s2) -> s1.compareTo(s2));
		after = System.currentTimeMillis(); 

		return after-before;
	}

	public static void main(String[] args) {
		double[] results = new double[4];
		int[] intArr;
		String[] strArr;
	
		for (int i = 0;i<runs;i++) {
			long time = 0;
			int count = 100;
			
			//int
			do {
				intArr = randomIntArray(count,intArrayRange);
				time = insertionSortMeasureTime(intArr);

				if (time > timeToMeasure*1000) {
					count = count/2;
				}
				
				else {
					count = count+count/2;
				}
				
			}	
			while (time < timeToMeasure*975 || time > timeToMeasure*1025);
			
			System.out.println("New int array, size: "+intArr.length+" time to sort: "+time/1000.0);
			
			results[0] = results[0]+intArr.length;
			results[1] = results[1]+time/1000.0;
			
			time = 0;
			count = 100;
			
			
			//String
			do {
				strArr = randomStringArray(count,stringArrayRange);
				time = insertionSortMeasureTime(strArr);

				if (time > timeToMeasure*1000) {
					count = count/2;
				}
				
				else {
					count = count+count/2;
				}
				
			}	
			while (time < timeToMeasure*975 || time > timeToMeasure*1025);
			
			System.out.println("New str array, size: "+strArr.length+" time to sort: "+time/1000.0);
			
			results[2] = results[2]+strArr.length;
			results[3] = results[3]+time/1000.0;
		}
		
		for (int i = 0;i<results.length;i++) {
			results[i] = results[i]/runs;
		}
				
	}
}
