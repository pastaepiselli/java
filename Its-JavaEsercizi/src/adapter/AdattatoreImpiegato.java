package adapter;

import java.time.LocalDate;

import azienda.Impiegato;

public class AdattatoreImpiegato implements Dipendente {
	private Impiegato impiegato;
	
	
	public AdattatoreImpiegato(Impiegato impiegato) {
		super();
		this.impiegato = impiegato;
	}
	
	public Impiegato getImpiegato() {
		return impiegato;
	}


	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	// ------- esercizio di adattamento ---------

	@Override
	public String getNominativo() {
		// TODO Auto-generated method stub
		return this.impiegato.getNome();
	}

	@Override
	public double getRetribuzioneAnnua() {
		// TODO Auto-generated method stub
		return this.impiegato.getSalario() * 13;
	}

	@Override
	public int getAnniAnzianita() {
		// TODO Auto-generated method stub
		return LocalDate.now().getYear() - this.impiegato.getAnnoAssunzione();
	}

	@Override
	public String toString() {
//		return "AdattatoreImpiegato [impiegato=" + impiegato + "]";
		return "Adattatore Impiegato: " + getImpiegato() + "\n" + "RAL: " 
		+ getAnniAnzianita() + "\n" 
		+ "anzianita: " + getAnniAnzianita() + " anni.";
	}
	
	
	
}
