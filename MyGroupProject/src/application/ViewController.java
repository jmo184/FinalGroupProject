package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewController implements Initializable {

	@FXML
	private Button home;
	
	@FXML
	private ListView<String> list1;
	
	@FXML
	private ListView<String> list2;
	
	@FXML
	private ListView<String> list3;
	
	@FXML
	private ListView<String> list4;
	
	@FXML
	private ListView<String> list5;
	
	@FXML
	private ListView<String> list6;

	@FXML
	private ListView<String> list7;
	
	@FXML
	private AnchorPane anchorView;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			FileInputStream input = new FileInputStream("data.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
			ArrayList<String> items = new ArrayList<String>();
			String line = buffer.readLine();
			while(line != null) {
				items.add(line);
				line = buffer.readLine();
			}
			buffer.close();
			
			int arraySize = items.size();
			int i = 0;

			while (i < arraySize)
			{
				list1.getItems().add(items.get(i));
				i++;
				list2.getItems().add(items.get(i));
				i++;
				list3.getItems().add(items.get(i));
				i++;
				list4.getItems().add(items.get(i));
				i++;
				list5.getItems().add(items.get(i));
				i++;
				list6.getItems().add(items.get(i));
				i++;
				list7.getItems().add(items.get(i));
				i++;
			}
			
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	  @FXML
	    void gobackhome(ActionEvent event) throws IOException {
	    	anchorView = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
	  		Scene scene = new Scene(anchorView);
	  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	  		window.setScene(scene);
	  		window.show();
	    }
	
}
