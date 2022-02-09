package PC_Manager;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Manager_Login extends PC_Main {
	@FXML
	private Label wrongLabel;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button cancelButton;

	Stage mainStage;
	Stage kioskStage;
	Scene scene1;	
	Scene scene2;

	public void ManagerCancel(ActionEvent event) throws Exception {
		Stage stage = (Stage)cancelButton.getScene().getWindow();
		stage.close();
	}
	public void ManagerLogin(ActionEvent event) throws Exception {
		if (username.getText().equals("admin") && password.getText().equals("admin")) {
			try {
				Parent root1 = FXMLLoader.load(getClass().getResource("/Scene/Manager_Main.fxml"));
				Parent root2 = FXMLLoader.load(getClass().getResource("/Scene/Kiosk.fxml"));
		
				mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				kioskStage = new Stage();

				scene1 = new Scene(root1);
				scene2 = new Scene(root2);
				mainStage.setTitle("Manager_Main");
				kioskStage.setTitle("Kiosk");
				mainStage.setScene(scene1);
				kioskStage.setScene(scene2);
				mainStage.setX(900);
				mainStage.setY(30);
				kioskStage.setX(80);
				kioskStage.setY(30);
				mainStage.show();
				kioskStage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			wrongLabel.setText("Login Failed");
		}
	}
}
