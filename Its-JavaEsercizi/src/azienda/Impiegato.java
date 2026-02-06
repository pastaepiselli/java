package azienda;

import java.util.Date;
import java.util.Objects;

public class Impiegato implements Comparable<Impiegato> {

	private final String nome;
	private double salario;
	private final Date dataAssunzione;
	
	
	private static int contatore = 0;

	public Impiegato(String nome, double salario, Date dataAssunzione) {
		this.nome = nome;
		this.salario = salario;
		this.dataAssunzione = dataAssunzione;
		
		// contatore aumenta ogni volta che si crea una classe impiegato
		contatore++;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}
	
	@SuppressWarnings("deprecation")
	public int getAnnoAssunzione() {
		return this.getDataAssunzione().getYear() + 1900;
	}

	public static int getContatore() {
		return contatore;
	}
	
	public void incrSalario(double aumento) {
		this.salario += aumento;
	}

	@Override
	public String toString() {
		return String.format("Dipendente Nome=%s, Salario=%s, DataAssunzione=%s", nome, salario, dataAssunzione);
	}

	@Override
	public int compareTo(Impiegato p) {
		return this.getNome().compareTo(p.getNome());
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAssunzione, nome, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Impiegato other = (Impiegato) obj;
		return Objects.equals(dataAssunzione, other.dataAssunzione) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	
	
	
	
	
	
	
	

	

}
