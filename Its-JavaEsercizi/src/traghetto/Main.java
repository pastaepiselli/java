package traghetto;

public class Main {

	public static void main(String[] args) throws IllegalAccessException {
		// creo biglietteria
		Biglietteria b = new Biglietteria();
		
		// creo veicoli / persone
		Auto audi = new Auto("Targa1", 3, TipoAuto.Standard);
		Persona p1 = new Persona("Marco", "PierLeoni");
		Tir tir1= new Tir("Targa2", 2, 12.4);
		Moto moto1 = new Moto("Targa3", 1);
		Auto suv = new Auto("Targa4", 5, TipoAuto.Suv);
		Auto mini = new Auto("Targa5", 2, TipoAuto.Mini);
		
		// aggiungo p1: Persona tariffa = 2.5
		b.aggiungiInCoda(p1);
		b.riceviPagamento();
		
		System.out.println(b.getCassa()); // 2.5
		
		// aggiungo audi con 3 persone tariffa = 2.5 * 3 + costo_standard(5) = 12.5
		b.aggiungiInCoda(audi); 
		
		b.riceviPagamento();
		System.out.println(b.getCassa()); // 15.0
		
		// aggiungo tir con 2 persone tariffa = 2. 2.5 + costotir(12.5) + merce trasportata (merce * 0.5) 
		b.aggiungiInCoda(tir1); // 23.5
		
		// aggiungo moto con una persona tariffa = 2.5 + 3.5 
		b.aggiungiInCoda(moto1); // 6
		
		// ricevo pagamento di tir1
		b.riceviPagamento(); 
		System.out.println(b.getCassa()); // 21.0
		
		// ricevo pagamento di moto1
		b.riceviPagamento();
		System.out.println(b.getCassa()); // 44.5
		
		// aggiungo suv con 5 passeggeri = 5 * 2.5 + costo_suv(8.5)
		b.aggiungiInCoda(suv);
		
		// aggiungo mini con 2 passeggeri  = 2 * 2.5 + costo_mini(4)
		b.aggiungiInCoda(mini);
		
		// ricevo pagameto di suv (arrivato prima di mini)
		b.riceviPagamento(); // 21.0
		System.out.println(b.getCassa()); // 65.5
		
		// ricevo pagamento di mini 
		b.riceviPagamento(); // 9.00
		
		System.out.println(b.getCassa()); // 74.5
		
		
		
	
		
		
	}

}
