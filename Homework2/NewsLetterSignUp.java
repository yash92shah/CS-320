package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework2/NewsLetterSignUp")
public class NewsLetterSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String f_name;
	String l_name = "";
	String e_mail;
	boolean run = false;
	String temp = "not success";
	


	public NewsLetterSignUp() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (temp == "not success") 
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\">");
			out.println("<title>CS320 Newsletter</title>");
			out.println(
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/animate.css\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/main.css\" />");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">");
			out.println("<div class=\"row\">");
			out.println("<div class=\"col-sm-offset-3 col-sm-6 newsletter-form animated bounceInDown\">");
			out.println("<div class=\"well text-center\">");
			out.println("<h1>CS320 Newsletter</h1>");
			out.println("<hr />");
			out.println(
					"<p class=\"lead\">Subscribe to our weekly Newsletter, and stay up-to-date with all things related to the course!</p>");

			out.println("<form action=\"NewsLetterSignUp\" method=\"post\">");
			out.println("<div class=\"form-group \">");
			out.println("<div class=\"input-group\">");
			out.println("<div class=\"input-group-addon\">");
			out.println("<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>");
			out.println("</div>");

			if (run == false) {

				out.println(
						"<input class=\"form-control\" type=\"text\" name=\"name\" placeholder=\"Enter your first and last name\" />");
				out.println("</div>");
			} else {
				if (getServletContext().getAttribute("name").equals("")
						|| getServletContext().getAttribute("f_name").equals("")
						|| getServletContext().getAttribute("l_name").equals("")) {
					
					out.println(
							"<input class=\"form-control\" type=\"text\" name=\"name\" placeholder=\"Enter your first and last name\" />");
					out.println("</div>");
					
					out.println("<p class=\"text-danger\">Please enter your first and last names.</p>");
				} else {
					out.println("<input class=\"form-control\" type=\"text\" name=\"name\" value=\'"
							+ getServletContext().getAttribute("name") + "\' />");
					// System.out.println(name_temp);
					out.println("</div>");
				}
			}
			out.println("</div>");
			out.println("<div class=\"form-group\">");
			out.println("<div class=\"input-group\">");
			out.println("<div class=\"input-group-addon\">");
			out.println("<span class=\"glyphicon glyphicon-envelope\" aria-hidden=\"true\"></span>");
			out.println("</div>");

			if (run == false) 
			{

				out.println(
						"<input class=\"form-control\" type=\"text\" name=\"e_mail\" placeholder=\"Enter your email Address\" />");
				out.println("</div>");
			} else {
				if (getServletContext().getAttribute("e_mail").equals("")) {

					out.println(
							"<input class=\"form-control\" type=\"text\" name=\"e_mail\" placeholder=\"Enter your email Address\" />");
					out.println("</div>");
					out.println("<p class=\"text-danger\">Please enter your email Address.</p>");
				} else {
					out.println("<input class=\"form-control\" type=\"text\" name=\"e_mail\" value="
							+ getServletContext().getAttribute("e_mail") + " />");
					out.println("</div>");
				}
			}

			out.println("<p></p> ");
			out.println("<input type=\"submit\" class=\"btn btn-info btn-block btn-lg\" value=\"Subscribe Now!\" />");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("<html><head>");
			out.println("<meta charset=\"utf-8\"><title>CS320 Newsletter</title>");
			out.println(
					"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/Homework2/styles/animate.css\"><link rel=\"stylesheet\" href=\"http://albertcervantes.com/cs320/cdn/homework2/styles/main.css\" /></head>");
			out.println("<body><div class=\"container\"><div class=\"row\">");
			out.println("<div class=\"col-sm-offset-3 col-sm-6 newsletter-form animated bounceInDown\">");
			out.println("<div class=\"well text-center\">");
			out.println("<h1>CS320 Newsletter</h1><hr />");
			out.println("<p class=\"lead\">You're all set, <strong>" + getServletContext().getAttribute("f_name")
					+ "</strong>!<br />We'll e-mail you at <strong>" + getServletContext().getAttribute("e_mail")
					+ "</strong> with regular updates.</p>");
			out.println("<h1><span class=\"glyphicon glyphicon-ok text-success\"></span></h1>");
			out.println("<a href=\"NewsLetterAdmin\">View All E-mails</a>");

			out.println("</div></div></div></div></body></html>");
			run = false;
			temp = "not success";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String e_mail = request.getParameter("e_mail");
		//System.out.println(name);
		user_entries objuser_entries = new user_entries(f_name, l_name, e_mail);
		if (name == "") {
			getServletContext().setAttribute("name", "");
		} else {
			String[] temp = new String[2];
			temp = name.split(" ");
			f_name = temp[0];
			if (temp.length > 1)
				l_name = temp[1];
			if (l_name == "" || (temp[0].length() == 1 && temp[1].length() == 1)
					|| (temp[0].length() == 1 && temp[1].length() > 1)
					|| (temp[0].length() > 1 && temp[1].length() == 1)) {
				getServletContext().setAttribute("name", "");
				getServletContext().setAttribute("f_name", "");
				getServletContext().setAttribute("l_name", "");
			} else {
				getServletContext().setAttribute("name", name);
				getServletContext().setAttribute("f_name", f_name);
				getServletContext().setAttribute("l_name", l_name);
				objuser_entries.setF_name(f_name);
				objuser_entries.setL_name(l_name);
			}
		}

		if (e_mail == "") {
			getServletContext().setAttribute("e_mail", "");
		} else {
			 String email_pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		     java.util.regex.Pattern p = java.util.regex.Pattern.compile(email_pattern);
		     java.util.regex.Matcher m2 = p.matcher(e_mail);
				
		     if (e_mail == null || !m2.matches()) {
		    	 System.out.println("test");
		    	 getServletContext().setAttribute("e_mail", "");
				}
		     
		     else {
		    	 getServletContext().setAttribute("e_mail", e_mail);
					objuser_entries.setE_mail(e_mail);
			}
		}
		if (objuser_entries.getF_name() != null && objuser_entries.getL_name() != null
				&& objuser_entries.getE_mail() != null)  {
			@SuppressWarnings("unchecked")
			ArrayList<user_entries> entry = (ArrayList<user_entries>) getServletContext().getAttribute("entry");
			
			if(entry == null){
				entry = new ArrayList<user_entries>();
				
				
				//response.sendRedirect("NewsletterAdmin");
				
			}
			entry.add(objuser_entries);
			this.getServletContext().setAttribute("entry", entry);
			temp = "success";
		}		
	
		run = true;
		doGet(request, response);
	}

}

