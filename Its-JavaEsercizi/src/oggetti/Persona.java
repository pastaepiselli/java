package oggetti;

public class Persona {
	
	// 1. attributi
	private String nome;
	private int eta;
	private float peso;
	
	// 2. costruttori
	public Persona(String nome, int eta, float peso) {
		this.nome = nome;
		this.eta = eta;
		this.peso = peso;
	}
	
	public Persona(String nome, float peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		if (eta > 0) {
			this.eta = eta;
		}
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return String.format("Persona [nome=%s, eta=%s, peso=%s]", nome, eta, peso);
	}
	
	// metodi operatii
	
	public void cresce() {
		eta++;
	}
	
	public void cresce(int incremento) {
		eta += incremento;
	}
	
	
	
	
	
	
}
