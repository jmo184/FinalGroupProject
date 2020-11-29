package application;

/*
Group 12: The Code Crew
Team leader:
Tuan Nguyentuan9891/#72470140
Jackie Tranjmo184/#70924204 
Samir Stanislav YezhnikovskyHeart-Force/ #71355492
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
		} catch(Exception e) { // catch errors 
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { // function to launch the GUI
		launch(args);
	}
}
