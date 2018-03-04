package da222mz_assign3.Exercise9;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class TinyPainterMain extends Application {
	
	public void start(Stage mainStage) {
		
		//Shape lists
		ArrayList<Line> lineList = new ArrayList<Line>();
		ArrayList<Rectangle> dotList = new ArrayList<Rectangle>();
		ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();
		
		//Layouts
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(5);
	    grid.setPadding(new Insets(5,5,5,5)); //top, right, bottom, left
	    grid.setGridLinesVisible(true); //For debugging
	    
	    HBox menu = new HBox();
	    menu.setSpacing(10);
		
		//Nodes
		ComboBox<String> shapeSel = new ComboBox<String>();
		shapeSel.getItems().addAll("Line","Dot","Rectangle","Circle");
		shapeSel.getSelectionModel().select("Line");
		
		//Add sizes to size selection box
		ComboBox<Double> sizeSel = new ComboBox<Double>();
		for (Double d = 0.5; d<=40; d=d+0.5) {
			sizeSel.getItems().add(d);
		}
		sizeSel.getSelectionModel().select(0);
		
		ColorPicker colourSel = new ColorPicker();
		
	    Pane canvas = new Pane();
	    canvas.setPrefSize(GridPane.REMAINING, GridPane.REMAINING);
	    canvas.setMaxSize(GridPane.REMAINING, GridPane.REMAINING);
	    canvas.setStyle("-fx-background-color: #C90000");
	    
	    canvas.setOnMousePressed(draw -> {
	    	if (shapeSel.getSelectionModel().getSelectedItem().equals("Line")) {
	    		Line newLine;
	    		double startX = draw.getX();
	    		double startY = draw.getY();
	    		newLine = new Line(startX,startY,startX,startY);
	    		newLine.setStrokeWidth(sizeSel.getSelectionModel().getSelectedItem());
	    		newLine.setStroke(colourSel.getValue());
	    		
	    		canvas.getChildren().add(newLine);
	    		
	    		lineList.add(newLine);
	    	}
	    	
	    	if (shapeSel.getSelectionModel().getSelectedItem().equals("Dot")) {
	    		Rectangle newDot;
	    		double startX = draw.getX();
	    		double startY = draw.getY();
	    		double size = sizeSel.getSelectionModel().getSelectedItem();
	    		
	    		newDot = new Rectangle();
	    		newDot.setWidth(size);
	    		newDot.setHeight(size);
	    		newDot.setFill(colourSel.getValue());	
	    		newDot.setX(startX-(size/2.0));
	    		newDot.setY(startY-(size/2.0));
	    		
	    		canvas.getChildren().add(newDot);
	    		dotList.add(newDot);
	    	}
	    	
	    	if (shapeSel.getSelectionModel().getSelectedItem().equals("Rectangle")) {
	    		Rectangle newRect;
	    		double size = sizeSel.getSelectionModel().getSelectedItem();
	    		
	    		newRect = new Rectangle(1,1);
	    		newRect.setWidth(size);
	    		newRect.setHeight(size);
	    		newRect.setFill(colourSel.getValue());	
	    		newRect.setX(draw.getX()-(size/2.0));
	    		newRect.setY(draw.getY()-(size/2.0));
	    		
	    		canvas.getChildren().add(newRect);
	    		rectList.add(newRect);
	    	}	    	
	    });
	    
	    canvas.setOnMouseDragged(draw -> {
	    	if (shapeSel.getSelectionModel().getSelectedItem().equals("Line")) {
	    		Line endLine = lineList.get(lineList.size()-1);
	    		Double size = endLine.getStrokeWidth();
		    	endLine.setEndX(draw.getX());
		    	if (draw.getY() < size) { endLine.setEndY(size/2.0); } //Can't draw over menu
		    	else { endLine.setEndY(draw.getY()); }
	    	}
	    	
	    	if (shapeSel.getSelectionModel().getSelectedItem().equals("Rectangle")) {
	    		Rectangle rect = rectList.get(rectList.size()-1);
	    		
	    		Double xPos = draw.getX();
	    		Double yPos = draw.getY();
	    		
	    		if (xPos > rect.getX()) {
	    			rect.setWidth(draw.getX()-rect.getX());
	    			}
	    		else {
	    			rect.setWidth(rect.getX()-draw.getX());
	    			rect.setTranslateX(draw.getX()-rect.getX());
	    		}
	    		
	    		if (yPos > rect.getY()) {
	    			rect.setHeight(draw.getY()-rect.getY());
	    		}
	    		
	    		else if (rect.getY()-yPos >= rect.getY()) {
	    			rect.setHeight(rect.getY()-draw.getY());
	    			rect.setTranslateY(draw.getY()-rect.getY());
	    		}
	    			
	    		else {
	    			rect.setHeight(rect.getY()-draw.getY());
	    			rect.setTranslateY(draw.getY()-rect.getY());
	    		}
	    	}
	    });
		
		//Add notes to layouts
	    menu.getChildren().addAll(shapeSel,sizeSel,colourSel);
	    grid.add(menu,0,0);
		grid.add(canvas,0,1,3,1);
		
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
