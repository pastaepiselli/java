package eccezioni;

import java.io.FileReader;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
		try {
			// proviamo questo codice
//			FileReader reader = new FileReader("text.txt");
			Double divisione = dividi(2, 2);
			System.out.println(divisione);
			stampaTesto(null);
//		}catch (IOException e) { // se torna errore
//			System.out.println(e.getMessage()); // loggiamo messaggio errore
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CorsoJavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // stampa lo stack degli errori
		}
	}
	
	public static void stampaTesto(String testo) throws CorsoJavaException{
		if (testo == null) {
			throw new CorsoJavaException();
		}
	}

	public static Double dividi(Integer a, Integer b) throws ArithmeticException {
		if (a == null) {
			throw new NullPointerException("Divedendo non puo essere null");
		}
		if (b == 0) {
			throw new ArithmeticException("Errore divisione per zero");
		}
		Double risultato = (double) a/b; // wrappo con Double wrapper per accettare anche altre variabili
		return risultato;
	}

}
