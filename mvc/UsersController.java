package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/mvc/Users")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		if (context.getAttribute("JspUsers") == null){
			ArrayList<JspUserBean> users = new ArrayList<JspUserBean>();
			users.add(new JspUserBean("John Doe", "john@doe.com", "1!"));
			users.add(new JspUserBean("Joe Boxer", "joe@boxer.com", "2@"));
			users.add(new JspUserBean("Mary Boxer", "mary@boxer.com", "3#"));
			context.setAttribute("JspUsers", users);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		@SuppressWarnings("unchecked")
		ArrayList<JspUserBean> users =
				(ArrayList<JspUserBean>) context.getAttribute("JspUsers");
		
		// Attach a reference to the Users in the request object
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/mvc/ViewUsers.jsp");
		
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
