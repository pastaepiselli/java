package studio_medico;

import java.time.LocalDate;

public class Appuntamento {
	private Medico medico;
	private Paziente paziente;
	private LocalDate data;
	private String ora;
	public Appuntamento(Medico medico, Paziente paziente, LocalDate data, String ora) {
		this.medico = medico;
		this.paziente = paziente;
		this.data = data;
		this.ora = ora;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	
	

}
