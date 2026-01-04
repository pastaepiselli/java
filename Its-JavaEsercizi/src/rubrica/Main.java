package rubrica;

public class Main {

	public static void main(String[] args) {
		Contatto mirko = new Contatto("Mirko", "Pierlions", "3742225793");
		Contatto ale = new Contatto("Alessandro", "Popa", "3479291745");
		Contatto luca = new Contatto("Luca", "Marchetti", "3858293758");
		
		Rubrica rubrica = new Rubrica();
		
		// aggiungi contatto
		rubrica.aggiungiContatto(luca);
		
		
		// numero contatti registrati
		System.out.println(rubrica.numeroContattiRegistrati());
		rubrica.mostraContattoPosizioneSpecificata(3);
		
		rubrica.stampaContatti();
		
		// 
		System.out.println(rubrica.numeroPostiLiberi());

	}

}
