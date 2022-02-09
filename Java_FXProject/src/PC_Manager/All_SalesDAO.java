package PC_Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class All_SalesDAO {

	private static All_SalesDAO instance = new All_SalesDAO();
	
	public All_SalesDAO() {
	}

	public static All_SalesDAO getInstance() {
		return instance;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<All_SalesDTO> tableView(){
		ArrayList<All_SalesDTO> slist = new ArrayList<>();
		
		String sql = "SELECT * FROM SALES ORDER BY DATES";

		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String dates = rs.getString("dates");
				String sales = rs.getString("sales");
				
				All_SalesDTO dto = new All_SalesDTO(dates,sales);
				slist.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return slist;
	}
	
	public int sinsert(All_SalesDTO dto) {
		int result = 0;

		String query = "insert into sales values (?, ?)";

		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getDate());
			pstmt.setString(2, dto.getSales());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}

		return result;
	}
}
