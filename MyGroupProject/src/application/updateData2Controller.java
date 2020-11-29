package application;

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
    	    	 	   
    	    	BufferedReader br = new BufferedReader(new FileReader("data.txt")); 
    	    	String line="";
    	    	ArrayList<String> list = new ArrayList<String>();
    	    	while ((line = br.readLine()) != null){
    	    	
    	    		String[] values = line.split(",");
    	  
    	    	   list.add(values[0]);
    	    	}    	
    	    	for (int i = 0; i < list.size(); i += 7) {
    	    		  List<String> list1 = list.subList(i, Math.min(i + 7, list.size()));
  		  
    	    		  
    
    	    	        if (list1.get(0).contains(ID.getText())) {
    	    	        	firstName.setText(list1.get(1));
   	    	        	lastName.setText(list1.get(2));
    	    	       
   	    	           if (list1.get(3).contains("Female")) {
    	    	          
   	    	        	female.setSelected(true);  	
    	    	                }
   	    	                else if (list1.get(3).contains("Male")) {
    	    	                	male.setSelected(true);  	
    	    	                    }
    	    	        	dob.setText(list1.get(4));
    	    	        	phone.setText(list1.get(5));
    	    	        	homeAd.setText(list1.get(6));

    	    	}
    	    }
    	    	br.close();
    	  }
    	    
    	    @FXML
    	    void Update(ActionEvent event) throws IOException {
    	    

    	    	BufferedReader br = new BufferedReader(new FileReader("data.txt")); 
    	    	String line="";
    	    	ArrayList<String> list = new ArrayList<String>();
    	    	List<List<String>> list1 = new ArrayList<List<String>>();
    	    	while ((line = br.readLine()) != null){
    	
    	    		String[] values = line.split(",");
    	    	   list.add(values[0]);
    	    		
    	    			
    	    	}

    	    	 ArrayList<String> inner = new ArrayList<String>();
    	    	 inner.addAll(list);
    	    	 for (int i = 0; i < list.size(); i += 7) {
    	    	        list1.add(new ArrayList<String>(list.subList(i, Math.min(list.size(), i + 7))));
    	    	        }
    	    	 System.out.println("entirelist1: " + list);
    	    	 System.out.println("entirelist2: " + list1);
    	    	 System.out.println("outerlist: " + list1.get(0));
    	    	 System.out.println("innerlist: " + list.get(0));
    	    for (int i = 0; i<list1.size(); i++) {  
    	    
    	    	if ((list1.get(i).contains(ID.getText()))) {
    	    		
    	    		System.out.println(list1.get(i));
    	    		System.out.println("before clear: "+list1);
    	    	 	list1.get(i).clear();
    	    		System.out.println("after clear: "+list1);
    	    		
    	    		
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
    	    System.out.println("afteradd: "+ list1);
    	    
    	    
    	    ArrayList<String> al= new ArrayList<String>();
    	    
    	    for (int j = 0; j<list1.size(); j++) {
    	    	al.addAll(list1.get(j));
    	    }
    	    FileWriter writer = new FileWriter("data.txt");
		   	for(String str: al) {
		   	writer.write(str + System.lineSeparator());
		   	}
		   	
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
    	    	        	


    @FXML
    void gobackhome(ActionEvent event) throws IOException {
    	anchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

}
