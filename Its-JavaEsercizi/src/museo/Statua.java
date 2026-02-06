package museo;

public class Statua extends Opera{
	private static int counter;
	private String codice = "s";
	private String materiale;
	private double altezza;
	

	public Statua(String titolo, String autore, String materiale, double altezza) {
		super(titolo, autore);
		this.materiale = materiale;
		this.altezza = altezza;
		this.codice += counter++;
		 
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Statua.counter = counter;
	}

	public String getCodice() {
		return codice;
	}

	public String getMateriale() {
		return materiale;
	}

	public double getAltezza() {
		return altezza;
	}

	@Override
	public String toString() {
		return "Statua [codice=" + codice + ", materiale=" + materiale + ", altezza=" + altezza + "]";
	}
	
	
	
	
	
	

}
