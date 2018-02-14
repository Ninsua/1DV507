package da222mz_assign3.count_words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IdentyfyWordsMain {
	
	//Reads a file's text into a giant string
	public static String readFile(File f) throws IOException {
		BufferedReader fileReader;
		StringBuilder input = new StringBuilder();

		fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));	
			
		while (fileReader.ready()) {
			input.append((char) fileReader.read());
		}
			
		fileReader.close();

		return input.toString();
	}
	
	
	public static void writeFile(File f,String input) throws IOException  {
		OutputStreamWriter writer;
		
		writer = new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8);
		
		for (int i = 0;i<input.length();i++)
			writer.write(input.charAt(i));
				
		writer.close();
	}

	public static void main(String[] args) {
		File inputFile;
		File outputFile;
		String[] words;
		String input = "";
		String output = "";
		String inputPath = "/home/sastac/Documents/kurser/java2/ass3/HistoryOfProgramming.txt";
		String outputPath = "";
		
		
		inputFile = new File(inputPath);
		
		//Reads file into String
		try {
			input = readFile(inputFile);
		}
		
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		//Split string into array
		words = input.split("[!?~]*+ ");
		
		//Input string array to wordlist by removing special charas
		Stream<String> wordStream = Arrays.stream(words);
		List<String> wordsList = wordStream
					.map(w -> w.replaceAll("[^a-z-A-Z-\']", ""))
					.collect(Collectors.toList());
		
		//wordList to string
		for (String s : wordsList) {
			output += s+" ";
		}
		
		//Set new path and new file
		outputPath = inputFile.getParent()+"/"+"words.txt";
		outputFile = new File(outputPath);
		
		//Writes string into file
		try {
			writeFile(outputFile,output);
		}
		
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		Word w1 = new Word("Knark");
		 
		

	}

}
