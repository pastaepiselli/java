package prenotazioneVoli;

public class PostiNonDispException extends Exception {

	private static final long serialVersionUID = 1L; // non ho ancora capito a che serve

	@Override
	public String getMessage() {
		return "Errore posti non disponibili!";
	}
	
}
