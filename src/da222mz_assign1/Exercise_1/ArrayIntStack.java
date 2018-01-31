package da222mz_assign1.Exercise_1;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	public ArrayIntStack() {
		super();
	}
	
	public void push(int n) {
		values[size] = n;
		size++;
	}
	
	public int pop() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		int temp = values[size-1];
		values[size-1] = 0;
		size--;
		return temp;
		
	}
		
	public int peek() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		return values[size-1];
	}

}
