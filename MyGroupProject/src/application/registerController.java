package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registerController {

    @FXML
    private Button add;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phone;

    @FXML
    private TextField homeAd;

    @FXML
    private TextField dob;

    @FXML
    private TextField ID;
    @FXML
    private CheckBox female;

    @FXML
    private CheckBox male;
    @FXML
    private AnchorPane anchor;


    @FXML
    void register(ActionEvent event) throws IOException {
    	
    	
        List<String> Array = new ArrayList<String>();
        File myfile = new File("data.txt");
        
        if(!myfile.exists()){
          myfile.createNewFile();
        }        
        Scanner myReader = new Scanner(myfile);
    	String data = null;
    	String stID = ID.getText();
    	 
    		
    	if (stID.matches("^[a-zA-Z]{3}[0-9]{3}$") == false) { // if the user name is not "abc123" exit the program.
			   Alert alert = new Alert(AlertType.WARNING);
	  	        alert.setTitle("ERROR");
	  	        alert.setHeaderText(null);
	  	        alert.setContentText("INVALID INPUT ID. Please Try again");
	  	        alert.showAndWait();
	  	      anchor = FXMLLoader.load(getClass().getResource("register.fxml")); 
	 	  		Scene scene = new Scene(anchor);
	 	  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	 	  		window.setScene(scene);
	 	  		window.show();
	
		}
    	else { 
    		
    if (myfile.length() == 0) {
    	  Array.add(stID);
          File file=new File("data.txt");
          FileWriter writer = new FileWriter(file,true); 
          Array.add(firstName.getText());
          Array.add(lastName.getText());
          
          if (female.isSelected()) {
              Array.add("Female");     	
              }
              else if (male.isSelected()) {
                  Array.add("Male");     	
                  }
          Array.add(dob.getText());
          Array.add(phone.getText());
          Array.add(homeAd.getText());
      	
      	
          for(String str: Array) {
          	  writer.write(str + System.lineSeparator());
          	}         
          
          Alert alert = new Alert(AlertType.INFORMATION);
  	        alert.setTitle("INFORMATION STATUS");
  	        alert.setHeaderText(null);
  	        alert.setContentText("NEW USER CREATED.");
  	        alert.showAndWait();
  	        
          writer.close();
          myReader.close(); 
          ID.clear();
          firstName.clear();
          lastName.clear();
          phone.clear();
          homeAd.clear();
          dob.clear();
          male.setSelected(false);
          female.setSelected(false);
         }
    	
    	
    else {
    		
   	while (myReader.hasNextLine()) {
            data = myReader.nextLine();
       	
       if (data.contains(stID)) {   
    	   
    	   Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("ERROR");
 	        alert.setHeaderText(null);
 	        alert.setContentText("THE USER ALREADY EXISTED");
 	        alert.showAndWait();
 	        
 	        anchor = FXMLLoader.load(getClass().getResource("register.fxml")); 
 	  		Scene scene = new Scene(anchor);
 	  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
 	  		window.setScene(scene);
 	  		window.show();
 	  		
 	  		break;
       }
       }
        if (!data.contains(stID)) {
        	
        Array.add(stID);
        File file=new File("data.txt");
        FileWriter writer = new FileWriter(file,true); 
        Array.add(firstName.getText());
        Array.add(lastName.getText());
        
        if (female.isSelected()) {
            Array.add("Female");     	
            }
            else if (male.isSelected()) {
                Array.add("Male");     	
                }
        Array.add(dob.getText());
        Array.add(phone.getText());
        Array.add(homeAd.getText());
    	
    	
        for(String str: Array) {
        	  writer.write(str + System.lineSeparator());
        	}         
        
        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("INFORMATION STATUS");
	        alert.setHeaderText(null);
	        alert.setContentText("NEW USER CREATED.");
	        alert.showAndWait();
	        
        writer.close();
        myReader.close(); 
        ID.clear();
        firstName.clear();
        lastName.clear();
        phone.clear();
        homeAd.clear();
        dob.clear();
        male.setSelected(false);
        female.setSelected(false);
       }
    }
    }
    }

    
    @FXML
    void gobackhome(ActionEvent event) throws IOException {
    	anchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    
    
}