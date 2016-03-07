package Lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Lab2/DrivingTest")
public class DrivingTest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	int currentQuestionIndex;
	int number_of_questions;
	int correctAnswer = 0;

	public int getCurrentQuestionIndex() 
	{
		return currentQuestionIndex;

	}

	public void setCurrentQuestionIndex(int currentQuestionIndex)
	
	{
		this.currentQuestionIndex = currentQuestionIndex;
	}

	public DrivingTest() 
	{
		super();
	}   
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String path = this.getServletContext().getRealPath("/WEB-INF/driving.txt");
		String temp = "";
		ArrayList<Question> questionList = new ArrayList<Question>();
		getServletContext().setAttribute("questionList", questionList);
		try {
			FileReader file = new FileReader(path);
			BufferedReader input = new BufferedReader(file);
			String line = "";
			while ((line = input.readLine()) != null) {
				Question question = new Question();
				if (!line.isEmpty()) {
					question.setDescription(line);
					question.setAnswerA(input.readLine());
					question.setAnswerB(input.readLine());
					question.setAnswerC(input.readLine());
					question.setAnswerCorrect(Integer.parseInt(input.readLine()
							.trim()));
					System.out.println("description: "
							+ question.getDescription());
					System.out.println("AnswerA " + question.getAnswerA());
					System.out.println("AnswerB " + question.getAnswerB());
					System.out.println("AnswerC: " + question.getAnswerC());
					System.out.println("Correct answer "
							+ question.getAnswerCorrect());
					questionList.add(question);
				}
			}
		} catch (Exception e) {

		}
	}
	
	
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				@SuppressWarnings("unchecked")
				ArrayList<Question> questionsList = (ArrayList<Question>) getServletContext().getAttribute("questionList");
			response.setContentType("text/html");
			int score = 0;
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>DrivingTest</title></head><body>");
			out.println("<form action ='DrivingTest' method = 'post' >");
			int id = 1;
			int valueOfRadio = 1;
			for (Question question : questionsList) {
				out.println("<p>" + ((questionsList.indexOf(question)) + 1)
						+ "</p>");
				out.println("<text name='description'> "
						+ question.getDescription() + "</text> <br />");
				out.println("<input type='radio' name='" + id + "' value='"
						+ String.valueOf(valueOfRadio)
						+ "' />  <text name='answerA'> " + question.getAnswerA()
						+ "</text> <br />");
				out.println("<input type='radio' name='" + id + "' value='"
						+ String.valueOf(valueOfRadio + 1)
						+ "' />  <text name='answerB'> " + question.getAnswerB()
						+ "</text> <br />");
				out.println("<input type='radio' name='" + id + "' value='"
						+ String.valueOf(valueOfRadio + 2)
						+ "' />  <text name='answerC'> " + question.getAnswerC()
						+ "</text> <br />");
				id++;
			}
			number_of_questions = id - 1;

			out.println("<input type = 'submit' name='submit' value='Submit' />");
			out.println("</form>");
			out.println("</body></html>");
		}
		
	
   @SuppressWarnings("unchecked")
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
		
		doGet(request, response);
					ArrayList<Question> questionList = (ArrayList<Question>) getServletContext()
					.getAttribute("questionList");
			int id;
			correctAnswer = 0;
			for (Question question : questionList) {
				try {
					id = questionList.indexOf(question) + 1;
					int valueOfRadio = Integer.parseInt(request.getParameter(""
							+ id + ""));
					System.out.println("valueOfRadio " + valueOfRadio);
					if (question.getAnswerCorrect() == valueOfRadio) {
						correctAnswer++;
						System.out.println("correct answerinside loop" + correctAnswer);
					}
				} catch (Exception e) 
				{
				}

			}
			System.out.println("number_of_questions" + number_of_questions);
			double score = (double) ((double) (100 * (double) correctAnswer) / (double) number_of_questions);
			System.out.println("score " + score + "correctAnswer" + correctAnswer);
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>DrivingTest</title></head><body>");
			out.println("<p>score= " + score + " correct answer " + correctAnswer
					+ "</p>");
			out.println("</body></html>");
		}
		
		
	}

