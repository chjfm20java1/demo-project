package dapack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daopack.Emp;
import daopack.UserDao;

@WebServlet("/EmployeeServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = (request.getParameter("jobid"));
		PrintWriter pw = response.getWriter();
		UserDao dao = new UserDao();
		ArrayList<Emp> list = dao.selectAllEmps(eid);
		
		request.setAttribute("emps",list);
		
		RequestDispatcher r1 = request.getRequestDispatcher("employee.jsp");
		
		r1.forward(request, response);
		
		for(Emp e:list)
		{
			pw.println(e);
		}
		
	}

		
		
	}

