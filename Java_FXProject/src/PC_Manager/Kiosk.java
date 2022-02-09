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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Kiosk implements Initializable{


    @FXML
    private Button k_com1;
    @FXML
    private Button k_com2;
    @FXML
    private Button k_com3;
    @FXML
    static Label Label1; // Null 로 인식을 한다. 
    @FXML
    static Label Label2;
    @FXML
    static Label Label3;
    
    

    // 회원이 사용 할 컴퓨터
    public static int customer_com = 0;
	Stage stage1;
	Stage stage2;
	Stage stage3;
	Scene scene1;
	Scene scene2;
	Scene scene3;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		k_com1.setOnAction(event -> k_com1_calc(event));
		k_com2.setOnAction(event -> k_com2_calc(event));
		k_com3.setOnAction(event -> k_com3_calc(event));
	}

	private int k_com1_calc(ActionEvent event) {
		customer_com = 1;
		try {
	         Parent root1 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Login.fxml"));
	         Stage stage1 = new Stage();
	         scene1 = new Scene(root1);
	         stage1.setTitle("Customer_Login");
	         stage1.setScene(scene1);
	         stage1.setX(30);
	         stage1.setY(30);
	         stage1.show();
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
		return customer_com;
	}

	private int k_com2_calc(ActionEvent event) {
		customer_com = 2;
		try {
	         Parent root2 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Login.fxml"));
	         stage2 = new Stage();
	         scene2 = new Scene(root2);
	         stage2.setTitle("Customer_Login");
	         stage2.setScene(scene2);
	         stage2.setX(30);
	         stage2.setY(30);
	         stage2.show();
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
		return customer_com;
	}

	private int k_com3_calc(ActionEvent event) {
		customer_com = 3;
		try {
	         Parent root3 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Login.fxml"));
	         stage3 = new Stage();
	         scene3 = new Scene(root3);
	         stage3.setTitle("Customer_Login");
	         stage3.setScene(scene3);
	         stage3.setX(30);
	         stage3.setY(30);
	         stage3.show();
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
		return customer_com;
	}


}
