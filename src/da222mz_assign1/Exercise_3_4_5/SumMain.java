package da222mz_assign1.Exercise_3_4_5;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Is this a good solution strategy?
 * No, because this recursion calls itself twice.
 * The complexity (amount of operations) is a lot higher
 * since it has to calculate two sums using recursion.
 * Calculating the sum can be done with only calculating one via 
 * the (n-1)+n formula.
 */

public class SumMain {
	
	public static int Sum(int n) throws IllegalArgumentException {
		if (zeroOrLess(n)) {
			throw new IllegalArgumentException("Can't sum 0 or less");
		}
		if (n == 1) {
			return 1;
		}
		return Sum(n/2,1)+Sum(n,n/2+1);
	}
	
	public static int Sum(int n, int i) {
		if (n == 1) {
			return 1;
		}
		
		else if (n == i) {
			return n;
		}
		
		return n+Sum(n-1,i);
	}
	
	private static boolean zeroOrLess(int n) {
		if (n < 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int toSum = -1;
		
		System.out.println("Insert number to sum:");
		try {
			toSum = input.nextInt();
			input.close();
		}
		
		catch (InputMismatchException e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("Sum of "+toSum+" is "+Sum(toSum));
		}
		
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

}
