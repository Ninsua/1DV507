package da222mz_assign1.Exercise_2;

import java.util.ArrayList;

public class Lorry extends Vehicle {
	
	public Lorry() {
		space = 40;
		fee = 300;
		passengerFee = 15;
		maxPassengers = 2;
		passengers = new ArrayList<Passenger>();
	}

}
