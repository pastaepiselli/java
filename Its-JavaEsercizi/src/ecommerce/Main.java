package ecommerce;

public class Main {

	public static void main(String[] args) {
		
		// creo carrello
		Carrello c = new Carrello();
		
		
		// prodotti
		Product p1 = new Product(1, "Balsamo", 3, 5.99);
		Product p2 = new Product(2, "Jeans Baggy", 2, 19.99);
		
		
		
		// prodotti scontati
		ProductSale ps1 = new ProductSale(3, "Patatine Pollo", 5, 1.99, 3, 20.0);
		ProductSale ps2 = new ProductSale(4, "Pasta Barilla", 2, 1.49, 5, 30.0);
		
		
		// aggiungo prodotti
		c.addProduct(p1);
		c.printProducts();
		c.addProduct(p1);
		c.printProducts();
		
	}

}
