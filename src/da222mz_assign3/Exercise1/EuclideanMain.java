package da222mz_assign3.Exercise1;

public class EuclideanMain {
	
	private static int gcd(int a,int b) {
		if (b == 0) {
			return a;
		}
		
		//To make sure the user don't input denominator>numerator.
		if (a<b) {
			int temp = a;
			a = b;
			b = temp;
		}

		return gcd(b,a%b);
	}

	public static void main(String[] args) {
		System.out.println(gcd(18,12));
		System.out.println(gcd(42,56));
		System.out.println(gcd(9,28));
	}

}
