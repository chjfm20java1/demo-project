package sevletpackaages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserBean.User;
import daopackage.SelectAllDao;

@WebServlet("/Selectallserv")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      PrintWriter pw=response.getWriter();
	      ResultSet rs=(ResultSet) SelectAllDao.selectAllUser();
	    		  
	    		  
	    		  
	    		  try {
					while (rs.next()) {
						pw.println(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	      
	}

}
