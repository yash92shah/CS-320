package Lab4;

import java.util.Date;

public class Information 

{

	String f_name;
	String l_name;
	Integer cin;
	String quarter;
	String course;
	Date date;
	
	public Information(String f_name, String l_name, Integer cin, String quarter, String course, Date date) 
	{
	
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.cin = cin;
		this.quarter = quarter;
		this.course = course;
		this.date = date;
	}
	
	public String getF_name() 
	{
		return f_name;
	}
	
	public void setF_name(String f_name) 
	{
		this.f_name = f_name;
	}
	
	public String getL_name() 
	{
		return l_name;
	}
	
	public void setL_name(String l_name) 
	{
		this.l_name = l_name;
	}
	
	public Integer getCin() 
	{
		return cin;
	}
	
	public void setCin(Integer cin) 
	{
		this.cin = cin;
	}
	
	public String getQuarter() 
	{
		return quarter;
	}
	
	public void setQuarter(String quarter) 
	{
		this.quarter = quarter;
	}
	
	public String getCourse() 
	{
		return course;
	}
	
	public void setCourse(String course) 
	{
		this.course = course;
	}
	
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}

}
