package PC_Manager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class All_Sales implements Initializable {

    @FXML
	private TableView<All_SalesTable> table;
	private ArrayList<All_SalesDTO> Sales_List;
	private ObservableList<All_SalesTable> TSales_List;
    @FXML
    private Button okBtn;
    
	public All_Sales() {
		Sales_List = new ArrayList<All_SalesDTO>();
		TSales_List = FXCollections.observableArrayList();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		okBtn.setOnAction(event -> okBtn(event));
		stableMake();
	}
	
	private void okBtn(ActionEvent event) {
		Manager_Main.allsalesrstage.close();
	}

	public void stableMake() {
		Sales_List.clear();
		TSales_List.clear();

		All_SalesDAO dao = All_SalesDAO.getInstance();
		Sales_List = dao.tableView();

		for (int i = 0; i < Sales_List.size(); i++) {
			All_SalesDTO dto = Sales_List.get(i);

			String date = dto.getDate();
			String sales = dto.getSales();

			All_SalesTable st = new All_SalesTable(date, sales);
			TSales_List.add(st);

		}

		TableColumn date = table.getColumns().get(0);
		date.setCellValueFactory(new PropertyValueFactory<>("tDate"));

		TableColumn sales = table.getColumns().get(1);
		sales.setCellValueFactory(new PropertyValueFactory<>("tSales"));

		table.setItems(TSales_List);

	}


}

