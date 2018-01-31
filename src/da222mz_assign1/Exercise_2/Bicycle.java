package da222mz_assign1.Exercise_2;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
	
	public Bicycle(Passenger p) {
		space = 1;
		fee = 20;
		passengerFee = 20;
		maxPassengers = 1;
		passengers = new ArrayList<Passenger>();
		addPassenger(p);
	}

}