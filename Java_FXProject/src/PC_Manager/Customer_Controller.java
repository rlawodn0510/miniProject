package PC_Manager;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Customer_Controller implements Initializable {

	@FXML
	private TextField memId;
	@FXML
	private PasswordField memPass;
	@FXML
	private TextField memName;
	@FXML
	private TextField memPhone;
	@FXML
	private Button updateBtn;
	@FXML
	private Button delBtn;
	@FXML
	private Button okBtn;
	@FXML
	private TableView<Customer_Table> table;
	private ArrayList<CustomerDTO> Customer_List;
	private ObservableList<Customer_Table> TCustomer_List;

	public Customer_Controller() {
		Customer_List = new ArrayList<CustomerDTO>();
		TCustomer_List = FXCollections.observableArrayList();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		memId.setEditable(false);

		delBtn.setOnAction(event -> delCustomer(event));
		updateBtn.setOnAction(event -> updateCustomer(event));
		okBtn.setOnAction(event -> okCustomer(event));

		tableMake();

		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer_Table>() {

			@Override
			public void changed(ObservableValue<? extends Customer_Table> arg0, Customer_Table oldValue,
					Customer_Table newValue) {
				if (table.getSelectionModel().getSelectedIndex() > -1) {
					int su = table.getSelectionModel().getSelectedIndex();
					Customer_Table ct = TCustomer_List.get(su);
					memId.setText(ct.getTId());
					memPass.setText(ct.getTPass());
					memName.setText(ct.getTName());
					memPhone.setText(ct.getTPhone());
				}
			}
		});

	}

	public void tableMake() {
		Customer_List.clear();
		TCustomer_List.clear();

		CustomerDAO dao = CustomerDAO.getInstance();
		Customer_List = dao.tableView();

		for (int i = 0; i < Customer_List.size(); i++) {
			CustomerDTO dto = Customer_List.get(i);

//			String amho = "*";
//			for (int z = 0; z < dto.getPassword().length(); z++) {
//				amho = amho.concat("*");
//			}
			String id = dto.getId();
			String pass = dto.getPassword();
			String name = dto.getName();
			String phone = dto.getPhone();

			Customer_Table ct = new Customer_Table(id, pass, name, phone);
			TCustomer_List.add(ct);

		}

		TableColumn tbMemId = table.getColumns().get(0);
		tbMemId.setCellValueFactory(new PropertyValueFactory<>("tId"));

		TableColumn tbMemPass = table.getColumns().get(1);
		tbMemPass.setCellValueFactory(new PropertyValueFactory<>("tPass"));

		TableColumn tbMemName = table.getColumns().get(2);
		tbMemName.setCellValueFactory(new PropertyValueFactory<>("tName"));

		TableColumn tbMemTel = table.getColumns().get(3);
		tbMemTel.setCellValueFactory(new PropertyValueFactory<>("tPhone"));

		table.setItems(TCustomer_List);

	}

	private void delCustomer(ActionEvent event) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("customer delete");
		alert.setContentText("ID " + memId.getText() + " 님의 정보를 삭제하시겠습니까?");
		Optional<ButtonType> result1 = alert.showAndWait();
		if (result1.get() == ButtonType.OK) {

			String userId = memId.getText();
			CustomerDTO dto = new CustomerDTO(userId);
			CustomerDAO dao = CustomerDAO.getInstance();
			int result = dao.delete(dto);

			tableMake();
			if (result == 1) {
				memId.setText("");
				memPass.setText("");
				memName.setText("");
				memPhone.setText("");
				System.out.println("삭제 성공");

			} else {
				System.out.println("실패");
			}
		} else if (result1.get() == ButtonType.CANCEL) {
			alert.close();
		}

	}

	private void updateCustomer(ActionEvent event) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("customer update");
		alert.setContentText("ID " + memId.getText() + " 님의 정보를 변경하시겠습니까?");
		Optional<ButtonType> result2 = alert.showAndWait();
		if (result2.get() == ButtonType.OK) {

			String userId = memId.getText();
			String userPw = memPass.getText();
			String userName = memName.getText();
			String userPhone = memPhone.getText();
			CustomerDTO dto = new CustomerDTO(userId, userPw, userName, userPhone);
			CustomerDAO dao = CustomerDAO.getInstance();
			int result = dao.update(dto);
			tableMake();
			if (result == 1) {
				memId.setText("");
				memPass.setText("");
				memName.setText("");
				memPhone.setText("");
				System.out.println("회원수정 성공");

			} else {
				System.out.println("실패");
			}
		} else if (result2.get() == ButtonType.CANCEL) {
			alert.close();
		}

	}

	private void okCustomer(ActionEvent event) {
		Manager_Main.customerstage.close();
	}

}
