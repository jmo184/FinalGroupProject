package application;

/*
Group 12: The Code Crew
Team leader:
Tuan Nguyentuan9891/#72470140

Jackie Tranjmo184/#70924204

Samir Stanislav YezhnikovskyHeart-Force/ #71355492
*/

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
    	
    	
        List<String> Array = new ArrayList<String>(); // using the array list to store data.
        File myfile = new File("data.txt");  // open the file
        
        if(!myfile.exists()){ // if the file is not exist then create the new one
          myfile.createNewFile();
        }        
        Scanner myReader = new Scanner(myfile); // scan the file
    	String data = null; // declare data.
    	String stID = ID.getText(); // enter the Student ID text.
    	 
    		
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
    		
    if (myfile.length() == 0) {  // if the content of the file is empty, 
    	  Array.add(stID);  // add the ID in the array
          File file=new File("data.txt");  // open the file
          FileWriter writer = new FileWriter(file,true);  // writer contain to the file.
          Array.add(firstName.getText()); // add the First Name to the file
          Array.add(lastName.getText()); // add the last name to the file
          
          if (female.isSelected()) { // add check to female if female selected
              Array.add("Female");     	
              }
              else if (male.isSelected()) { // add check to male if male selected
                  Array.add("Male");     	
                  }
          Array.add(dob.getText());   // add the date of birth to the file
          Array.add(phone.getText());  // add the phone to the file
          Array.add(homeAd.getText());  // add the home address to the file
      	
      	
          for(String str: Array) {  // write to contain of the array to the file
          	  writer.write(str + System.lineSeparator());
          	}         
          // new user created when open the new file
          Alert alert = new Alert(AlertType.INFORMATION);
  	        alert.setTitle("INFORMATION STATUS");
  	        alert.setHeaderText(null);
  	        alert.setContentText("NEW USER CREATED.");
  	        alert.showAndWait();
  	        // close the file and myreader.
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
    		// if the file is create and not an empty file
   	while (myReader.hasNextLine()) {
            data = myReader.nextLine();
       	 // loop through the file
       if (data.contains(stID)) {   
    	   // if the data contain the Student ID print the Error and try again.
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
   	   // if the contain of the file does not contain the Student ID, then add new student info
        if (!data.contains(stID)) {
        	// code the same thing as above when create a new student.
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
	        // close and clear all file.
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

    // go back to the Main Menu if click the home button
    @FXML
    void gobackhome(ActionEvent event) throws IOException {
    	anchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    
    
}