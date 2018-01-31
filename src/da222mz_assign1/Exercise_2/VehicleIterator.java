package da222mz_assign1.Exercise_2;

import java.util.Iterator;
import java.util.ArrayList;

public class VehicleIterator implements Iterator<Vehicle> {
	private final ArrayList<Vehicle> vehicles; 
	private final int lastElement;
	private int currentElement;
	
	public VehicleIterator(ArrayList<Vehicle> vList ,int space) {
		currentElement = 0;
		lastElement = space;
		vehicles = vList;
	}
	
	public boolean hasNext() {
		return currentElement < lastElement;
	}
	
	public Vehicle next() {
		return vehicles.get(currentElement++);
	}
	
}
