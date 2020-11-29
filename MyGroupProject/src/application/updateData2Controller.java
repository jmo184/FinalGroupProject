package application;
/*
Group 12: The Code Crew
Team leader:
Tuan Nguyentuan9891/#72470140

Jackie Tranjmo184/#70924204

Samir Stanislav YezhnikovskyHeart-Force/ #71355492

this is import all the files needed for  the controller
*/
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public class updateData2Controller {


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
    private AnchorPane anchor;

    @FXML
    private TextField ID;

    @FXML
    private CheckBox female;

    @FXML
    private CheckBox male;

    @FXML
    private Button home;
    


    	    @FXML
    	    void SearchingStu(ActionEvent event) throws IOException {
    	    	 	   
    	    	BufferedReader br = new BufferedReader(new FileReader("data.txt")); // use buffered Reader to open the file 
    	    	String line="";  // declare the empty line
    	    	ArrayList<String> list = new ArrayList<String>(); // use array to store data.
    	    	while ((line = br.readLine()) != null){ // if the file is not empty
    	    	
    	    		String[] values = line.split(","); // add the value to the array
    	  
    	    	   list.add(values[0]); // add the array of value to the list
    	    	}    	
    	    	for (int i = 0; i < list.size(); i += 7) { // loop through the list length and divide it into sections 
    	    		  List<String> list1 = list.subList(i, Math.min(i + 7, list.size())); // each of the array inside the arraylist contain 7 items
  		  
    	    	        if (list1.get(0).contains(ID.getText())) {  // if the Student ID store in the 0 index contain when input the Student ID search
    	    	        	firstName.setText(list1.get(1)); // print out the first name in after search
   	    	        	    lastName.setText(list1.get(2));// print out the last name in after search
    	    	       
   	    	           if (list1.get(3).contains("Female")) {// check the female box in after search
    	    	          
   	    	            	female.setSelected(true);  	
    	    	                }
   	    	                else if (list1.get(3).contains("Male")) {// check the male box in after search
    	    	                	male.setSelected(true);  	
    	    	                    }
    	    	        	dob.setText(list1.get(4));// print out the dob in after search
    	    	        	phone.setText(list1.get(5));// print out the phone in after search
    	    	        	homeAd.setText(list1.get(6));// print out the home address in after search

    	    	}
    	    }
    	    	br.close();
    	  }
    	     // update function
    	    @FXML
    	    void Update(ActionEvent event) throws IOException {
    	    

    	    	BufferedReader br = new BufferedReader(new FileReader("data.txt"));  // read the file
    	    	String line=""; 
    	    	ArrayList<String> list = new ArrayList<String>(); // store in the array list
    	    	List<List<String>> list1 = new ArrayList<List<String>>(); // store arrayList inside the list.
    	    	while ((line = br.readLine()) != null){
    	
    	    		String[] values = line.split(",");
    	    	   list.add(values[0]); // read the contain of the file if exist then store it inside the arraylist
    	    		
    	    			
    	    	}

    	    	 ArrayList<String> inner = new ArrayList<String>(); // declare another arraylist for later use
    	    	 inner.addAll(list); // addAll the list inside the inner arraylist
    	    	 for (int i = 0; i < list.size(); i += 7) { // loop through the list and divide the list into an equal section.
    	    	        list1.add(new ArrayList<String>(list.subList(i, Math.min(list.size(), i + 7)))); 
    	    	        }
    	    	 System.out.println("entirelist1: " + list);
    	    	 System.out.println("entirelist2: " + list1);
    	    	 System.out.println("outerlist: " + list1.get(0));
    	    	 System.out.println("innerlist: " + list.get(0));
    	    for (int i = 0; i<list1.size(); i++) {  
    	       // loop through the list1.size  array, if it contain the updated ID, Delete the entire ID
    	    	if ((list1.get(i).contains(ID.getText()))) {
    	    		
    	    		System.out.println(list1.get(i));
    	    		System.out.println("before clear: "+list1);
    	    	 	list1.get(i).clear(); // delete funtion
    	    		System.out.println("after clear: "+list1);
    	    		
    	    		// then add new info or update the info
    	    		   list1.get(i).add(ID.getText());
    	    		   list1.get(i).add(firstName.getText());
    	    		   list1.get(i).add(lastName.getText());
    	    		    if (female.isSelected()) {
    	    		    	list1.get(i).add("Female");     	
    	  	              }
    	   	              else if (male.isSelected()) {
    	   	            	list1.get(i).add("Male");     	
    	  	                  
    	   	              }
    	    		    
    	    		    list1.get(i).add(dob.getText());
   	   	                list1.get(i).add(phone.getText());
   	  	                list1.get(i).add(homeAd.getText());
  		              
    	    	}
    	    	}
    	      
    	    ArrayList<String> al= new ArrayList<String>(); // declare another arraylist to print out the data or write the update data to file
    	    
    	    for (int j = 0; j<list1.size(); j++) {
    	    	al.addAll(list1.get(j)); // add the al Arraylist to file
    	    }
    	    FileWriter writer = new FileWriter("data.txt"); // open the file
		   	for(String str: al) { // write all content to file
		   	writer.write(str + System.lineSeparator());
		   	}
		   	// update warning
		    Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("UPDATE STATUS");
	        alert.setHeaderText(null);
	        alert.setContentText("UPDATE SUCCESS");
	        alert.showAndWait();
		   	
	        anchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
	  		Scene scene = new Scene(anchor);
	  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	  		window.setScene(scene);
	  		window.show();
		   	writer.close();
	    	
    	    	br.close();
    	    }
    	    	        	
  // click on the home button to goback to the main Menu

    @FXML
    void gobackhome(ActionEvent event) throws IOException {
    	anchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

}
