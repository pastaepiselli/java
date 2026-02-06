package museo;

import java.util.Objects;

public abstract class Opera implements Comparable<Opera>  {
	private String titolo;
	private String autore;
	private StatoOpera stato = null;
	private String codice;
	
	public Opera(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	
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

	public StatoOpera getStato() {
		return stato;
	}

	public void setStato(StatoOpera stato) {
		this.stato = stato;
	}

	public String getCodice() {
		return codice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // se sono nella stessa locazione di memoria
			return true;
		if (obj == null) // se null
			return false;
		if (getClass() != obj.getClass()) // controlla le classi
			return false;
		Opera other = (Opera) obj;
		return Objects.equals(codice, other.codice); // codice uguale
	}

	@Override
	public int compareTo(Opera arg0) {
		return this.codice.compareTo(arg0.codice);
	}
	
	
	
	
	
	
	
	
	
	
}
