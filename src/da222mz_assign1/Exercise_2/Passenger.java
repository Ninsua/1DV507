package da222mz_assign1.Exercise_2;

public class Passenger implements FerryUsageInterface {
	private int space = 1;
	private int fee;
	private String name;
	private int age;
	private int gender; //More than 2 genders, etc
	
	public Passenger(String n, int a, int g) {
		if (negCheck(a) || negCheck(g)) {
			throw new IllegalArgumentException("Age or gender cannot be below 0");
		}
		name = n;
		age = a;
		gender = g;
		fee = 20;
	}
	
	public String toString() {
		return "Name: "+name+" Age: "+age+" Gender: "+gender;
	}
	
	public int getSpace() {
		return space;
	}
	
	public int getFee() {
		return fee;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setFee(int f) {
		if (negCheck(f)) {
			throw new IllegalArgumentException("Fee cannot be below 0");
		}
		fee = f;
	}
	
	private boolean negCheck(int n) {
		return n < 0;
	}

}
