package da222mz_assign3.count_words;

import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordHashSet implements WordSet {
	private int size;
	private Node[] buckets;
	
	
	public WordHashSet() {
		buckets = new Node[20];
		size = 0;
	}
	
	public void add(Word w) {
		//Look for similar objects
		if (lookUp(w)) {
			return ;
		}
		
		//Not found, add new node to the head of the bucket
		int bucket = getBucket(w);
		Node node = buckets[bucket];
		
		node = new Node(w);
		node.next = buckets[bucket];
		buckets[bucket] = node;
		size++;
		if (size == buckets.length)
			reHash();
	}
	
	public boolean contains(Word w) {
		//Look for similar objects
		if (lookUp(w)) {
			
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		int length = buckets.length;
		
		
		//Add all Word's to a string
		for (int i = 0; i<length; i++) {
			Node n = buckets[i];
				
			while (n != null) {
				output.append(n.value.toString());
				output.append(" ");
				n = n.next;
			}	
		}
		
		return output.toString();
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<Word> iterator() {
		return new WordHashSetIterator();
	}
	
	private int getBucket(Word w) {
		int hash = w.hashCode();
		
		if (hash < 0)
			hash = -hash; 
		
		return hash%buckets.length;
	}
	
	//Looks for similar objects
	private boolean lookUp(Word w) {
		int hash = w.hashCode();
		int bucket = getBucket(w);
		Node node = buckets[bucket];
		
		while (node != null) {
			if (node.value.equals(w) && node.value.hashCode() == hash)
				return true;

			node = node.next;
		}
		
		return false;
	}
	
	//Rescale the array and rehash elments to make sure lookup is fast
	private void reHash() {
		Node[] oldBuckets = buckets;
		buckets = new Node[oldBuckets.length*2];
		size = 0;
		
		//Re-hash and add all the nodes to the new array
		for (int i = 0;i<oldBuckets.length;i++) {
			Node node = oldBuckets[i];
			
			while (node != null) {
				add(node.value);
				node = node.next;
			}	
		}
	}
	
	//Node inner class
	private class Node {
		private Word value;
		private Node next;
		
		public Node(Word w) {
			value = w;
		}
	}
	
	//Iterator
	private class WordHashSetIterator implements Iterator<Word> {
		int arrayPos;
		Node current;
		
		public WordHashSetIterator() {
			arrayPos = -1;
			current = null;
		}
		
		public boolean hasNext() {
			if (current != null && current.next != null) {
				return true;
			}
			
			for (int i = arrayPos+1; i<buckets.length; i++) {
				if (buckets[i] != null) {
					return true;
				}
			}
			
			return false;
		}
		
		public Word next() throws NoSuchElementException {	
			if (current != null && current.next != null) {
				current = current.next;
			}
			
			else {
				do {
					arrayPos++;
					if (arrayPos == buckets.length) {
						throw new NoSuchElementException();
					}
					current = buckets[arrayPos];
				}
				while (current == null);
			}
			
			return current.value;
		}
	}
}
