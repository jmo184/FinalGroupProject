package application;

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
    	
    	anchor = FXMLLoader.load(getClass().getResource("register.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void updateStu(ActionEvent event) throws IOException {
    	
     	anchor = FXMLLoader.load(getClass().getResource("updateData2.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void viewStu(ActionEvent event) throws IOException {
                anchor = FXMLLoader.load(getClass().getResource("viewStudents.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void removeStu(ActionEvent event) throws IOException {
    		anchor = FXMLLoader.load(getClass().getResource("remover.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	
    	 Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("logout status");
	        alert.setHeaderText(null);
	        alert.setContentText("LOGOUT Success");
	        alert.showAndWait();
    	anchor = FXMLLoader.load(getClass().getResource("login.fxml")); 
  		Scene scene = new Scene(anchor);
  		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  		window.setScene(scene);
  		window.show();
    }

}
