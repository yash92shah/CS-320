package Homework1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Homework1/AboutMe")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutMe() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter s =response.getWriter();

s.println("<html>");
s.println("<head>");
s.println("<title>Homework1</title>");
s.println("</head>");
s.println("<body>");
 s.println("<h2><span id='Student-Name'>Name:Yash Shah</span></h2></br>");
s.println("<h2><span id='Student-CIN'>CIN:305090661</span></h2></br>");

s.println("<b><h4>Question 1:</h4></b></br>");
s.println("<b><h4>Current year of Position</h4></b></br>");
s.println("<div id='q1-response'>1st Year-Graduate</div></br>");

s.println("<b><h4>Question 2:</h4></b></br>");
s.println("<b><h4>Major</h4></b></br>");
s.println("<div id='q3-response'>Computer Science</div></br>");

s.println("<b><h4>Question 3:</h4></b></br>");
s.println("<b><h4>Language Explored</h4></b></br>");
s.println("<ul id='q2-response'><li> C : 2000+ LOC</li><li> C++ : 2000+ LOC</li><li>Java : 3000+ LOC</li><li>PL/SQL : 5000+ LOC</li><li>PHP : 1000+ LOC</li><li>Java script : 1000+ LOC</li></ul</br>");

s.println("<b><h4>Question 4:</h4></b></br>");
s.println("<b><h4>Why this course?</h4></b></br>");
  s.println("<p id='q4-response'>->I Want to learn bootstrap.I want to Revised my JAVA,JSP concepts,Servlet life cycle and also bootstraps. This Course contains all topics which I intended to learn and explore.</p>");

s.println("<b><h4>Expection from 320</h4></b></br>");
  s.println("<p id='q4-response'>-> I should be comfortable with JSP and Servlet so that can design client-server based applications. I must able to build database and make front end - back end connection so that it helps me to implement small projects and definitely looking for the big budget projects.</p>");

 
s.println("<b><h4>Intented to study of 320??</h4></b></br>");
  s.println("<p id='q4-response'>->It's obvious to work for a big budget projects in a companies such as Google ,Facebook ,Intel ,IBM ,Samsung ,Apple and so on.But yes will start with a small work so that I can learn each and every small things of the projects and after taking such a good experience I will go with the big brands.</p>");
 

s.println("<b><h4>Question 5:</h4></b></br>");
s.println("<b><h4>About Self</h4></b></br>");
  s.println("<p id='q4-response'>->I'm a graduate student from California State University - Los Angeles pursuing Masters in Computer Science.Before joining the school, I had worked as a Web Developer in a company named Softech Pvt.Ltd. for 6 months.After that I also worked as a Production Manager in the company named CHAMANLAL SARABHAI & CO., which is my own family business.</p>");
  s.println("<p id='q4-response'>->I'm truly passionate about my work and a quick learner by adopting emerging technologies.I enjoyed a lot during my job, was a part of my family business and worked in Softech Pvt. Ltd. where I got an opportunity to work as a Manager Observer and Developer .It was a great experience where I explored myself with making a project based on musical training and making instruments and learn a lot. Along with coding also handled production support activities such as resolving customer's questions,script preparation for fixing the user errors,preparing client reports and so on.Appreciated by team and co-workers for my work which always helps in boosting myself. Best part was I got an opportunity to implement few ideas into applications which was proposed by us to professor for my college and we were successful in that implementations.</p>");
    
s.println("<p id='q4-response'>->“Rhythm Pulze” is a Web application based on the musical events and the training of the various instruments. It is developed because of the one main reason that people might to know the rare instruments which are made with pipes,wood,skin,this was my project. I also did 3 months course of Ethical  Hacking.</p>");
  s.println("<p id='q4-response'>->Apart from my studies I also did my graduation in Arts/Music,specific instrument named Tabla.I am currently having  my own band named RHYTHM PULSE.I am very much passionate about my music and also for playing cricket.I was Honored as The Great Musician at HASMUKH GOSWAMI COLLEGE OF ENGINEERING and the trust,my college.Had performed on the television show name “India’s Got Talent” and reached to the semis and also performed at IIM Chaos, IIT Pavai(Mumbai)  and many other places in Ahmedabad and all over India.Almost having 18 times and above attended the Blood Donation Camps.</p>");

  s.println("<p id='q4-response'>->Graduated with Bachelor's in Computer Engineering in the year 2014.</p>");
		  s.println("<p id='q4-response'>->Email-id-yjs1992@gmail.com.</p>");
  
	
s.println("</body>");
s.println("</html>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
