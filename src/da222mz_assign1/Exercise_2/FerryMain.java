package da222mz_assign1.Exercise_2;

import java.util.Iterator;
import java.util.Random;
import java.lang.StringBuilder;

public class FerryMain {

	public static void main(String[] args) {
		Ferry f1 = new Ferry();
		Car c1 = new Car();
		Bus b1 = new Bus();
		Lorry l1 = new Lorry();
		Bicycle bi1;
		Passenger p1 = new Passenger("Lasse",60,0);
		Passenger p2 = new Passenger("Erik",25,0);
		Passenger p3 = new Passenger("Eric",32,0);
		Passenger p4 = new Passenger("Amata",20,0);
		Passenger p5 = new Passenger("Olle",25,0);
		bi1 = new Bicycle(p4);
		
		/*
		 * Drivers or something like that
		 * Not sure if a driver should automatically be assigned to the vehicle or not
		 * when a vehicle is created but it's not exactly hard to implement...
		 */
		c1.addPassenger(p2);
		b1.addPassenger(p3);
		l1.addPassenger(p1);

		//Throws an IllegalArgumentException if the object is already on the ferry
		f1.embark(bi1);
		f1.embark(c1);
		f1.embark(b1);
		f1.embark(l1);
		f1.embark(p5);
		
		System.out.println("EMBARKED:\n"+f1.toString());
		
		System.out.println("ITERATOR:");
		Iterator<Vehicle> asd = f1.iterator();
		while (asd.hasNext()) {
			System.out.println(asd.next());
		}
		
		//Fill the ferry with passengers
		Passenger p6 = new Passenger("Emilia",25,1);
		while(f1.hasRoomFor(p6)) {
			Random r1 = new Random();
			StringBuilder sB1 = new StringBuilder();
			for (int i = 0;i<5;i++) {
				sB1.append((r1.nextInt(26) + 'a'));
			}
			p6 = new Passenger(sB1.toString(),r1.nextInt(10)+19,r1.nextInt(99));
			f1.embark(p6);
		}
		
		//hasSpaceFor works exactly the same but for vehicles
		if (!f1.hasRoomFor(p6)) {
			System.out.println("No room for more passengers");
		}
		
		System.out.println("EMBARKED:\n"+f1.toString());
		
		f1.disembark();
		
		System.out.println("DISEMBARKED:\n"+f1.toString());
	
	}

}
