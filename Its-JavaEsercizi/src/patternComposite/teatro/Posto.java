package patternComposite.teatro;

public class Posto {
	private char fila;
	private int numero;
	
	public Posto(char fila, int numero) {
		super();
		this.fila = fila;
		this.numero = numero;
	}

	public char getFila() {
		return fila;
	}

	public void setFila(char fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Posto [fila=" + fila + ", numero=" + numero + "]";
	}	
	
	
}
