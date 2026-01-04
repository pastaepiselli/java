package azienda;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		// 0 
		System.out.println(Impiegato.getContatore());
		
		Impiegato imp1 = new Impiegato("Mirko", 1500, new Date());
		
		// 1
		System.out.println(Impiegato.getContatore());
		
		Impiegato imp2 = new Impiegato("Dioni", 1800, new Date(120, 5, 5));
		
		// 2
		System.out.println(Impiegato.getContatore());
		
		System.out.println(imp2);
		
		System.out.println(imp1.getAnnoAssunzione());
		
		System.out.println(imp2.getAnnoAssunzione());
		
		imp1.incrSalario(100);
		System.out.println(imp1.getSalario());
		
		imp2.incrSalario(100);
		System.out.println(imp2.getSalario());
		
		Azienda azienda = new Azienda("eng");
		System.out.println(azienda);
		azienda.assume(imp1);
		azienda.assume(imp2);
		System.out.println(azienda);
		
		azienda.incrSalarioTutti(50);
		System.out.println(azienda);
		
		
		// assunto oggi no bonus
		Manager m1 = new Manager("man1", 3000, new Date(), "anna");
		
		Manager m2 = new Manager("man2", new Date(115, 2, 5), "anna");
		
		System.out.println(m1);
		System.out.println(m2);
		
		m1.incrSalario(100);
		m2.incrSalario(100);
		
		System.out.println("dopo l'incremento...");
		
		System.out.println(m1);
		System.out.println(m2);
		
		azienda.assume(m2);
		azienda.assume(m1);
		
		System.out.println(azienda);
		
		
		
		
		
		
		
;	}
}
