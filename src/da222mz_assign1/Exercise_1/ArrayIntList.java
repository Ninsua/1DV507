package da222mz_assign1.Exercise_1;

public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	public ArrayIntList() {
		super();
	}
	
	public void add(int n) {
		sizeCheck();
		values[size] = n;
		size++;
	}
	
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (!checkIndex(index,size)) {
			throw new IndexOutOfBoundsException();
		}
		sizeCheck();
		for (int i=size;i>index;i--) {
			values[i] = values[i-1];
		}
		values[index] = n;
		size++;
	}
	
	public void remove(int index) throws IndexOutOfBoundsException {
		if (!checkIndex(index,size)) {
			throw new IndexOutOfBoundsException();
		}
		for (int i=index;i<size-1;i++) {
			values[i] = values[i+1];
		}
		values[size-1] = 0;
		size--;
	}
	
	public int get(int index) throws IndexOutOfBoundsException {
		if (!checkIndex(index,size)) {
			throw new IndexOutOfBoundsException();
		}
		return values[index];
	}
	
	public int indexOf(int n) {
		if (isEmpty()) {
			return -1;
		}
		
		for (int i=0;i<size;i++) {
			if (values[i] == n) {
				return i;
			}
		}
		
		return -1;
	}
	
	//Checks size and resizes if necessary
	private void sizeCheck() {
		if (size+1 > values.length) {
			resize();
		}
	}
	

}
