package cartoleria;

public class Penna extends Articolo {
	private String colore;
	public Penna(String marca, String modello, double costo, String colore) {
		super(marca, modello, costo);
		this.colore = colore;

		
	}
	
	public String getColore() {
		return colore;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", colore= " + this.colore;
	}
}
