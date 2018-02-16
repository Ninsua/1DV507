package da222mz_assign3.count_words;

import java.util.Iterator;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		WordHashSet wordHash = new WordHashSet();
		
		Word w1 = new Word("allowed");
		Word w2 = new Word("ALlOWeD");
		Word w3 = new Word("alowey");
		
		
		wordHash.add(w1);
		wordHash.add(w2);
		wordHash.add(w3);
		
		
		
		Random r1 = new Random();
		//Generate 3 random letter "words" (b-y), not max and min pos
		for (int i = 0;i<10; i++) {
			String randomLetters = "";
			for (int j = 0 ; j<3 ; j++) {
				char c = (char) ((char) r1.nextInt(24)+1+'a');
				randomLetters=randomLetters+c;
			}
			Word w = new Word(randomLetters);
			wordHash.add(w);
		}	
		
		System.out.println(wordHash.size());
		System.out.println(wordHash.toString());
		
		Iterator<Word> it = wordHash.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
