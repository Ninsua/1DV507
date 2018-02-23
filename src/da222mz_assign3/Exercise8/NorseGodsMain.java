package da222mz_assign3.Exercise8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class NorseGodsMain extends Application {
	
	//Reads a file's text into a giant string
	public static String readFile(File f) throws IOException {
		BufferedReader fileReader;
		StringBuilder input = new StringBuilder();

		fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));	
			
		while (fileReader.ready()) {
			char c = (char) fileReader.read();
			if (c == '\n') {
				input.append(" ");
			}
			else {
				input.append(c);
			}
		}
			
		fileReader.close();

		return input.toString();
	}
	
	public void start(Stage mainStage) {
		//List of gods and it's populating
		ArrayList<NorseGod> godsList = new ArrayList<NorseGod>();
		
		NorseGod odin = new NorseGod();
		NorseGod thor = new NorseGod();
		NorseGod loki = new NorseGod();
		NorseGod baldr = new NorseGod();
		NorseGod freyr = new NorseGod();
		NorseGod freyja = new NorseGod();
		NorseGod heimdallr = new NorseGod();
		NorseGod bragi = new NorseGod();
		NorseGod tyr = new NorseGod();
		
		odin.setName("Odin");
		odin.SetRace("Norse God");
		godsList.add(odin);
		
		thor.setName("Thor");
		thor.SetRace("Norse God");
		godsList.add(thor);
		
		loki.setName("Loki");
		loki.SetRace("Norse God");
		godsList.add(loki);
		
		baldr.setName("Baldr");
		baldr.SetRace("Norse God");
		godsList.add(baldr);
		
		freyr.setName("Freyr");
		freyr.SetRace("Norse God");
		godsList.add(freyr);
		
		freyja.setName("Freyja");
		freyja.SetRace("Norse God");
		godsList.add(freyja);
		
		heimdallr.setName("Heimdallr");
		heimdallr.SetRace("Norse God");
		godsList.add(heimdallr);
		
		bragi.setName("Bragi");
		bragi.SetRace("Norse God");
		godsList.add(bragi);
		
		tyr.setName("Tyr");
		tyr.SetRace("Norse God");
		godsList.add(tyr);
		
		try {
			URL url = getClass().getResource("gods/odin.txt");
			odin.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/thor.txt");
			thor.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/loki.txt");
			loki.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/baldr.txt");
			baldr.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/freyr.txt");
			freyr.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/freyja.txt");
			freyja.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/heimdallr.txt");
			heimdallr.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/bragi.txt");
			bragi.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/tyr.txt");
			tyr.setDesc(readFile(new File(url.getPath())));
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//Nodes
		Label header = new Label("Norse gods and other Beings");
	    header.setTextAlignment(TextAlignment.CENTER);
	    header.setFont(Font.font("Helvetica",30));
	    
	    ListView<NorseGod> list = new ListView<NorseGod>();
	    
	    for (NorseGod ng : godsList) {
	    	list.getItems().add(ng);
	    }
	    
	    
		
	    //Layouts
		GridPane grid = new GridPane();
	    grid.setHgap(5);
	    grid.setVgap(5);
		
		grid.add(header,0,0,2,1);
		grid.add(list, 0, 1);
	    
	    grid.setPadding(new Insets(5,5,5,5)); //top, right, bottom, left
	    grid.setGridLinesVisible(true); //For debugging
	    
		//Scene stuff
		Scene scene = new Scene(grid);
		mainStage.setTitle("Norse Gods");
		mainStage.setResizable(false);
		mainStage.setScene(scene);
		mainStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}


}
