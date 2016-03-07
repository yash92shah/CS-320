package Lab2;

public class Question 
{
	private String description;
	private String answerA;
	private String answerB;
	private String answerC;
	private int answerCorrect;
	private int answer;
	
	
	

	public Question(String description, String answerA, String answerB,
			String answerC, int answerCorrect, int answer) 
	{
		super();
		this.description = description;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerCorrect = answerCorrect;
		this.answer = answer;
	}


	public Question() 
	{
		
	}


	public String getDescription() 
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}


	public String getAnswerA() 
	{
		return answerA;
	}


	public void setAnswerA(String answerA) 
	{
		this.answerA = answerA;
	}


	public String getAnswerB() 
	{
		return answerB;
	}


	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}


	public String getAnswerC() {
		return answerC;
	}


	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}


	public int getAnswerCorrect() {
		return answerCorrect;
	}


	public void setAnswerCorrect(int answerCorrect) {
		this.answerCorrect = answerCorrect;
	}


	public int getAnswer() {
		return answer;
	}


	public void setAnswer(int answer) {
		this.answer = answer;
	}
	

}
