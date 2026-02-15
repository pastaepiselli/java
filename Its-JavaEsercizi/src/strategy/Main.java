package strategy;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    	
    	// creo carrello
        Carrello carrello = new Carrello();

        
        // aggiungo prodotti
        carrello.add(new Prodotto("Maglia", 2, 20));
        carrello.add(new Prodotto("Jeans", 1, 50));

        
        // ottengo data d'acquisto 
        LocalDate dataAcquisto = LocalDate.of(2025, 11, 25); 
        
        Sconto strategy = null;
		try {
			// ritorna lo sconto utilizzabile
			strategy = PeriodoSconto.getSconto(dataAcquisto); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// calcola il totale con sconto
        double totale = carrello.calcoloTotale(strategy);
        
        // senza sconto inserito
        double totale1 = carrello.calcoloTotale(null);
        

        System.out.println("Totale finale: " + totale);
        System.out.println("Totale finale (no sconto): " + totale1);
    }
}
