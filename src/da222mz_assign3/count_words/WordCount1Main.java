package da222mz_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class WordCount1Main {

	public static void main(String[] args) {
		String[] words;
		String input = "";
		String inputPath = "";
		File inputFile;
		
		//Arguments
		for (int i = 0;i<args.length;i++) {
			
			if (args[i].charAt(0) == '-') {
				if (args[i].charAt(1) == 'f' && args.length > 1) {
					inputPath = args[i+1];
				}
			}
			
		}
		
		inputFile = new File(inputPath);
		
		//Reads file into String
		try {
			input = IdentyfyWordsMain.readFile(inputFile);
		}
		
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	
		words = input.split("[!?~]*+ ");
		
		//Add words to the hashset && treeset
		HashSet<Word> wordHash = new HashSet<Word>();
		TreeSet<Word> wordTree = new TreeSet<Word>();
		for (String s : words) {
			Word w = new Word(s);
			wordHash.add(w);
			wordTree.add(w);
		}
		
		//Iterate over the tree
		Iterator<Word> treeIterator = wordTree.iterator();
		while (treeIterator.hasNext()) {
			System.out.println(treeIterator.next().toString());
		}
		
		//Printing sizes
		System.out.println("HashSet size: "+wordHash.size());
		System.out.println("TreeSet size: "+wordTree.size());
		
	}

}
