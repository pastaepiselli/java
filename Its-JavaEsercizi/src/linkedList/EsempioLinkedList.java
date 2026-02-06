package linkedList;

import java.util.LinkedList;

public class EsempioLinkedList {

	public static void main(String[] args) {
		LinkedList<String> fiori = new LinkedList<String>(); // non ha dimensione iniziale
		System.out.println(fiori);
		System.out.println(fiori.size());
		fiori.add("rosa");
		fiori.add("margherita");
		fiori.add("orchidea");
		fiori.add("viola");
		System.out.println(fiori);
		
		for (String f : fiori) {
			System.out.println(f);
		}
		
		fiori.add(1, "narciso"); // inserisco in posizione di magherita
		System.out.println();
		
		// fiori.add(11, "narciso"); // non possono esserci buchi ritorna errore
		
		// inserisce e shifta
		for (String f : fiori) {
			System.out.println(f);
		}
		for (String f : fiori) {
			System.out.println(f);
		}
		fiori.addFirst("tulipano"); // aggiungo come primo elemento 
		
		System.out.println();
		
		for (String f : fiori) {
			System.out.println(f);
		}
		
		System.out.println(fiori.indexOf("Rosa")); // le string hanno gia equals
		
		System.out.println(fiori.removeLast()); // rimuove ultimo e lo ritorna
		System.out.println(fiori.removeFirst()); // rimuove primo e lo ritorna
		
		System.out.println();
		
		for (String f : fiori) {
			System.out.println(f);
		}
	}
	

}
