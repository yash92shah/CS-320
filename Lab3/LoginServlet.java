package Lab3;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab3/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public LoginServlet() 
	{
		super();

	}

	private String getName(HttpServletRequest request) 
	{
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("firstname"))
					return cookie.getValue();

		return null;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Cookie and Session</title></head><body>");
		out.println("<center><h1>Cookie and Session</h1></center>");
		out.println("<form action='LoginServlet' method='post'>");

		String firstname = getName(request);

		if (firstname != null)

			out.println("First name: "
					+ "<input type='text' name='firstname' value='" + firstname
					+ " ' /><br /> " + "<br />");

		else

			out.println("First name: <input type='text' name='firstname' /><br />");
		out.println("<label for='remember'>Remember Me:</label>");
		out.println("<input type='checkbox' name='remember' value='yes'>");
		out.println("<br />");
		out.println("<input type='submit' name='Submit' value='Submit' />");
		out.println("</center>");
		out.println("</form>");
		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		String firstname = getName(request);
		//String remember = request.getParameter("checkbox");

		//String name = getName(request);

		if (firstname == null || request.getParameter("remember") != null) 
		{
			firstname = request.getParameter("firstname");
			// create a cookie to store the user's name

			Cookie cookie = new Cookie("firstname", firstname);
			request.getSession().setAttribute("user", firstname);
			response.addCookie(cookie);

		}

		response.sendRedirect("WelcomeServlet");

	}

}
