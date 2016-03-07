package cs320.lecture1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CountDown")
public class CountDown extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	int counter=10;
    public CountDown() 
    {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>CountDown</title>");
		out.println("</head>");
		out.println("<body>");
		
		if(counter == 0)
		{
			out.println("<p> Begins Now!!!! </p>");
		}

		else
		{
			out.println("<h3>" + counter +"</h3>");
			response.setHeader("Refresh", "1");
			--counter;
		}
		out.println("</body>");
		out.println("</html>");
	}

}
