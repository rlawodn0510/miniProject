package PC_Manager;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class Customer_Com1 implements Initializable {

    @FXML
    private Label Com1_Label1;
    @FXML
    private Button clac1;

	private java.util.Date thisTime;
	private long min,sec, diff, rsdiff;
	private String rsCal;
	boolean stop = false;
	public static int hap1 = 0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		clac1.setOnAction(event -> clac1_com1(event));
		
		thisTime = new Date();
		Thread thread = new Thread() {
	        @Override
	        public void run() {
	            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
	            while (!stop) {
	            	  
	                Date nextTime = new Date();
	                
	                diff = nextTime.getTime()-thisTime.getTime();
	                
	                rsdiff = TimeUnit.MILLISECONDS.convert(diff, TimeUnit.MILLISECONDS);
	                
	                min = (rsdiff/1000) / 60 % 60;
	                sec = (rsdiff/1000) % 60;
	                
	                rsCal = min+" hour "+sec + " min ";

	                Platform.runLater(() -> {
	                	Com1_Label1.setText(rsCal);
	                });
	                
	                try { Thread.sleep(100); } catch (InterruptedException e) {}
	            }
	        }
	        
	    };
	    thread.setDaemon(true);
	    thread.start();		
		
	}
	
	private void clac1_com1(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("com1");
		hap();
		alert.setContentText("금액은 " + hap1 + " 원 입니다.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			stop = true;
			hap();
			Manager_Main.allhap += hap1;
			Customer_Login.Com1Stage.close();
		} else if (result.get() == ButtonType.CANCEL) {
			alert.close();
		}

	}
	
	public void hap () {
		
		int min_calc = 0;
		if ((int)sec >= 1 && (int)sec <= 31) {
			min_calc = 500;
		} else {
			min_calc = 1000;
		}
		hap1 = ((int)min * 1000) + min_calc;
	}
	

}