package da222mz_assign1.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Vehicle implements FerryUsageInterface{
	protected int space;
	protected int fee;
	protected int passengerFee;
	protected int maxPassengers;
	protected ArrayList<Passenger> passengers;
	
	public String toString() {
		return "It's a "+this.getClass().getSimpleName()+"! Passengers: "+passengers.size();
	}
	
	public int getSpace() {
		return space;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void addPassenger(Passenger p) {
		if (passengers.size()+1 > maxPassengers) {
			throw new IllegalArgumentException("Cannot fit more passengers");
		}
		p.setFee(this.passengerFee);
		passengers.add(p);
	}
	
	public boolean hasPassengers() {
		return passengers.size() > 0;
	}
	
	public Iterator<Passenger> iterator() {
		return new PassengerIterator(passengers,passengers.size());
	}
	
}
