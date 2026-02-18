package corridori;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Corridore> corsa = new ArrayList<Corridore>();
		
		
		int tappe = 5;
		// i corridori si vestono
		Corridore c1 = new Corridore(tappe, "Mirko");
		Corridore c2 = new Corridore(tappe, "Sandro");
		Corridore c3 = new Corridore(tappe, "Pier");
		Corridore c4 = new Corridore(tappe, "Luca");
		Corridore c5 = new Corridore(tappe, "Rapons");
		
		corsa.add(c1);
		corsa.add(c2);
		corsa.add(c3);
		corsa.add(c4);
		corsa.add(c5);
		
		// si mettono i posizione
		Thread t1 = new Thread(c1, c1.getNome());
		Thread t2 = new Thread(c2, c2.getNome());
		Thread t3 = new Thread(c3, c3.getNome());
		Thread t4 = new Thread(c4, c4.getNome());
		Thread t5 = new Thread(c5, c5.getNome());
		
		// viaaaa
		t3.start();
//		try {
//			t3.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		t4.start();
		t5.start();
		t1.start();
		
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Corridore corridore : corsa) {
		    if (corridore.getPosizionamento() == 1) {
		        System.out.println("Il vincitore e: " + corridore.getNome());
		    }
		}


		
		
		
		
		
		
		
	

	}

}
