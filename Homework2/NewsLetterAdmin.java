package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Homework2.user_entries;

@WebServlet("/Homework2/NewsLetterAdmin")
public class NewsLetterAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsLetterAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>CS320 Newsletter</title>");
		out.println("<html>");
		out.println(
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
		out.println(
				"<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/animate.css\">");
		out.println(
				"<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/main2.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"row\">");
		out.println("<div class=\"col-sm-offset-2 col-sm-8 newsletter-form animated fadeInUp\">");
		out.println("<div class=\"well\">");
		out.println("<h1>E-mail List <small>CS320 Newsletter</small></h1>");
		out.println("<hr />");

		out.println("<table class=\"table table-bordered table-striped table-hover\">");
		out.println("<tr>");
		out.println("<th>First</th>");
		out.println("<th>Last</th>");
		out.println("<th>E-mail</th>");
		out.println("<th>Date</th>");
		out.println("</tr>");
		ServletContext context = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<user_entries> entries = (List<user_entries>) context.getAttribute("entry" );
		// this.getServletContext().getAttribute(arg0)
		Date date = new Date();
		for (user_entries objusers : entries) {
			out.println("<tr>");
			out.println("<td>" + objusers.getF_name() + "</td>");
			out.println("<td>" + objusers.getL_name() + "</td>");
			out.println("<td>" + objusers.getE_mail() + "</td>");
			out.println("<td>"+date.toString()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<p class=\"text-center\">");
		out.println("<a href=\"NewsLetterSignUp\">Back to Sign-Up</a>");
		out.println("</p>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
