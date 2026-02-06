package museo;


public class Quadro extends Opera {
	private static int counter;
	private String codice = "q";
	private String tecnica;

	public Quadro(String titolo, String autore, String tecnica) {
		super(titolo, autore);
		this.tecnica = tecnica;
		this.codice += counter;
	}

	public String getCodice() {
		return codice;
	}

	public String getTecnica() {
		return tecnica;
	}

	@Override
	public String toString() {
		return "Quadro [codice=" + codice + ", tecnica=" + tecnica + "]";
	}



	

	
	
	
	
	

}
