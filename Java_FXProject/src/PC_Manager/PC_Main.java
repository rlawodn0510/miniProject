package PC_Manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PC_Main extends Application {
	public void start(Stage primaryStage) {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("/Scene/Manager_Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Manager_Login");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
