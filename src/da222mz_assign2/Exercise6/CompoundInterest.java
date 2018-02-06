package da222mz_assign2.Exercise6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static java.lang.Math.toIntExact;

public class CompoundInterest extends Application {
	
	public int calcCompInt(double p,double r,double t) {
		double n = 0;
		
		
		return toIntExact(Math.round(p*Math.pow((1+r/n),n*t)));
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Compound Interest");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(30);
	    grid.setVgap(30);
	    //top,right,bottom,left, wat
	    grid.setPadding(new Insets(0, 250, 150, 0));
	    grid.setGridLinesVisible(true);
	    
	    Text text = new Text(0,0,"Compound Interest");
	    text.setFont(Font.font("Helvetica",25));
		
	    grid.add(text,7,0);
		grid.add(new Label("Start ammount:"), 0, 3);
	    
		System.out.println(grid.getRowCount());
	    
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
