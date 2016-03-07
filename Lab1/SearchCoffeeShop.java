package Lab1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab1/SearchCoffeeShop")
public class SearchCoffeeShop extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
 
	public void init(ServletConfig config) throws ServletException 
	{
		
		super.init(config);
		String Readsource = getServletContext().getRealPath("/WEB-INF/coffeeshop.txt");
		
    	FileReader fileReader = null;
		try 
		{
			fileReader = new FileReader(Readsource);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
        
    	List<Coffee> a1 = new ArrayList<Coffee>();

        Scanner s = new Scanner(fileReader);
        while(s.hasNextLine())
        {
        	String i = s.nextLine();
        	String arr[] = i.split("\t" );
        	Coffee c = new Coffee();
            c.setStore_ID(arr[0]);
            c.setStoreName(arr[1]);
            c.setPhone(arr[2]);
            c.setAddress(arr[3]);
            c.setCity(arr[4]);
            c.setZip_Code(arr[5]);
            c.setLatitude(arr[6]);
            c.setLongitude(arr[7]);
            
        a1.add(c);
        
        }
        
        config.getServletContext().setAttribute("All_coffee_List",a1);  
        
      s.close();
      return;
      
      
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Search for Coffee Shop</title></head><body>" );
        out.println( "<form action='SearchCoffeeShop' method='post'>" );
        out.println( "ZipCode: <input type='text' name='Zip_Code' />  " );
        out.println( "<input type='submit' name='Search' value='Search' /> <br />" );
        out.println( "</form>" );
        out.println( "</body></html>" );	
                
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		
		doGet(request, response);
		
		String zip_code= request.getParameter("Zip_Code");
        System.out.println("zip code is"+zip_code);
             
      
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        out.println( "<html><head><title>Output</title>" );
        out.println("</head><body><table border>");
        out.println( "<tr><td>ZipCode</td><td>Phone</td><td>Address</td></tr>");
              
        @SuppressWarnings("unchecked")
		List<Coffee> lcs = (List<Coffee>) getServletContext().getAttribute("All_coffee_List");     
        
      for(Coffee cs1:lcs){
	
        		if(cs1.getZip_Code().contains(zip_code))
        		{
        			out.println("<tr>");
        			out.println("<td>");
        		out.println(cs1.getZip_Code());
        		out.println("</td>");
        				out.println("<td>");
        		out.println(cs1.getPhone());
        		out.println("</td>");
        				out.println("<td>");
        		out.println(cs1.getAddress());
        		out.println("</td>");
        				out.println("</tr>");
        	
        	}
        }
 
	out.println( "</table>" );
    out.println( "<br>" );
    out.println("<a href = 'SearchCoffeeShop'><input type='submit' value='Search Again' /></a>");
    out.println( "</body>" );
    out.println( "</html>" );
        
        
        
		
	}
}


		
	
	


