package da222mz_assign3.Exercise8;

public class NorseGod {
	private String name;
	private String race;
	private String desc;
	
	public NorseGod() {
		name = "";
		race = "";
		desc = "";
	}
	
	public NorseGod(String n, String r, String d) throws IllegalArgumentException {
		emptyStringErrorThrower(n);
		emptyStringErrorThrower(r);
		emptyStringErrorThrower(d);
		name = n;
		race = r;
		desc = d;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) throws IllegalArgumentException {
		emptyStringErrorThrower(n);
		name = n;
	}
	
	public String getRace() {
		return race;
	}
	
	public void SetRace(String r) throws IllegalArgumentException {
		emptyStringErrorThrower(r);
		race = r;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String d) throws IllegalArgumentException {
		emptyStringErrorThrower(d);
		desc = d;
	}
	
	private void emptyStringErrorThrower(String s) throws IllegalArgumentException {
		if (s.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
}
