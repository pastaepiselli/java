package cartoleria;

public class Gomma extends Articolo {

	private String dimensione;
	private String forma;
	public Gomma(String marca, String modello, double costo, String dimensione, String forma) {
		super(marca, modello, costo);
		this.dimensione = dimensione;
		this.forma = forma;
	}
	
	public String getDimensione() {
		return dimensione;
	}
	public String getForma() {
		return forma;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", dimensione= " + this.dimensione + ", forma= " + this.forma;
	}

}
