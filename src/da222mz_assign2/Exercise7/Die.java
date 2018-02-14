package da222mz_assign2.Exercise7;

import java.util.Random;

import javafx.scene.image.ImageView;

public class Die {
	static final int STANDARD_DIE_SIDES = 6;
	private int sides; //For dice with more sides
	private int value;
	
	//Standard die
	public Die() {
		Random random = new Random();
		sides = STANDARD_DIE_SIDES; //Standard die
		value = random.nextInt(sides)+1; //Starts with random value	
	}
	
	//Standard die
	public Die(int startValue) {
		sides = STANDARD_DIE_SIDES;
		value = startValue;

	}
	
	//Non-standard die
	public Die(int startValue,int maxSides) {
		sides = maxSides; //
		value = startValue;
	}
	
	public void roll() {
		Random random = new Random();
		value = random.nextInt(sides)+1;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getSides() {
		return sides;
	}
	
}
