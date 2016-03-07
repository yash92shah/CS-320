package Homework2;

public class user_entries 
{

	private String f_name;
	private String l_name;
	private String e_mail;

	public user_entries() 
	{
		
	}

	public user_entries(String f_name, String l_name, String e_mail) 
	{
		this.setF_name(f_name);
		this.setL_name(l_name);
		this.setE_mail(e_mail);
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

	public String getE_mail() 
	{
		return e_mail;
	}

	public void setE_mail(String e_mail) 
	{
		this.e_mail = e_mail;
	}
}
