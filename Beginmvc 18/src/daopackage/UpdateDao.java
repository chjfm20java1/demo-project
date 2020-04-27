package daopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import UserBean.User;

public class UpdateDao {
	
	public static int updateuser(String username,String password,String role) {
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	int rowupdated=0;
	//ResultSet rs=null;
	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			pstmt=conn.prepareStatement("update petuser set password=?,role=?where username=? ");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			rowupdated=pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowupdated;
				
		

	}
}
