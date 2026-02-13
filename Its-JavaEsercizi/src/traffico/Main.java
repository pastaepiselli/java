package traffico;

import java.util.ArrayList;
import java.util.function.Predicate;



public class Main {
	public static void main(String[] args) {
		ArrayList<Automobile> traffico = new ArrayList<Automobile>();
		
		traffico.add(new Automobile("Volkswagen", "Polo", "GN091ST"));
		traffico.add(new Automobile("Chevrolet", "Spark", "EM760XA"));
		traffico.add(new Automobile("Volkswagen", "Up", "FR629FP"));
		traffico.add(new Automobile("Fiat", "Panda", "TN380PR"));
		
		// circolano solo le auto di marca Fiat
		System.out.println("circolano solo le auto di marca Fiat");
		
		ArrayList<Automobile> f = filtraAutomobili(traffico, (auto) -> auto.getMarca().equals("Fiat"));
		for (Automobile automobile : f) {
			System.out.println(automobile);
		}
		
		System.out.println();
		
		// circolano solo le auto con targhe pari
		System.out.println("cirolano solo le auto con le targhe pari");
		f = filtraAutomobili(traffico, (auto) -> {int value = Integer.parseInt(auto.getTarga().replaceAll("[^0-9]", ""));
		return value % 2 == 0;
		});
		
		for (Automobile automobile : f) {
			System.out.println(automobile);
		}
		
		// circolano solo le auto con targhe dispari
		System.out.println("circolano solo le auto con targhe dispari");
		f = filtraAutomobili(traffico, (auto) ->  {int value = Integer.parseInt(auto.getTarga().replaceAll("[^0-9]", ""));
		return value % 2 != 0;
		});
		for (Automobile automobile : f) {
			System.out.println(automobile);
		}
		
	}
	
	public static ArrayList<Automobile> filtraAutomobili(ArrayList<Automobile> traffico, Predicate<Automobile> p) {
		ArrayList<Automobile> filtrato = new ArrayList<Automobile>();
		for (Automobile automobile : traffico) {
			if (p.test(automobile)) {
				filtrato.add(automobile);
			}			
		}
		return filtrato;
	}
}
