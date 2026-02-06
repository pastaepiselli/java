package studio_medico;

public class Medico extends Persona {
	private String specializzazione;
	
	public Medico(String nome, String specializzazione) {
		super(nome);
		this.specializzazione = specializzazione;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
}
