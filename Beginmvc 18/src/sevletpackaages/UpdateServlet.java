package sevletpackaages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserBean.User;
import daopackage.UpdateDao;

@WebServlet("/UpdateServ")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		PrintWriter pw=response.getWriter();
		
		UpdateDao dao=new UpdateDao();
		User u= new User();
		
		
		UpdateDao.updateuser(username, password, role);
		pw.println("<h1 style=color:green>role updated succesfully!!!<h1>");
		

		
	}

}
