package cartoleria;

public class Private extends Cliente {
	
	private double cash;
	public Private(String anagrafica, double cash) {
		super(anagrafica);
		this.setCash(cash);
	}
	

	public double getCash() {
		return cash;
	}


	public void setCash(double cash) {
		this.cash = cash;
	}


	@Override
	public void paga(double importo) {
		cash = cash - importo;

	}

	@Override
	public String toString() {
		return "Privato: " + super.toString() + ", cash= " + this.getCash();
	}
	

}
