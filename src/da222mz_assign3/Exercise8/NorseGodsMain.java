package da222mz_assign3.Exercise8;

/*
 * TODO
 * Automate the adding of gods by scanning the gods folder, if time allows it (probably not)
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class NorseGodsMain extends Application {
	
	//Reads ANSI encoded text files into a giant string
	public static String readFile(File f) throws IOException {
		BufferedReader fileReader;
		StringBuilder input = new StringBuilder();

		fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "Cp1252"));	
			
		while (fileReader.ready()) {
			char c = (char) fileReader.read();
				input.append(c);
		}
			
		fileReader.close();

		return input.toString();
	}
	
	public void start(Stage mainStage) {
		//List of gods and it's populating
		ArrayList<NorseGod> godsList = new ArrayList<NorseGod>();
		ArrayList<String> stringList = new ArrayList<String>();
		
		NorseGod odin = new NorseGod();
		NorseGod thor = new NorseGod();
		NorseGod loki = new NorseGod();
		NorseGod baldr = new NorseGod();
		NorseGod freyr = new NorseGod();
		NorseGod freyja = new NorseGod();
		NorseGod heimdallr = new NorseGod();
		NorseGod bragi = new NorseGod();
		NorseGod tyr = new NorseGod();
		NorseGod ninhursag = new NorseGod();
		
		//All this stuff needs to be automated, maybe someday...
		odin.setName("Odin");
		odin.SetRace("W�den");
		godsList.add(odin);
		
		thor.setName("Thor");
		thor.SetRace("Norse God");
		godsList.add(thor);
		
		loki.setName("Loki");
		loki.SetRace("Some guy");
		godsList.add(loki);
		
		baldr.setName("Baldr");
		baldr.SetRace("Norse God");
		godsList.add(baldr);
		
		freyr.setName("Freyr");
		freyr.SetRace("Norse God");
		godsList.add(freyr);
		
		freyja.setName("Freyja");
		freyja.SetRace("Some chick");
		godsList.add(freyja);
		
		heimdallr.setName("Heimdallr");
		heimdallr.SetRace("Norse God");
		godsList.add(heimdallr);
		
		bragi.setName("Bragi");
		bragi.SetRace("dude stop Bragi'n"); //sorry I'll see myself out
		godsList.add(bragi);
		
		tyr.setName("Tyr");
		tyr.SetRace("Norse God");
		godsList.add(tyr);
		
		//Not a norse god but w/e
		ninhursag.setName("Ninhursag");
		ninhursag.SetRace("Mother Goddess, Goddess of Fertility");
		godsList.add(ninhursag);

		//Read descriptions from text files, obviously needs to be automated
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
			
			url = getClass().getResource("gods/tyr.txt");
			tyr.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/tyr.txt");
			tyr.setDesc(readFile(new File(url.getPath())));
			
			url = getClass().getResource("gods/ninhursag.txt");
			ninhursag.setDesc(readFile(new File(url.getPath())));
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//Create string list and map them to a god (for display purposes)
		for (int i = 0;i<godsList.size();i++) {
			stringList.add(godsList.get(i).getName());
		}
		
	    //Layouts
		GridPane grid = new GridPane();
	    grid.setHgap(15);
	    grid.setVgap(0);
	    grid.setPadding(new Insets(5,5,5,5)); //top, right, bottom, left
	    // grid.setGridLinesVisible(true); //For debugging
	    
	    VBox nameAndRaceBox = new VBox();
	    nameAndRaceBox.setSpacing(0);
	    nameAndRaceBox.setPadding(new Insets(0,0,8,0));
	    
	    ScrollPane scrollBox = new ScrollPane();
	    scrollBox.setPrefSize(400, 300);
	    scrollBox.setFitToWidth(true);
		
		//Nodes
		Label header = new Label("Norse gods and other Beings");
	    header.setTextAlignment(TextAlignment.CENTER);
	    header.setFont(Font.font("Helvetica",25));
	    header.setStyle("-fx-font-weight: bold");
	    
	    //Node that displays the list
	    ListView<String> list = new ListView<String>();
	    for (String s : stringList) {
	    	list.getItems().add(s);
	    }
	    list.setMaxWidth(140);
	    list.setMaxHeight(350);
	    
	    //Select the first item in list
	    list.getSelectionModel().select(0);
	    list.getFocusModel().focus(0);
	    
	    //Content nodes
	    Label nameDisplay = new Label(godsList.get(list.getSelectionModel().getSelectedIndex()).getName());
	    nameDisplay.setFont(Font.font("Helvetica",16));
	    nameDisplay.setStyle("-fx-font-weight: bold");
	    Label raceDisplay = new Label(godsList.get(list.getSelectionModel().getSelectedIndex()).getRace());
	    raceDisplay.setFont(Font.font("Helvetica",12));
	    raceDisplay.setStyle("-fx-font-style: italic");
	    Text descDisplay = new Text(godsList.get(list.getSelectionModel().getSelectedIndex()).getDesc());
	    descDisplay.setFont(Font.font("Helvetica"));
	    
	    TextFlow richText = new TextFlow();
	    richText.setPrefSize(GridPane.REMAINING, GridPane.REMAINING);
	    richText.getChildren().add(descDisplay);
	    
	    //Listeners
	    list.getSelectionModel().selectedIndexProperty().addListener(contentUpdate -> {
	    	nameDisplay.setText(godsList.get(list.getSelectionModel().getSelectedIndex()).getName());
	    	raceDisplay.setText(godsList.get(list.getSelectionModel().getSelectedIndex()).getRace());
	    	descDisplay.setText(godsList.get(list.getSelectionModel().getSelectedIndex()).getDesc());
	    });
	    
	    //Add nodes to layouts
	    scrollBox.setContent(richText);
	    nameAndRaceBox.getChildren().addAll(nameDisplay,raceDisplay);
	    
		grid.add(header,0,0,2,1);
		grid.add(list, 0,1,1,3);
		grid.add(nameAndRaceBox,1,1);
		grid.add(scrollBox,1,2);
	    
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
