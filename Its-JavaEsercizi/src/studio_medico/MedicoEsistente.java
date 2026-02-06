package studio_medico;

public class MedicoEsistente extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Medico gia presente";
	}
	
	

}
