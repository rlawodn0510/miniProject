package PC_Manager;

import javafx.beans.property.SimpleStringProperty;

public class Customer_Table {

		  private SimpleStringProperty tId;
		  private SimpleStringProperty tPass;
		  private SimpleStringProperty tName;
		  private SimpleStringProperty tPhone;
		  
		  public Customer_Table(String tId, String tPass,String tName,String tPhone) {
		    super();
		    this.tId = new SimpleStringProperty(tId);
		    this.tPass = new SimpleStringProperty(tPass);
		    this.tName = new SimpleStringProperty(tName);
		    this.tPhone = new SimpleStringProperty(tPhone);
		  }

		public String getTId() {
			return tId.get();
		}

		public void setTId(String tId) {
			this.tId.set(tId);
		}

		public String getTPass() {
			return tPass.get();
		}

		public void setTPass(String tPass) {
			this.tPass.set(tPass);
		}

		public String getTName() {
			return tName.get();
		}

		public void setTName(String tName) {
			this.tName.set(tName);
		}

		public String getTPhone() {
			return tPhone.get();
		}

		public void setTPhone(String tPhone) {
			this.tPhone.set(tPhone);
		}

}
