package Midterm320;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm320/CarAdministrator")

public class CarAdministrator extends HttpServlet 
{
	private static final long serialVersionUID = 1L;       
	public void init() throws ServletException 
	{

		ServletContext context = this.getServletContext();
		
		// adding the values 
		
		if (context.getAttribute("Inventory") == null) 
		{
			ArrayList<CarInventory> Inventory = new ArrayList<CarInventory>();
			Inventory.add(new CarInventory("Honda", "Civic",2006));
			Inventory.add(new CarInventory("Porshe", "CV-10",2014));
			Inventory.add(new CarInventory("Honda", "Civic",2011));
			Inventory.add(new CarInventory("TATA", "Nano",2012));
			Inventory.add(new CarInventory("BMW", "A-3",2001));
			context.setAttribute("Inventory", Inventory);
		}

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{

		ServletContext context = this.getServletContext();
		ArrayList<CarInventory> Inventory = (ArrayList<CarInventory>) context.getAttribute("Inventory");

		// to remove the selected items which should be deleted
		if (request.getParameter("index") != null) 
		{
			for (int i = 0; i < Inventory.size(); i++) 
			{
				if (Inventory.get(i).getId() == i) 
				{
					Inventory.remove(i);
					break;
				}
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Car Administration</title></head>");
		out.println("<body>");

		out.println("<form action=\"CarAdministrator\" method=\"get\"  role=\"form\"> ");
		out.println("<label class=\"sr-only\">Search</label>");
		out.println(" <input type='text' name='search'  placeholder=\"Enter Search\"></br>");
		out.println("</br>");
		out.println("<select>");
		out.println("<option id='Select'> Select </option>");
		out.println("<option id='Make'> Make </option>");
		out.println("<option id='Model'> Model </option>");
		out.println("<option id='Year'> Year </option>");
		out.println("<option id='all'> All </option>");
		out.println("</select>");
		out.println("<input class=\"btn btn-success\" type='Submit' name='Search' value='Search' /> ");
		out.println("</form>");
		out.println("</body></html>");
	
		out.println("<fieldset><legend><b><font  size=\"+3\"color=\"black\"> Cars Inventory</b></font></legend>");
		out.println("<table border=3 >");
		out.println("<tr> ");
		out.println("<th> <b> Make </b> </th>");
		out.println("<th> <b> Model </b> </th>");
		out.println("<th> <b> Year </b> </th>");
		out.println(" </tr>");
		
		// to search the items

		for (int i = 0; i < Inventory.size(); i++) 
		{
			if (request.getParameter("Search") == null ||
					// for Make wise search
					Inventory.get(i).getMake().contains(request.getParameter("Search")) ||
					// for Model wise search
					Inventory.get(i).getModel().contains(request.getParameter("Search")) || 
					// for Year wise search
					Integer.toString(Inventory.get(i).getYear()).contains(request.getParameter("Search"))) 
				{
					out.println("<tr><td>"+Inventory.get(i).getMake()+"</td>");
					out.println("<td>"+Inventory.get(i).getModel()+"</td>");
					out.println("<td>"+Inventory.get(i).getYear()+"</td>");
				
				
				// to remove data 
				out.println("<td><a href ='CarAdministrator?index=" + i + "'>Delete</a></td>");
				out.println("</tr>");
			}
		}

		out.println("</table>");
		out.println("</fieldset>");
		
				
		// for adding new item 
		out.println("<br><a href='AddServlet320'value='' name='add' >ADD</a>");	
		}

}
