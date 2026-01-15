package ecommerce;

import java.util.ArrayList;

public class Carrello {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product p) {
		int t = this.products.indexOf(p);
		if (t != -1) {
			this.products.get(t).setQuantity(this.products.get(t).getQuantity() + p.getQuantity());
		} else {
			this.products.add(p);
		}
	}
	
	public void removeProduct(Product p) {
		int t = this.products.indexOf(p);
		if(t != -1) {
			if (this.products.get(t).getQuantity() - p.getQuantity() > 1) {
				this.products.get(t).setQuantity(this.products.get(t).getQuantity() - p.getQuantity());
			} else {
				this.products.remove(t);
			}
		} else {
			System.out.println("Prodotto non esistente");
		}
	}
	
	public double total() {
		double total = 0.0;
		for (Product prodotto : products) {
			total += prodotto.getTotal();
		}
		
		return total;
	}
	
	public void printProducts() {
		for (Product prodotto : products) {
			System.out.println(prodotto);
		}
	}
}
