package lista_prodotti;


enum Categoria {
	alimentare,
	abbigliamento,
	elettronica,
	media,
	nonEsiste
	
	
}
public class Prodotto {
	private int codice;
	private String descrizione;
	private Categoria categoria;
	private int quantita;
	private boolean disponibilita;
	private double prezzo;
	private int percentuale;
	
	public Prodotto(int codice, String descrizione, Categoria categoria, int quantita, boolean disponibilita,
			double prezzo, int percentuale) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.quantita = quantita;
		this.disponibilita = disponibilita;
		this.prezzo = prezzo;
		this.percentuale = percentuale;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getPercentuale() {
		return percentuale;
	}

	public void setPercentuale(int percentuale) {
		this.percentuale = percentuale;
	}

	@Override
	public String toString() {
		return "Prodotto [codice=" + codice + ", descrizione=" + descrizione + ", categoria=" + categoria
				+ ", quantita=" + quantita + ", disponibilita=" + disponibilita + ", prezzo=" + prezzo
				+ ", percentuale=" + percentuale + "]";
	}
	
	
}
