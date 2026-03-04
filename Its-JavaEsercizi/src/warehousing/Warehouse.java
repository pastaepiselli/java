package warehousing;

public class Warehouse {
	private double capacity;
	
	// spazio occupato da oggetti
	private double balance;
	public Warehouse(double capacity) {
		
		if (capacity <= 0)
			this.capacity = 0;
		else
			this.capacity = capacity;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getCapacity() {
		return this.capacity;
	}
	
	public double howMuchSpaceLeft() {
		return this.capacity - this.balance;
	}
	
	public void addToWarehouse(double amount) {
		
		// se balance > capacity il resto viene scaratato
		if (amount > 0) {
			double newBalance = this.balance + amount; // lol 
			if (newBalance >= this.capacity) {
				this.balance  = this.capacity;
			}
			else {
				this.balance = newBalance;
			}
		}
	}
	
	public double takeFromWarehouse(double amount) {
	    if (amount <= 0) {
	        return 0;
	    }

	    if (amount > this.balance) {
	        double allWeHave = this.balance;
	        this.balance = 0;  // svuota
	        return allWeHave;
	    }

	    this.balance -= amount;
	    return amount; 
	}
	
	@Override
	public String toString() {
		return "balance= " + this.balance + " ,space left= " + this.howMuchSpaceLeft();
	}
}
