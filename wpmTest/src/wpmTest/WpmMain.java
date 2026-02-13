package wpmTest;

import java.util.Random;
import java.util.Scanner;

public class WpmMain {
	// array di frasi da digitare 
	private static String[] frasi = { 
			"The quick fox jumps over the lazy dog.",
			"Pack my box with five dozen liquor jugs.",
			"The five boxing wizards jump quickly."
	};

	public static double calcoloAccuratezza(String test, String testoInput) {
		// gestisce sia che il testo in input sia troppo lungo escludendo quelle lettere
		// sia che sia troppo corto contando le nono inserite come errore
		int lunghezzaMinima = Math.min(test.length(), testoInput.length());

		int caratteriCorretti = 0;
		for (int i = 0; i < lunghezzaMinima; i++) { // in piu previene errori nel caso in testo inserito sia piu lungo
			char c1 = testoInput.charAt(i); // carattere del testo in input
			char c2 = test.charAt(i); // carattere del testo

			// devono essere uguali
			if (c1 == c2) { // essendo primitivi non hanno il metodo equals
				caratteriCorretti++;
			}

		}
		// casting a double per evitare divisione tra interi
		double accuratezza = ((double)caratteriCorretti / test.length()) * 100; // calcolo la precentuale
		return accuratezza;
	}

	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");
		System.out.flush();
	} 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // per prendere input
		while (true) {

			Random random = new Random(); // numero casuale per selezionare frase

			System.out.println("==== WPM TEST ====");

			String fraseScelta = frasi[random.nextInt(frasi.length)]; // seleziona una frase casuale tramite index
			System.out.println("Digita la seguente frase");
			System.out.println("/ " + fraseScelta + " /");

			System.out.println("Premi INVIO per iniziare");

			// nextLine() ritorna l'input scritto dopo l'inivio ma a noi in questo caso non interessa
			// ci interessa forzare il fatto di premere INVIO per continuare
			sc.nextLine(); // aspetta INVIO per continuare
			System.out.println("Inizio!!");

			long start_time = System.currentTimeMillis(); // ritorna il tempo in millisecondi

			String testoDigitato = sc.nextLine();

			long end_time = System.currentTimeMillis();

			// calcolo tempo impiegato
			long tempoImpiegato = end_time - start_time;

			// formula per calcolare wpm

			// considero una parola standard 5 caratteri
			int numeroCaratteri = testoDigitato.length();
			double tempoInMinuti = (tempoImpiegato / 1000.0) / 60.0;
			double wpm = (numeroCaratteri / 5) / tempoInMinuti;

			// divido per 1000 per ottenere i secondi


			System.out.println("==== FINE TEST ==== ");
			System.out.println("Hai impiegato: " + tempoImpiegato / 1000 + " secondi!");
			System.out.println("Il tuo WPM e di: " +String.format("%.2f", wpm));
			double accuratezza = calcoloAccuratezza(fraseScelta, testoDigitato);
			System.out.println("Accuratezza: " + Math.round(accuratezza) + "%.");
			System.out.println("==== ==== ==== ====");

			System.out.println("Continuare? S/n");


			String continuare = sc.next(); // ritorna il valore della stringa in input
			if (continuare.toLowerCase().equals("s")) {
				clearScreen();
				continue;

			} else if (continuare.toLowerCase().equals("n")) {
				System.out.println("Grazie per aver giocato!");
				break;
			}
		}

		sc.close();


	}

}


