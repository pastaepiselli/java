package studio_medico;

public class MedicoOccupato extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Medico non disponibile questo giorno";
	}




}
