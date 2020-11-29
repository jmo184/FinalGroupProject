package application;
/*
Full Name: Tuan Nguyen
UTSA ID: oce608

this is import all the files needed for  the controller
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try { // open the main window 
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root,370,260); // set window size 370, 260
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // style of the window
			primaryStage.setScene(scene); // set scene
			primaryStage.setTitle("login"); // set the title of the window
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
