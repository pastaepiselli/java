package mappe;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class EsempioMappe {

	public static void main(String[] args) {
		TreeMap<Integer, Studente> mappa = new TreeMap<Integer, Studente>(new IntgerComprator());
		
		
		// seguiamo questa logica per assicurare il fatto che la chiave sia uguale al numero di matricola
		Studente s1 = new Studente(123, "mario", 202);
		mappa.put(s1.getMatricola(), s1);
		
		Studente s2 = new Studente(456, "anna", 2021);
		mappa.put(s2.getMatricola(), s2);
		
		System.out.println(mappa);
		
		// questo e solo il tipo :P
		Set<Entry<Integer, Studente>> set = mappa.entrySet();
		
		// il set e fatto di entry e ogni entry ha Integer e Studente
		for (Entry<Integer, Studente> entry : set) {
			System.out.println();
			System.out.println(entry.getKey() + ": " + entry.getValue());
			
		}
		
		// inserisco una chiave doppia
		Studente s3 = new Studente(123, "giulia", 2022);
		if (!mappa.containsKey(s3.getMatricola())) { // se nn e contenuta
			mappa.put(s3.getMatricola(), s3); 
		}
		
		mappa.putIfAbsent(s3.getMatricola(), s3); // questo fa il controllo in alto con solo un riga
		
		set = mappa.entrySet();
		for (Entry<Integer, Studente> entry : set) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		

	}

}
