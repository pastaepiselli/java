package eccezioni;


public class CorsoJavaException extends Exception {
	// garantire che quando andiamo a prendere questo oggetto in memoria 
	// l'oggetto che prendi e garantito che e questo 
	 private static final long serialVersionUID = 45545446;
	// creiamo la nostra eccezione
	@Override
	public String getMessage() {
		return "Attenzione eccezione in Corso Java";
	}
	
}


