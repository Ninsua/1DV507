package da222mz_assign2.Exercise6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	    grid.setHgap(15);
	    grid.setVgap(15);
	    //top,right,bottom,left, wat
	    grid.setPadding(new Insets(10,5, 10, 5));
	    grid.setGridLinesVisible(true);
	    
	    Text header = new Text(0,0,"Compound Interest");
	    header.setTextAlignment(TextAlignment.CENTER);
	    header.setFont(Font.font("Helvetica",40));
	    
	    final TextField ammountField = new TextField();
	    final TextField interestField = new TextField();
	    final TextField yearField = new TextField();
	    
	    Button calculate = new Button();
		
	    grid.add(header,0,0);
	    GridPane.setFillWidth(header,true);
		grid.add(new Label("Start ammount:"), 0, 1);
		grid.add(new Label("Interest:"), 0, 2);
		grid.add(new Label("Number of years"), 0, 3);
		
		grid.add(ammountField, 1, 1);
		grid.add(interestField, 1, 2);
		grid.add(yearField, 1, 3);
		
		
		
	    
		//System.out.println(grid.getRowCount());
	    
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
