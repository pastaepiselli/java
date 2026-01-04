package oggetti;

import java.util.Date;

public class EsempioDate {
	public static void main(String[] args) {
		Date d = new Date();
		
		// to string metodo di classe per printare la data
		
		// anche se in realta se printo solo d mi printa la stessa cosa 
		// quando println incontra un oggetto richiama il toString di esso
		// ecco perche funziona 
		System.out.println(d);
		System.out.println(d.toString());
		
		d.setMonth(1);
		
		// ha cambiato il giorno non ha cambiato semplicemente il mese
		// deve rimanere coerente
		System.out.println(d);
		
		// non da errore ma aggiunge fino a soddisfare la nostra richiesta rimanendo coerente
		d.setMonth(14);
		System.out.println(d);
		
		d.setMonth(-1);
		System.out.println(d);
		// 125 perche parte da 1900 e somma, 11 perche i mesi partono da 0
		Date natale = new Date(125, 11, 25);
		
		System.out.println(natale);
	}	
		
}
