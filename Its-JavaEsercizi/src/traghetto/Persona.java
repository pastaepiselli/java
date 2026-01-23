package traghetto;

public class Persona implements Tariffabile {
	private String nome;
	private String cognome;
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	@Override
	public double calcoloTariffa() {
		// TODO Auto-generated method stub
		return 2.5;
	}
	
	
}
