package da222mz_assign1.Exercise_3_4_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalMain {

	//Returns an array filled with said Pascal's row
	public static int[] pascalRow(int n) throws IllegalArgumentException {
		if (lessThanZero(n-1)) {
			throw new IllegalArgumentException("Row can't be zero or less");
		}
		else if (n-1 == 0) {
			return new int[] {1};
		}
		
		int[] rowArray = new int[n];
		for (int i = 0;i<n;i++) {
			rowArray[i] = binCo(n-1,i);
		}
		
		return rowArray;
	}
	
	//Prints Pascal's triangle up to row n
	public static void pascalPrint(int n) throws IllegalArgumentException {
		if (lessThanZero(n-1)) {
			throw new IllegalArgumentException("Row can't be zero or less");
		}
		int padding;
		int[][] triangle = new int[n][];

		for (int i = 1;i<=n;i++) {
			triangle[i-1] = pascalRow(i);
		}
		
		padding = String.valueOf(triangle[n-1][n/2]).length()+1;
		
		for (int i = 0;i<triangle.length;i++) {
			
			System.out.format("%"+((n-i)*(padding/2)+1)+"s", "");
			
			for (int j = 0;j<triangle[i].length;j++) {
				System.out.format("%"+padding+"d", triangle[i][j]);
			}
			System.out.println("\n");
		}
		
	}
	
	//Calculates the binomial coefficient
	public static int binCo(int n, int k) {
		if (k == 0 && n >= 0) {
			return 1;
		}
		else if (k > n || k < 0) {
			return 0;
		}
		
		return binCo(n-1,k-1)+binCo(n-1,k);
	}

	private static boolean lessThanZero(int n) {
		if (n < 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows = 0;
		
		System.out.println("How many rows of Pascal's triangle do you want to print?");
		try {
			rows = input.nextInt();
			input.close();
		}
		
		catch (InputMismatchException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		//Prints the triangle
		try {
			/*Use commented code below to print just a specific row
			 *
			for (int i : pascalRow(rows)) {
				System.out.print(i+" ");
			}
			*/
			pascalPrint(rows); //Remove this if specific row
			
		}
		
		
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
	}

}
