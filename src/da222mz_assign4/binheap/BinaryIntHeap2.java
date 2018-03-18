package da222mz_assign4.binheap;

import java.util.NoSuchElementException;

public class BinaryIntHeap2 {
	private int[] heap;
	private int size;
	
	public BinaryIntHeap2() {
		size = 0;
		heap = new int[10];
	}
	
	public void insert(int n) {
		if (size == 0) {
			heap[1] = n;
			size++;
		}
		
		else {
			if (size+2 > heap.length) {
				resize();
			}
			
			//Add
			heap[size+1] = n;
			size++;
			
			//Percolate
			percolate(size);
		}
	}
	
	public int pullHighest() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		int highest = heap[1];
		int last = heap[size-1];
		
		heap[1] = heap[size-1];
		heap[size] = 0;
		percolateDown(1);
		size--;

		return highest;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		String str = "";
		for (int i = 1;i<=size;i++) {
			str = str+heap[i]+",";
		}
		
		return str;
	}
	
	private int getLeft(int index) {
		return 2*index;
	}
	
	private int getRight(int index) {
		return 2*index+1;
	}
	
	private void percolate(int index) {
		System.out.print("added: "+heap[index]);
		while (index > 1 && heap[index] > heap[index/2]) {
			System.out.println(". Parent is higher, swapping "+heap[index]+" and "+heap[index/2]);
			swap(index,index/2);
			index = index/2; //Get parent index
		}
		System.out.print("added: "+heap[index]);
	}
	
	private void percolateDown(int index) {

		int swapIndex = heap[getLeft(index)] > heap[getRight(index)] ? getLeft(index) : getRight(index);
		
		while (heap[index] < heap[swapIndex]) {	
				System.out.println("perlocateDown: left: " + heap[getLeft(index)] + " right: " + heap[getRight(index)]);
				swapIndex = heap[2*index] > heap[2*index+1] ? 2*index : 2*index+1;
				System.out.println(heap[index] + " is larger than " + heap[swapIndex] + ", swaping...");
				swap(index,swapIndex);
				index = swapIndex;
		}
	}
	
	private void swap(int index1,int index2) {
		int swap = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = swap;
	}
	
	private void resize() {
		int[] newArray = new int[heap.length*2];
		for (int i = 0;i<heap.length;i++) {
			newArray[i] = heap[i];
		}
		heap = newArray;
	}

}
