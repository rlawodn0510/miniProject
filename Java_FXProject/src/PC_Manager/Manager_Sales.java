package PC_Manager;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Manager_Sales implements Initializable{

    @FXML
    private TextField allgold;
    @FXML
    private Button allcalc;
    @FXML
    private Button close;
    @FXML
    private TextField date;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int monthValue = now.getMonthValue(); 
		int dayOfMonth = now.getDayOfMonth();
		String today = Integer.toString(year) + "년 " +
				Integer.toString(monthValue) + "월 " +
				Integer.toString(dayOfMonth) + "일";
	
		allcalc.setOnAction(event -> allcalc(event));
		close.setOnAction(event -> close(event));
		
		//allgold.setEditable(false);
		date.setText(today);
		allgold.setText(Integer.toString(Manager_Main.allhap) + " 원");
		
	}
	
	private void allcalc(ActionEvent event) {
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("sales");
		alert.setContentText("오늘의 정산액은 " + allgold.getText() + " 원 입니다.");
		Optional<ButtonType> result3 = alert.showAndWait();
		if (result3.get() == ButtonType.OK) {
			
			String sdate = date.getText();
			String sallgold = allgold.getText();
			All_SalesDTO dto = new All_SalesDTO(sdate, sallgold);
			All_SalesDAO dao = All_SalesDAO.getInstance();
			int result = dao.sinsert(dto);
			if (result == 1) {
				System.out.println("정산 성공");

			} else {
				System.out.println("실패");
			}
			
		} else if (result3.get() == ButtonType.CANCEL) {
			alert.close();
		}
	}
	
	private void close(ActionEvent event) {
		Manager_Main.salesrstage.close();
	}

}
