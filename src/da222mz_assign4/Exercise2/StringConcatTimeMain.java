package da222mz_assign4.Exercise2;

import java.lang.StringBuilder;
import java.util.Random;

public class StringConcatTimeMain {
	static int runs = 1; //amount of runs dipswitch
	
	Runtime rt = Runtime.getRuntime();
	
	public static String randomString(int size) {
		Random randToFill = new Random();
		String randStr = "";
		for (int i = 0;i<size;i++) {
			randStr = randStr+""+((char) (randToFill.nextInt(26) + 'a'));
		}
		return randStr;
	}

	public static void main(String[] args) {
		StringBuilder buffer = new StringBuilder();
		long[] results = new long[8]; //Number of concats/appends, final string length. 0-1 concat short, 2-3 concat long, 4-5 append short, 6-7 append long
		int concatCount = 0;
		String shortStr = "";
		String longStr = "";
		long before = 0;
		long after = 0;

		Runtime runTime = Runtime.getRuntime();
		
		long usedMemory = runTime.totalMemory()-runTime.freeMemory();
		long mbytes = usedMemory/1000000;
		

		for (int i = 0;i<runs;i++) {
			String oneCharaStr = randomString(1);
			String eightyCharStr = randomString(80);

			//Concat short strings
			long count = 1;
			long timePassed = 0;
			while (timePassed < 1000000000) { //One second in nanoseconds
				count = (long) Math.log(count);
				shortStr = "";
				
				System.out.println(count);

				before = System.nanoTime(); 
				for (int j = 0;j<count;j++) {
					shortStr = shortStr+oneCharaStr;
				}
				after = System.nanoTime();

				timePassed = after-before; 
			}
			
			System.out.println("Concat short timePassed: "+timePassed/1000000000.0);
			
			results[0] = results[0]+count;
			results[1] = results[1]+shortStr.length();
			
			//Concat long strings
			count = 1;
			timePassed = 0;
			while (timePassed < 1000000000) { //One second in nanoseconds
				count = count+count;
				longStr = "";
				
				before = System.nanoTime(); 
				for (int j = 0;j<count;j++) {
					longStr = longStr+eightyCharStr;
				}
				after = System.nanoTime();

				timePassed = after-before; 
			}
			
			results[2] = results[2]+count;
			results[3] = results[3]+longStr.length();
			
			
			//Append short strings
			count = 1;
			timePassed = 0;
			while (timePassed < 1000000000) { //One second in nanoseconds
				count = count+count;
				buffer = new StringBuilder();
				
				before = System.nanoTime(); 
				for (int j = 0;j<count;j++) {
					buffer.append(oneCharaStr);
				}
				after = System.nanoTime();

				timePassed = after-before; 
			}
			
			results[4] = results[4]+count;
			results[5] = results[5]+buffer.length();
		}
		
		results[0] = results[0]/runs;
		results[1] = results[1]/runs;
		results[2] = results[2]/runs;
		results[3] = results[3]/runs;
		results[4] = results[4]/runs;
		results[5] = results[5]/runs;
		
		System.out.println("Concat short\nNumber of concats: "+results[0]);
		System.out.println("Final string length: "+results[1]);
		System.out.println("Concat long\nNumber of concats: "+results[2]);
		System.out.println("Final string length: "+results[3]);
		System.out.println("Append short\nNumber of appends: "+results[4]);
		System.out.println("Final string length: "+results[5]);
	}
}