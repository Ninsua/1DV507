package da222mz_assign3.count_words;

//TODO fix the iterator

import java.util.Iterator;

public class WordTreeSet implements WordSet {
	Node root;
	int size;
	
	public WordTreeSet() {
		root = null;
		size = 0;
	}
	
	public void add(Word w) {
		if (root == null) {
			root = new Node(w);
			size++;
		}
		
		else {
			root.add(w);
		}
	}

	public boolean contains(Word w) {
		if (size == 0) {
			return false;
		}
		
		return root.contains(w);
	}

	
	public int size() {
		return size;
	}
	
	public Iterator<Word> iterator() {
		return new WordTreeSetIterator(root);
	}
	
	
	private class Node {
		Node left;
		Node right;
		Word value;
		
		public Node(Word w) {
			value = w;
		}
		
		public void add(Word w) {
			if (w.equals(this.value)) {
				return ;
			}
			
			int direction = w.compareTo(this.value);
			
			if (direction < 0) {
				if (left == null) {
					left = new Node(w);
					size++;
				}
				
				else {
					left.add(w);
				}
			}
			
			else if (direction > 0) {
				if (right == null) {
					right = new Node(w);
					size++;
				}
				
				else {
					right.add(w);
				}
			}
		}
		
		public boolean contains(Word w) {
			if (w.equals(this.value)) {
				return true;
			}
			
			int direction = w.compareTo(this.value);
			
			//Left
			if (direction < 0) {
				if (left == null) {
					return false;
				}
				
				else {
					return left.contains(w);
				}
			}
			
			//Right
			else {
				if (right == null) {
					return false;
				}
				
				else {
					return right.contains(w);
				}
			}
		}
		
	}
	
	private class WordTreeSetIterator implements Iterator<Word> {
		Node current;
		
		public WordTreeSetIterator(Node root) {
			current = root;
		}
		
		public boolean hasNext() {
			Node asd = current;
			
			if (asd == null) {
				return false;
			}
			
			else if (asd.left != null) {
				
			}
			
			while (asd.left != null) {
				if (asd.left != null) {
				
				}	
			}
			
			return false;
		}
		
		public Word next() {
			
			return new Word("wwwww");
		}
		
	}
}
