package laBanca;

public class ImportoNonValidoException extends Exception {
	private static final long serialVersionUID = 1061129279188504690L;
	private String message;
	public ImportoNonValidoException(String message) {
		this.message = message;
	}
}
