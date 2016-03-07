package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc/HiddenVariables")
public class HiddenVariables extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("attribute1", "request scope");
		
		HttpSession session = request.getSession();
		session.setAttribute("attribute2", "session scope");
		
		ServletContext application = this.getServletContext();
		application.setAttribute("attribute3", "application scope");
		
		// The same variable in multiple scopes
		
		session.setAttribute("repeated", "session scope");
		application.setAttribute("repeated", "application scope");
		request.setAttribute("repeated", "request scope");
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("HiddenVariables.jsp");
		
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
