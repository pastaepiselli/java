package studio_medico;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        GestoreAmbulatorio gestore = new GestoreAmbulatorio();

        // aggiungo medici
        try {
            gestore.aggiungiMedico("Rossi", "Cardiologia");
            gestore.aggiungiMedico("Bianchi", "Dermatologia");

            // medico duplicato (ERRORE)
            gestore.aggiungiMedico("Rossi", "Ortopedia");

        } catch (Exception e) {
            System.out.println("ERRORE aggiungiMedico: " + e.getMessage());
        }

        // prenotazione
        try {
            gestore.prenotaAppuntamento(
                    "Mario Rossi",
                    "Rossi",
                    "mario@email.it",
                    LocalDate.of(2026, 3, 10),
                    "10:30"
            );
            System.out.println("Appuntamento prenotato correttamente");

        } catch (Exception e) {
            System.out.println("ERRORE prenotazione: " + e.getMessage());
        }

        // paziente occupato
        try {
            gestore.prenotaAppuntamento(
                    "Mario Rossi",
                    "Bianchi",
                    "mario@email.it",
                    LocalDate.of(2026, 3, 10),
                    "10:30"
            );
        } catch (Exception e) {
            System.out.println("ERRORE paziente occupato: " + e.getMessage());
        }

        // medico occupato
        try {
            gestore.prenotaAppuntamento(
                    "Anna Verdi",
                    "Rossi",
                    "anna@email.it",
                    LocalDate.of(2026, 3, 10),
                    "10:30"
            );
        } catch (Exception e) {
            System.out.println("ERRORE medico occupato: " + e.getMessage());
        }

        // --- MEDICO NON ESISTENTE ---
        try {
            gestore.prenotaAppuntamento(
                    "Luca Bianchi",
                    "Neri",
                    "luca@email.it",
                    LocalDate.of(2026, 3, 11),
                    "09:00"
            );
        } catch (Exception e) {
            System.out.println("ERRORE medico non trovato: " + e.getMessage());
        }

        // annullamento
        try {
            gestore.annullaAppuntamento(
                    "mario@email.it",
                    LocalDate.of(2026, 3, 10),
                    "10:30"
            );
            System.out.println("Appuntamento annullato correttamente");

        } catch (Exception e) {
            System.out.println("ERRORE annullamento: " + e.getMessage());
        }

        // annulamento inesistente
        try {
            gestore.annullaAppuntamento(
                    "mario@email.it",
                    LocalDate.of(2026, 3, 10),
                    "10:30"
            );
        } catch (Exception e) {
            System.out.println("ERRORE appuntamento inesistente: " + e.getMessage());
        }


    }
}
