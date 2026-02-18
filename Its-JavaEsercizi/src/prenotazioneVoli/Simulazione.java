package prenotazioneVoli;

public class Simulazione {
	public static void main(String[] args) {
		Assegnatore ass = new Assegnatore();
		Cliente c1 = new Cliente("Tiziano", 8, ass);
		Cliente c2 = new Cliente("Luca", 5, ass);
		Cliente c3 = new Cliente("Popa", 6, ass);
		Cliente c4 = new Cliente("Valentina", 5, ass);
		
		// avvio dei thread
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
		// aspetto l'esecuzione delle prenotazioni per eseguire il main
		try {
			c1.join(); 
			c2.join();
			c3.join();
			c4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Posti rimasti: " + ass.getTotalePosti());
		
		
		
	}
}
