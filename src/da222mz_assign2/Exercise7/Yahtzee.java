package da222mz_assign2.Exercise7;

/* Accidentally wrote this so you have to check the boxes for the dice
 * that you want to rethrow, WHOOPS
 */


import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Yahtzee extends Application {
	static ArrayList<SimpleEntry<Integer,Image>> imageMap = new ArrayList<SimpleEntry<Integer,Image>>();
	static ImageView[] dieToImageView = new ImageView[5];
	static CheckBox[] checkBoxes = new CheckBox[5];
	static Die[] diceToRoll = new Die[5];
	static Die[] diceArray = new Die[5];
	static final int MAX_ROLLS = 3;
	static int rolls = 0;
	
	//Kinda used poker rules for this instead of the order described in the assignment. oops.
	private String result() {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		boolean threeOfAKind = false;
		boolean pair = false;

		
		for (Die d : diceArray) {
			resultList.add(d.getValue());
		}
		
		resultList.sort((Integer a,Integer b) -> a.compareTo(b));
		
		if (resultList.get(0) == resultList.get(4)) {
			return "Yahtzee!";
		}
		
		
		//Look for 3 and 4 of a kind
		int threeValue = -1;
		for (int i = 1;i<=6;i++) {
			int count = 0;
			
			for (int v : resultList) {
				if (v == i) {
					count++;
				}
			}
			
			if (count == 3) {
				threeOfAKind = true;
				threeValue = i;
			}
			
			if (count == 4) {
				return "Four of a kind!";
			}
		}
		
		//Look for full house && pair
		for (int i = 1;i<=6;i++) {
			int count = 0;
			
			for (int v : resultList) {
				if (v == i && i != threeValue) {
					count++;
				}
			}
			
			if (count == 2 && threeOfAKind) {
				return "Full house!";
			}
			
			else if (count == 2 && !threeOfAKind) {
				pair = true;
			}
		}
		
		//Look for large straight
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		boolean six = false;
		
		for (int i = 0;i<resultList.size();i++) {
			int v = resultList.get(i);
			System.out.println(v);
			if (v == 1) {
				one = true;
			}
			if (v == 2) {
				two = true;
			}
			if (v == 3) {
				three = true;
			}
			if (v == 4) {
				four = true;
			}
			if (v == 5) {
				five = true;
			}
			if (v == 6) {
				six = true;
			}
			
			/* Somehow this didn't work...?
			one = v == 1;
			two = v == 2;
			three = v == 3;
			four = v == 4;
			five = v == 5;
			six = v == 6;
			*/
		}
		
		System.out.println(one+" "+two+" "+three+" "+four+" "+five+" "+six); 
		
		if ((one&&two&&three&&four&&five) || (two&&three&&four&&five&&six)) {
			return "Large straight!";
		}
		

		if (threeOfAKind) {
			return "Three of a kind!";
		}

		//Look for small straight
		if ((one&&two&&three&&four) || (two&&three&&four&&five) || (three&&four&&five&&six)) {
			return "Small straight!";
		}
		
		if (pair) {
			return "Pair!";
		}

		return "Sorry ya got nothin'";
	}
	
	private void updateImage(Die d,ImageView iv) throws IllegalArgumentException {
		if (d == null || iv == null) {
			throw new IllegalArgumentException("No object found");
		}
		Image side = imageMap.get(d.getValue()-1).getValue();
		iv.setImage(side);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Die die1 = new Die(1);
		diceArray[0] = die1;
		Die die2 = new Die(2);
		diceArray[1] = die2;
		Die die3 = new Die(3);
		diceArray[2] = die3;
		Die die4 = new Die(4);
		diceArray[3] = die4;
		Die die5 = new Die(5);
		diceArray[4] = die5;
		 
	    //Nodes
	    Text header = new Text(0,0,"Yahtzee");
	    header.setTextAlignment(TextAlignment.CENTER);
	    header.setFont(Font.font("Helvetica",30));
	    
	    Label info = new Label();
	    info.setText("You have "+(MAX_ROLLS-rolls)+" rolls left.");
	    
	    //Images
	    Image side1 = new Image(getClass().getResourceAsStream("img/side1.png"),80,80,true,true);
	    imageMap.add(new SimpleEntry<Integer,Image>(1,side1));
	    Image side2 = new Image(getClass().getResourceAsStream("img/side2.png"),80,80,true,true);
	    imageMap.add(new SimpleEntry<Integer,Image>(2,side2));
	    Image side3 = new Image(getClass().getResourceAsStream("img/side3.png"),80,80,true,true);
	    imageMap.add(new SimpleEntry<Integer,Image>(3,side3));
	    Image side4 = new Image(getClass().getResourceAsStream("img/side4.png"),80,80,true,true);
	    imageMap.add(new SimpleEntry<Integer,Image>(4,side4));
	    Image side5 = new Image(getClass().getResourceAsStream("img/side5.png"),80,80,true,true);
	    imageMap.add(new SimpleEntry<Integer,Image>(5,side5));
	    Image side6 = new Image(getClass().getResourceAsStream("img/side6.png"),80,80,true,true);
	    imageMap.add(new SimpleEntry<Integer,Image>(6,side6));
	    
	    //Imageviewers
	    ImageView die1Viewer = new ImageView(side1);
	    dieToImageView[0] = die1Viewer;
	    ImageView die2Viewer = new ImageView(side2);
	    dieToImageView[1] = die2Viewer;
	    ImageView die3Viewer = new ImageView(side3);
	    dieToImageView[2] = die3Viewer;
	    ImageView die4Viewer = new ImageView(side4);
	    dieToImageView[3] = die4Viewer;
	    ImageView die5Viewer = new ImageView(side5);
	    dieToImageView[4] = die5Viewer;
	    
	    //Checkboxes
	    CheckBox die1Box = new CheckBox();
	    die1Box.setDisable(true);
	    checkBoxes[0] = die1Box;
	    die1Box.setOnAction(addToRollList -> {
	    	if (die1Box.isSelected()) {
	    		diceToRoll[0] = die1;
	    	}
	    	
	    	else {
	    		diceToRoll[0] = null;
	    	}
	    });
	    
	    CheckBox die2Box = new CheckBox();
	    die2Box.setDisable(true);
	    checkBoxes[1] = die2Box;
	    die2Box.setOnAction(addToRollList -> {
	    	if (die2Box.isSelected()) {
	    		diceToRoll[1] = die2;
	    	}
	    	
	    	else {
	    		diceToRoll[1] = null;
	    	}
	    });
	    
	    CheckBox die3Box = new CheckBox();
	    die3Box.setDisable(true);
	    checkBoxes[2] = die3Box;
	    die3Box.setOnAction(addToRollList -> {
	    	if (die3Box.isSelected()) {
	    		diceToRoll[2] = die3;
	    	}
	    	
	    	else {
	    		diceToRoll[2] = null;
	    	}
	    });
	    
	    CheckBox die4Box = new CheckBox();
	    die4Box.setDisable(true);
	    checkBoxes[3] = die4Box;
	    die4Box.setOnAction(addToRollList -> {
	    	if (die4Box.isSelected()) {
	    		diceToRoll[3] = die4;
	    	}
	    	
	    	else {
	    		diceToRoll[3] = null;
	    	}
	    });
	    
	    CheckBox die5Box = new CheckBox();
	    die5Box.setDisable(true);
	    checkBoxes[4] = die5Box;
	    die5Box.setOnAction(addToRollList -> {
	    	if (die5Box.isSelected()) {
	    		diceToRoll[4] = die5;
	    	}
	    	
	    	else {
	    		diceToRoll[4] = null;
	    	}
	    });
	    
		GridPane.setHalignment(die1Box, HPos.CENTER);
		GridPane.setValignment(die1Box, VPos.CENTER);
		GridPane.setHalignment(die2Box, HPos.CENTER);
		GridPane.setValignment(die2Box, VPos.CENTER);
		GridPane.setHalignment(die3Box, HPos.CENTER);
		GridPane.setValignment(die3Box, VPos.CENTER);
		GridPane.setHalignment(die4Box, HPos.CENTER);
		GridPane.setValignment(die4Box, VPos.CENTER);
		GridPane.setHalignment(die5Box, HPos.CENTER);
		GridPane.setValignment(die5Box, VPos.CENTER);
	    
	    Button rollButton = new Button("Roll the dice!");
	    rollButton.setOnAction(roll -> {
	    	if (rolls == 0) {
	    		die1.roll();
	    		die2.roll();
	    		die3.roll();
	    		die4.roll();
	    		die5.roll();
	    		
	    		die1Box.setDisable(false);
	    		die2Box.setDisable(false);
	    		die3Box.setDisable(false);
	    		die4Box.setDisable(false);
	    		die5Box.setDisable(false);
	    		
	    		updateImage(die1,die1Viewer);
	    		updateImage(die1,die1Viewer);
	    		updateImage(die2,die2Viewer);
	    		updateImage(die3,die3Viewer);
	    		updateImage(die4,die4Viewer);
	    		updateImage(die5,die5Viewer);
	    		rolls++;
	    		info.setText("You have "+(MAX_ROLLS-rolls)+" rolls left.");
	    	}
	    	
	    	else if (rolls < MAX_ROLLS) {
	    			for (int i = 0;i<diceToRoll.length;i++) {
	    				Die d = diceToRoll[i];
	    				if (d != null) {
	    					d.roll();
	    					updateImage(d,dieToImageView[i]); //Update box image
	    					checkBoxes[i].fire(); //Unchecks boxes for rethrow
	    					info.setText("You have "+(MAX_ROLLS-rolls)+" left."); //Updates info label
	    				}
	    			}
	    			
	    				rolls++;
	    				info.setText("You have "+(MAX_ROLLS-rolls)+" rolls left.");

	    			if (rolls == MAX_ROLLS) {
	    				rollButton.setText("Restart?");
	    				info.setText(result());
	    	    		die1Box.setDisable(true);
	    	    		die2Box.setDisable(true);
	    	    		die3Box.setDisable(true);
	    	    		die4Box.setDisable(true);
	    	    		die5Box.setDisable(true);
	    			}
	    	}
	    	
	    	else {
	    		rolls = 0;
	    		info.setText("You have "+(MAX_ROLLS-rolls)+" rolls left.");
	    	}
	    	
	    	
	    });
		
	    //Layouts
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(5);
	    
	    grid.setPadding(new Insets(5,5,5,5)); //top, right, bottom, left
	    //grid.setGridLinesVisible(true); //For debugging
	    
	    grid.add(header,0,0,2,1);
		grid.add(die1Viewer, 0, 1);
		grid.add(die2Viewer, 1, 1);
		grid.add(die3Viewer, 2, 1);
		grid.add(die4Viewer, 3, 1);
		grid.add(die5Viewer, 4, 1);
		grid.add(die1Box, 0, 2);
		grid.add(die2Box, 1, 2);
		grid.add(die3Box, 2, 2);
		grid.add(die4Box, 3, 2);
		grid.add(die5Box, 4, 2);
		grid.add(rollButton,0,3);
		grid.add(info,1,3,4,1);
	    
		//Scene stuff
		Scene scene = new Scene(grid);
		primaryStage.setTitle("Yahtzee");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
