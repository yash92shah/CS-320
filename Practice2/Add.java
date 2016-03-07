package Practice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Practice2/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Add() 
    {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		response.sendRedirect("Add.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
		String user = request.getParameter("user");
		@SuppressWarnings("unchecked")
		List<user> stud1=(List<user>)getServletContext().getAttribute("userList");
		List<rebatedetails> rd =new ArrayList<rebatedetails>();
		user u = new user();
		u.setName(user);
		u.setRd(rd);
		stud1.add(u);
		response.sendRedirect("rebate");
	}

}
