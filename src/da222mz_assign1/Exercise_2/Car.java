package da222mz_assign1.Exercise_2;

import java.util.ArrayList;

public class Car extends Vehicle {
	
	public Car() {
		space = 5;
		fee = 100;
		passengerFee = 15;
		maxPassengers = 4;
		passengers = new ArrayList<Passenger>();
	}

}
