package ripasso;

public abstract class SuperClasse {
	private String nome;
	public SuperClasse(String nome) {
		this.nome = nome;
	}
	
	public int caca() {
		return 2;
	}
	
	public abstract int pipi();
}
