package museo;

import javax.management.InstanceAlreadyExistsException;

public class Main {

    public static void main(String[] args) {

        // Creo il museo con massimo 2 opere esposte
        Museo museo = new Museo(2);

        // Creo alcune opere
        Quadro q1 = new Quadro("Q001", "La Gioconda", "boh");
        Quadro q2 = new Quadro("Q002", "L'Ultima Cena", "disegrato");
        Statua s1 = new Statua("S001", "David di Michelangelo", "Marmo", 2.02);

        try {
            // Caricamento quadri
            museo.carica(q1);
            museo.carica(q2);

            // Questa va in magazzino (limite raggiunto)
            museo.carica(s1);

        } catch (InstanceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        // --- STAMPA STATO ---
        System.out.println("=== SALA ESPOSITIVA ===");
        System.out.print(museo.stampaSala());

        System.out.println("=== DEPOSITO ===");
        System.out.print(museo.stampaDeposito());

        // --- RICERCA ---
        System.out.println("=== RICERCA ===");
        Opera trovata = museo.cerca("Q001");
        if (trovata != null) {
            System.out.println("Trovata: " + trovata.getTitolo() +
                               " (" + trovata.getStato() + ")");
        }

        // --- SPOSTAMENTO ---
        System.out.println("=== SPOSTAMENTO ===");
        Opera spostata = museo.sposta("Q002");
        if (spostata != null) {
            System.out.println("Spostata in deposito: " + spostata.getTitolo());
        }

        // --- STAMPA FINALE ---
        System.out.println("=== SALA ESPOSITIVA (DOPO SPOSTAMENTO) ===");
        System.out.print(museo.stampaSala());

        System.out.println("=== DEPOSITO (DOPO SPOSTAMENTO) ===");
        System.out.print(museo.stampaDeposito());

        // --- TEST OPERA INESISTENTE ---
        System.out.println("=== TEST OPERA INESISTENTE ===");
        Opera inesistente = museo.sposta("X999");
        System.out.println(inesistente == null ? "Opera non trovata" : "Errore");

        System.out.println("\n--- TEST COMPLETATO ---");
    }
}
