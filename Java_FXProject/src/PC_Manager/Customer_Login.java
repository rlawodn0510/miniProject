package PC_Manager;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Customer_Login implements Initializable {

	@FXML
	private TextField cus_id;
	@FXML
	private PasswordField cus_pass;
	@FXML
	private Button cus_login;
	@FXML
	private Button cus_join;
	@FXML
	private Label cus_wrongLabel;

	Stage stage;
	Scene scene;
	public static Stage Com1Stage;
	public static Stage Com2Stage;
	public static Stage Com3Stage;
	Scene scene1;
	Scene scene2;
	Scene scene3;

	boolean stop = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cus_login.setOnAction(event -> cus_login(event));
		cus_join.setOnAction(event -> cus_join(event));
	}

	private void cus_login(ActionEvent event) {
		String userId = cus_id.getText();
		String userPw = cus_pass.getText();
		CustomerDTO dto = new CustomerDTO(userId, userPw);
		CustomerDAO dao = CustomerDAO.getInstance();
		int result = dao.login(dto);

		if (result == 1) {
			System.out.println("로그인 성공");
			try {
				if (Kiosk.customer_com == 1) {
					if (Kiosk.Label1 != null) {
						
						Kiosk.Label1.setText("Used");
					}

//					System.out.println(Kiosk.Label1);
//					System.out.println(Kiosk.Label1.getText());
					
					Parent root1 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Com1.fxml"));
					Com1Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					scene1 = new Scene(root1);
					Com1Stage.setTitle("Customer_Com1");
					Com1Stage.setScene(scene1);
					Com1Stage.setX(530);
					Com1Stage.setY(550);
					Com1Stage.show();
				} else if (Kiosk.customer_com == 2) {
					Parent root2 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Com2.fxml"));
					Com2Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					scene2 = new Scene(root2);
					Com2Stage.setTitle("Customer_Com2");
					Com2Stage.setScene(scene2);
					Com2Stage.setX(820);
					Com2Stage.setY(550);
					Com2Stage.show();
				} else if (Kiosk.customer_com == 3) {
					Parent root3 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Com3.fxml"));
					Com3Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					scene3 = new Scene(root3);
					Com3Stage.setTitle("Customer_Com3");
					Com3Stage.setScene(scene3);
					Com3Stage.setX(1100);
					Com3Stage.setY(550);
					Com3Stage.show();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (result == 0) {
			cus_wrongLabel.setText("password mismatch");
			System.out.println("비밀번호 불일치");
		} else if (result == -1) {
			cus_wrongLabel.setText("no Username");
			System.out.println("아이디가 없음");
		} else if (result == -2) {
			cus_wrongLabel.setText("database error");
			System.out.println("DB 오류 ");
		}
	}

	private void cus_join(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Scene/Customer_Join.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setTitle("Customer_Signup");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
