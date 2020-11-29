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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    private AnchorPane anchor;
    
    @FXML
    private Button add;

    @FXML
    private Button update;
    
    @FXML
    private Button view;

    @FXML
    private Button log;

    @FXML
    private Button remove;

    @FXML
    void addStu(ActionEvent event) throws IOException {
    	// go to the Register fxml of click to the register button.
    	anchor = FXMLLoader.load(getClass().getResource("register.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void updateStu(ActionEvent event) throws IOException {
    	// go to the updateData2 fxml of click to the update button.
     	anchor = FXMLLoader.load(getClass().getResource("updateData2.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void viewStu(ActionEvent event) throws IOException {
    	// go to viewStudents fxml of click to the view Student button.
        anchor = FXMLLoader.load(getClass().getResource("viewStudents.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void removeStu(ActionEvent event) throws IOException {
    	// go to remover fxml of click to the view remove studentbutton.
    	anchor = FXMLLoader.load(getClass().getResource("remover.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	// if click the log out button, will go back to the login page and print log out success
    	 Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("logout status");
	        alert.setHeaderText(null);
	        alert.setContentText("LOGOUT SUCESSFUL");
	        alert.showAndWait();
    	anchor = FXMLLoader.load(getClass().getResource("login.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

}
