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

@WebServlet("/mvc/Register")
public class JspRegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
  
	public void init() throws ServletException 
	{
		ServletContext context = this.getServletContext();
		if (context.getAttribute("JspUsers") == null)
		{
			ArrayList<JspUserBean> users = new ArrayList<JspUserBean>();
			context.setAttribute("JspUsers", users);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/mvc/RegisterForm.jsp");
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean isValidNewUser = true;
		
		if (name == null || name.trim().length() == 0)
		{
			isValidNewUser = false;
			request.setAttribute("nameError", "Invalid Name");
		}
		
		if (email == null || email.trim().length() == 0)
		{
			isValidNewUser = false;
			request.setAttribute("emailError", "Invalid E-mail Address");
		}
		
		if (password == null || password.trim().length() == 0)
		{
			isValidNewUser = false;
			request.setAttribute("passwordError", "Invalid Password");
		}
		
		if (isValidNewUser)
		{
			ServletContext context = this.getServletContext();
			@SuppressWarnings("unchecked")
			ArrayList<JspUserBean> users = (ArrayList<JspUserBean>) context.getAttribute("JspUsers");
			
			// Instantiate a new User object
			JspUserBean newUser = new JspUserBean(name, email, password);
			// Add the new User to the array list of Users
			users.add( newUser );
			
			// Attach a reference to the request of the new user
			request.setAttribute("user", newUser);
			
			// Redirect
			//response.sendRedirect("Login");
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/mvc/Welcome.jsp");
						
			dispatcher.forward(request, response);
		}
		else		
			doGet(request, response);
	}

}
