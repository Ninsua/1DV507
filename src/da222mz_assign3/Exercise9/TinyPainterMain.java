package da222mz_assign3.Exercise9;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class TinyPainterMain extends Application {
	
	public void start(Stage mainStage) {
		
		//Shape lists
		ArrayList<Shape> shapeList = new ArrayList<Shape>();
		
		//Layouts
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(5);
	    grid.setPadding(new Insets(5,5,5,5)); //top, right, bottom, left
	    grid.setGridLinesVisible(true); //For debugging
		
		//Nodes
		ComboBox<String> shapeSel = new ComboBox<String>();
		shapeSel.getItems().addAll("Line","Dot","Rectangle","Circle");
		shapeSel.getSelectionModel().select("Line");
		
		ComboBox<Double> sizeSel = new ComboBox<Double>();
		for (Double d = 0.5; d<=40; d=d+0.5) {
			sizeSel.getItems().add(d);
		}
		sizeSel.getSelectionModel().select(0);
		
		ColorPicker colourSel = new ColorPicker();
		
	    HBox drawField = new HBox();
	    drawField.setPrefSize(GridPane.REMAINING, GridPane.REMAINING);
	    drawField.setStyle("-fx-background-color: #C90000");
	    
	    drawField.setOnMouseClicked(draw -> {
	    	if (shapeSel.getSelectionModel().getSelectedItem().equals("Line")) {
	    		double rootX = draw.getX();
	    		double rootT = draw.getY();
	    		shapeList.add(new Line(0,0,rootX,rootY);
	    	}
	    });
		
		//Add notes to layouts
		grid.add(shapeSel,0,0);
		grid.add(sizeSel,1,0);
		grid.add(colourSel,2,0);
		grid.add(drawField,0,1,3,1);
		
		
		Scene mainScene = new Scene(grid,800,600);
		mainStage.setTitle("Tiny Painter");
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		mainStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
}
