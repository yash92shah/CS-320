package homework3;

public class CoffeeeShopL 
{
	private String latitude;
	private String longitude;
	private String city;
	private String address;
	private String zip;
	
	
	public CoffeeeShopL() 
	{
	
	}

	public CoffeeeShopL(String latitude, String longitude, String city,String address,String zip) 
	{
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.address =address;
		this.zip=zip;
		
		
	}

	public String getLatitude() 
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude() 
	{
		return longitude;
	}

	public void setLongitude(String longitude) 
	{
		this.longitude = longitude;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getZip() 
	{
		return zip;
	}

	public void setZip(String zip) 
	{
		this.zip = zip;
	}
}
		