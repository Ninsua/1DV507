package da222mz_assign1.Exercise_9;

//Insert a path as an argument when running the application

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;
import java.lang.StringBuilder;
import java.util.Arrays;


public class WarAndPeace {
	
	//Reads text file and returns a string containing said text
	public static String readTxt(String path) throws IOException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		StringBuilder text = new StringBuilder();
		
		while (scan.hasNextLine()) {
			text.append(scan.nextLine());
			text.append(" ");
		}
		scan.close();
		
		return text.toString();
	}

	public static void main(String[] args) {
		String[] wordUp;
		String text = "";
		String path = "";
		
		//Argument check
		try {
			path = args[0];
		}
		
		catch (IndexOutOfBoundsException e) {
			System.err.println("Insert a path as an argument when running the application");
			System.exit(1);
		}
		
		try {
			text = readTxt(path);
		}
		
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		wordUp = text.split("[!?~]*+ ");
		
		Stream<String> wordStream = Arrays.stream(wordUp);
		
		long wordCount = 
				wordStream
					.map(w -> w.toLowerCase())
					.map(w -> w.replaceAll("[^a-z-\']", ""))
					.filter(w -> w.length()>0)		
					.distinct()
					.count();
		
		//Print results
		System.out.println("Reading text from file: "+path);
		System.out.println("Total number of unique words: "+wordCount);
	}

}
