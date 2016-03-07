package Practice2;

import java.util.List;

public class user
{

public String name;
public List<rebatedetails> rd;


public user(String name, List<rebatedetails> rd) 
{
	super();
	this.name = name;
	this.rd = rd;
}



public user() 
{
	super();
}



public String getName() 
{
	return name;
}


public void setName(String name) 
{
	this.name = name;
}


public List<rebatedetails> getRd() 
{
	return rd;
}


public void setRd(List<rebatedetails> rd) 
{
	this.rd = rd;
}



}
