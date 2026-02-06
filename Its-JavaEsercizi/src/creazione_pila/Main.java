package creazione_pila;

public class Main {

	public static void main(String[] args) {
		// linked list con object 
		PilaGenericaObject piatti = new PilaGenericaObject();
		piatti.add("piatto sporco");
		piatti.add("piatto pulito");
		piatti.add("piatto bagnato");
		
		for (Object p : piatti.getPila()) {
			System.out.println(p);
		}
		
		// rimuovo l'ultimo seguento logica lifo
		piatti.remove();
		
		System.out.println();
		
		for (Object p : piatti.getPila()) {
			System.out.println(p);
		}
		
		System.out.println();
		// linked list con generic
		
		
		PilaGenericaGenerics<String> fogli = new PilaGenericaGenerics<String>();
		fogli.add("esame");
		fogli.add("esercizi");
		fogli.add("bolleta");
		
		for (String f : fogli.getPila()) {
			System.out.println(f.toUpperCase());
		}
		
		
		fogli.remove(); // rimuovo ultimo
		
		System.out.println();
		
		for (String f : fogli.getPila()) {
			System.out.println(f);
		}
		
		
		
		
		
		
	}

}
