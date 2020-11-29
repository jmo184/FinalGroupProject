package application;

/*
Group 12: The Code Crew
Team leader:
Tuan Nguyentuan9891/#72470140
Jackie Tranjmo184/#70924204
Samir Stanislav YezhnikovskyHeart-Force/ #71355492
*/

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
         String user = userName.getText();   // enter text to username
         String pword = password.getText();  // enter password
         	 
        	 if(user.equals("admin") && pword.equals("abc123")) { // username and password if contain then it will open the app
        	   // giving alert if the login is successful.
        	   Alert alert = new Alert(AlertType.INFORMATION);  
	  	        alert.setTitle("LOGIN STATUS");
	  	        alert.setHeaderText(null);
	  	        alert.setContentText("LOGIN SUCCESS");
	  	        alert.showAndWait();
	  	    // if login success, the menu will open 
	  		loginAnchor = FXMLLoader.load(getClass().getResource("mainMenu.fxml")); 
	  		Scene scene = new Scene(loginAnchor);
	  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	  		window.setScene(scene);
	  		window.show();
	  	        
	 
         }
         else{  // if the login fail, then input again until corrected password and username. 
        	  Alert alert = new Alert(AlertType.INFORMATION);
	  	        alert.setTitle("login status");
	  	        alert.setHeaderText(null);
	  	        alert.setContentText("Login Fail, please try again");
	  	        alert.showAndWait();
         }
         userName.clear(); // clear out the text after 
         password.clear(); // clear out the password after 
    }

}
	
	
	

