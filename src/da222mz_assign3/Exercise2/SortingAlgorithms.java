package da222mz_assign3.Exercise2;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {
	
	public static int[] insertionSort(int[] in) {
		
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
	
	public static String[] insertionSort(String[] in, Comparator<String> c) {
		
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
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] intArray = new int[] {10,9,8,7,6,5,4,3,2,1};
		int[] sorrtedInt = insertionSort(intArray);
		System.out.println(intArray[0]);
		System.out.println(sorrtedInt[9]);
		
		for (int i = 0 ;i<intArray.length ; i++) {
			System.out.print(intArray[i]+",");
		}
		System.out.println("");
		for (int i = 0 ;i<sorrtedInt.length ; i++) {
			System.out.print(sorrtedInt[i]+",");
		}
		
		System.out.print("\n");
		
		String[] stringArray = new String[] {"Josef","Inge","Harald","Gustaf","Fredrik","Erik","David","Caesar","Bertil","Adam"};
		String[] sortedStrings = insertionSort(stringArray,(String s1,String s2) -> s1.compareTo(s2));
		
		for (int i = 0 ;i<stringArray.length ; i++) {
			System.out.print(stringArray[i]+",");
		}
		System.out.print("\n");
		System.out.print("\n");
		
		
		for (int i = 0 ;i<sortedStrings.length ; i++) {
			System.out.print(sortedStrings[i]+",");
		}
		
		
		
	}
}
