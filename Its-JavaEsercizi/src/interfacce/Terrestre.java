package interfacce;

public abstract class Terrestre implements Animale {
	@Override
	public String categoria() {
		return "Terrestre";
	}
	
	@Override
	public String toString() {
		return "Categoria: terrestre";
	}
}
