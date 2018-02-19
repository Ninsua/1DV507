package da222mz_assign3.count_words;

public class Word implements Comparable<Word> {
	private String word;
	private int hash;
	
	public Word(String str) {
		if (str.isEmpty()) {
		   throw new IllegalArgumentException("Word cannot be empty");
		}
		word = str;
		hash = hashGenerator();
	}	
	   
	public String toString() {
		return word;
	}
	

	//Not sure if this one was meant to be case sensitive or not
	public boolean equals(Object other) {
		if (other instanceof Word || other instanceof String) {
			return word.compareToIgnoreCase(other.toString()) == 0;
		}
			return word.equals(other);
	}
	
	
	public int hashCode() {
		return hash;
	}
	
	public int compareTo(Word w) {
		return word.compareToIgnoreCase(w.word);
	}
	   
	private int hashGenerator() {
		int digest = 0;
		
		for (int i = 0 ; i < word.length() ; i++) {
			digest = digest+Character.getNumericValue(Character.toLowerCase(word.charAt(i)));
		}
		
		return digest;
	}
	   

}
