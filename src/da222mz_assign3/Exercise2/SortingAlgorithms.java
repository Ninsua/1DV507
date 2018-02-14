package da222mz_assign3.Exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class SortingAlgorithms {
	
	public static int[] insertionSort(int[] in) {
		
		//Array size == 1 = already sorted
		if (in.length<2) {
			
			return in;
		}
		
		int[] sortedInt = new int[in.length];// Arrays.copyOf(in, in.length[])

		//for (int i = in.length-1; i>0; i=i-(in.length%2)-1) {
			//broken
			for (int j = 0; j<in.length-1; j=j-in.length%2+1) {
				System.out.println(in[j]+" "+in[j+1]);
				
				if (in[j] < in[j+1]) {
					
					sortedInt[j] = in[j];
					sortedInt[j+1] = in[j+1];
				}
				
				//Swap
				else {
					System.out.println("swap!");
					sortedInt[j] = in[j+1];
					sortedInt[j+1] = in[j];
				}
			}
		//}
		

		
		return sortedInt;
	}
	
	public static void main(String[] args) {
		
		int[] intArray = new int[] {10,9,8,7,6,5,4,3,2,1};
		int[] sorrtedInt = insertionSort(intArray);
		System.out.println(intArray[0]);
		System.out.println(sorrtedInt[9]);
		
		if (intArray[0] == sorrtedInt[9]) {
			System.out.println(intArray[0]+" == "+sorrtedInt[9]);
		}
		
		
		System.out.println(intArray[1] == sorrtedInt[0]);
		
		
	}
}
