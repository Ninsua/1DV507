package da222mz_assign4.Exercise2;

import java.lang.StringBuilder;
import java.util.Random;

public class StringConcatTimeMain {
	static int runs = 5; //Amount of runs dipswitch
	static int shortStrLength = 1; //Short string length dipswitch
	static int longStrLength = 80; //Long string length dipswitch
	static int timeToMeasure = 1; //Time to measure, in seconds
	
	public static String randomString(int size) {
		Random randToFill = new Random();
		String randStr = "";
		for (int i = 0;i<size;i++) {
			randStr = randStr+""+((char) (randToFill.nextInt(26) + 'a'));
		}
		return randStr;
	}
	
	public static int measureTime(String str,int time) {
		String mStr = "";
		long before = 0;
		before = System.currentTimeMillis(); 
		while (System.currentTimeMillis()-before < time*1000) { //Measuring...
			mStr = mStr+str;
		}
		return mStr.length();
	}
	
	public static int measureStringBuilderTime(String str,int time) {
		StringBuilder sb1 = new StringBuilder();
		long before = 0;
		before = System.currentTimeMillis(); 
		while (System.currentTimeMillis()-before < time*1000) { //Measuring...
			sb1.append(str);
		}
		return sb1.length();
	}
	
	public static void main(String[] args) {
		long[] results = new long[8]; //Number of concats/appends, final string length. 0-1 concat short, 2-3 concat long, 4-5 append short, 6-7 append long

		for (int i = 0;i<runs;i++) {
			//Generate random strings
			String shortStr = randomString(shortStrLength); 
			String longStr = randomString(longStrLength);

			//Measure
			int concatShortStrTimeLength = measureTime(shortStr,timeToMeasure);
			int concatLongStrTimeLength = measureTime(longStr,timeToMeasure);
			int appendShortStrTimeLength = measureStringBuilderTime(shortStr,timeToMeasure);
			int appendLongStrTimeLength = measureStringBuilderTime(longStr,timeToMeasure);
			
			//Save results
			results[0] = results[0]+concatShortStrTimeLength/shortStrLength;
			results[1] = results[1]+concatShortStrTimeLength;
			results[2] = results[2]+concatLongStrTimeLength/longStrLength;
			results[3] = results[3]+concatLongStrTimeLength;
			results[4] = results[4]+appendShortStrTimeLength/shortStrLength;
			results[5] = results[5]+appendShortStrTimeLength;
			results[6] = results[6]+appendLongStrTimeLength/longStrLength;
			results[7] = results[7]+appendLongStrTimeLength;
		}
		
		//Get average
		for (int i = 0;i<results.length;i++) {
			results[i] = results[i]/runs;
		}
			
		//Print results
		System.out.println("Concat short:\nNumber of concats: "+results[0]);
		System.out.println("Final string length: "+results[1]);
		System.out.println("Concat long:\nNumber of concats: "+results[2]);
		System.out.println("Final string length: "+results[3]);
		System.out.println("Append short:\nNumber of appends: "+results[4]);
		System.out.println("Final string length: "+results[5]);
		System.out.println("Append Long:\nNumber of appends: "+results[6]);
		System.out.println("Final string length: "+results[7]);
	}
}