package azienda;

import java.util.ArrayList;

public class Azienda {
	private String nome;
	private ArrayList<Impiegato> dipendenti;
	
	public Azienda(String nome) {
		this.nome = nome;
		this.dipendenti = new ArrayList<Impiegato>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Impiegato> getDipendenti() {
		return dipendenti;
	}

	@Override
	public String toString() {
		String s = "Nome Azienda: " + this.nome + "\n";
		s+= "elenco dipendeni: \n";
		for (Impiegato impiegato : this.dipendenti) {
			s+= impiegato.toString() + "\n";
		}
		return s;
	}
	
	public void assume(Impiegato imp) {
		this.dipendenti.add(imp);
	}
	
	public void incrSalarioTutti(double aumento) {
		for (Impiegato impiegato : this.dipendenti) {
			impiegato.incrSalario(aumento);
		}
	}
	
}
