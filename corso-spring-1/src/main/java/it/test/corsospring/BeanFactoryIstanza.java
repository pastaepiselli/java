package it.test.corsospring;

public class BeanFactoryIstanza {

	private OrdineService ordine = new OrdineService();
	// implementare ProdottoService

	public OrdineService getOrdine() {
		return ordine;
	}

	public void setOrdine(OrdineService ordine) {
		this.ordine = ordine;
	}
}
