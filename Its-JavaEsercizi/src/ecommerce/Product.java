package ecommerce;

public class Product {
	private int id;
	private String description;
	private int quantity;
	private double price;
	
	public Product(int id, String description, int quantity, double price) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	
	public double getTotal() {
		return this.getQuantity() * this.getPrice();
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", description=" + description + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	
	
	
	
}
