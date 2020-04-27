package daopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import UserBean.User;

public class DeleteDao {
	
	public static int deluser(User u) {
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	int rowdeleted=0;
	//ResultSet rs=null;
	

		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				pstmt=conn.prepareStatement("delete from petuser where username=?");
				pstmt.setString(1, u.getUsername());
				rowdeleted=pstmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rowdeleted;
			
			
}
}