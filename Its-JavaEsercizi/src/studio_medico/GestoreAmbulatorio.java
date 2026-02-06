package studio_medico;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestoreAmbulatorio {

	private ArrayList<Medico> medici = new ArrayList<Medico>();
	private ArrayList<Appuntamento> appuntamenti = new ArrayList<Appuntamento>();


	// aggiunto alla funzione nome paziente
	public void prenotaAppuntamento(String nomePaziente,
			String nomeMedico,
			String emailPaziente,
			LocalDate data,
			String ora)
					throws MedicoNonTrovato, PazienteOccupato, MedicoOccupato {

		if (nomeMedico == null || nomeMedico.isEmpty())
			throw new IllegalArgumentException("Nome medico vuoto");

		if (emailPaziente == null || emailPaziente.isEmpty())
			throw new IllegalArgumentException("Email paziente vuota");

		if (nomePaziente == null || nomePaziente.isEmpty())
			throw new IllegalArgumentException("Nome paziente vuoto");

		// cerca medico
		Medico m = null;
		for (Medico med : medici) {
			if (med.getNome().equals(nomeMedico)) {
				m = med;
				break;
			}
		}

		if (m == null)
			throw new MedicoNonTrovato();

		// controlli conflitti
		for (Appuntamento a : appuntamenti) {

			if (a.getPaziente().getEmail().equals(emailPaziente) &&
					a.getData().equals(data) &&
					a.getOra().equals(ora)) {

				throw new PazienteOccupato();
			}

			if (a.getMedico().getNome().equals(nomeMedico) &&
					a.getData().equals(data) &&
					a.getOra().equals(ora)) {

				throw new MedicoOccupato();
			}
		}

		Paziente p = new Paziente(nomePaziente, emailPaziente);
		appuntamenti.add(new Appuntamento(m, p, data, ora));
	}

	public void annullaAppuntamento(String emailPaziente, LocalDate data, String ora) throws Exception{
		if (emailPaziente.isEmpty()) {
			throw new IllegalAccessException("Email paziente non puo essere vuota");
		}
		Appuntamento app_rim = null;
		for (Appuntamento a : appuntamenti) {
			// appuntamento esiste
			if (a.getPaziente().getEmail().equals(emailPaziente) 
					&& a.getData().equals(data) 
					&& a.getOra().equals(ora)){
				app_rim = a;
			}
		}
		// appuntamento non esiste
		if (app_rim == null) {
			throw new AppuntamentoInesistente();
		}
		appuntamenti.remove(app_rim);
		System.out.println("Appuntamento rimosso");
	}

	public void aggiungiMedico(String nome, String specializzazione) throws Exception {
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome non puo essere vuoto");
		}

		if (medici.contains(new Medico(nome, specializzazione))) {
			throw new MedicoEsistente();
		}

		medici.add(new Medico(nome, specializzazione));
	}


}
