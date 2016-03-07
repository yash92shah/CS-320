package Practice2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Practice2/addrebate")
public class addrebate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addrebate() 
    {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String user = request.getParameter("username");
		String item =request.getParameter("item");
		String amount =request.getParameter("amount");
		
		rebatedetails rd = new rebatedetails();
		rd.setItem(item);
		rd.setAmount(Integer.parseInt(amount));
		rd.setRecieved(null);
		ServletContext context=this.getServletContext();
		@SuppressWarnings("unchecked")
		List<user> stud1=(List<user>)context.getAttribute("userList");
		
		for(user u1:stud1)
		{
			if(u1.getName().equalsIgnoreCase(user)){
			
			   u1.getRd().add(rd);	
		    }
		}	
		response.sendRedirect("rebate");
		
	}

}

