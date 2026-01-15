package hotel;

public class Room {
	private int numero;
	private int piano;
	private int postiLetto;
	
	public Room(int numero, int piano, int postiLetto) {
		this.numero = numero;
		this.piano = piano;
		this.postiLetto = postiLetto;
	}

	public int getPostiLetto() {
		return postiLetto;
	}

	public void setPostiLetto(int postiLetto) {
		this.postiLetto = postiLetto;
	}

	public int getNumero() {
		return numero;
	}

	public int getPiano() {
		return piano;
	}

	@Override
	public String toString() {
		return "Room [numero=" + numero + ", piano=" + piano + ", postiLetto=" + postiLetto + "]";
	}
	
	
	
	
}
