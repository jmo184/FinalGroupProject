package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private AnchorPane loginAnchor;

    @FXML
    private TextField password;

    @FXML
    private TextField userName;

    @FXML
    private Button login;

    @FXML
    private Button account;


    @FXML
    void loginpage(ActionEvent event) throws IOException {
         String user = userName.getText();
         String pword = password.getText();
 
    	
       //  if(user.equals("user") && pword.equals("pw")) {
        	 
        	 if(user.equals("") && pword.equals("")) {
        	 
        	   Alert alert = new Alert(AlertType.INFORMATION);
	  	        alert.setTitle("LOGIN STATUS");
	  	        alert.setHeaderText(null);
	  	        alert.setContentText("LOGIN SUCCESS");
	  	        alert.showAndWait();
	  	    
	  		loginAnchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
	  		Scene scene = new Scene(loginAnchor);
	  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	  		window.setScene(scene);
	  		window.show();
	  	        
	 
         }
         else{
        	  Alert alert = new Alert(AlertType.INFORMATION);
	  	        alert.setTitle("login status");
	  	        alert.setHeaderText(null);
	  	        alert.setContentText("Login Fail, please try again");
	  	        alert.showAndWait();
         }
         userName.clear();
         password.clear();
    }

}
	
	
	

