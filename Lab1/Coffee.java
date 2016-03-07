package Lab1;

public class Coffee {

	String Store_ID;
	String Store_Name;
	String Phone;
	String Address;
	String City;
	String Zip_Code;
	String Latitude;
	String Longitude;

	public Coffee() {

	}

	public Coffee(String Store_ID, String Store_Name, String Phone,
			String Address, String City, String Zip_Code, String Latitude,
			String Longitude) {
		this.Store_ID = Store_ID;
		this.Store_Name = Store_Name;
		this.Phone = Phone;
		this.Address = Address;
		this.City = City;
		this.Zip_Code = Zip_Code;
		this.Latitude = Latitude;
		this.Longitude = Longitude;

	}

	public String getStore_ID() {
		return Store_ID;
	}

	public void setStore_ID(String Store_ID) {
		this.Store_ID = Store_ID;
	}

	public String getStore_Name() {
		return Store_Name;
	}

	public void setStoreName(String Store_Name) {
		this.Store_Name = Store_Name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getZip_Code() {
		return Zip_Code;
	}

	public void setZip_Code(String Zip_Code) {
		this.Zip_Code = Zip_Code;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		this.Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		this.Longitude = longitude;
	}

}
