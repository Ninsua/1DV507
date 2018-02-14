package da222mz_assign3.count_words;

public class Word implements Comparable<Word> {
	private String word;
	
	public Word(String str) {
		if (str.isEmpty()) {
		   throw new IllegalArgumentException("Word cannot be empty");
		}
		word = str;
	}	
	   
	public String toString() {
		return word;
	}
	
	public int hashCode() {
		int hash = 0;
		
		for (int i = 0 ; i < word.length() ; i++) {
			hash = hash+Character.getNumericValue(Character.toLowerCase(word.charAt(i)));
		}
		
		return hash;
	}
	
	//Not sure if this one was meant to be case sensitive or not
	public boolean equals(Object other) {
		if (word.compareToIgnoreCase(other)) {
			return true;
		}
		
		
	}

	@Override
	public int compareTo(Word w) {
		return this.hashCode()-w.hashCode();
	}
	   
	   
	   

}
