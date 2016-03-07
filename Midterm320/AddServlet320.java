package Midterm320;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm320/AddServlet320")

public class AddServlet320 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	boolean isValidMake = true;
	int id =100;
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Add</title></head><body>");
		
		if (request.getAttribute("error") != null)
			out.println("<p font-color=\"red\">" + request.getAttribute("error") + "</p>");
			out.println("<form action='AddServlet320' method='post' class='form-inline' role='form'> ");
		    out.println("<fieldset><legend><b><font  size=\"+2\"color=\"black\">Add New Car Inventory</b></font></legend>");	
		    out.println("<table border=3 >");
		    out.println("<tr> <td>");
		    out.println("Make  &nbsp;&nbsp;&nbsp;&nbsp;    : <input type='text' name='Make'   placeholder='Enter  Car Company'></br>");
		    out.println("</td> </tr><br>");
		
		    out.println("<tr> <td>");
		    out.println("Model &nbsp;: <input type='text' name='Model'   placeholder='Enter The Name Of Car'></br>");
		    out.println("</td> </tr><br>");

		    out.println("<tr><td> ");
		    out.println("Year &nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;	 : <input type='text' name='Year'  placeholder='Enter Year'></br>");
		    out.println("</td> </tr><br>");
		
		    out.println("<tr> <td>");
		    out.println("<input class='btn btn-success' type='Submit' name='AddServlet320' value='Add' /> <br />");
		    out.println("</td> </tr><br>");
		
		    out.println("</table >");
		    out.println("</fieldset >");
		    out.println("</form>");
		    out.println("</body></html>");

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		String Make = request.getParameter("Make");
		String Model = request.getParameter("Model");
		int Year = Integer.parseInt(request.getParameter("Year"));
		int y=1000;
		
		if(Make!=null && Make!="" && Model!="" && 
				request.getParameter("Year")!="" && Model!= null && Year>=y)
		{
		List<CarInventory> Inventory = (List<CarInventory>) getServletContext().getAttribute("Inventory");
		Inventory.add(new CarInventory(Make,Model,Year));
		response.sendRedirect("CarAdministrator");
		return;
		}
		
		request.setAttribute("Error", "You can not enter zero value for Year no field should be null");
		doGet(request, response);
	}
	
}

