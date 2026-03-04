package database;

public class LibroDTO {
	private int id;
	private String titolo;
	private String autore;
	private Double prezzo;
	
	public LibroDTO(String titolo, String autore, Double prezzo) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
	}
	
	

	public LibroDTO(int id, String titolo, String autore, Double prezzo) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}



	@Override
	public String toString() {
		return "LibroDTO [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", prezzo=" + prezzo + "]";
	}
	
	
	
	
	
	
}
