package daopack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
	
	public boolean  getUser(String uname, String  pwd)
	{
		Connection con = null;
		boolean validUser = false;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			pstmt = con.prepareStatement("select username,password from petuser where username=? and password=?");
		
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				validUser=true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return validUser;
		
		
	}
	public  ArrayList<Emp> selectAllEmps(String jobid)
	{
		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Emp> listOfEmps = new ArrayList<Emp>();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				stmt = con.prepareStatement("select employee_id,first_name,last_name,salary from employees where job_id=?");
				stmt.setString(1, jobid);
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next())
				{
					Emp e= new Emp(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
					listOfEmps.add(e);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return listOfEmps;
		
	}

}
