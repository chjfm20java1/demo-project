package sevletpackaages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserBean.User;
import daopackage.InsertDao;

@WebServlet("/InsertServ")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String role=request.getParameter("role");
	PrintWriter pw=response.getWriter();

	
	//InsertDao dao=new InsertDao();
	User u= new User();
	
	
	int rowinsert=InsertDao.save(u);
	if(rowinsert>0) {
		pw.println("<h1 style=color:green>Row Inserted Successfully</h1>");
	}else {
		pw.println("<h1 style=color:red>Sorry!!! unable to insert record</h1>");
	}
	
	}
}