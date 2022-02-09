package PC_Manager;

public class All_SalesDTO {
	
	private String date;
	private String sales;
	
	public All_SalesDTO(String date, String sales) {
		super();
		this.date = date;
		this.sales = sales;
	}
	
	// get set
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getSales() {
			return sales;
		}

		public void setSales(String sales) {
			this.sales = sales;
		}
}
