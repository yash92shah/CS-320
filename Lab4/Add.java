package Lab4;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab4/Add")
public class Add extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Add() 
    {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		request.getRequestDispatcher( "/WEB-INF/Lab4/Add.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String fname=request.getParameter( "fname" );
		String lname=request.getParameter( "lname" );
		Integer cin= Integer.parseInt(request.getParameter("cin"));
		String  quarter= request.getParameter("Qurter");
		String  course= request.getParameter("a");
		Date date=new Date();
		System.out.print(course);

  
				Information entry = new Information(fname,lname,cin,quarter,course, date);
	        	@SuppressWarnings("unchecked")
	        	List<Information> entries = (List<Information>) getServletContext().getAttribute( "entries" );
		        entries.add( entry );
		        request.getRequestDispatcher( "/WEB-INF/Lab4/Servey.jsp" ).forward(request, response );

	}

}
