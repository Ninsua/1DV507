package da222mz_assign2.Exercise5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Snowman extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Text text = new Text(20,50,"asd");
		
		Group root = new Group();
		root.getChildren().add(text);
		Scene scene = new Scene(root,500,100);
		
		primaryStage.setTitle("sas");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
