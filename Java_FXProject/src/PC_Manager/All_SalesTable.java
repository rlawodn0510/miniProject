package PC_Manager;

import javafx.beans.property.SimpleStringProperty;

public class All_SalesTable {

	private SimpleStringProperty tDate;
	private SimpleStringProperty tSales;

	public All_SalesTable(String tDate, String tSales) {
		super();
		this.tDate = new SimpleStringProperty(tDate);
		this.tSales = new SimpleStringProperty(tSales);
	}
	
	public String getTDate() {
		return tDate.get();
	}

	public void setTDate(String tDate) {
		this.tDate.set(tDate);
	}

	public String getTSales() {
		return tSales.get();
	}

	public void setTSales(String tSales) {
		this.tSales.set(tSales);
	}

}
