package studio_medico;

public class MedicoNonTrovato extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Medico non trovato.";
	}

	

}
