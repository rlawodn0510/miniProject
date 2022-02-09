package PC_Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {

	private static CustomerDAO instance = new CustomerDAO();

	public CustomerDAO() {
	}

	public static CustomerDAO getInstance() {
		return instance;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 회원가입
	public int insert(CustomerDTO dto) {
		int result = 0;

		String query = "insert into customer values (?, ?, ?, ?)";

		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());

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
	
	public ArrayList<CustomerDTO> tableView(){
		ArrayList<CustomerDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM CUSTOMER";

		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String pass = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				CustomerDTO dto = new CustomerDTO(id,pass,name,phone);
				list.add(dto);
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
		return list;
	}

	public int update(CustomerDTO dto) {
		String sql = "UPDATE CUSTOMER SET PASSWORD = ?, "
				+ "NAME = ?, PHONE = ? WHERE ID = ?";

		int result = 0;
		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getId());
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

	public int delete(CustomerDTO dto) {
		String sql = "DELETE FROM CUSTOMER WHERE ID = ?";

		int result = 0;
		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			result = pstmt.executeUpdate();
			con.close();
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
	public int login(CustomerDTO dto) { 
		
		String spl = "SELECT PASSWORD FROM CUSTOMER WHERE ID = ?"; 
		
		try {
			con = DatabaseServer.getConnection();
			pstmt = con.prepareStatement(spl);
			pstmt.setString(1,  dto.getId());
			rs = pstmt.executeQuery(); 
			if (rs.next()) {
				if (rs.getString("PASSWORD").equals(dto.getPassword())) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류 
	}

}
