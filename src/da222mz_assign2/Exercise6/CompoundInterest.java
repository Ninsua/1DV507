package da222mz_assign2.Exercise6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Group;
import javafx.scene.Node;
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
		
		//Nodes
		Text header = new Text(0,0,"Compound Interest");
	    header.setTextAlignment(TextAlignment.CENTER);
	    header.setFont(Font.font("Helvetica",30));
	    
	    Label ammontLabel = new Label("Start ammount:");
	    ammontLabel.setFont(Font.font("Helvetica",15));
	    Label interestLabel = new Label("Interest:");
	    interestLabel.setFont(Font.font("Helvetica",15));
	    Label yearsLabel = new Label("Number of years:");
	    yearsLabel.setFont(Font.font("Helvetica",15));
	    
	    final TextField ammountField = new TextField();
	    final TextField interestField = new TextField();
	    final TextField yearField = new TextField();
	    
	    Button calculate = new Button();
	    
	    //Boxes
		HBox splashHBox = new HBox();
		splashHBox.setSpacing(10);
		splashHBox.setStyle("-fx-background-color: #DD0000;");
		splashHBox.setAlignment(Pos.CENTER);
		splashHBox.getChildren().add(header);
		
		VBox leftVBox = new VBox();
		leftVBox.setPadding(new Insets(15,5,10,5)); //top,right,bottom,left, wat
		leftVBox.setSpacing(15);
		leftVBox.setStyle("-fx-background-color: #00DD00;");
		leftVBox.setAlignment(Pos.CENTER_LEFT);
		leftVBox.getChildren().addAll(ammontLabel,interestLabel,yearsLabel);
		
		VBox rightVBox = new VBox();
		rightVBox.setPadding(new Insets(10,5,10,5));
		rightVBox.setSpacing(11);
		rightVBox.setStyle("-fx-background-color: #0000DD;");
		rightVBox.setAlignment(Pos.CENTER_RIGHT);
		rightVBox.getChildren().addAll(ammountField,interestField,yearField);
		
		HBox middleBox = new HBox();
		//middleBox.setAlignment(Pos.CENTER);
		middleBox.setStyle("-fx-background-color: #DD6644;");
		middleBox.getChildren().addAll(leftVBox,rightVBox);
		
		/*
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(5);
	    grid.setVgap(5);
	    //top,right,bottom,left, wat
	    grid.setPadding(new Insets(10,5, 10, 5));
	    grid.setGridLinesVisible(true);
	    

	    

	    
	    

		
	    grid.add(header,0,0);
	    GridPane.setFillWidth(header,true);
		grid.add(new Label("Start ammount:"), 0, 1);
		grid.add(new Label("Interest:"), 0, 2);
		grid.add(new Label("Number of years"), 0, 3);
		
		grid.add(ammountField, 1, 1);
		grid.add(interestField, 1, 2);
		grid.add(yearField, 1, 3);
		*/
		
		
		
	    VBox root = new VBox();
	    root.getChildren().addAll(splashHBox,middleBox);
	    
		Scene scene = new Scene(root,300,220);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
