package da222mz_assign1.Exercise_2;

import java.util.ArrayList;

public class Bus extends Vehicle {
	
	public Bus() {
		space = 20;
		fee = 200;
		passengerFee = 10;
		maxPassengers = 20;
		passengers = new ArrayList<Passenger>();
	}

}
