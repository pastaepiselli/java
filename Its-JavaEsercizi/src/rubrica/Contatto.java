package rubrica;

public class Contatto {
	private String nome;
	private String cognome;
	private String numeroTelefonico;
	
	public Contatto(String nome, String cognome, String numeroTelefonico) {
		this.nome = nome;
		this.cognome = cognome;
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", numeroTelefonico=" + numeroTelefonico + "]";
	}
	
	
	
}