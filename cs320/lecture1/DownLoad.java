package cs320.lecture1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DownLoad() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	//read the image
		
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition", "attachment; filename=Epic.jpg");
		FileInputStream in=new FileInputStream("C:/Users/Yash/Epic.jpg");
		OutputStream out=response.getOutputStream();
		byte[] by=new byte[2048];
		int i;
		
		while((i = in.read( by )) > 0)
		//write the image
		out.write(by, 0, i);
		in.close();
		

	}


}
