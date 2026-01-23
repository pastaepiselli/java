package traghetto;

public class Moto extends Veicolo {
	private final int max_pers = 2;
	public Moto(String targa, int num_pers) throws IllegalAccessException {
		super(targa, num_pers);

	}

	@Override
	public double calcoloTariffa() {
		return 3.5 + (this.getNum_pers() * 2.5);
	}

	public int getMax_pers() {
		return max_pers;
	}
	
	@Override
	public void setNumPers(int num_pers) throws IllegalAccessException {
		if (num_pers > this.getMax_pers()) {
			throw new IllegalAccessException("Numero massimo per moto 2");
		}
		super.setNumPers(num_pers);
	}

}
