package da222mz_assign1.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;

public class PassengerIterator implements Iterator<Passenger> {
	private final ArrayList<Passenger> passengers; 
	private final int lastElement;
	private int currentElement;
	
	public PassengerIterator(ArrayList<Passenger> pList ,int l) {
		currentElement = 0;
		lastElement = l;
		passengers = pList;
	}
	
	public boolean hasNext() {
		return currentElement < lastElement;
	}
	
	public Passenger next() {
		return passengers.get(currentElement++);
	}
	

}
