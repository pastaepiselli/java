package prenotazioneEvento;

public class Posto  {
	private char corsia;
	private int numero;
	private boolean occupato = false;
	public Posto(char corsia, int numero) {
		super();
		this.corsia = corsia;
		this.numero = numero;
	}
	public char getCorsia() {
		return corsia;
	}
	public int getNumero() {
		return numero;
	}
	
	public boolean isOccupato() {
		return occupato;
	}
	
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	@Override
	public String toString() {
		return "Posto [corsia=" + corsia + ", numero=" + numero + "]";
	}
	
	
	public boolean equals(Posto p) {
		return p.getCorsia() == this.getCorsia() && p.getNumero() == this.getNumero();
	}
	
	
	
	
	
	
	
}
