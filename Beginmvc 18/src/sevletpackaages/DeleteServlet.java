package sevletpackaages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserBean.User;
import daopackage.DeleteDao;

@WebServlet("/removeserv")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String username=request.getParameter("username");
		PrintWriter pw=response.getWriter();
		
		
		DeleteDao dao=new DeleteDao();
		User u= new User();
		
		
		int rowdeleted=DeleteDao.deluser(u);
		if(rowdeleted>0) {
			pw.println("<h1 style=color:red>Row deleted successfully</h1>");
		}else {
			pw.println("<h1 style=color:red>Row deleted successfully</h1>");
		}

	}
}
