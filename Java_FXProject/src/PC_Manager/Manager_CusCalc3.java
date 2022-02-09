package PC_Manager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Manager_CusCalc3 implements Initializable {

    @FXML
    private Button calc;
    @FXML
    private TextField gold;
    int calc3 = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gold.setEditable(false);
		calc.setOnAction(event -> calc(event));
		
		calc3 = Customer_Com3.hap3;
		gold.setText(Integer.toString(calc3));
		
	}

	private void calc(ActionEvent event) {
		Manager_Main.com3stage.close();
	}

}