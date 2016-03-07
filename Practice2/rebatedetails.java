package Practice2;

import java.util.Date;

public class rebatedetails 
{

	public String item;
	public int amount;
	public Date recieved;
	
	
	
	public rebatedetails() 
	{
		super();
	}

	public rebatedetails(String item, int amount, Date recieved) 
	{
		super();
		this.item = item;
		this.amount = amount;
		this.recieved = recieved;
	}
	
	
	
	public String getItem() 
	{
		return item;
	}
	public void setItem(String item) 
	{	
		this.item = item;
	}
	public int getAmount() 
	{
		return amount;
	}
	public void setAmount(int amount) 
	{
		this.amount = amount;
	}
	public Date getRecieved() 
	{
		return recieved;
	}
	public void setRecieved(Date recieved) 
	{
		this.recieved = recieved;
	}	
		
}

