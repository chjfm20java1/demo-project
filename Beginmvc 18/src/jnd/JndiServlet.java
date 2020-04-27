package jnd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/WebServlet")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context envContext = null;
		Connection con = null;
		Statement stmt = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			java.io.PrintWriter pw = response.getWriter();
			envContext = new InitialContext();
			Context initContext  = (Context)envContext.lookup("java:/comp/env");
	        DataSource ds = (DataSource)initContext.lookup("jdbc/testDB");
	        //DataSource ds = (DataSource)envContext.lookup("java:/comp/env/jdbc/testDB");
	        con = ds.getConnection();
	        System.out.println("database connected");
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select username,password,role from petuser");
	        
	        pw.println("<table border=1>");
	        pw.println("<tr><td>username</td><td>password</td></tr><tr><td>role</td></tr>");
	        while(rs.next())
	        {
	        	pw.println("<tr>");
	        	pw.println("<td>"+rs.getString(1)+ "</td>" +  "<td>"+rs.getString(2)+"</td>"+rs.getString(3));
	        	pw.println("</tr>");
	        }
	        pw.println("</table>");
	        pw.close();
		} catch (NamingException e) {
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
		
	}
		
	}
	

