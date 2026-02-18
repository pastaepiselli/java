package prenotazioneVoli;

public class Cliente extends Thread {
	private String nome;
	private int numPosti;
	private Assegnatore ass;

	public Cliente(String nome, int numPosti, Assegnatore ass) {
		this.nome = nome;
		this.numPosti = numPosti;
		this.ass = ass;	
	}

	@Override
	public void run() { // prenota posti
		try {
			ass.assengnaPosti(nome, numPosti);
			System.out.println(nome + ": prenotazione riuscita per " + numPosti + " posti.");
		} catch (PostiNonDispException e) {
			System.out.println(
					nome + ": prenotazione FALLITA per " +
							numPosti + " posti. Motivo: " + e.getMessage()
					);
		}
	}


}
