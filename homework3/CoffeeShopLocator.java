package homework3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CoffeeShopLocator")
public class CoffeeShopLocator extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public CoffeeShopLocator() 
    {
        super();
        
    }
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String readsource= getServletContext().getRealPath("/WEB-INF/starbucks_1.csv");	
		FileReader fileReader = null;
		try 
		{
			fileReader = new FileReader(readsource);
		} catch (FileNotFoundException e) 
		{
		
			e.printStackTrace();
		}
		
		List<CoffeeeShopL> a1= new ArrayList<CoffeeeShopL>();
		Scanner s=new Scanner(fileReader);
		while(s.hasNextLine())
		{
			String temp = "Y";
			String i=s.nextLine();
			String arr[]=i.split(",");
			CoffeeeShopL c=new CoffeeeShopL();
			c.setLatitude(arr[0]);
        	c.setLongitude(arr[1]);
        	c.setCity(arr[2]);
        	c.setAddress(arr[3]);
        	for(int j = 0; j<arr.length; j++)
        	{
        	
        		if(arr.length > 4)
        		{	
        		c.setZip(arr[4]);
        		}
        		else
        		{
        		c.setZip(temp);
        		}
        		
        	}
        	
        	a1.add(c);
			
		}
		
			getServletContext().setAttribute("coffeelist", a1);
			s.close();
			response.setContentType( "text/html" );
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html lang=\"en\">");
			out.println("<head><title>Coffee Shop Locator</title></head>");
			out.println("<form action=\"CoffeeShopLocator\" method=\"post\">");
			out.println("<body><select name=\"select\">");
			out.println("<option value=\"Type\">Select</option>");
			out.println("<option value=\"Location\" name=\"Location \">Location</option>");
			out.println(" <option value=\"City\" name=\"City \">City</option>");
			out.println(" <option value=\"Zip\" name=\"Zip \">Zip</option>");
			out.println(" <input type=\"text\" name=\"val\" >");
			out.println("<tr><td><input type=\"Submit\" value=\"Search\" /></td></tr>");
			out.println("</select></form></body>");	
	}
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String select=request.getParameter("val");
		 String selection = request.getParameter("select");
	     List<CoffeeeShopL> ic =(List<CoffeeeShopL>)getServletContext().getAttribute("coffeelist");
         int counter=0;
		 response.setContentType( "text/html" );
	     PrintWriter out = response.getWriter();
	     out.println( "<html><head><title>Output</title>" );
	     out.println("</head><body><table border>");
	     out.println( "<tr><td>Latitude</td><td>Longitude</td><td>City</td><td>Address</td><td>Zipcode</td></tr>");
	     
	     if(selection.equals("Location"))
	     {
	    	 for(CoffeeeShopL cs: ic)
	    	 {
	    		 String ob[] = select.split(",");
	    		 if(cs.getLatitude().contains(ob[0]) && cs.getLongitude().contains(ob[1]))
	    		 {
	    			 out.println("<tr>");
	    			 out.println("<td>");
	    			 out.println(cs.getLatitude());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getLongitude());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getCity());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getAddress());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getZip());
	    			 out.println("</td>");
	                 out.println("</tr>");
	                 counter++;
	    		 }
	    	 }
	    	 
	     }
	    
	     if(selection.equals("City"))
	     {
	    	 for(CoffeeeShopL cs: ic)
	    	 {
	    		 if(cs.getCity().contains(select) )
	    		 {
	    			 out.println("<tr>");
	    			 out.println("<td>");
	    			 out.println(cs.getLatitude());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getLongitude());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getCity());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getAddress());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getZip());
	    			 out.println("</td>");
	                 out.println("</tr>");
	                 counter++;
	    		 }
	    	 }
	    	 
	     }
	     
	     if(selection.equals("Zip"))
	     {
	    	 for(CoffeeeShopL cs: ic)
	    	 {
	    		 if(cs.getZip().contains(select) )
	    		 {
	    			 out.println("<tr>");
	    			 out.println("<td>");
	    			 out.println(cs.getLatitude());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getLongitude());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getCity());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getAddress());
	    			 out.println("</td>");
	    			 out.println("<td>");
	    			 out.println(cs.getZip());
	    			 out.println("</td>");
	                 out.println("</tr>");
	                 counter++;
	    		 }
	    	 }
	    	 
	     }
	     if(counter==0)
	     {
	    	 out.println("Please Enter Correct Location Or City Or ZipCode");
	     }
	     out.println( "</table>" );
	     out.println( "<br>" );
	     out.println( "<a href = 'http://localhost:8090/cs320stu80/CoffeeShopLocator'> Search Again</a>");
	     out.println( "</body>" );
	     out.println( "</html>" );
	     
	
}
}


