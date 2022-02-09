package PC_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Customer_Join implements Initializable {

	@FXML
	private TextField id;
	@FXML
	private PasswordField password;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private Button joinBtn;
    @FXML
    private Button cancel;

	Stage stage;
	Scene scene;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		joinBtn.setOnAction(event -> joinCustomer(event));
		cancel.setOnAction(event -> cancelCustomer(event));

	}

	private void cancelCustomer(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Scene/Customer_Login.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setTitle("Customer_Login");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void joinCustomer(ActionEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Sign up");
		alert.setContentText("ID " + id.getText() + " 로 회원가입 하시겠습니까?");
		Optional<ButtonType> result1 = alert.showAndWait();
		
		if (result1.get() == ButtonType.OK) {
			String userId = id.getText();
			String userPw = password.getText();
			String userName = name.getText();
			String userPhone = phone.getText();
			CustomerDTO dto = new CustomerDTO(userId, userPw, userName, userPhone);

			// instance 객체로 불러오기
			CustomerDAO dao = CustomerDAO.getInstance();
			int result = dao.insert(dto);

			try {
				Parent root = FXMLLoader.load(getClass().getResource("/Scene/Customer_Login.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setTitle("Customer_Login");
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (result == 1) {
				System.out.println("회원가입 성공");

			} else {
				System.out.println("실패");
			}
		} else if (result1.get() == ButtonType.CANCEL) {
			alert.close();
		}

	}

}
