package mvc;

public class Item {
	private String name;
	private double price;
	private String description ;
	
	public Item(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
}
