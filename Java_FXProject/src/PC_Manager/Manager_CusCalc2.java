package PC_Manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Manager_CusCalc2 implements Initializable {

    @FXML
    private Button calc;
    @FXML
    private TextField gold;
    int calc2 = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gold.setEditable(false);
		calc.setOnAction(event -> calc(event));
		
		calc2 = Customer_Com2.hap2;
		gold.setText(Integer.toString(calc2));
		
	}

	private void calc(ActionEvent event) {
		Manager_Main.com2stage.close();
	}

}