package Lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab4/Server")
public class Server extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Server() 
    {
        super();
    
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        // create some test data for display
        List<Information> entries = new ArrayList<Information>();      
         getServletContext().setAttribute( "entries", entries );
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		request.getRequestDispatcher( "/WEB-INF/Lab4/Servey.jsp" ).forward(request, response );
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		doGet(request, response);
	}

}
