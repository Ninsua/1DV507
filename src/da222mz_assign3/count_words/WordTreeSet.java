package da222mz_assign3.count_words;

//TODO fix the iterator

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class WordTreeSet implements WordSet {
	private Node root;
	private int size;
	
	public WordTreeSet() {
		root = null;
		size = 0;
	}
	
	public void add(Word w) {
		if (root == null) {
			root = new Node(w);
			root.parent = null;
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
		private Node parent;
		private Node left;
		private Node right;
		private Word value;
		
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
					left.parent = this;
					size++;
				}
				
				else {
					left.add(w);
				}
			}
			
			else if (direction > 0) {
				if (right == null) {
					right = new Node(w);
					right.parent = this;
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
		private Node current;
		
		public WordTreeSetIterator(Node root) throws NoSuchElementException {
			if (root == null) {
				throw new NoSuchElementException();
			}
			
			current = root;
			
			//Starts at the leftmost node
			while (current.left != null) {
				current = current.left;
			}
			
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Word next() throws NoSuchElementException {
			if (current == null) {
				throw new NoSuchElementException();
			}
			
			
			Node next = current;
			
			if (current.right != null) {
				
				current = current.right;
				while (current.left != null) {
					current = current.left;
				}
				
				return next.value;
			}
			
			//Climb up the tree
			while (true) {
				
				//Last element
				if (current.parent == null) {
					current = null;
					
					return next.value;
				}
				
				if (current.parent.left == current) {
					current = current.parent;
					
					return next.value;
				}
				
				else {
					current = current.parent;
				}
			}
		}

		
	}
}
