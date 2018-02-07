package da222mz_assign2.Exercise5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Snowman extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Rectangle bg = new Rectangle(0,0,600,300);
		bg.setFill(Color.DEEPSKYBLUE);
		
		Circle sun = new Circle(500,75,55,Color.YELLOW);
		
		Circle head = new Circle(300,150,20,Color.WHITE);
		Circle torso = new Circle(300,195,30,Color.WHITE);
		Circle lowerBody = new Circle(300,260,50,Color.WHITE);
		Line arm1 = new Line(327,180,355,175);
		arm1.setStroke(Color.BURLYWOOD);
		arm1.setStrokeWidth(2);
		Line arm2 = new Line(273,180,246,175);
		arm2.setStroke(Color.BURLYWOOD);
		arm2.setStrokeWidth(2);
		
		Circle leftEye = new Circle(290,145,3,Color.BLACK);
		Circle rightEye = new Circle(310,145,3,Color.BLACK);
		
		Circle button1 = new Circle(300,177,3,Color.BLACK);
		Circle button2 = new Circle(300,192,3,Color.BLACK);
		Circle button3 = new Circle(300,207,3,Color.BLACK);
		
		Rectangle hat1 = new Rectangle(282,98,35,40);
		hat1.setFill(Color.BLACK);
		Rectangle hat2 = new Rectangle(274,128,50,10);
		hat1.setFill(Color.BLACK);
		hat2.setArcWidth(10);
		hat2.setArcHeight(10);
		Rectangle hat3 = new Rectangle(282,123,35,5);
		hat3.setFill(Color.RED);

		Line mouth = new Line(290,158,310,158);
		mouth.setStroke(Color.BLACK);
		
		Group root = new Group();
		root.getChildren().addAll(bg,sun);
		root.getChildren().addAll(head,torso,lowerBody,arm1,arm2);
		root.getChildren().addAll(mouth,leftEye,rightEye);
		root.getChildren().addAll(button1,button2,button3,hat1,hat2,hat3);
		Scene scene = new Scene(root,600,400);
		
		primaryStage.setTitle("Snowmayne");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
