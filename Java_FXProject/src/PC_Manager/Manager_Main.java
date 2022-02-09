package PC_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class Manager_Main implements Initializable {

	@FXML
	private Button com1;
	@FXML
	private Button com2;
	@FXML
	private Button com3;
	@FXML
	private Button customer;
	@FXML
	private Button sales;
	@FXML
	private Button calc;

	public static Stage com1stage;
	public static Stage com2stage;
	public static Stage com3stage;
	public static Stage customerstage;
	public static Stage salesrstage;
	public static Stage allsalesrstage;
	Scene scene1;
	Scene scene2;
	Scene scene3;
	Scene scene4;
	Scene scene5;
	Scene scene6;

	public static int allhap = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		com1.setOnAction(event -> com1_calc(event));
		com2.setOnAction(event -> com2_calc(event));
		com3.setOnAction(event -> com3_calc(event));
		customer.setOnAction(event -> customer_click(event));
		sales.setOnAction(event -> sales_click(event));
		calc.setOnAction(event -> calc_click(event));
	}

	private void com1_calc(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Scene/Manager_CusCalc.fxml"));
			com1stage = new Stage();
			scene1 = new Scene(root);
			com1stage.setTitle("Manager_CusCalc1");
			com1stage.setScene(scene1);
			com1stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void com2_calc(ActionEvent event) {
		try {
			Parent root2 = FXMLLoader.load(getClass().getResource("/Scene/Manager_CusCalc2.fxml"));
			com2stage = new Stage();
			scene2 = new Scene(root2);
			com2stage.setTitle("Manager_CusCalc2");
			com2stage.setScene(scene2);
			com2stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void com3_calc(ActionEvent event) {
		try {
			Parent root3 = FXMLLoader.load(getClass().getResource("/Scene/Manager_CusCalc3.fxml"));
			com3stage = new Stage();
			scene3 = new Scene(root3);
			com3stage.setTitle("Manager_CusCalc3");
			com3stage.setScene(scene3);
			com3stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void customer_click(ActionEvent event) {
		try {
			Parent root4 = FXMLLoader.load(getClass().getResource("/Scene/Customer_Controller.fxml"));
			customerstage = new Stage();
			scene4 = new Scene(root4);
			customerstage.setTitle("Customer_Controller");
			customerstage.setScene(scene4);
			customerstage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sales_click(ActionEvent event) {
		try {
			Parent root5 = FXMLLoader.load(getClass().getResource("/Scene/Manager_Sales.fxml"));
			salesrstage = new Stage();
			scene5 = new Scene(root5);
			salesrstage.setTitle("Manager_Sales");
			salesrstage.setScene(scene5);
			salesrstage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void calc_click(ActionEvent event) {
		try {
			Parent root6 = FXMLLoader.load(getClass().getResource("/Scene/All_Sales.fxml"));
			allsalesrstage = new Stage();
			scene6 = new Scene(root6);
			allsalesrstage.setTitle("All_Sales");
			allsalesrstage.setScene(scene6);
			allsalesrstage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
