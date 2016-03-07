package Midterm320;

public class CarInventory 
{
	private int id;
	private String Make;
	private String Model;
	private int Year;
	
	public CarInventory(String Make,String Model, int Year)
	{
		super();
		this.Make=Make;
		this.Model=Model;
		this.Year=Year;
	
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getMake() 
	{
		return Make;
	}

	public void setMake(String make) 
	{
		Make = make;
	}

	public String getModel() 
	{
		return Model;
	}

	public void setModel(String model) 
	{
		Model = model;
	}

	public int getYear() 
	{
		return Year;
	}

	public void setYear(int year) 
	{
		Year = year;
	}


}

