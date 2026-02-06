package studio_medico;

public class PazienteOccupato extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Paziente non disponibile in quel giorno";
	}

	

}
