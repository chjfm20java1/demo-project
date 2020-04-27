package sevletpackaages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopackage.UserDao;

@WebServlet("/LoginServl")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		UserDao dao = new UserDao();
		boolean checkuser = dao.getUser(name, pwd);
		//RequestDispatcher r1 = request.getRequestDispatcher("Success.jsp");
		//RequestDispatcher r2 = request.getRequestDispatcher("Failure.jsp");

		if (checkuser) {
			//r1.forward(request, response);
			//HttpSession session=session.setAttribute("name",username);
			pw.println("<h1 style=color:green>Hello User Welcome ....!");
			pw.println("<a href=AddServlet>visit</a>");
		} else {
			//r2.forward(request, response);
			
		}

	}
}
