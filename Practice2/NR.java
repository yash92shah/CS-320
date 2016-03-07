package Practice2;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/Practice2/NR", urlPatterns = { "/Practice2/NR" })
public class NR extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public NR() 
    {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String name =request.getParameter("ruser");
		String item =request.getParameter("ritem"); 
		
		@SuppressWarnings("unchecked")
		List<user> stud1 =(List<user>)getServletContext().getAttribute("userList"); 
		List<rebatedetails> rd = null;
	
		for(user s1:stud1) 
		{
			if(s1.getName().equalsIgnoreCase(name))
			{
			rd = s1.getRd();
			
			for(rebatedetails rd1:rd){
				if(rd1.getItem().equalsIgnoreCase(item)){
				rd1.setRecieved(new Date());
			}
		}
		
		}
	}	
		
		response.sendRedirect("rebate");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
