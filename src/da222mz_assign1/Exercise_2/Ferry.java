package da222mz_assign1.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ferry implements FerryInterface{
	private final int MAX_PASSENGERS;
	private final int MAX_SPACE;
	private int passengers;
	private int space; //For Vehicles
	private int money;
	private ArrayList<Passenger> pList;
	private ArrayList<Vehicle> vList;
	
	public Ferry() {
		pList = new ArrayList<Passenger>();
		vList = new ArrayList<Vehicle>();
		MAX_PASSENGERS = 200;
		MAX_SPACE = 40*5;
		passengers = 0;
		space = 0;
		money = 0;
	}
	
	public Ferry(int maxPassengers, int maxSpace) {
		MAX_PASSENGERS = maxPassengers;
		MAX_SPACE = maxSpace;
		passengers = 0;
		space = 0;
		money = 0;
	}
	
	public String toString() {
		return "Max passengers: "+MAX_PASSENGERS+"\nMax space: "+MAX_SPACE+
				"\nPassengers: "+passengers+"\nUsed Space: "+space+
				"\nCollected money: "+money;
	}
	
	public int countPassengers() {
		return passengers;
	}
	
	public int countVehicleSpace() {
		return space;
	}
	
	public int countMoney() {
		return money;
	}
	
	public Iterator<Vehicle> iterator() {
		return new VehicleIterator(vList,vList.size());
	}
	
	public void embark(Vehicle v) throws IllegalArgumentException {
		if (!hasSpaceFor(v)) {
			throw new IllegalArgumentException("Not enough space");
		}
		if (vehicleOnFerry(v)) {
			throw new IllegalArgumentException("Vehicle already on the ferry");
		}
		if (v.hasPassengers()) {
			Iterator<Passenger> it = v.iterator();
			while (it.hasNext()) {
				embark(it.next());
			}
		}
		vList.add(v);
		space = space+v.getSpace();
		money = money+v.getFee();
	}
	
	public void embark(Passenger p) throws IllegalArgumentException {
		if (!hasRoomFor(p)) {
			throw new IllegalArgumentException("Not enough of room");
		}
		if (passengerOnFerry(p)) {
			throw new IllegalArgumentException("Passenger already on the ferry");
		}
		pList.add(p);
		money = money+p.getFee();
		passengers++;
	}
	
	public void disembark() {
		vList.clear();
		pList.clear();
		passengers = 0;
		space = 0;
	}
	
	public boolean hasSpaceFor(Vehicle v) {
		if (v.getSpace() <= (MAX_SPACE-space)) {
			return true;
		}
		return false;
	}
	
	public boolean hasRoomFor(Passenger p) {
		if (p.getSpace() <= (MAX_PASSENGERS-passengers)) {
			return true;
		}
		return false;
	}
	
	//Check if the vehicle is on the fairy
	private boolean vehicleOnFerry(Vehicle v) {
		for (Vehicle veh : vList) {
			if (veh.equals(v)) {
				return true;
			}
		}
		return false;
	}
	
	//Check if the passenger is on the fairy
	private boolean passengerOnFerry(Passenger p) {
		for (Passenger pas : pList) {
			if (pas.equals(p)) {
				return true;
			}
		}
		return false;
	}

}
