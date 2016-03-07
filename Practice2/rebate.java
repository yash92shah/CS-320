package Practice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Practice2/rebate")
public class rebate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rebate() 
    {
        super();

    }

	public void init(ServletConfig config) throws ServletException 
	{	
		super.init(config);
		
		List<rebatedetails> rdMe = new ArrayList<rebatedetails>();
		@SuppressWarnings("deprecation")
		rebatedetails rd1 = new rebatedetails("Sony 32GB MicroSD Card",10,new Date("10/10/2015"));
		rebatedetails rd2 = new rebatedetails("Dell 22in Monitor",20,null);
		rdMe.add(rd1);
		rdMe.add(rd2);
		
		List<rebatedetails> rdMom = new ArrayList<rebatedetails>();
		rebatedetails rd3 = new rebatedetails("Sony 64GB MicroSD Card",20,null);
		rebatedetails rd4 = new rebatedetails("Dell 55in Monitor",30,null);
		rdMom.add(rd3);
		rdMom.add(rd4);
		
		
		
		List<user> u1 = new ArrayList<user>();
		user s1 = new user("Me",rdMe);
		user s2 = new user("Mom",rdMom);
		u1.add(s1);
		u1.add(s2);
	
	
		ServletContext context= this.getServletContext();
        context.setAttribute("userList", u1);
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		response.sendRedirect("rebate.jsp");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		String user = request.getParameter("user");
		ServletContext context=this.getServletContext();
		@SuppressWarnings("unchecked")
		List<user> lud=(List<user>)context.getAttribute("userList");
		List<rebatedetails> rebatedetails = null;
		
		for(user u1:lud){
			
			if (u1.getName().equalsIgnoreCase(user)){
				rebatedetails = u1.getRd();
			}
		}
		context.setAttribute("rd",rebatedetails);
		context.setAttribute("user",user);
		RequestDispatcher dispatch=request.getRequestDispatcher("rebate.jsp");
		dispatch.forward(request,response);
		
	}   
}