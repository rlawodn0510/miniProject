package PC_Manager;

import java.sql.*;

public class DatabaseServer {
	private static final DatabaseServer ConnUtil = null;

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		System.out.println("OK");
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/XEPDB1",
				"mytest","mytest");
		
	}
	

}
