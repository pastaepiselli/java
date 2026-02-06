package studio_medico;

public class Paziente extends Persona {
	private String email;
	public Paziente(String nome, String email) {
		super(nome);
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
